package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {

    private static AuthorisationConfig getAuthorisationConfig() {
        return ConfigFactory.newInstance().create(AuthorisationConfig.class, System.getProperties());
    }

    public static String getEmailUsername(){
        return getAuthorisationConfig().emailUsername();
    }

    public static String getEmailPassword(){
        return getAuthorisationConfig().emailPassword();
    }
}
