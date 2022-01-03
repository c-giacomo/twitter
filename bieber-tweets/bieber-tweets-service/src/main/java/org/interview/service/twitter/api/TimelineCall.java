package org.interview.service.twitter.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.interview.common.model.Message;
import org.interview.common.model.json.JSONMessage;
import org.springframework.stereotype.Service;

import com.google.gson.reflect.TypeToken;

@Service
public class TimelineCall extends AbstractCall<List<Message>, List<JSONMessage>> {
	
	public List<Message> getTimeline(String path) throws IOException {
		String result = super.getCall(path);
		List<JSONMessage> jsonRes = gson.fromJson(result, new TypeToken<ArrayList<JSONMessage>>(){ }.getType());
		return convert(jsonRes);
	}

	@Override
	public List<Message> convert(List<JSONMessage> message) {
		return message.stream().map(mapper::messageToModel).collect(Collectors.toList());
	}

}
