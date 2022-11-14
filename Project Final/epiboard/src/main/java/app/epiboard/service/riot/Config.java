package app.epiboard.service.riot;

import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Region;

public class Config {
    private final String API_KEY;
    private Region region;
    private static Config instance;

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    private Config() {
        API_KEY = "RGAPI-961e66a8-c786-4d86-8963-a555d56d18ac";
        region = Region.EUROPE_WEST;

        Orianna.setRiotAPIKey(API_KEY);
        Orianna.setDefaultRegion(region);
    }

    public String getKey() {
        return API_KEY;
    }

    public Region getRegion() {
        return region;
    }
}
