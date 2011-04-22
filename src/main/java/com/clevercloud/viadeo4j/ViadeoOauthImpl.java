/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clevercloud.viadeo4j;

import com.clevercloud.viadeo4j.auth.RequestToken;
import com.clevercloud.viadeo4j.json.CompanyConverter;
import com.clevercloud.viadeo4j.json.DateConverter;
import com.clevercloud.viadeo4j.json.JobAdConverter;
import com.clevercloud.viadeo4j.json.LocationConverter;
import com.clevercloud.viadeo4j.json.UserConverter;
import com.clevercloud.viadeo4j.json.UserMetadataConverter;
import com.clevercloud.viadeo4j.models.Company;
import com.clevercloud.viadeo4j.models.JobAd;
import com.clevercloud.viadeo4j.models.Location;
import com.clevercloud.viadeo4j.models.User;
import com.clevercloud.viadeo4j.models.UserMetadata;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.basic.DefaultOAuthProvider;

/**
 *
 * @author Julien Durillon
 */
public class ViadeoOauthImpl implements Viadeo {

    private OAuthConsumer consumer;

    private OAuthProvider provider = new DefaultOAuthProvider(REQUEST_TOKEN_URL,
       ACCESS_TOKEN_URL,
       USER_AUTHORIZATION_URL);

    private String callBackUrl;

    private AccessToken accessToken;

    private RequestToken requestToken;

    public ViadeoOauthImpl(String applicationApiKey, String applicationApiSecret, String callbackUrl) {
        this.consumer = new DefaultOAuthConsumer(applicationApiKey, applicationApiSecret);
        this.callBackUrl = callbackUrl;
    }

    public ViadeoOauthImpl(String applicationApiKey, String applicationApiSecret, String callbackUrl, AccessToken token) {
        this(applicationApiKey, applicationApiSecret, callbackUrl);
        this.accessToken = token;
        if (this.accessToken != null) {
            this.consumer.setTokenWithSecret(token.getToken(), token.getTokenSecret());
        }
    }

    @Override
    public String getAuthorizationUrl() throws ViadeoException {
        try {
            return provider.retrieveRequestToken(consumer, this.callBackUrl);
        } catch (Exception ex) {
            throw new ViadeoException(ex);
        }
    }

    @Override
    public AccessToken getAccessToken(String verifier) throws ViadeoException {
        try {
            this.provider.retrieveAccessToken(this.consumer, verifier);
            this.accessToken = new AccessToken(this.consumer.getToken(), this.consumer.getTokenSecret());
            return this.accessToken;
        } catch (Exception ex) {
            throw new ViadeoException(ex);
        }
    }

    @Override
    public void setAccessToken(AccessToken token) {
        this.accessToken = token;
        if (this.accessToken != null) {
            this.consumer.setTokenWithSecret(token.getToken(), token.getTokenSecret());
        }
    }

    @Override
    public RequestToken getRequestToken() {
        return this.requestToken;
    }

    @Override
    public String getApplicationKey() {
        return consumer.getConsumerKey();
    }

    @Override
    public String getApplicationSecret() {
        return consumer.getConsumerSecret();
    }

    @Override
    public User getUser() throws ViadeoException {
        return this.getUser("me");
    }

    private void checkAccessToken() throws ViadeoException {
        if (this.accessToken == null) {
            throw new ViadeoException("This is not an authorized instance of Viadeo. Please first get or set the accessToken");
        }
    }

    @Override
    public User getUser(String id) throws ViadeoException {
        checkAccessToken();
        try {
            URL url = new URL(API_BASE_URL + id);
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            this.consumer.sign(huc);

            huc.connect();

            BufferedReader br = new BufferedReader(new InputStreamReader(huc.getInputStream()));

            String buf = null;
            StringBuilder sb = new StringBuilder();
            while ((buf = br.readLine()) != null) {
                sb.append(buf).append('\n');
            }

            Gson gson = new GsonBuilder().registerTypeAdapter(User.class, new UserConverter()).
               registerTypeAdapter(Location.class, new LocationConverter()).
               registerTypeAdapter(Date.class, new DateConverter()).create();
            return gson.fromJson(sb.toString(), User.class);
        } catch (Exception ex) {
            throw new ViadeoException(ex);
        }
    }

    @Override
    public UserMetadata getUserMetadata(String id) throws ViadeoException {
        checkAccessToken();
        try {
            URL url = new URL(API_BASE_URL + id + API_METADATA_PATH);
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            this.consumer.sign(huc);

            huc.connect();

            BufferedReader br = new BufferedReader(new InputStreamReader(huc.getInputStream()));

            String buf = null;
            StringBuilder sb = new StringBuilder();
            while ((buf = br.readLine()) != null) {
                sb.append(buf).append('\n');
            }

            Gson gson = new GsonBuilder().registerTypeAdapter(UserMetadata.class, new UserMetadataConverter()).create();
            return gson.fromJson(sb.toString(), UserMetadata.class);
        } catch (Exception ex) {
            throw new ViadeoException(ex);
        }
    }

    @Override
    public JobAd getJobAd(String id) throws ViadeoException {
        checkAccessToken();
        try {
            URL url = new URL(API_BASE_URL + id);
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            this.consumer.sign(huc);

            huc.connect();

            BufferedReader br = new BufferedReader(new InputStreamReader(huc.getInputStream()));

            String buf = null;
            StringBuilder sb = new StringBuilder();
            while ((buf = br.readLine()) != null) {
                sb.append(buf).append('\n');
            }

            Gson gson = new GsonBuilder().registerTypeAdapter(JobAd.class, new JobAdConverter()).
               registerTypeAdapter(Date.class, new DateConverter()).create();
            return gson.fromJson(sb.toString(), JobAd.class);
        } catch (Exception ex) {
            throw new ViadeoException(ex);
        }
    }

    @Override
    public Company getCompany(String id) throws ViadeoException {
        checkAccessToken();
        try {
            URL url = new URL(API_BASE_URL + id);
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            this.consumer.sign(huc);

            huc.connect();

            BufferedReader br = new BufferedReader(new InputStreamReader(huc.getInputStream()));

            String buf = null;
            StringBuilder sb = new StringBuilder();
            while ((buf = br.readLine()) != null) {
                sb.append(buf).append('\n');
            }

            Gson gson = new GsonBuilder().registerTypeAdapter(Company.class, new CompanyConverter()).
               registerTypeAdapter(Location.class, new LocationConverter()).
               registerTypeAdapter(Date.class, new DateConverter()).create();
            return gson.fromJson(sb.toString(), Company.class);
        } catch (Exception ex) {
            throw new ViadeoException(ex);
        }
    }
}
