package comparators.universityComparatorClasses;

import models.University;

public class YearOfFoundationComparator implements IUniversityComparator {
    @Override
    public int compare(University university1, University university2) {
        return Integer.compare(university1.getYearOfFoundation(), university2.getYearOfFoundation());
    }
}
