package no.uio.ub.neo.model;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-12-22T11:44:56.431+0100")
@StaticMetamodel(Term.class)
public class Term_ {
	public static volatile SingularAttribute<Term, Integer> termId;
	public static volatile SingularAttribute<Term, String> langId;
	public static volatile SingularAttribute<Term, String> lexicalValue;
	public static volatile SingularAttribute<Term, String> status;
	public static volatile SingularAttribute<Term, Timestamp> termCreated;
	public static volatile SingularAttribute<Term, Integer> termCreatedBy;
	public static volatile SingularAttribute<Term, Timestamp> termModified;
	public static volatile SingularAttribute<Term, Integer> termModifiedBy;
	public static volatile SingularAttribute<Term, Concept> concept;
}
