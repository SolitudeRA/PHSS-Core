package me.protogalaxy.security;

/**
 * PHSS Token
 *
 * @author SolitudeRA (https://github.com/SolitudeRA)
 */

public class PhssToken {
    private String issuer;
    private String expirationTime;
    private String username;
    private String password;
    private String picture;

    public PhssToken(String issuer, String expirationTime, String username, String password, String picture) {
        this.issuer = issuer;
        this.expirationTime = expirationTime;
        this.username = username;
        this.password = password;
        this.picture = picture;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(String expirationTime) {
        this.expirationTime = expirationTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
