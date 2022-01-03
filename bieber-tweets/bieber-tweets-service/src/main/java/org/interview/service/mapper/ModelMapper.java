package org.interview.service.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.interview.common.model.Message;
import org.interview.common.model.User;
import org.interview.common.model.json.JSONMessage;
import org.interview.common.model.json.JSONUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ModelMapper {
	
	@Mapping(target = "id", expression = "java(Long.valueOf(jsonMessage.getId()).longValue())")
	@Mapping(target = "creationDate", source = "created_at", qualifiedByName = "stringToUnixTime")
	@Mapping(target = "content", source = "text")
	Message messageToModel(JSONMessage jsonMessage);
	
	@Mapping(target = "id", expression = "java(Long.valueOf(jsonUser.getId()).longValue())")
	@Mapping(target = "creationDate", source = "created_at", qualifiedByName = "stringToUnixTime")
	@Mapping(target = "screenName", source = "screen_name")
	User userToModel(JSONUser jsonUser);
	
	
	@Named("stringToUnixTime")
	default Long stringToUnixTime(String time) {
		SimpleDateFormat df = new SimpleDateFormat("EEE MMM d HH:mm:ss Z yyyy");
		Date date = null;
		try {
			date = df.parse(time);
		} catch (ParseException e) {}
		return date != null ? date.getTime() : null;
	}
}
