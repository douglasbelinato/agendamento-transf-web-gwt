package br.com.cvc.agendamento.integration.utils;

import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthBearerClientRequest;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
import org.apache.oltu.oauth2.client.response.OAuthResourceResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.types.GrantType;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Componente utilitário para centralizar a responsabilidade
 * de chamadas REST.
 *
 */
public class RestClientUtils {
	
	private static final String clientId = "clientCvc";
	
	private static final String clientSecret = "s3cr3t";
	
	private static final String host = "http://localhost:";
	
	private static final String serverPort = "8080";
	
	private static final String tokenUrl = "/oauth/token";
	
	private static final String APPLICATION_JSON = "application/json";
	
	public OAuthResourceResponse get(String uri) throws OAuthSystemException, OAuthProblemException {
		String token = getAccessToken();
    	OAuthClientRequest bearerClientRequest = new OAuthBearerClientRequest(host + serverPort + uri)
    	         .setAccessToken(token).buildQueryMessage();

    	OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());
    	return oAuthClient.resource(bearerClientRequest, OAuth.HttpMethod.GET, OAuthResourceResponse.class);
	}

	public OAuthResourceResponse post(String uri, String jsonBody) throws OAuthSystemException, OAuthProblemException {
		String token = getAccessToken();
    	
    	OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());
    	OAuthClientRequest bearerClientRequest = new OAuthBearerClientRequest(host + serverPort + uri)
    			.setAccessToken(token).buildQueryMessage();
    	
    	bearerClientRequest.setBody(jsonBody);
    	bearerClientRequest.setHeader("Content-Type", APPLICATION_JSON);
    	
	   	return oAuthClient.resource(bearerClientRequest, OAuth.HttpMethod.POST, OAuthResourceResponse.class);
	}
	
	private String getAccessToken() throws OAuthSystemException, OAuthProblemException {
		OAuthClientRequest request = OAuthClientRequest
	            .tokenLocation(host + serverPort + tokenUrl)
	            .setGrantType(GrantType.CLIENT_CREDENTIALS)
	            .buildQueryMessage();
		
		request.addHeader("Accept", APPLICATION_JSON);
        request.addHeader("Content-Type", APPLICATION_JSON);
        request.addHeader("Authorization", gerarBasicAuthorizationHeader());
        
        OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());
    	
    	return oAuthClient.accessToken(request, OAuthJSONAccessTokenResponse.class).getAccessToken();
	}
	
	private String gerarBasicAuthorizationHeader() {
		byte[] bytes = (clientId).concat(":").concat(clientSecret).getBytes(StandardCharsets.UTF_8);
		return "Basic ".concat(Base64.getEncoder().encodeToString(bytes));
	}

}
