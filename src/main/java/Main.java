import models.Student;
import models.University;
import utils.JsonUtil;
import utils.ReadDataFromXlsx;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        //Read data from *.xlsx file
        List<Student> studentsBeforeSerialization = ReadDataFromXlsx.getStudentData("src/main/resources/universityInfo.xlsx");
        List<University> universityBeforeSerialization = ReadDataFromXlsx.getUniversityData("src/main/resources/universityInfo.xlsx");

        //Serialization and deserialization Student list
        System.out.println("Student list in JSON format:");
        String studentsToJson = JsonUtil.serializeStudentList(studentsBeforeSerialization);
        System.out.println(studentsToJson);
        List<Student> studentsAfterDeserialization = JsonUtil.deserializeStudentList(studentsToJson);
        System.out.println(studentsBeforeSerialization.equals(studentsAfterDeserialization) ? "The collections are identical." : "The collections are not identical.");

        //Serialization and deserialization University list
        System.out.println("\nUniversity list in JSON format:");
        String universityToJson = JsonUtil.serializeUniversityList(universityBeforeSerialization);
        System.out.println(universityToJson);
        List<University> universityAfterDeserialization = JsonUtil.deserializeUniversityList(universityToJson);
        System.out.println(universityBeforeSerialization.equals(universityAfterDeserialization) ? "The collections are identical." : "The collections are not identical.");

        //Serialization and deserialization Student objects
        Stream<Student> listOfStudents1 = studentsBeforeSerialization.stream();
        Stream<Student> listOfStudents2 = studentsBeforeSerialization.stream();
        System.out.println("\nSome Student objects in JSON format and in original format:");
        Stream.concat(
                        listOfStudents1.limit(2).map(JsonUtil::serializeStudentObject),
                        listOfStudents2.limit(2).map(JsonUtil::serializeStudentObject).map(JsonUtil::deserializeStudentObject))
                .forEach(System.out::println);

        //Serialization and deserialization University objects
        Stream<University> listOfUniversity1 = universityBeforeSerialization.stream();
        Stream<University> listOfUniversity2 = universityBeforeSerialization.stream();
        System.out.println("\nSome University objects in JSON format and in original format:");
        Stream.concat(
                        listOfUniversity1.limit(2).map(JsonUtil::serializeUniversityObject),
                        listOfUniversity2.limit(2).map(JsonUtil::serializeUniversityObject).map(JsonUtil::deserializeUniversityObject))
                .forEach(System.out::println);
    }
}
