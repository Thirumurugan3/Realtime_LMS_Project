package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class loggerUtil {
    private loggerUtil(){}

    public static Logger getLogger(Class<?> clazz){
        return LogManager.getLogger(clazz);
    }
}
