package net.cijug.demo.soccer.cukes;

import org.slf4j.bridge.SLF4JBridgeHandler;

import java.util.logging.Handler;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class KillStupidJavaUtilLogging {
    static {
        final Logger logger = LogManager.getLogManager().getLogger("");

        for (Handler h : logger.getHandlers()) {
            logger.removeHandler(h);
        }

        SLF4JBridgeHandler.install();
    }
}
