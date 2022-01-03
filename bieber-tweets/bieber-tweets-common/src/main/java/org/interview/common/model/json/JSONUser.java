package org.interview.common.model.json;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class JSONUser {
	private String id;
	private String created_at;
	private String name;
	private String screen_name;
}
