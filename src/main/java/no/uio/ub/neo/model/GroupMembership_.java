package no.uio.ub.neo.model;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-12-20T12:40:57.458+0100")
@StaticMetamodel(GroupMembership.class)
public class GroupMembership_ {
	public static volatile SingularAttribute<GroupMembership, Integer> groupMembershipId;
	public static volatile SingularAttribute<GroupMembership, Timestamp> created;
	public static volatile SingularAttribute<GroupMembership, Integer> conceptId;
	public static volatile SingularAttribute<GroupMembership, Integer> groupId;
}
