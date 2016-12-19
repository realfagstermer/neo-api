package no.uio.ub.neo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vocabularies database table.
 * 
 */
@Entity
@Table(name="vocabularies")
@NamedQuery(name="Vocabulary.findAll", query="SELECT v FROM Vocabulary v")
public class Vocabulary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="VOCABULARIES_VOCABID_GENERATOR", sequenceName="VOCABULARIES_VOCAB_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VOCABULARIES_VOCABID_GENERATOR")
	@Column(name="vocab_id")
	private String vocabId;

	@Column(name="marc_value")
	private String marcValue;

	private Integer padding;

	//bi-directional many-to-one association to Concept
	@OneToMany(mappedBy="vocabulary")
	private List<Concept> concepts;

	//bi-directional many-to-one association to Group
	@OneToMany(mappedBy="vocabulary")
	private List<Group> groups;

	//bi-directional many-to-one association to String
	@OneToMany(mappedBy="vocabulary")
	private List<String> strings;

	public Vocabulary() {
	}

	public String getVocabId() {
		return this.vocabId;
	}

	public void setVocabId(String vocabId) {
		this.vocabId = vocabId;
	}

	public String getMarcValue() {
		return this.marcValue;
	}

	public void setMarcValue(String marcValue) {
		this.marcValue = marcValue;
	}

	public Integer getPadding() {
		return this.padding;
	}

	public void setPadding(Integer padding) {
		this.padding = padding;
	}

	public List<Concept> getConcepts() {
		return this.concepts;
	}

	public void setConcepts(List<Concept> concepts) {
		this.concepts = concepts;
	}

	public Concept addConcept(Concept concept) {
		getConcepts().add(concept);
		concept.setVocabulary(this);

		return concept;
	}

	public Concept removeConcept(Concept concept) {
		getConcepts().remove(concept);
		concept.setVocabulary(null);

		return concept;
	}

	public List<Group> getGroups() {
		return this.groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public Group addGroup(Group group) {
		getGroups().add(group);
		group.setVocabulary(this);

		return group;
	}

	public Group removeGroup(Group group) {
		getGroups().remove(group);
		group.setVocabulary(null);

		return group;
	}

	public List<String> getStrings() {
		return this.strings;
	}

	public void setStrings(List<String> strings) {
		this.strings = strings;
	}

	public String addString(String string) {
		getStrings().add(string);
		string.setVocabulary(this);

		return string;
	}

	public String removeString(String string) {
		getStrings().remove(string);
		string.setVocabulary(null);

		return string;
	}

}