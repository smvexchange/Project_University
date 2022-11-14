package utils;

import models.Statistics;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class WriteDataToXlsx {
    private static final Logger logger = LogManager.getLogger(WriteDataToXlsx.class.getName());

    private WriteDataToXlsx() {
    }

    public static void writeStatisticData(List<Statistics> statisticsList, Path path) {
        logger.info("Recording xlsx report started");
        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            XSSFSheet sheet = workbook.createSheet("Статистика");
            String[] columnHeaders = {"№ п/п",
                    "Профиль обучения",
                    "Средний балл за экзамен",
                    "Количество студентов по профилю",
                    "Количество университетов по профилю",
                    "Названия университетов"};
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setFontHeightInPoints((short) 12);
            headerFont.setColor(IndexedColors.BLACK.index);
            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFont(headerFont);
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
            headerStyle.setBorderTop(BorderStyle.THIN);
            headerStyle.setBorderRight(BorderStyle.THIN);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            CellStyle dataCellStyle = workbook.createCellStyle();
            dataCellStyle.setBorderTop(BorderStyle.THIN);
            dataCellStyle.setBorderRight(BorderStyle.THIN);
            dataCellStyle.setBorderBottom(BorderStyle.THIN);
            dataCellStyle.setBorderLeft(BorderStyle.THIN);
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < columnHeaders.length; i++) {
                Cell headerCell = headerRow.createCell(i);
                headerCell.setCellValue(columnHeaders[i]);
                headerCell.setCellStyle(headerStyle);
            }
            int rowNumber = 1;
            for (Statistics element : statisticsList) {
                Row row = sheet.createRow(rowNumber);
                Cell cell0 = row.createCell(0);
                cell0.setCellValue(rowNumber);
                cell0.setCellStyle(dataCellStyle);
                Cell cell1 = row.createCell(1);
                cell1.setCellValue(element.getProfile().toString());
                cell1.setCellStyle(dataCellStyle);
                Cell cell2 = row.createCell(2);
                cell2.setCellValue(element.getAvrExamScore());
                cell2.setCellStyle(dataCellStyle);
                Cell cell3 = row.createCell(3);
                cell3.setCellValue(element.getQuantityOfStudentByProfile());
                cell3.setCellStyle(dataCellStyle);
                Cell cell4 = row.createCell(4);
                cell4.setCellValue(element.getQuantityOfUniversityByProfile());
                cell4.setCellStyle(dataCellStyle);
                Cell cell5 = row.createCell(5);
                cell5.setCellValue(element.getUniversityName());
                cell5.setCellStyle(dataCellStyle);
                rowNumber++;
            }
            for (int i = 0; i < columnHeaders.length; i++) {
                sheet.autoSizeColumn(i);
            }
            try (FileOutputStream fos = new FileOutputStream(path.toFile())) {
                workbook.write(fos);
            } catch (IOException exception) {
                logger.error("Unable to write file", exception);
            }
        } catch (IOException exception) {
            logger.error("Unable to create xlsx workbook", exception);
        }
        logger.info("Recording *.xlsx report finished");
    }
}
