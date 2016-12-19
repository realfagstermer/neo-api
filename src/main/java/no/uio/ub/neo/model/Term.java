package no.uio.ub.neo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the terms database table.
 * 
 */
@Entity
@Table(name="terms")
@NamedQuery(name="Term.findAll", query="SELECT t FROM Term t")
public class Term implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TERMS_TERMID_GENERATOR", sequenceName="TERMS_TERM_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TERMS_TERMID_GENERATOR")
	@Column(name="term_id")
	private Integer termId;

	@Column(name="lexical_value")
	private String lexicalValue;

	private String status;

	@Column(name="term_created")
	private Timestamp termCreated;

	@Column(name="term_modified")
	private Timestamp termModified;

	//bi-directional many-to-one association to Concept
	@ManyToOne
	@JoinColumn(name="concept_id")
	private Concept concept;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="lang_id")
	private Language language;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="term_created_by")
	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="term_modified_by")
	private User user2;

	public Term() {
	}

	public Integer getTermId() {
		return this.termId;
	}

	public void setTermId(Integer termId) {
		this.termId = termId;
	}

	public String getLexicalValue() {
		return this.lexicalValue;
	}

	public void setLexicalValue(String lexicalValue) {
		this.lexicalValue = lexicalValue;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getTermCreated() {
		return this.termCreated;
	}

	public void setTermCreated(Timestamp termCreated) {
		this.termCreated = termCreated;
	}

	public Timestamp getTermModified() {
		return this.termModified;
	}

	public void setTermModified(Timestamp termModified) {
		this.termModified = termModified;
	}

	public Concept getConcept() {
		return this.concept;
	}

	public void setConcept(Concept concept) {
		this.concept = concept;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

}