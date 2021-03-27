package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {

    private static WebConfig getWebConfig() {
        return ConfigFactory.newInstance().create(WebConfig.class, System.getProperties());
    }

    public static String getWebRemoteDriver() {

        return String.format(System.getProperty("web.remote.driver"),
                getWebConfig().webRemoteDriverUser(),
                getWebConfig().webRemoteDriverPassword());
    }

    public static boolean isRemoteWebDriver() {
        return System.getProperty("web.remote.driver") != null;
    }

    public static String getWebVideoStorage() {
        return System.getProperty("video.storage");
    }

    public static boolean isVideoOn() {
        return getWebVideoStorage() != null;
    }

    public static String getWebUrl() {
        return getWebConfig().webUrl();
    }

    private static AuthorizationConfig getAuthorisationConfig() {
        return ConfigFactory.newInstance().create(AuthorizationConfig.class, System.getProperties());
    }

    public static String getEmailUsername(){
        return getAuthorisationConfig().emailUsername();
    }

    public static String getEmailPassword(){
        return getAuthorisationConfig().emailPassword();
    }
}
