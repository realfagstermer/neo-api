package no.uio.neo.model;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-06-15T12:36:59.977+0200")
@StaticMetamodel(ConceptString.class)
public class ConceptString_ {
	public static volatile SingularAttribute<ConceptString, Integer> stringId;
	public static volatile SingularAttribute<ConceptString, Timestamp> created;
	public static volatile SingularAttribute<ConceptString, Integer> createdBy;
	public static volatile SingularAttribute<ConceptString, Timestamp> deprecated;
	public static volatile SingularAttribute<ConceptString, Integer> deprecatedBy;
	public static volatile SingularAttribute<ConceptString, Integer> form;
	public static volatile SingularAttribute<ConceptString, Integer> geographic;
	public static volatile SingularAttribute<ConceptString, Timestamp> modified;
	public static volatile SingularAttribute<ConceptString, Integer> modifiedBy;
	public static volatile SingularAttribute<ConceptString, Integer> subtopic;
	public static volatile SingularAttribute<ConceptString, Integer> temporal;
	public static volatile SingularAttribute<ConceptString, Integer> topic;
	public static volatile SingularAttribute<ConceptString, String> vocabId;
}
