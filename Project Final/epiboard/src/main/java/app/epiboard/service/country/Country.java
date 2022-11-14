package app.epiboard.service.country;

import java.net.MalformedURLException;

public class Country extends CountryRest{

    public Country() throws MalformedURLException {
        super("https://restcountries.com/v3.1/all");
    }
}
