package in.reqres.config;

import org.aeonbits.owner.ConfigFactory;

public class EndpointConfiguration {

    private static EndpointConfig endConfig = ConfigFactory.create(EndpointConfig.class);

    public static String getBaseUrl() {

        return endConfig.getBaseURL();
    }
}
