package no.uio.neo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the group_memberships database table.
 * 
 */
@Entity
@Table(name="group_memberships")
@NamedQuery(name="GroupMembership.findAll", query="SELECT g FROM GroupMembership g")
public class GroupMembership  {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GROUP_MEMBERSHIPS_GROUPMEMBERSHIPID_GENERATOR", sequenceName="GROUP_MEMBERSHIPS_GROUP_MEMBERSHIP_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GROUP_MEMBERSHIPS_GROUPMEMBERSHIPID_GENERATOR")
	@Column(name="group_membership_id")
	private Integer groupMembershipId;

	@Column(name="concept_id")
	private Integer conceptId;

	private Timestamp created;

	@Column(name="group_id")
	private Integer groupId;

	public GroupMembership() {
	}

	public Integer getGroupMembershipId() {
		return this.groupMembershipId;
	}

	public void setGroupMembershipId(Integer groupMembershipId) {
		this.groupMembershipId = groupMembershipId;
	}

	public Integer getConceptId() {
		return this.conceptId;
	}

	public void setConceptId(Integer conceptId) {
		this.conceptId = conceptId;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Integer getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

}