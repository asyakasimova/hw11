package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/authorisation.properties"
})
public interface AuthorisationConfig extends Config {

    @Key("email.username")
    String emailUsername();
    @Key("email.password")
    String emailPassword();
}
