import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Students:");
        List<Student> students = ReadDataFromXlsx.getStudentData("src/main/resources/universityInfo.xlsx");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("\nUniversities:");
        List<University> universities = ReadDataFromXlsx.getUniversityData("src/main/resources/universityInfo.xlsx");
        for (University university : universities) {
            System.out.println(university);
        }
    }
}
