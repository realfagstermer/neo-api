package no.uio.ub.neo.model;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-12-20T12:40:57.814+0100")
@StaticMetamodel(String.class)
public class String_ {
	public static volatile SingularAttribute<String, Integer> stringId;
	public static volatile SingularAttribute<String, Timestamp> created;
	public static volatile SingularAttribute<String, Timestamp> deprecated;
	public static volatile SingularAttribute<String, Timestamp> modified;
	public static volatile SingularAttribute<String, Integer> createdBy;
	public static volatile SingularAttribute<String, Integer> deprecatedBy;
	public static volatile SingularAttribute<String, Integer> form;
	public static volatile SingularAttribute<String, Integer> geographic;
	public static volatile SingularAttribute<String, Integer> modifiedBy;
	public static volatile SingularAttribute<String, Integer> subtopic;
	public static volatile SingularAttribute<String, Integer> temporal;
	public static volatile SingularAttribute<String, Integer> topic;
}
