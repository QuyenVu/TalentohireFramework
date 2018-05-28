package helpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {

    private static Logger logger  = Logger.getLogger(Log.class.getName());
    private FileHandler fh = null;
    public Log() {
        //just to make our log file nicer :)
        SimpleDateFormat format = new SimpleDateFormat("M-d_HHmmss");
        try {
            fh = new FileHandler("C:\\Log\\test\\MyLogFile_"
                    + format.format(Calendar.getInstance().getTime()) + ".log");
        } catch (Exception e) {
            e.printStackTrace();
        }

        fh.setFormatter(new SimpleFormatter());
        logger.addHandler(fh);
    }

    public static void startTestCase(String sTestCaseName){
        logger .info("Started Test case");
    }

    public static void endTestCase(String sTestCaseName){
        logger .info("Ended Test Case");
    }

    public static void info(String message) { logger .info(message); }

    public static void error(String message)
    {
        logger .warning(message);
    }

}