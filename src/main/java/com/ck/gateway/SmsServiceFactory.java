package com.ck.gateway;

import com.ck.SmsConstants;
import lombok.extern.slf4j.Slf4j;
import org.jboss.logging.Logger;
import java.util.Map;

/**
 * @author Niko Köbler, https://www.n-k.de, @dasniko
 */
@Slf4j
public class SmsServiceFactory {
    private static final Logger log = Logger.getLogger(SmsServiceFactory.class);
    public static SmsService get(Map<String, String> config) {
        if (Boolean.parseBoolean(config.getOrDefault(SmsConstants.SIMULATION_MODE, "false"))) {
            return (phoneNumber, message) -> log.warn(String.format("***** SIMULATION MODE ***** Would send SMS to %s with text: %s", phoneNumber, message));
        } else {
            return (phoneNumber, message) -> log.warn(String.format("***** SIMULATION MODE ***** Would send SMS to %s with text: %s", phoneNumber, message));
        }
    }

}
