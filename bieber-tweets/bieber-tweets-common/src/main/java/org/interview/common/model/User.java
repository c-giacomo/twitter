package org.interview.common.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	private Long id;
	private Long creationDate;
	private String name;
	private String screenName;
	
	@Override
	public String toString() {
		return "User id: " + getId() + "\n" + 
			   " User Creation Date: " + getCreationDate() + "\n" +
			   " User Name: " + getName() + "\n" +
			   " Screen Name: " + getScreenName() + "\n";
	}

}
