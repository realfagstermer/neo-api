package no.uio.ub.neo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the groups database table.
 * 
 */
@Entity
@Table(name="groups")
@NamedQuery(name="Group.findAll", query="SELECT g FROM Group g")
public class Group  {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GROUPS_GROUPID_GENERATOR", sequenceName="GROUPS_GROUP_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GROUPS_GROUPID_GENERATOR")
	@Column(name="group_id")
	private Integer groupId;

	private Timestamp created;

	@Column(name="vocab_id")
	private String vocabId;

	public Group() {
	}

	public Integer getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public String getVocabId() {
		return this.vocabId;
	}

	public void setVocabId(String vocabId) {
		this.vocabId = vocabId;
	}

}