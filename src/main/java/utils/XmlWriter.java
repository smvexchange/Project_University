package utils;

import models.FullReport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

public class XmlWriter {

    private static final Logger logger = LogManager.getLogger(XmlWriter.class);

    private XmlWriter() {
    }

    public static void marshalling(FullReport report) {
        logger.debug("Starting marshalling process.");
        try {
            JAXBContext context = JAXBContext.newInstance(FullReport.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            try {
                Files.createDirectory(Paths.get("target\\xmlReqs"));
                logger.debug("Directory \"xmlReqs\" created.");
            } catch (IOException exception) {
                logger.warn("The \"xmlReqs\" directory already exists.");
            }
            File xmlFile = new File("target\\xmlReqs\\req_" + LocalDate.now() + ".xml");
            marshaller.marshal(report, xmlFile);
        } catch (JAXBException exception) {
            logger.error("Marshalling process failed.", exception);
        }
        logger.info("Marshalling process successfully completed.");
    }
}
