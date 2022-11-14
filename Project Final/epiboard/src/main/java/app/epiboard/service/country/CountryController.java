package app.epiboard.service.country;

import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@Api(tags = "Country", description = " ")
@RequestMapping(name = "/api/country", produces = "application/json")
public class CountryController {

    @GetMapping("/capital/{country}")
    @ApiOperation(value = "Retrieve a Capital from a country", notes = "Return capital on JSON.")
    public JsonNode getCapital(@PathVariable("country") String country) {
        try {
            CountryRest capital = new Capital(country);
            return capital.toJsonCapital();
        } catch (Exception e) {
            System.out.println("Capital of \"" + country + "\" not found.");
        }
        return null;
    }

    @GetMapping("/region/{region}")
    @ApiOperation(value = "Retrieve Countries from a region", notes = "Return countries on JSON.")
    public JsonNode getRegion(@PathVariable("region") String region) {
        try {
            CountryRest reg = new Region(region);
            return reg.toJsonCountries();
        } catch (Exception e) {
            System.out.println("Region of \""+ region +"\" not found.");
        }
        return null;
    }

    @GetMapping("/countries")
    @ApiOperation(value = "Retrieve all Countries", notes = "Return countries on JSON.")
    public JsonNode getCountry() throws IOException {
        CountryRest country = new Country();
        return country.toJSON();
    }
}
