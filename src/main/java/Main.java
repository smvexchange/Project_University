import models.Student;
import models.University;
import utils.ReadDataFromXlsx;
import utils.StatisticsUtil;
import utils.WriteDataToXlsx;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        //Read data from *.xlsx file
        List<Student> studentsList = ReadDataFromXlsx.getStudentData("src/main/resources/universityInfo.xlsx");
        List<University> universityList = ReadDataFromXlsx.getUniversityData("src/main/resources/universityInfo.xlsx");

        //Get statistic and write to *.xlsx file
        Path path = Paths.get("src/main/resources/statisticInfo.xlsx");
        WriteDataToXlsx.writeStatisticData(StatisticsUtil.getStatisticByProfiles(studentsList, universityList), path);
    }
}
