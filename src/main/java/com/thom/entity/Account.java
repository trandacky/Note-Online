package com.thom.entity;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "account")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="account_id")
	private Long id;

	@JsonIgnore
	@Column(unique = true)
	private String password;

	@Column
	private String name;

	@Column
	private Instant birthDay = ZonedDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh")).toInstant();

	@Column
	private Instant createDate = ZonedDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh")).toInstant();

	@Column
	private Instant updateDate = ZonedDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh")).toInstant();

	@OneToMany(mappedBy = "account")
	@JsonIgnore
	private List<Note> notes;

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Instant getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Instant birthDay) {
		this.birthDay = birthDay;
	}

	public Instant getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Instant createDate) {
		this.createDate = createDate;
	}

	public Instant getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Instant updateDate) {
		this.updateDate = updateDate;
	}

}
