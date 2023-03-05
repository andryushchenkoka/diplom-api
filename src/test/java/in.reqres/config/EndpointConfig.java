package in.reqres.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/endpoint.properties"
})
public interface EndpointConfig extends Config {

    @Key("base-url")
    String getBaseURL();

    @Key("login")
    String getLoginEndpoint();

    @Key("register")
    String getRegisterEndpoint();

    @Key("singleUser")
    String getSingleUserEndpoint();
}
