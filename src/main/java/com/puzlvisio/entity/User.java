package com.puzlvisio.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by Chudov A.V. on 11/13/2016.
 */
@Getter
@Setter
@Document(collection = "users")
public class User {

	@Id	private String id;
	private String login;
	private String password;
	private String email;
	private String type;
	private long score;
	private String status;
	private TS ts;
	private AdvInfo advInfo;
	private List<Friend> friends;
	private List<PuzzledPicture> puzzledPictures;

	public User(){
		this.ts = new TS();
	}
}
