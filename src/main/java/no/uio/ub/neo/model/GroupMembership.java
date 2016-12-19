package no.uio.ub.neo.model;

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
public class GroupMembership implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GROUP_MEMBERSHIPS_GROUPMEMBERSHIPID_GENERATOR", sequenceName="GROUP_MEMBERSHIPS_GROUP_MEMBERSHIP_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GROUP_MEMBERSHIPS_GROUPMEMBERSHIPID_GENERATOR")
	@Column(name="group_membership_id")
	private Integer groupMembershipId;

	private Timestamp created;

	//bi-directional many-to-one association to Concept
	@ManyToOne
	@JoinColumn(name="concept_id")
	private Concept concept;

	//bi-directional many-to-one association to Group
	@ManyToOne
	@JoinColumn(name="group_id")
	private Group group;

	public GroupMembership() {
	}

	public Integer getGroupMembershipId() {
		return this.groupMembershipId;
	}

	public void setGroupMembershipId(Integer groupMembershipId) {
		this.groupMembershipId = groupMembershipId;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Concept getConcept() {
		return this.concept;
	}

	public void setConcept(Concept concept) {
		this.concept = concept;
	}

	public Group getGroup() {
		return this.group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

}