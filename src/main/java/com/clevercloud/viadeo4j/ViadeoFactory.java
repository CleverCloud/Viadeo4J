/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clevercloud.viadeo4j;

/**
 *
 * @author Julien Durillon <julien.durillon@clever-cloud.com>
 */
public class ViadeoFactory {
    public Viadeo getViadeo(String key, String secret, String callbackUrl){
        return new ViadeoOauthImpl(key, secret, callbackUrl);
    }
    
    
    public Viadeo getAuthenticatedViadeo(String key, String secret, String callbackUrl, String accessToken, String accessSecret) {
        AccessToken at = new AccessToken(accessToken, accessSecret);
        return getAuthenticatedViadeo(key,secret,callbackUrl,at);
    }

    private Viadeo getAuthenticatedViadeo(String key, String secret, String callbackUrl, AccessToken at) {
        return new ViadeoOauthImpl(key, secret, callbackUrl, at);
    }
    
    
}
