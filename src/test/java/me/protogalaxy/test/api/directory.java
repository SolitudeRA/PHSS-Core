package me.protogalaxy.test.api;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class directory {
    @Test
    public void create() {
        try {
            Files.createDirectories(Paths.get("/dir1/dir2/dir3"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
