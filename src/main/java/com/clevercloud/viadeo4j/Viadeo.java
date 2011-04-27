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

    /**
     * Get request_token then the authorization_url and return it.
     * 
     * @return oauth authorization_url
     * @throws ViadeoException 
     */
    public String getAuthorizationUrl() throws ViadeoException;

    /**
     * Retrieve oauth access_token.
     * @param verifier the oauth_verifier response from authorization.
     * @return the couple access_token / access_secret
     * @throws ViadeoException 
     */
    public AccessToken getAccessToken(String verifier) throws ViadeoException;

    /**
     * Getter for the application key.
     * @return The application key. (Given to the factory)
     */
    public String getApplicationKey();

    /**
     * Getter for the application secret.
     * @return The application secret. (Given to the factory)
     */
    public String getApplicationSecret();

    /**
     * Get the company of id <strong>id</strong>.
     * @param id The Identifier of the company.
     * @return The corresponding company.
     * @throws ViadeoException if the company does not exists, or is not a company.
     */
    public Company getCompany(String id) throws ViadeoException;

    /**
     * Get the Job Ad of id <strong>id</strong>.
     * @param id The Identifier of the job ad.
     * @return The corresponding job ad.
     * @throws ViadeoException if the job ad does not exists, or is not a company.
     */
    public JobAd getJobAd(String id) throws ViadeoException;

    public RequestToken getRequestToken();

    
    public void setRequestToken(String token, String secret);
    
    public void setRequestToken(RequestToken token);
    
    /**
     * Get the authenticated user.
     * @return The user.
     * @throws ViadeoException 
     */
    User getUser() throws ViadeoException;

    /**
     * Get the User of id <strong>id</strong>.
     * @param id The Identifier of the user.
     * @return The corresponding user.
     * @throws ViadeoException if the user does not exists, or is not a company.
     */
    User getUser(String id) throws ViadeoException;

    
    /**
     * Get the User metadata for id <strong>id</strong>.
     * 
     * @param id The identifier.
     * @return A UserMetadata instance.
     * @throws ViadeoException 
     */
    UserMetadata getUserMetadata(String id) throws ViadeoException;

    /**
     * Setter for the access token.
     * @param token 
     */
    void setAccessToken(AccessToken token);
    
    /**
     * Setter for the access token.
     * @param token
     * @param secret 
     */
    void setAccessToken(String token, String secret);
}
