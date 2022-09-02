package comparators.studentComparatorClasses;

import java.util.Comparator;

public interface IStudentComparator extends Comparator<models.Student> {
    int compare(models.Student student1, models.Student student2);
}
