package com.example.restservice.raiderioservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharacterProfilController {

    @GetMapping("/raider-io")
    public String characterProfil() {
        CharacterProfil character =  new CharacterProfil("eu", "hyjal", "Uzphen");
        return character.getCharacter();
    }
}
