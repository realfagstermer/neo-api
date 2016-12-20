package no.uio.ub.neo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the concepts database table.
 *
 */
@Entity
@Table(name="concepts")
@NamedQuery(name="Concept.findAll", query="SELECT c FROM Concept c")
public class Concept implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONCEPTS_CONCEPTID_GENERATOR", sequenceName="CONCEPTS_CONCEPT_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONCEPTS_CONCEPTID_GENERATOR")
	@Column(name="concept_id")
	private Integer conceptId;

	@Column(name="concept_type")
	private String conceptType;

	private Timestamp created;

	private String definition;

	private Timestamp deprecated;

	@Column(name="editorial_note")
	private String editorialNote;

	@Column(name="external_id")
	private Integer externalId;

	private Timestamp modified;

	private String note;

	@Column(name="scope_note")
	private String scopeNote;

	@Column(name="used_by_libs")
	private String usedByLibs;

	//bi-directional many-to-one association to Concept
	@ManyToOne
	@JoinColumn(name="replaced_by")
	private Concept concept;

	//bi-directional many-to-one association to Concept
	@OneToMany(mappedBy="concept")
	private List<Concept> concepts;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="created_by")
	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="deprecated_by")
	private User user2;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="modified_by")
	private User user3;

	//bi-directional many-to-one association to Vocabulary
	@ManyToOne
	@JoinColumn(name="vocab_id")
	private Vocabulary vocabulary;

	//bi-directional many-to-one association to GroupMembership
	@OneToMany(mappedBy="concept")
	private List<GroupMembership> groupMemberships;

	//bi-directional many-to-one association to Mapping
	@OneToMany(mappedBy="concept")
	private List<Mapping> mappings;

	//bi-directional many-to-one association to Relationship
	@OneToMany(mappedBy="concept1Bean")
	private List<Relationship> relationships1;

	//bi-directional many-to-one association to Relationship
	@OneToMany(mappedBy="concept2Bean")
	private List<Relationship> relationships2;

	//bi-directional many-to-one association to String
	@OneToMany(mappedBy="concept1")
	private List<String> strings1;

	//bi-directional many-to-one association to String
	@OneToMany(mappedBy="concept2")
	private List<String> strings2;

	//bi-directional many-to-one association to String
	@OneToMany(mappedBy="concept3")
	private List<String> strings3;

	//bi-directional many-to-one association to String
	@OneToMany(mappedBy="concept4")
	private List<String> strings4;

	//bi-directional many-to-one association to String
	@OneToMany(mappedBy="concept5")
	private List<String> strings5;

	//bi-directional many-to-one association to Term
	@OneToMany(mappedBy="concept")
	private List<Term> terms;

	public Concept() {
	}

	public Integer getConceptId() {
		return this.conceptId;
	}

	public void setConceptId(Integer conceptId) {
		this.conceptId = conceptId;
	}

	public String getConceptType() {
		return this.conceptType;
	}

	public void setConceptType(String conceptType) {
		this.conceptType = conceptType;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public String getDefinition() {
		return this.definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public Timestamp getDeprecated() {
		return this.deprecated;
	}

	public void setDeprecated(Timestamp deprecated) {
		this.deprecated = deprecated;
	}

	public String getEditorialNote() {
		return this.editorialNote;
	}

	public void setEditorialNote(String editorialNote) {
		this.editorialNote = editorialNote;
	}

	public Integer getExternalId() {
		return this.externalId;
	}

	public void setExternalId(Integer externalId) {
		this.externalId = externalId;
	}

	public Timestamp getModified() {
		return this.modified;
	}

	public void setModified(Timestamp modified) {
		this.modified = modified;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getScopeNote() {
		return this.scopeNote;
	}

	public void setScopeNote(String scopeNote) {
		this.scopeNote = scopeNote;
	}

	public String getUsedByLibs() {
		return this.usedByLibs;
	}

	public void setUsedByLibs(String usedByLibs) {
		this.usedByLibs = usedByLibs;
	}

	public Concept getConcept() {
		return this.concept;
	}

	public void setConcept(Concept concept) {
		this.concept = concept;
	}

	public List<Concept> getConcepts() {
		return this.concepts;
	}

	public void setConcepts(List<Concept> concepts) {
		this.concepts = concepts;
	}

	public Concept addConcept(Concept concept) {
		getConcepts().add(concept);
		concept.setConcept(this);

		return concept;
	}

	public Concept removeConcept(Concept concept) {
		getConcepts().remove(concept);
		concept.setConcept(null);

		return concept;
	}

	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

	public User getUser3() {
		return this.user3;
	}

	public void setUser3(User user3) {
		this.user3 = user3;
	}

	public Vocabulary getVocabulary() {
		return this.vocabulary;
	}

	public void setVocabulary(Vocabulary vocabulary) {
		this.vocabulary = vocabulary;
	}

	public List<GroupMembership> getGroupMemberships() {
		return this.groupMemberships;
	}

	public void setGroupMemberships(List<GroupMembership> groupMemberships) {
		this.groupMemberships = groupMemberships;
	}

	public GroupMembership addGroupMembership(GroupMembership groupMembership) {
		getGroupMemberships().add(groupMembership);
		groupMembership.setConcept(this);

		return groupMembership;
	}

	public GroupMembership removeGroupMembership(GroupMembership groupMembership) {
		getGroupMemberships().remove(groupMembership);
		groupMembership.setConcept(null);

		return groupMembership;
	}

	public List<Mapping> getMappings() {
		return this.mappings;
	}

	public void setMappings(List<Mapping> mappings) {
		this.mappings = mappings;
	}

	public Mapping addMapping(Mapping mapping) {
		getMappings().add(mapping);
		mapping.setConcept(this);

		return mapping;
	}

	public Mapping removeMapping(Mapping mapping) {
		getMappings().remove(mapping);
		mapping.setConcept(null);

		return mapping;
	}

	public List<Relationship> getRelationships1() {
		return this.relationships1;
	}

	public void setRelationships1(List<Relationship> relationships1) {
		this.relationships1 = relationships1;
	}

	public Relationship addRelationships1(Relationship relationships1) {
		getRelationships1().add(relationships1);
		relationships1.setConcept1Bean(this);

		return relationships1;
	}

	public Relationship removeRelationships1(Relationship relationships1) {
		getRelationships1().remove(relationships1);
		relationships1.setConcept1Bean(null);

		return relationships1;
	}

	public List<Relationship> getRelationships2() {
		return this.relationships2;
	}

	public void setRelationships2(List<Relationship> relationships2) {
		this.relationships2 = relationships2;
	}

	public Relationship addRelationships2(Relationship relationships2) {
		getRelationships2().add(relationships2);
		relationships2.setConcept2Bean(this);

		return relationships2;
	}

	public Relationship removeRelationships2(Relationship relationships2) {
		getRelationships2().remove(relationships2);
		relationships2.setConcept2Bean(null);

		return relationships2;
	}

	public List<String> getStrings1() {
		return this.strings1;
	}

	public void setStrings1(List<String> strings1) {
		this.strings1 = strings1;
	}

	public String addStrings1(String strings1) {
		getStrings1().add(strings1);
		strings1.setConcept1(this);

		return strings1;
	}

	public String removeStrings1(String strings1) {
		getStrings1().remove(strings1);
		strings1.setConcept1(null);

		return strings1;
	}

	public List<String> getStrings2() {
		return this.strings2;
	}

	public void setStrings2(List<String> strings2) {
		this.strings2 = strings2;
	}

	public String addStrings2(String strings2) {
		getStrings2().add(strings2);
		strings2.setConcept2(this);

		return strings2;
	}

	public String removeStrings2(String strings2) {
		getStrings2().remove(strings2);
		strings2.setConcept2(null);

		return strings2;
	}

	public List<String> getStrings3() {
		return this.strings3;
	}

	public void setStrings3(List<String> strings3) {
		this.strings3 = strings3;
	}

	public String addStrings3(String strings3) {
		getStrings3().add(strings3);
		strings3.setConcept3(this);

		return strings3;
	}

	public String removeStrings3(String strings3) {
		getStrings3().remove(strings3);
		strings3.setConcept3(null);

		return strings3;
	}

	public List<String> getStrings4() {
		return this.strings4;
	}

	public void setStrings4(List<String> strings4) {
		this.strings4 = strings4;
	}

	public String addStrings4(String strings4) {
		getStrings4().add(strings4);
		strings4.setConcept4(this);

		return strings4;
	}

	public String removeStrings4(String strings4) {
		getStrings4().remove(strings4);
		strings4.setConcept4(null);

		return strings4;
	}

	public List<String> getStrings5() {
		return this.strings5;
	}

	public void setStrings5(List<String> strings5) {
		this.strings5 = strings5;
	}

	public String addStrings5(String strings5) {
		getStrings5().add(strings5);
		strings5.setConcept5(this);

		return strings5;
	}

	public String removeStrings5(String strings5) {
		getStrings5().remove(strings5);
		strings5.setConcept5(null);

		return strings5;
	}

	public List<Term> getTerms() {
		return this.terms;
	}

	public void setTerms(List<Term> terms) {
		this.terms = terms;
	}

	public Term addTerm(Term term) {
		getTerms().add(term);
		term.setConcept(this);

		return term;
	}

	public Term removeTerm(Term term) {
		getTerms().remove(term);
		term.setConcept(null);

		return term;
	}

}