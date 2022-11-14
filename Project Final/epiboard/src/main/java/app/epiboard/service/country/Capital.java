package app.epiboard.service.country;

import java.net.MalformedURLException;

public class Capital extends CountryRest{

    public Capital(String country) throws MalformedURLException {
        super(
                country,
                String.format("https://restcountries.com/v3.1/name/%s", country)
        );
    }
}
