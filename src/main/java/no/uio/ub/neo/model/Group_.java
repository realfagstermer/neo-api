package no.uio.ub.neo.model;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-12-21T10:39:45.086+0100")
@StaticMetamodel(Group.class)
public class Group_ {
	public static volatile SingularAttribute<Group, Integer> groupId;
	public static volatile SingularAttribute<Group, Timestamp> created;
	public static volatile SingularAttribute<Group, String> vocabId;
}
