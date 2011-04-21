/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clevercloud.viadeo4j;

/**
 *
 * @author Julien Durillon
 */
public interface Viadeo {

    static final String USER_AGENT = System.getProperty("viadeo4j.http.user.agent", "viadeo4j:1.0 20110420");

    static final String CALLBACK_URL = "oob";

    static final String REQUEST_TOKEN_URL = "http://www.viadeo.com/oauth-provider/request_token";

    static final String USER_AUTHORIZATION_URL = "http://www.viadeo.com/oauth-provider/authorize";

    static final String ACCESS_TOKEN_URL = "http://www.viadeo.com/oauth-provider/access_token";

    static final String API_BASE_URL = "http://api.viadeo.com/";

    static final String API_METADATA_PATH = "/metadata";

    public String getAuthorizationUrl() throws ViadeoException;
}
