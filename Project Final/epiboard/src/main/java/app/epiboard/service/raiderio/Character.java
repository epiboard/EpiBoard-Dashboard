package app.epiboard.service.raiderio;

import java.net.MalformedURLException;
public class Character extends RaiderIo{
    public Character(String region, String realm, String name) throws MalformedURLException {
        super(
                region,
                realm,
                name,
                String.format("https://raider.io/api/v1/characters/profile?region=%s&realm=%s&name=%s",
                        region,
                        realm,
                        name));
    }
}
