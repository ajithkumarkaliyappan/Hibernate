package com.hibernate.manytomanymapping;

import javax.persistence.*;

@Entity
@Table(name  = "answerM2M")
public class AnswerManyToMany {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String answerName;
	private String postedBy;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnswerName() {
		return answerName;
	}
	public void setAnswerName(String answerName) {
		this.answerName = answerName;
	}
	public String getPostedBy() {
		return postedBy;
	}
	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}
	
	
}
