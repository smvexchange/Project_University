package comparators.universityComparatorClasses;

import java.util.Comparator;

public interface IUniversityComparator extends Comparator<models.University> {
    int compare(models.University university1, models.University university2);
}
