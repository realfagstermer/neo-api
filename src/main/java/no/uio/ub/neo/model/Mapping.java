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
public class Mapping  {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MAPPINGS_MAPPINGID_GENERATOR", sequenceName="MAPPINGS_MAPPING_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MAPPINGS_MAPPINGID_GENERATOR")
	@Column(name="mapping_id")
	private Integer mappingId;

	private Timestamp created;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="mapping_relation")
	private String mappingRelation;

	@Column(name="source_concept_id")
	private Integer sourceConceptId;

	@Column(name="target_concept_id")
	private String targetConceptId;

	@Column(name="target_vocabulary_id")
	private String targetVocabularyId;

	private Timestamp verified;

	@Column(name="verified_by")
	private Integer verifiedBy;

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

	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public String getMappingRelation() {
		return this.mappingRelation;
	}

	public void setMappingRelation(String mappingRelation) {
		this.mappingRelation = mappingRelation;
	}

	public Integer getSourceConceptId() {
		return this.sourceConceptId;
	}

	public void setSourceConceptId(Integer sourceConceptId) {
		this.sourceConceptId = sourceConceptId;
	}

	public String getTargetConceptId() {
		return this.targetConceptId;
	}

	public void setTargetConceptId(String targetConceptId) {
		this.targetConceptId = targetConceptId;
	}

	public String getTargetVocabularyId() {
		return this.targetVocabularyId;
	}

	public void setTargetVocabularyId(String targetVocabularyId) {
		this.targetVocabularyId = targetVocabularyId;
	}

	public Timestamp getVerified() {
		return this.verified;
	}

	public void setVerified(Timestamp verified) {
		this.verified = verified;
	}

	public Integer getVerifiedBy() {
		return this.verifiedBy;
	}

	public void setVerifiedBy(Integer verifiedBy) {
		this.verifiedBy = verifiedBy;
	}

}