package app.epiboard.service.riot;

import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.staticdata.Champions;
import com.merakianalytics.orianna.types.core.summoner.Summoner;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;



@RestController
@Api(tags = "League of Legends", description = " ")
@RequestMapping(name = "/api/riot/league", produces = "application/json")
public class RiotController {

    @GetMapping("/overview/{pseudo}")
    @ApiOperation(value = "Retrieve a Player's Account from League of Legend", notes = "Return a player's account on JSON.")
    public String searchUser(@PathVariable String pseudo) {
        Config.getInstance();
        Summoner summoner = Orianna.summonerNamed(pseudo).get();
        if (summoner.exists()) {
            return summoner.toJSON();
        } else {
            return "The player \"" + pseudo + "\" doesn't exist.";
        }
    }

    @GetMapping("/match/{pseudo}")
    @ApiOperation(value = "Retrieve current game from a Player from League of Legend", notes = "Return current game information on JSON.")
    public String searchMatch(@PathVariable String pseudo) {
        Config.getInstance();
        Summoner summoner = Orianna.summonerNamed(pseudo).get();
        if (summoner.isInGame()) {
            return summoner.getCurrentMatch().toJSON();
        } else {
            return "The player \"" + pseudo + "\" doesn't exist or is not in game.";
        }
    }

    @GetMapping("/champions")
    @ApiOperation(value = "Retrieve All Champions from League of Legend", notes = "Return champions on JSON.")
    public String champions() {
        return Champions.withRegion(Region.EUROPE_WEST).get().toJSON();
    }

}
