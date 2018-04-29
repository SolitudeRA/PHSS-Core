package me.protogalaxy.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


//TODO: Music controller implement
@PreAuthorize("hasRole('ROLE_USER')")
@RestController
@RequestMapping("/music")
public class MusicController {
    @PostMapping("/upload")
    public String musicUpload(@RequestParam("music") MultipartFile file) {
        return null;
    }
}
