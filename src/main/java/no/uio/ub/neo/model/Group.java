package no.uio.ub.neo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the groups database table.
 * 
 */
@Entity
@Table(name="groups")
@NamedQuery(name="Group.findAll", query="SELECT g FROM Group g")
public class Group implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GROUPS_GROUPID_GENERATOR", sequenceName="GROUPS_GROUP_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GROUPS_GROUPID_GENERATOR")
	@Column(name="group_id")
	private Integer groupId;

	private Timestamp created;

	//bi-directional many-to-one association to GroupMembership
	@OneToMany(mappedBy="group")
	private List<GroupMembership> groupMemberships;

	//bi-directional many-to-one association to Vocabulary
	@ManyToOne
	@JoinColumn(name="vocab_id")
	private Vocabulary vocabulary;

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

	public List<GroupMembership> getGroupMemberships() {
		return this.groupMemberships;
	}

	public void setGroupMemberships(List<GroupMembership> groupMemberships) {
		this.groupMemberships = groupMemberships;
	}

	public GroupMembership addGroupMembership(GroupMembership groupMembership) {
		getGroupMemberships().add(groupMembership);
		groupMembership.setGroup(this);

		return groupMembership;
	}

	public GroupMembership removeGroupMembership(GroupMembership groupMembership) {
		getGroupMemberships().remove(groupMembership);
		groupMembership.setGroup(null);

		return groupMembership;
	}

	public Vocabulary getVocabulary() {
		return this.vocabulary;
	}

	public void setVocabulary(Vocabulary vocabulary) {
		this.vocabulary = vocabulary;
	}

}