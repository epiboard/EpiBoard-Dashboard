package app.epiboard.service.raiderio;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class RaiderIo {
    private String region;
    private String realm;
    private String name;
    private URL newUrl;


    public RaiderIo(String region, String realm, String name, String url) throws MalformedURLException {
        this.region = region;
        this.realm = realm;
        this.name = name;
        this.newUrl = new URL(url);
    }

    public JsonNode toJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(newUrl);
    }
}
