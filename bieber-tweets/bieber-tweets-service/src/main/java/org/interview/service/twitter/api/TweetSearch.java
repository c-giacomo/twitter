package org.interview.service.twitter.api;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.interview.common.model.Message;
import org.interview.common.model.json.JSONStatuses;
import org.springframework.stereotype.Service;

import com.google.gson.reflect.TypeToken;

@Service
public class TweetSearch extends AbstractCall<List<Message>, JSONStatuses> {
	
	public List<Message> trackTweets(String path) throws IOException {
		String result = super.getCall(path);
		JSONStatuses jsonRes = gson.fromJson(result, new TypeToken<JSONStatuses>(){ }.getType());
		return convert(jsonRes);
	}

	@Override
	public List<Message> convert(JSONStatuses message) {
		return message.getStatuses().stream().map(mapper::messageToModel).collect(Collectors.toList());
	}

}
