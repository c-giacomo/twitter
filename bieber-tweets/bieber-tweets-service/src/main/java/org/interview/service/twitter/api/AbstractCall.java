package org.interview.service.twitter.api;

import java.io.IOException;
import java.io.InputStreamReader;

import org.interview.service.mapper.ModelMapper;
import org.interview.service.twitter.oauth.TwitterAuthenticator;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.common.io.CharStreams;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class AbstractCall<T, V> {
	
	@Autowired
	protected ModelMapper mapper;
	
	@Autowired
	private TwitterAuthenticator twitterAuthenticator;
	
	protected Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	public String getCall(String path) throws IOException {
		HttpRequest request = twitterAuthenticator.getFactory().buildGetRequest(new GenericUrl(path));
		HttpResponse response = request.execute();
		
		return CharStreams.toString(new InputStreamReader(response.getContent(), response.getContentCharset()));
	}
	
	public abstract T convert(V message);

}
