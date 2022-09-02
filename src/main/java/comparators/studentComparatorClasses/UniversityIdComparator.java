package comparators.studentComparatorClasses;

import models.Student;
import org.apache.commons.lang3.StringUtils;

public class UniversityIdComparator implements IStudentComparator {
    @Override
    public int compare(Student student1, Student student2) {
        return StringUtils.compare(student1.getUniversityId(), student2.getUniversityId());
    }
}
