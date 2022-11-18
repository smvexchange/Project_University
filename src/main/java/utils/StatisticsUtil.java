package utils;

import enums.StudyProfile;
import models.Statistics;
import models.Student;
import models.University;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

public class StatisticsUtil {
    private static final Logger logger = LogManager.getLogger(StatisticsUtil.class.getName());

    private StatisticsUtil() {
    }

    public static List<Statistics> getStatisticByProfiles(List<Student> students, List<University> universities) {
        logger.debug("Getting statistics started.");
        List<Statistics> statisticsList = new ArrayList<>();
        Set<StudyProfile> profileSet = universities.stream()
                .map(University::getMainProfile)
                .collect(Collectors.toSet());

        profileSet.forEach(studyProfile -> {
            Statistics statistics = new Statistics();
            statisticsList.add(statistics);
            statistics.setProfile(studyProfile);

            List<String> universityIdByProfile = universities.stream()
                    .filter(university -> university.getMainProfile().equals(studyProfile))
                    .map(University::getId)
                    .toList();
            statistics.setQuantityOfUniversityByProfile(universityIdByProfile.size());
            statistics.setUniversityName(StringUtils.EMPTY);

            List<Student> studentListByProfile = students.stream()
                    .filter(student -> universityIdByProfile.contains(student.getUniversityId()))
                    .toList();
            statistics.setQuantityOfStudentByProfile(studentListByProfile.size());

            OptionalDouble avrExamScoreByProfile = studentListByProfile.stream()
                    .mapToDouble(Student::getAvgExamScore)
                    .average();

            statistics.setAvrExamScore(0);
            avrExamScoreByProfile.ifPresent(value -> statistics.setAvrExamScore(
                    (float) BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue())
            );

            statistics.setUniversityName(universities.stream()
                    .filter(university -> universityIdByProfile.contains(university.getId()))
                    .map(University::getFullName)
                    .collect(Collectors.joining(", ")));
        });
        logger.info("Calculating statistic data completed.");
        return statisticsList;
    }
}
