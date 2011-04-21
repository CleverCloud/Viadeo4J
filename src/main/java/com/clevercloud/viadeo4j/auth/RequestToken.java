/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clevercloud.viadeo4j.auth;

/**
 *
 * @author Julien Durillon
 */
public class RequestToken {

    private String token;

    private String tokenSecret;

    public RequestToken(String token, String tokenSecret) {
        this.token = token;
        this.tokenSecret = tokenSecret;
    }

    public String getToken() {
        return token;
    }

    public String getTokenSecret() {
        return tokenSecret;
    }

    
}
