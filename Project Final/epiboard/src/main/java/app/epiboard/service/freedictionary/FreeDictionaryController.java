package app.epiboard.service.freedictionary;

import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@Api(tags = "Free Dictionary", description = " ")
@RequestMapping(name = "/api/freedictionary", produces = "application/json")
public class FreeDictionaryController {

    @GetMapping("/phonetic/{word}")
    @ApiOperation(value = "Retrieve an audio pronunciation from a Word", notes = "Return an audio and a phonetic on JSON.")
    public JsonNode dictionaryPhonetic(@PathVariable("word") String word) {
        try {
            FreeDictionary w = new FreeDictionary(word);
            return w.toJsonPhonetic();
        } catch (Exception e) {
            System.out.println("Word " + word + " not found, please make sure this is an English word.");
        }
        return null;
    }
    @GetMapping("/meaning/{word}")
    @ApiOperation(value = "Retrieve definition(s) from a Word", notes = "Return all definitions on JSON.")
    public JsonNode dictionaryMeaning(@PathVariable("word") String word) {
        try {
            FreeDictionary w = new FreeDictionary(word);
            return w.toJsonMeanings();
        } catch (Exception e) {
            System.out.println("Word " + word + " not found, please make sure this is an English word.");
        }
        return null;
    }
}
