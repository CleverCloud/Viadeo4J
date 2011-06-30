/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clevercloud.viadeo4j;

import com.clevercloud.viadeo4j.models.Company;
import com.clevercloud.viadeo4j.models.JobAd;
import com.clevercloud.viadeo4j.models.User;
import com.clevercloud.viadeo4j.models.UserMetadata;
import org.scribe.model.Token;
import org.scribe.model.Verifier;

import java.io.Serializable;

/**
 * @author Julien Durillon
 */
public interface Viadeo extends Serializable {

   static final String API_BASE_URL = "http://api.viadeo.com/";

   /**
    * Get request_token then the authorization_url and return it.
    *
    * @return oauth authorization_url
    * @throws ViadeoException
    */
   public String getAuthorizationUrl() throws ViadeoException;

   /**
    * Retrieve oauth access_token.
    *
    * @param verifier the oauth_verifier response from authorization.
    * @return the couple access_token / access_secret
    * @throws ViadeoException
    */
   public Token getAccessToken(String verifier);

   /**
    * Retrieve OAuth acces_token.
    *
    * @param verifier the verifier response from authorization.
    * @return the Token
    */
   public Token getAccessToken(Verifier verifier);

   /**
    * Get the company of id <strong>id</strong>.
    *
    * @param id The Identifier of the company.
    * @return The corresponding company.
    * @throws ViadeoException if the company does not exists, or is not a company.
    */
   public Company getCompany(String id) throws ViadeoException;

   /**
    * Get the Job Ad of id <strong>id</strong>.
    *
    * @param id The Identifier of the job ad.
    * @return The corresponding job ad.
    * @throws ViadeoException if the job ad does not exists, or is not a company.
    */
   public JobAd getJobAd(String id) throws ViadeoException;

   /**
    * Get the authenticated user.
    *
    * @return The user.
    * @throws ViadeoException
    */
   User getUser() throws ViadeoException;

   /**
    * Get the User of id <strong>id</strong>.
    *
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
    *
    * @param token
    */
   void setAccessToken(Token token);

   /**
    * Setter for the access token.
    *
    * @param token
    * @param secret
    */
   void setAccessToken(String token, String secret);
}
