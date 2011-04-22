/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clevercloud.viadeo4j;

import com.clevercloud.viadeo4j.auth.RequestToken;
import com.clevercloud.viadeo4j.models.Company;
import com.clevercloud.viadeo4j.models.JobAd;
import com.clevercloud.viadeo4j.models.User;
import com.clevercloud.viadeo4j.models.UserMetadata;

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

    public AccessToken getAccessToken(String verifier) throws ViadeoException;

    public String getApplicationKey();

    public String getApplicationSecret();

    public Company getCompany(String id) throws ViadeoException;

    public JobAd getJobAd(String id) throws ViadeoException;

    public RequestToken getRequestToken();

    User getUser() throws ViadeoException;

    User getUser(String id) throws ViadeoException;

    UserMetadata getUserMetadata(String id) throws ViadeoException;

    void setAccessToken(AccessToken token);

}
