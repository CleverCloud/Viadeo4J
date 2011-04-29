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
public class RequestToken implements Serializable {

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

    @Override
    public String toString() {
        return "RequestToken{" + "token=" + token + ", tokenSecret=" + tokenSecret + '}';
    }
}
