import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadDataFromXlsx {

    private ReadDataFromXlsx() {
    }

    public static List<Student> getStudentData(String xlsxFile) throws IOException {
        List<Student> studentDataStorage = new ArrayList<>();
        Workbook workbook = new XSSFWorkbook(new FileInputStream(xlsxFile));
        Sheet sheet = workbook.getSheet("Студенты");
        Iterator<Row> iterator = sheet.rowIterator();
        iterator.next();
        while (iterator.hasNext()) {
            Row cells = iterator.next();
            if (cells.getCell(0) == null) {
                break;
            }
            studentDataStorage.add(new Student(
                    cells.getCell(1).getStringCellValue(),
                    cells.getCell(0).getStringCellValue(),
                    cells.getCell(2).getNumericCellValue(),
                    cells.getCell(3).getNumericCellValue()));
        }
        return studentDataStorage;
    }

    public static List<University> getUniversityData(String xlsxFile) throws IOException {
        List<University> universityDataStorage = new ArrayList<>();
        Workbook workbook = new XSSFWorkbook(new FileInputStream(xlsxFile));
        Sheet sheet = workbook.getSheet("Университеты");
        Iterator<Row> iterator = sheet.iterator();
        iterator.next();
        while (iterator.hasNext()) {
            Row cells = iterator.next();
            if (cells.getCell(0) == null) {
                break;
            }
            universityDataStorage.add(new University(
                    cells.getCell(0).getStringCellValue(),
                    cells.getCell(1).getStringCellValue(),
                    cells.getCell(2).getStringCellValue(),
                    (int) cells.getCell(3).getNumericCellValue(),
                    StudyProfile.valueOf(cells.getCell(4).getStringCellValue())));
        }
        return universityDataStorage;
    }
}
