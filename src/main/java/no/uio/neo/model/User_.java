package no.uio.neo.model;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-06-17T09:16:44.232+0200")
@StaticMetamodel(User.class)
public class User_ {
	public static volatile SingularAttribute<User, Integer> userId;
	public static volatile SingularAttribute<User, Timestamp> created;
	public static volatile SingularAttribute<User, Integer> createdBy;
	public static volatile SingularAttribute<User, String> name;
	public static volatile SingularAttribute<User, String> username;
}
