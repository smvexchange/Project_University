import models.FullReport;
import models.Statistics;
import models.Student;
import models.University;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {

        logger.info("Application started...");
        Path statisticInfoFile = Paths.get("src/main/resources/statisticInfo.xlsx");
        Path universityInfoFile = Paths.get("src/main/resources/universityInfo.xlsx");
        List<Student> studentsList = ReadDataFromXlsx.getStudentData(String.valueOf(universityInfoFile));
        List<University> universityList = ReadDataFromXlsx.getUniversityData(String.valueOf(universityInfoFile));
        List<Statistics> statisticsList = StatisticsUtil.getStatisticByProfiles(studentsList, universityList);
        WriteDataToXlsx.writeStatisticData(statisticsList, statisticInfoFile);

        FullReport fullReport = new FullReport();
        fullReport.setStudentList(studentsList);
        fullReport.setUniversityList(universityList);
        fullReport.setStatisticsList(statisticsList);
        fullReport.setProcessDate(LocalDateTime.now());
        XmlWriter.marshalling(fullReport);
        JsonWriter.writeJsonToFile(fullReport);
        logger.info("Application finished.");
    }
}
