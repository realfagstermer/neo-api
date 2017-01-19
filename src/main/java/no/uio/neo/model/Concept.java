package no.uio.neo.model;

import javax.persistence.*;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the concepts database table.
 *
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "concepts")
@NamedQuery(name = "Concept.findAll", query = "SELECT c FROM Concept c")
public class Concept {

    @JsonProperty("id")
    @Id
    @SequenceGenerator(name = "CONCEPTS_CONCEPTID_GENERATOR", sequenceName = "CONCEPTS_CONCEPT_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONCEPTS_CONCEPTID_GENERATOR")
    @Column(name = "concept_id")
    private Integer conceptId;

    @JsonProperty("type")
    @Column(name = "concept_type")
    private String conceptType;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Timestamp created;

    @Column(name = "created_by")
    private Integer createdBy;

    private String definition;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Timestamp deprecated;

    @Column(name = "deprecated_by")
    private Integer deprecatedBy;

    @Column(name = "editorial_note")
    private String editorialNote;

    @JsonIgnore
    // @SequenceGenerator(name = "CONCEPTS_EXTERNALID_GENERATOR", sequenceName = "CONCEPTS_EXTERNAL_ID_SEQ")
    // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONCEPTS_EXTERNALID_GENERATOR")
    @Generated(GenerationTime.INSERT)
    @Column(name = "external_id", columnDefinition = "serial", insertable = false)
    private Integer externalId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Timestamp modified;

    @Column(name = "modified_by")
    private Integer modifiedBy;

    private String note;

    @Column(name = "replaced_by")
    private Integer replacedBy;

    @Column(name = "scope_note")
    private String scopeNote;

    @Column(name = "used_by_libs")
    private String usedByLibs;

    @JsonProperty("vocab")
    @Column(name = "vocab_id")
    private String vocabId;

    // bi-directional many-to-one association to Term
    @OneToMany(mappedBy = "concept", fetch = FetchType.EAGER)
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

    public Integer getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
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

    public Integer getDeprecatedBy() {
        return this.deprecatedBy;
    }

    public void setDeprecatedBy(Integer deprecatedBy) {
        this.deprecatedBy = deprecatedBy;
    }

    public String getEditorialNote() {
        return this.editorialNote;
    }

    public void setEditorialNote(String editorialNote) {
        this.editorialNote = editorialNote;
    }

    @JsonProperty("externalId")
    public String getExternalId() {
        int padding = (vocabId.equals("REAL") ? 6 : 5);// todo: fetch from database, support ujur
        return String.format("%s%0" + padding + "d", vocabId, externalId);
    }

    public Timestamp getModified() {
        return this.modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }

    public Integer getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getReplacedBy() {
        return this.replacedBy;
    }

    public void setReplacedBy(Integer replacedBy) {
        this.replacedBy = replacedBy;
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

    public String getVocabId() {
        return this.vocabId;
    }

    public void setVocabId(String vocabId) {
        this.vocabId = vocabId;
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