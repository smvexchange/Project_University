package utils;

import comparators.studentComparatorClasses.FullNameComparator;
import comparators.studentComparatorClasses.*;
import comparators.universityComparatorClasses.*;
import enums.StudentComparators;
import enums.UniversityComparators;

public class ComparatorUtilClass {

    private ComparatorUtilClass() {

    }

    public static IStudentComparator getStudentComparator(StudentComparators comparators) {
        if (StudentComparators.FULLNAMECOMPARATOR.compareTo(comparators) == 0) {
            return new FullNameComparator();
        } else if (StudentComparators.UNIVERSITYIDCOMPARATOR.compareTo(comparators) == 0) {
            return new UniversityIdComparator();
        } else if (StudentComparators.COURSENUMBERCOMPARATOR.compareTo(comparators) == 0) {
            return new CourseNumberComparator();
        } else {
            return new AvrExamScoreComparator();
        }
    }

    public static IUniversityComparator getUniversityComparator(UniversityComparators comparators) {
        if (UniversityComparators.IDCOMPARATOR.compareTo(comparators) == 0) {
            return new IdComparator();
        } else if (UniversityComparators.FULLNAMECOMPARATOR.compareTo(comparators) == 0) {
            return new comparators.universityComparatorClasses.FullNameComparator();
        } else if (UniversityComparators.SHORTNAMECOMPARATOR.compareTo(comparators) == 0) {
            return new ShortNameComparator();
        } else if (UniversityComparators.YEAROFFOUNDATIONCOMPARATOR.compareTo(comparators) == 0) {
            return new YearOfFoundationComparator();
        } else {
            return new MainProfileComparator();
        }
    }
}
