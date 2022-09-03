package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import models.Student;
import models.University;

import java.util.List;

public class JsonUtil {

    private JsonUtil() {
    }

    //    Student methods
    public static String serializeStudentObject(Student student) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(student);
    }

    public static String serializeStudentList(List<Student> studentList) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(studentList);
    }

    public static Student deserializeStudentObject(String student) {
        return new Gson().fromJson(student, Student.class);
    }

    public static List<Student> deserializeStudentList(String studentList) {
        return new Gson().fromJson(studentList, new TypeToken<List<Student>>() {
        }.getType());
    }

    //  University methods
    public static String serializeUniversityObject(University university) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(university);
    }

    public static String serializeUniversityList(List<University> universityList) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(universityList);
    }

    public static University deserializeUniversityObject(String university) {
        return new Gson().fromJson(university, University.class);
    }

    public static List<University> deserializeUniversityList(String universityList) {
        return new Gson().fromJson(universityList, new TypeToken<List<University>>() {
        }.getType());
    }
}
