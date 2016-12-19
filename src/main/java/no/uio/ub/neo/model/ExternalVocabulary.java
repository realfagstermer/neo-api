package no.uio.ub.neo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the external_vocabularies database table.
 * 
 */
@Entity
@Table(name="external_vocabularies")
@NamedQuery(name="ExternalVocabulary.findAll", query="SELECT e FROM ExternalVocabulary e")
public class ExternalVocabulary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXTERNAL_VOCABULARIES_EXTERNALVOCABULARYID_GENERATOR", sequenceName="EXTERNAL_VOCABULARIES_EXTERNAL_VOCABULARY_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXTERNAL_VOCABULARIES_EXTERNALVOCABULARYID_GENERATOR")
	@Column(name="external_vocabulary_id")
	private String externalVocabularyId;

	@Column(name="concept_scheme_uri")
	private String conceptSchemeUri;

	@Column(name="concept_uri_pattern")
	private String conceptUriPattern;

	private Timestamp created;

	@Column(name="graph_uri")
	private String graphUri;

	private String name;

	private String note;

	@Column(name="sparql_endpoint")
	private String sparqlEndpoint;

	//bi-directional many-to-one association to Mapping
	@OneToMany(mappedBy="externalVocabulary")
	private List<Mapping> mappings;

	public ExternalVocabulary() {
	}

	public String getExternalVocabularyId() {
		return this.externalVocabularyId;
	}

	public void setExternalVocabularyId(String externalVocabularyId) {
		this.externalVocabularyId = externalVocabularyId;
	}

	public String getConceptSchemeUri() {
		return this.conceptSchemeUri;
	}

	public void setConceptSchemeUri(String conceptSchemeUri) {
		this.conceptSchemeUri = conceptSchemeUri;
	}

	public String getConceptUriPattern() {
		return this.conceptUriPattern;
	}

	public void setConceptUriPattern(String conceptUriPattern) {
		this.conceptUriPattern = conceptUriPattern;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public String getGraphUri() {
		return this.graphUri;
	}

	public void setGraphUri(String graphUri) {
		this.graphUri = graphUri;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getSparqlEndpoint() {
		return this.sparqlEndpoint;
	}

	public void setSparqlEndpoint(String sparqlEndpoint) {
		this.sparqlEndpoint = sparqlEndpoint;
	}

	public List<Mapping> getMappings() {
		return this.mappings;
	}

	public void setMappings(List<Mapping> mappings) {
		this.mappings = mappings;
	}

	public Mapping addMapping(Mapping mapping) {
		getMappings().add(mapping);
		mapping.setExternalVocabulary(this);

		return mapping;
	}

	public Mapping removeMapping(Mapping mapping) {
		getMappings().remove(mapping);
		mapping.setExternalVocabulary(null);

		return mapping;
	}

}