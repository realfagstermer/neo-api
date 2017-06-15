package no.uio.neo.model;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-06-15T12:15:10.408+0200")
@StaticMetamodel(Concept.class)
public class Concept_ {
	public static volatile SingularAttribute<Concept, Integer> conceptId;
	public static volatile SingularAttribute<Concept, String> conceptType;
	public static volatile SingularAttribute<Concept, Timestamp> created;
	public static volatile SingularAttribute<Concept, Integer> createdBy;
	public static volatile SingularAttribute<Concept, String> definition;
	public static volatile SingularAttribute<Concept, Timestamp> deprecated;
	public static volatile SingularAttribute<Concept, Integer> deprecatedBy;
	public static volatile SingularAttribute<Concept, String> editorialNote;
	public static volatile SingularAttribute<Concept, Integer> externalId;
	public static volatile SingularAttribute<Concept, Timestamp> modified;
	public static volatile SingularAttribute<Concept, Integer> modifiedBy;
	public static volatile SingularAttribute<Concept, String> note;
	public static volatile SingularAttribute<Concept, Integer> replacedBy;
	public static volatile SingularAttribute<Concept, String> scopeNote;
	public static volatile SingularAttribute<Concept, String> usedByLibs;
	public static volatile SingularAttribute<Concept, String> vocabId;
	public static volatile ListAttribute<Concept, Term> terms;
}
