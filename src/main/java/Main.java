import comparators.studentComparatorClasses.IStudentComparator;
import comparators.universityComparatorClasses.IUniversityComparator;
import enums.StudentComparators;
import enums.UniversityComparators;
import models.Student;
import models.University;
import utils.ComparatorUtilClass;
import utils.ReadDataFromXlsx;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Students:");
        List<Student> students = ReadDataFromXlsx.getStudentData("src/main/resources/universityInfo.xlsx");
        IStudentComparator fullStudentNameComp = ComparatorUtilClass.getStudentComparator(StudentComparators.FULLNAMECOMPARATOR);
        IStudentComparator universityIdComp = ComparatorUtilClass.getStudentComparator(StudentComparators.UNIVERSITYIDCOMPARATOR);
        IStudentComparator courseNumberComp = ComparatorUtilClass.getStudentComparator(StudentComparators.COURSENUMBERCOMPARATOR);
        IStudentComparator avrExamScoreComp = ComparatorUtilClass.getStudentComparator(StudentComparators.AVREXAMSCORECOMPARATOR);
        Stream<Student> StudentListStream = students.stream();
        StudentListStream
                .sorted(fullStudentNameComp
                        .thenComparing(universityIdComp)
                        .thenComparing(courseNumberComp)
                        .thenComparing(avrExamScoreComp))
                .forEach(System.out::println);

        System.out.println("\nUniversities:");
        List<University> universities = ReadDataFromXlsx.getUniversityData("src/main/resources/universityInfo.xlsx");
        IUniversityComparator idComp = ComparatorUtilClass.getUniversityComparator(UniversityComparators.IDCOMPARATOR);
        IUniversityComparator fullUniversityNameComp = ComparatorUtilClass.getUniversityComparator(UniversityComparators.FULLNAMECOMPARATOR);
        IUniversityComparator shortNameComp = ComparatorUtilClass.getUniversityComparator(UniversityComparators.SHORTNAMECOMPARATOR);
        IUniversityComparator yearOfFoundationComp = ComparatorUtilClass.getUniversityComparator(UniversityComparators.YEAROFFOUNDATIONCOMPARATOR);
        IUniversityComparator mainProfileComp = ComparatorUtilClass.getUniversityComparator(UniversityComparators.MAINPROFILECOMPARATOR);
        Stream<University> UniversityListStream = universities.stream();
        UniversityListStream
                .sorted(idComp
                        .thenComparing(fullUniversityNameComp)
                        .thenComparing(shortNameComp)
                        .thenComparing(yearOfFoundationComp)
                        .thenComparing(mainProfileComp))
                .forEach(System.out::println);
    }
}
