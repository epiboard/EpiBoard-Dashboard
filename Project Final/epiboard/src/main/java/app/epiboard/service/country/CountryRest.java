package app.epiboard.service.country;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class CountryRest {
    private String name;

    private java.net.URL URL;


    public CountryRest(String name, String url) throws MalformedURLException {
        this.name = name;
        this.URL = new URL(url);
    }
    public CountryRest(String url) throws MalformedURLException {
        this.URL = new URL(url);
    }

    public String getName() {
        return name;
    }


    public java.net.URL getURL() {
        return URL;
    }

    public JsonNode toJsonCapital() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(URL).get(0).get("capital");
    }
    public JsonNode toJsonCountries() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode tree = mapper.readTree(URL);
        ObjectNode newTree = mapper.createObjectNode();
        int i = 1;
        for (JsonNode s: tree) {
            newTree.set(String.valueOf(i++),s.get("name").get("common"));
        }
        return newTree;
    }
    public JsonNode toJSON() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(URL);
    }
}
