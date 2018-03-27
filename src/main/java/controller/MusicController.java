package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//TODO: Music controller implement
@RestController
@RequestMapping("/music")
public class MusicController {
    @RequestMapping("/gettrack")
    public String getTrack(@RequestParam(value = "trackInf") String trackInf) {
        return null;
    }
}
