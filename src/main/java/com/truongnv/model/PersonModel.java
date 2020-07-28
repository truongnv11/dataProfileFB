package com.truongnv.model;

import java.io.Serializable;
import java.util.List;

public class PersonModel implements Serializable {
	private String uri;
	private String familyName;
	private String givenName;
	private String nick;
	private String birthday;
	private String phone;
	private String mbox;
	private String locality;
	private String schoolHomepage;
	private List<PersonModel> friends;
	private List<PostModel> posts;

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public List<PersonModel> getFriends() {
		return friends;
	}

	public void setFriends(List<PersonModel> friends) {
		this.friends = friends;
	}

	public List<PostModel> getPosts() {
		return posts;
	}

	public void setPosts(List<PostModel> posts) {
		this.posts = posts;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMbox() {
		return mbox;
	}

	public void setMbox(String mbox) {
		this.mbox = mbox;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getSchoolHomepage() {
		return schoolHomepage;
	}

	public void setSchoolHomepage(String schoolHomepage) {
		this.schoolHomepage = schoolHomepage;
	}

}
