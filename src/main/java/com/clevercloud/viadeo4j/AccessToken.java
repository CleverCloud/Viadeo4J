/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.clevercloud.viadeo4j;

/**
 *
 * @author Julien Durillon
 */
public class AccessToken {

    private String token;
    private String tokenSecret;

    public AccessToken(String accessToken, String accessTokenSecret) {
        this.token = accessToken;
        this.tokenSecret = accessTokenSecret;
    }

    public String getToken() {
        return token;
    }

    public String getTokenSecret() {
        return tokenSecret;
    }
}
