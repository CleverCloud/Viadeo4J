package com.clevercloud.viadeo4j;

import org.scribe.model.Token;

/**
 *
 * @author Julien Durillon <julien.durillon@clever-cloud.com>
 */
public class ViadeoFactory {
    public Viadeo getViadeo(String key, String secret, String callbackUrl){
        return new ViadeoOauthImpl(key, secret, callbackUrl);
    }
    
    public Viadeo getAuthenticatedViadeo(String key, String secret, String callbackUrl, String accessToken, String accessSecret) {
        Token at = new Token(accessToken, accessSecret);
        return getAuthenticatedViadeo(key,secret,callbackUrl,at);
    }

    public Viadeo getAuthenticatedViadeo(String key, String secret, String callbackUrl, Token at) {
        return new ViadeoOauthImpl(key, secret, callbackUrl, at);
    }
    
    
}
