package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

//TODO: Music controller implement
@RestController
@RequestMapping("/music")
public class MusicController {
    @RequestMapping("/listAlbum")
    public String listAlbum(@RequestParam(name = "id") UUID userid) {
        return null;
    }
}
