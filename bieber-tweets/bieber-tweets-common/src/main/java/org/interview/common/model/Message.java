package org.interview.common.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@SuppressWarnings("rawtypes")
public class Message implements Comparable {
	
	private Long id;
	private Long creationDate;
	private String content;
	private User user;
	
	@Override
	public int compareTo(Object o) {
		Message m = (Message) o;
        return getCreationDate().compareTo(m.getCreationDate());
	}
	
	@Override
	public String toString() {
		return getUser() + 
						   " Message id: " + getId() + "\n" + 
						   " Creation Date: " + getCreationDate() + "\n" +
						   " Content: " + getContent() + "\n\n\n";
	}

}
