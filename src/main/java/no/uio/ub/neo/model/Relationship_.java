package no.uio.ub.neo.model;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-12-20T12:40:57.754+0100")
@StaticMetamodel(Relationship.class)
public class Relationship_ {
	public static volatile SingularAttribute<Relationship, Integer> relationId;
	public static volatile SingularAttribute<Relationship, Timestamp> created;
	public static volatile SingularAttribute<Relationship, Timestamp> modified;
	public static volatile SingularAttribute<Relationship, String> relType;
	public static volatile SingularAttribute<Relationship, Integer> concept1;
	public static volatile SingularAttribute<Relationship, Integer> concept2;
	public static volatile SingularAttribute<Relationship, Integer> createdBy;
	public static volatile SingularAttribute<Relationship, Integer> modifiedBy;
}
