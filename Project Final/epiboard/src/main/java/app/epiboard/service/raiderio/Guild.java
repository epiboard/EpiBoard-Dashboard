package app.epiboard.service.raiderio;

import java.net.MalformedURLException;
public class Guild extends RaiderIo{
    public Guild(String region, String realm, String name) throws MalformedURLException {
        super(
                region,
                realm,
                name,
                String.format("https://raider.io/api/v1/guilds/profile?region=%s&realm=%s&name=%s&fields=members",
                        region,
                        realm,
                        name));
    }
}
