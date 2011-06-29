package com.clevercloud.viadeo4j;

import org.scribe.builder.api.DefaultApi20;
import org.scribe.model.OAuthConfig;

/**
 * Created by IntelliJ IDEA.
 * User: Julien Durillon
 * Date: 29/06/11
 *
 * @author Julien Durillon
 */
public class ViadeoWebServerApi extends DefaultApi20 {

   private final String baseUrl = "http://www.viadeo.com/oauth-provider/";


   @Override
   public String getAccessTokenEndpoint() {
      return baseUrl + "access_token2";
   }

   @Override
   public String getAuthorizationUrl(OAuthConfig config) {
      return new StringBuilder(baseUrl).append("authorize2?").append("response_type=code")
              .append("&display=popup")
              .append("&client_id=").append(config.getApiKey())
              .append("&redirect_uri=").append(config.getCallback()).toString();
   }
}
