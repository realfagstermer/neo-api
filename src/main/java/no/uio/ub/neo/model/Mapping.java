package no.uio.ub.neo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the mappings database table.
 * 
 */
@Entity
@Table(name="mappings")
@NamedQuery(name="Mapping.findAll", query="SELECT m FROM Mapping m")
public class Mapping implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MAPPINGS_MAPPINGID_GENERATOR", sequenceName="MAPPINGS_MAPPING_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MAPPINGS_MAPPINGID_GENERATOR")
	@Column(name="mapping_id")
	private Integer mappingId;

	private Timestamp created;

	@Column(name="mapping_relation")
	private String mappingRelation;

	@Column(name="target_concept_id")
	private String targetConceptId;

	private Timestamp verified;

	//bi-directional many-to-one association to Concept
	@ManyToOne
	@JoinColumn(name="source_concept_id")
	private Concept concept;

	//bi-directional many-to-one association to ExternalVocabulary
	@ManyToOne
	@JoinColumn(name="target_vocabulary_id")
	private ExternalVocabulary externalVocabulary;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="created_by")
	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="verified_by")
	private User user2;

	public Mapping() {
	}

	public Integer getMappingId() {
		return this.mappingId;
	}

	public void setMappingId(Integer mappingId) {
		this.mappingId = mappingId;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public String getMappingRelation() {
		return this.mappingRelation;
	}

	public void setMappingRelation(String mappingRelation) {
		this.mappingRelation = mappingRelation;
	}

	public String getTargetConceptId() {
		return this.targetConceptId;
	}

	public void setTargetConceptId(String targetConceptId) {
		this.targetConceptId = targetConceptId;
	}

	public Timestamp getVerified() {
		return this.verified;
	}

	public void setVerified(Timestamp verified) {
		this.verified = verified;
	}

	public Concept getConcept() {
		return this.concept;
	}

	public void setConcept(Concept concept) {
		this.concept = concept;
	}

	public ExternalVocabulary getExternalVocabulary() {
		return this.externalVocabulary;
	}

	public void setExternalVocabulary(ExternalVocabulary externalVocabulary) {
		this.externalVocabulary = externalVocabulary;
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