package org.interview.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.interview.common.model.Message;
import org.interview.service.twitter.api.TimelineCall;
import org.interview.service.twitter.api.TweetSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TwitterJob {
	
	@Autowired
	private TimelineCall timelineCall;
	
	@Autowired
	private TweetSearch tweetSearch;
	
	@SuppressWarnings("unchecked")
	public void doJob() throws IOException {
		List<Message> timeline = timelineCall.getTimeline("https://api.twitter.com/1.1/statuses/home_timeline.json");
		List<Message> bieberTrack = tweetSearch.trackTweets("https://api.twitter.com/1.1/search/tweets.json?q=bieber");
			
		List<Message> result = new ArrayList<>();
		result.addAll(timeline);
		result.addAll(bieberTrack);
		
		Collections.sort(result);
		log.info(result.toString());
	}

}
