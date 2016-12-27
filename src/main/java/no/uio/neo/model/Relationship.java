package no.uio.neo.model;

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
public class Relationship  {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RELATIONSHIPS_RELATIONID_GENERATOR", sequenceName="RELATIONSHIPS_RELATION_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RELATIONSHIPS_RELATIONID_GENERATOR")
	@Column(name="relation_id")
	private Integer relationId;

	private Integer concept1;

	private Integer concept2;

	private Timestamp created;

	@Column(name="created_by")
	private Integer createdBy;

	private Timestamp modified;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="rel_type")
	private String relType;

	public Relationship() {
	}

	public Integer getRelationId() {
		return this.relationId;
	}

	public void setRelationId(Integer relationId) {
		this.relationId = relationId;
	}

	public Integer getConcept1() {
		return this.concept1;
	}

	public void setConcept1(Integer concept1) {
		this.concept1 = concept1;
	}

	public Integer getConcept2() {
		return this.concept2;
	}

	public void setConcept2(Integer concept2) {
		this.concept2 = concept2;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getModified() {
		return this.modified;
	}

	public void setModified(Timestamp modified) {
		this.modified = modified;
	}

	public Integer getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getRelType() {
		return this.relType;
	}

	public void setRelType(String relType) {
		this.relType = relType;
	}

}