package app.epiboard.service.freedictionary;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class FreeDictionary {

    private String lang;

    private String word;

    private String url = "https://api.dictionaryapi.dev/api/v2/entries/en/";

    private final URL newUrl;

    public FreeDictionary(String word) throws MalformedURLException {
        this.word = word;
        this.url += word;
        this.newUrl = new URL(url);
    }

    public JsonNode toJsonPhonetic() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode tree = mapper.readTree(newUrl).get(0).get("phonetics");
        ObjectNode newTree = mapper.createObjectNode();
        ObjectNode subTree = mapper.createObjectNode();
        int i = 1;
        for (JsonNode s : tree) {
            if (s.get("text") != null || s.get("audio") != null) {
                subTree.set("text", s.get("text"));
                subTree.set("audio", s.get("audio"));
                newTree.putObject(String.valueOf(i++)).setAll(subTree);
            }
        }
        return newTree;
    }

    public JsonNode toJsonMeanings() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode tree = mapper.readTree(newUrl).get(0).get("meanings");
        System.out.println(tree.toString());
        ObjectNode newTree = mapper.createObjectNode();
        ObjectNode subTree = mapper.createObjectNode();
        int i = 1;
        for (int j = 0; tree.get(j) != null; j++) {
            for (JsonNode s : tree.get(j).get("definitions")) {
                if (s.get("definition") != null || s.get("example") != null) {
                    subTree.set("definition", s.get("definition"));
                    subTree.set("example", s.get("example"));
                    newTree.putObject(String.valueOf(i++)).setAll(subTree);
                }
            }
        }
        return newTree;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
