package no.uio.ub.neo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the strings database table.
 * 
 */
@Entity
@Table(name="strings")
@NamedQuery(name="String.findAll", query="SELECT s FROM String s")
public class String implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="STRINGS_STRINGID_GENERATOR", sequenceName="STRINGS_STRING_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STRINGS_STRINGID_GENERATOR")
	@Column(name="string_id")
	private Integer stringId;

	private Timestamp created;

	private Timestamp deprecated;

	private Timestamp modified;

	//bi-directional many-to-one association to Concept
	@ManyToOne
	@JoinColumn(name="form")
	private Concept concept1;

	//bi-directional many-to-one association to Concept
	@ManyToOne
	@JoinColumn(name="geographic")
	private Concept concept2;

	//bi-directional many-to-one association to Concept
	@ManyToOne
	@JoinColumn(name="subtopic")
	private Concept concept3;

	//bi-directional many-to-one association to Concept
	@ManyToOne
	@JoinColumn(name="temporal")
	private Concept concept4;

	//bi-directional many-to-one association to Concept
	@ManyToOne
	@JoinColumn(name="topic")
	private Concept concept5;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="created_by")
	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="deprecated_by")
	private User user2;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="modified_by")
	private User user3;

	//bi-directional many-to-one association to Vocabulary
	@ManyToOne
	@JoinColumn(name="vocab_id")
	private Vocabulary vocabulary;

	public String() {
	}

	public Integer getStringId() {
		return this.stringId;
	}

	public void setStringId(Integer stringId) {
		this.stringId = stringId;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getDeprecated() {
		return this.deprecated;
	}

	public void setDeprecated(Timestamp deprecated) {
		this.deprecated = deprecated;
	}

	public Timestamp getModified() {
		return this.modified;
	}

	public void setModified(Timestamp modified) {
		this.modified = modified;
	}

	public Concept getConcept1() {
		return this.concept1;
	}

	public void setConcept1(Concept concept1) {
		this.concept1 = concept1;
	}

	public Concept getConcept2() {
		return this.concept2;
	}

	public void setConcept2(Concept concept2) {
		this.concept2 = concept2;
	}

	public Concept getConcept3() {
		return this.concept3;
	}

	public void setConcept3(Concept concept3) {
		this.concept3 = concept3;
	}

	public Concept getConcept4() {
		return this.concept4;
	}

	public void setConcept4(Concept concept4) {
		this.concept4 = concept4;
	}

	public Concept getConcept5() {
		return this.concept5;
	}

	public void setConcept5(Concept concept5) {
		this.concept5 = concept5;
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

	public User getUser3() {
		return this.user3;
	}

	public void setUser3(User user3) {
		this.user3 = user3;
	}

	public Vocabulary getVocabulary() {
		return this.vocabulary;
	}

	public void setVocabulary(Vocabulary vocabulary) {
		this.vocabulary = vocabulary;
	}

}