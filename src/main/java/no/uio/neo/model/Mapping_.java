package no.uio.neo.model;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-12-21T10:39:45.307+0100")
@StaticMetamodel(Mapping.class)
public class Mapping_ {
	public static volatile SingularAttribute<Mapping, Integer> mappingId;
	public static volatile SingularAttribute<Mapping, Timestamp> created;
	public static volatile SingularAttribute<Mapping, Integer> createdBy;
	public static volatile SingularAttribute<Mapping, String> mappingRelation;
	public static volatile SingularAttribute<Mapping, Integer> sourceConceptId;
	public static volatile SingularAttribute<Mapping, String> targetConceptId;
	public static volatile SingularAttribute<Mapping, String> targetVocabularyId;
	public static volatile SingularAttribute<Mapping, Timestamp> verified;
	public static volatile SingularAttribute<Mapping, Integer> verifiedBy;
}
