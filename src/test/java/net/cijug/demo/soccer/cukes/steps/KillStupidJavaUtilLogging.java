package net.cijug.demo.soccer.cukes.steps;

import org.slf4j.bridge.SLF4JBridgeHandler;

import java.util.logging.Logger;
import java.util.logging.LogManager;
import java.util.logging.Handler;

public class KillStupidJavaUtilLogging {
    static {
        final Logger logger = LogManager.getLogManager().getLogger("");

        for (Handler h : logger.getHandlers()) {
            logger.removeHandler(h);
        }

        SLF4JBridgeHandler.install();
    }
}
