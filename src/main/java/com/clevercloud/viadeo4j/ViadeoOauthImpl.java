package com.clevercloud.viadeo4j;

import com.clevercloud.viadeo4j.auth.ViadeoWebServerApi;
import com.clevercloud.viadeo4j.json.*;
import com.clevercloud.viadeo4j.models.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.*;
import org.scribe.oauth.OAuthService;

import java.util.Date;

/**
 * @author Julien Durillon
 */
class ViadeoOauthImpl implements Viadeo {

   private OAuthService service;

   private Token accessToken;

   /**
    * Create a viadeo object that uses oauth to authenticate the user.
    *
    * @param applicationApiKey
    * @param applicationApiSecret
    * @param callbackUrl
    */
   public ViadeoOauthImpl(String applicationApiKey, String applicationApiSecret, String callbackUrl) {
      this.service = new ServiceBuilder().provider(ViadeoWebServerApi.class).apiKey(applicationApiKey).apiSecret(applicationApiSecret).callback(callbackUrl).build();
   }

   /**
    * Create a viadeo object that with existing access accessToken.
    *
    * @param applicationApiKey
    * @param applicationApiSecret
    * @param callbackUrl
    * @param accessToken
    */
   public ViadeoOauthImpl(String applicationApiKey, String applicationApiSecret, String callbackUrl, Token accessToken) {
      this(applicationApiKey, applicationApiSecret, callbackUrl);
      this.accessToken = accessToken;
   }

   @Override
   public String getAuthorizationUrl() throws ViadeoException {
      return this.service.getAuthorizationUrl(null);
   }

   @Override
   public Token getAccessToken(String verifier) {
      return this.getAccessToken(new Verifier(verifier));
   }

   public Token getAccessToken(Verifier verifier) {
      this.accessToken = this.service.getAccessToken(null, verifier);
      return this.accessToken;
   }

   @Override
   public void setAccessToken(Token token) {
      this.accessToken = token;
   }

   @Override
   public void setAccessToken(String token, String secret) {
      this.setAccessToken(new Token(token, secret));
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
         String user = makeRequest(id);

         Gson gson = new GsonBuilder().registerTypeAdapter(User.class, new UserConverter()).
                 registerTypeAdapter(Location.class, new LocationConverter()).
                 registerTypeAdapter(Date.class, new DateConverter()).create();
         return gson.fromJson(user, User.class);
      } catch (Exception ex) {
         throw new ViadeoException(ex);
      }
   }

   @Override
   public UserMetadata getUserMetadata(String id) throws ViadeoException {
      checkAccessToken();
      try {
         String userMetadata = makeRequest(id);

         Gson gson = new GsonBuilder().registerTypeAdapter(UserMetadata.class, new UserMetadataConverter()).create();
         return gson.fromJson(userMetadata, UserMetadata.class);
      } catch (Exception ex) {
         throw new ViadeoException(ex);
      }
   }

   @Override
   public JobAd getJobAd(String id) throws ViadeoException {
      checkAccessToken();
      try {
         String jobAd = makeRequest(id);

         Gson gson = new GsonBuilder().registerTypeAdapter(JobAd.class, new JobAdConverter()).
                 registerTypeAdapter(Date.class, new DateConverter()).create();
         return gson.fromJson(jobAd, JobAd.class);
      } catch (Exception ex) {
         throw new ViadeoException(ex);
      }
   }

   @Override
   public Company getCompany(String id) throws ViadeoException {
      checkAccessToken();
      try {
         String company = makeRequest(id);

         Gson gson = new GsonBuilder().registerTypeAdapter(Company.class, new CompanyConverter()).
                 registerTypeAdapter(Location.class, new LocationConverter()).
                 registerTypeAdapter(Date.class, new DateConverter()).create();
         return gson.fromJson(company, Company.class);
      } catch (Exception ex) {
         throw new ViadeoException(ex);
      }
   }

   private String makeRequest(String path) throws ViadeoException {
      try {

         if(this.accessToken == null) {
            throw new ViadeoException("The access_token does not exist. Please retrieve one before accessing to the API");
         }

         if (path.startsWith("/")) {
            path = path.substring(1);
         }

         OAuthRequest request = new OAuthRequest(Verb.GET, API_BASE_URL+path);
         this.service.signRequest(this.accessToken, request);
         Response response = request.send();

         return response.getBody();
      } catch (Exception ex) {
         throw new ViadeoException(ex);
      }
   }
}
