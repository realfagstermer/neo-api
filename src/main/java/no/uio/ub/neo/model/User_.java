package no.uio.ub.neo.model;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-12-20T12:40:58.126+0100")
@StaticMetamodel(User.class)
public class User_ {
	public static volatile SingularAttribute<User, Integer> userId;
	public static volatile SingularAttribute<User, Timestamp> created;
	public static volatile SingularAttribute<User, String> domain;
	public static volatile SingularAttribute<User, String> name;
	public static volatile SingularAttribute<User, String> username;
	public static volatile SingularAttribute<User, Integer> createdBy;
}
