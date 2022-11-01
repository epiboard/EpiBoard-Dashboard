package com.example.restservice.raiderioservice;



import com.nimbusds.jose.shaded.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class CharacterProfil {
    private String region;
    private String realm;
    private String name;
    private String url = "https://raider.io/api/v1/characters/profile?region=" + region + "&realm=" + realm + "&name=" + name;

    CharacterProfil(String region, String realm, String name) {
        this.region = region;
        this.realm = realm;
        this.name = name;

    }

    /*public JSONObject readJsonFromUrl(String link) throws IOException {
        InputStream input = new URL(link).openStream();
        // Input Stream Object To Start Streaming.
        try {                                 // try catch for checked exception
            BufferedReader re = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
            // Buffer Reading In UTF-8
            String Text = Read(re);         // Handy Method To Read Data From BufferReader
            return new JSONObject(Text);    // Returning JSON
        } catch (Exception e) {
            return null;
        } finally {
            input.close();
        }
    }
    public String Read(Reader re) throws IOException {     // class Declaration
        StringBuilder str = new StringBuilder();     // To Store Url Data In String.
        int temp;
        do {

            temp = re.read();       //reading Charcter By Chracter.
            str.append((char) temp);

        } while (temp != -1);
        //  re.read() return -1 when there is end of buffer , data or end of file.

        return str.toString();

    }*/

    public String getCharacter() {
        return url;
    }

    public String getRegion() {
        return region;
    }

    public String getRealm() {
        return realm;
    }

    public String getName() {
        return name;
    }
}
