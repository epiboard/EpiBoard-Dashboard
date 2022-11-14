package app.epiboard.service.raiderio;

import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;


@RestController
@Api(tags = "Raider Io", description = " ")
@RequestMapping(name = "/api/raiderio", produces = "application/json")
public class RaiderIoController {


    @GetMapping("/character/{region}/{realm}/{name}")
    @ApiOperation(value = "Retrieve a Character from World of Warcraft", notes = "Return character's information on JSON.")
    public JsonNode raiderIoCharacter(@ApiParam(allowableValues = "eu, us, tw, kr, cn")
                                          @PathVariable("region") String region,
                                          @PathVariable("realm") String realm,
                                          @PathVariable("name") String name) {
        try {
            RaiderIo test = new Character(
                    region,
                    realm,
                    name);
            return test.toJson();
        } catch (Exception e) {
            System.out.println("Character: \"" + name +
                    "\" from the Realm : \"" + realm +
                    "-" + region + "\", not found.");
        }
        return null;
    }

    @GetMapping("/guild/{region}/{realm}/{name}")
    @ApiOperation(value = "Retrieve members of Guild from World of Warcraft", notes = "Return all members and their overview from a guild.")
    public JsonNode raiderIoGuild(@ApiParam(allowableValues = "eu, us, tw, kr, cn")
                                      @PathVariable("region") String region,
                                      @PathVariable("realm") String realm,
                                      @PathVariable("name") String name) {
        try {
            RaiderIo test = new Guild(
                    region,
                    realm,
                    name);
            return test.toJson();
        } catch (Exception e) {
            System.out.println("Guild: \"" + name +
                    "\" from the Realm : \"" + realm +
                    "-" + region + "\", not found.");
        }
        return null;

    }
}
