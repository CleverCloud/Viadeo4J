/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.clevercloud.viadeo4j.auth;


import java.io.Serializable;


/**
 *
 * @author Julien Durillon
 */
public class AccessToken implements Serializable {

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

    @Override
    public String toString() {
        return "AccessToken{" + "token=" + token + ", tokenSecret=" + tokenSecret + '}';
    }
}
