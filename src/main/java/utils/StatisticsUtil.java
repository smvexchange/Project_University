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
        logger.info("Getting statistics started");
        List<Statistics> statisticsList = new ArrayList<>();
        Set<StudyProfile> profileSet = universities.stream()
                .map(University::getMainProfile)
                .collect(Collectors.toSet());
        profileSet.forEach(studyProfile -> {
            Statistics statistics = new Statistics();
            statisticsList.add(statistics);
            List<String> universityIdByProfile = universities.stream()
                    .filter(university -> university.getMainProfile().equals(studyProfile))
                    .map(University::getId)
                    .toList();
            List<Student> studentListByProfile = students.stream()
                    .filter(student -> universityIdByProfile.contains(student.getUniversityId()))
                    .toList();
            OptionalDouble avrExamScoreByProfile = studentListByProfile.stream()
                    .mapToDouble(Student::getAvgExamScore)
                    .average();
            statistics.setProfile(studyProfile);
            statistics.setAvrExamScore(0);
            avrExamScoreByProfile.ifPresent(value -> statistics.setAvrExamScore(
                    BigDecimal.valueOf(value).setScale(3, RoundingMode.HALF_UP).doubleValue())
            );
            statistics.setQuantityOfStudentByProfile(studentListByProfile.size());
            statistics.setQuantityOfUniversityByProfile(universityIdByProfile.size());
            statistics.setUniversityName(StringUtils.EMPTY);
            statistics.setUniversityName(universities.stream()
                    .filter(university -> universityIdByProfile.contains(university.getId()))
                    .map(University::getFullName)
                    .collect(Collectors.joining(", ")));


        });
        logger.debug("Getting statistics completed");
        return statisticsList;
    }
}
