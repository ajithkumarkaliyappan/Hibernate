package com.hibernate.manytomanymapping;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="questionM2M")
public class QuestionManyToMany {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String questionName;
	
	//many to many mapping 
	@ManyToMany(targetEntity = AnswerManyToMany.class, cascade = {CascadeType.ALL})
	
	//3rd new table created
	@JoinTable(
			name = "Q_A_m2m",
			joinColumns = {@JoinColumn(name = "q_id")},
			inverseJoinColumns = { @JoinColumn(name = "ans_id")})
	private List<AnswerManyToMany> answers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public List<AnswerManyToMany> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswerManyToMany> answers) {
		this.answers = answers;
	}


	
	
	
	
}
