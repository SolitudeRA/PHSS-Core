package me.protogalaxy.controller;

import org.springframework.web.bind.annotation.*;


//TODO: Music controller implement
@RestController
@RequestMapping("/music")
public class MusicController {
    @RequestMapping("/upload")
    public String upload() {
        return null;
    }

    @GetMapping("/track")
    public String getTrack() {
        return null;
    }

    @RequestMapping("/updateTrack")
    public String updateTrack() {
        return null;
    }
}
