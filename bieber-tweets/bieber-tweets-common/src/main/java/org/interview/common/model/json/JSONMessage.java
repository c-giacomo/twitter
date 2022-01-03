package org.interview.common.model.json;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class JSONMessage {
	
	private String created_at;
	private String id;
	private String id_str;
	private String text;
	private JSONUser user;

}
