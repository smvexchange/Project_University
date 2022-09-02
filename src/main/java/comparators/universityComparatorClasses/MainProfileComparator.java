package comparators.universityComparatorClasses;

import models.University;

public class MainProfileComparator implements IUniversityComparator {
    @Override
    public int compare(University university1, University university2) {
        return university1.getMainProfile().compareTo(university2.getMainProfile());
    }
}
