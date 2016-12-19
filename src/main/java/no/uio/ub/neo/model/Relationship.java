package no.uio.ub.neo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the relationships database table.
 * 
 */
@Entity
@Table(name="relationships")
@NamedQuery(name="Relationship.findAll", query="SELECT r FROM Relationship r")
public class Relationship implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RELATIONSHIPS_RELATIONID_GENERATOR", sequenceName="RELATIONSHIPS_RELATION_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RELATIONSHIPS_RELATIONID_GENERATOR")
	@Column(name="relation_id")
	private Integer relationId;

	private Timestamp created;

	private Timestamp modified;

	@Column(name="rel_type")
	private String relType;

	//bi-directional many-to-one association to Concept
	@ManyToOne
	@JoinColumn(name="concept1")
	private Concept concept1Bean;

	//bi-directional many-to-one association to Concept
	@ManyToOne
	@JoinColumn(name="concept2")
	private Concept concept2Bean;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="created_by")
	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="modified_by")
	private User user2;

	public Relationship() {
	}

	public Integer getRelationId() {
		return this.relationId;
	}

	public void setRelationId(Integer relationId) {
		this.relationId = relationId;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getModified() {
		return this.modified;
	}

	public void setModified(Timestamp modified) {
		this.modified = modified;
	}

	public String getRelType() {
		return this.relType;
	}

	public void setRelType(String relType) {
		this.relType = relType;
	}

	public Concept getConcept1Bean() {
		return this.concept1Bean;
	}

	public void setConcept1Bean(Concept concept1Bean) {
		this.concept1Bean = concept1Bean;
	}

	public Concept getConcept2Bean() {
		return this.concept2Bean;
	}

	public void setConcept2Bean(Concept concept2Bean) {
		this.concept2Bean = concept2Bean;
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