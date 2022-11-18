package utils;

import models.FullReport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

public class JsonWriter {

    private static final Logger logger = LogManager.getLogger(JsonWriter.class);

    private JsonWriter() {
    }

    public static void writeJsonToFile(FullReport report) {
        logger.debug("Starting serialization process.");
        try {
            Files.createDirectories(Paths.get("target\\jsonReqs\\"+ LocalDate.now()));
            logger.debug("Directory for *.json files created.");
        } catch (IOException exception) {
            logger.warn("The \"jsonReqs\" directory already exists.");
        }

        writeToJsonFile("target\\jsonReqs\\" + LocalDate.now() + "\\student_" + LocalDate.now() + ".json", JsonUtil.serializeList(report.getStudentList()));
        writeToJsonFile("target\\jsonReqs\\" + LocalDate.now() + "\\university_" + LocalDate.now() + ".json", JsonUtil.serializeList(report.getUniversityList()));
        writeToJsonFile("target\\jsonReqs\\" + LocalDate.now() + "\\statistics_" + LocalDate.now() + ".json", JsonUtil.serializeList(report.getStatisticsList()));
        logger.info("Serialization process successfully completed.");
    }

    private static void writeToJsonFile(String fileName, String sourceString) {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.write(String.valueOf(sourceString).getBytes(StandardCharsets.UTF_8));
        } catch (IOException exception) {
            logger.fatal("Unable to write " + fileName + " file", exception);
        }
        logger.debug(fileName + " file created.");
    }
}
