package no.uio.neo.model;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-12-21T10:39:44.984+0100")
@StaticMetamodel(ExternalVocabulary.class)
public class ExternalVocabulary_ {
	public static volatile SingularAttribute<ExternalVocabulary, String> externalVocabularyId;
	public static volatile SingularAttribute<ExternalVocabulary, String> conceptSchemeUri;
	public static volatile SingularAttribute<ExternalVocabulary, String> conceptUriPattern;
	public static volatile SingularAttribute<ExternalVocabulary, Timestamp> created;
	public static volatile SingularAttribute<ExternalVocabulary, String> graphUri;
	public static volatile SingularAttribute<ExternalVocabulary, String> name;
	public static volatile SingularAttribute<ExternalVocabulary, String> note;
	public static volatile SingularAttribute<ExternalVocabulary, String> sparqlEndpoint;
}
