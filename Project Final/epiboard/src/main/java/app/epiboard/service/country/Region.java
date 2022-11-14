package app.epiboard.service.country;

import java.net.MalformedURLException;

public class Region extends CountryRest {

    public Region(String region) throws MalformedURLException {
        super(region, String.format("https://restcountries.com/v3.1/region/%s", region));
    }
}
