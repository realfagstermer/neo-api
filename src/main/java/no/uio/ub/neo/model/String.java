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
public class String  {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="STRINGS_STRINGID_GENERATOR", sequenceName="STRINGS_STRING_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STRINGS_STRINGID_GENERATOR")
	@Column(name="string_id")
	private Integer stringId;

	private Timestamp created;

	@Column(name="created_by")
	private Integer createdBy;

	private Timestamp deprecated;

	@Column(name="deprecated_by")
	private Integer deprecatedBy;

	private Integer form;

	private Integer geographic;

	private Timestamp modified;

	@Column(name="modified_by")
	private Integer modifiedBy;

	private Integer subtopic;

	private Integer temporal;

	private Integer topic;

	@Column(name="vocab_id")
	private String vocabId;

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

	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getDeprecated() {
		return this.deprecated;
	}

	public void setDeprecated(Timestamp deprecated) {
		this.deprecated = deprecated;
	}

	public Integer getDeprecatedBy() {
		return this.deprecatedBy;
	}

	public void setDeprecatedBy(Integer deprecatedBy) {
		this.deprecatedBy = deprecatedBy;
	}

	public Integer getForm() {
		return this.form;
	}

	public void setForm(Integer form) {
		this.form = form;
	}

	public Integer getGeographic() {
		return this.geographic;
	}

	public void setGeographic(Integer geographic) {
		this.geographic = geographic;
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

	public Integer getSubtopic() {
		return this.subtopic;
	}

	public void setSubtopic(Integer subtopic) {
		this.subtopic = subtopic;
	}

	public Integer getTemporal() {
		return this.temporal;
	}

	public void setTemporal(Integer temporal) {
		this.temporal = temporal;
	}

	public Integer getTopic() {
		return this.topic;
	}

	public void setTopic(Integer topic) {
		this.topic = topic;
	}

	public String getVocabId() {
		return this.vocabId;
	}

	public void setVocabId(String vocabId) {
		this.vocabId = vocabId;
	}

}