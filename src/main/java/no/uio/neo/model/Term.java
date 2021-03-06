package no.uio.neo.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.sql.Timestamp;

/**
 * The persistent class for the terms database table.
 *
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "terms")
@NamedQuery(name = "Term.findAll", query = "SELECT t FROM Term t")
public class Term {
    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    @Id
    @SequenceGenerator(name = "TERMS_TERMID_GENERATOR", sequenceName = "TERMS_TERM_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TERMS_TERMID_GENERATOR")
    @Column(name = "term_id")
    private Integer termId;

    @JsonProperty("lang")
    @Column(name = "lang_id")
    private String langId;

    @JsonProperty("value")
    @Column(name = "lexical_value")
    private String lexicalValue;

    private String status;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JsonProperty("created")
    @Column(name = "term_created")
    private Timestamp termCreated;

    @JsonProperty("createdBy")
    @Column(name = "term_created_by")
    private Integer termCreatedBy;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JsonProperty("modified")
    @Column(name = "term_modified")
    private Timestamp termModified;

    @JsonProperty("modifiedBy")
    @Column(name = "term_modified_by")
    private Integer termModifiedBy;

    // bi-directional many-to-one association to Concept
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "concept_id")
    private Concept concept;

    public Term() {
    }

    public Integer getTermId() {
        return this.termId;
    }

    public void setTermId(Integer termId) {
        this.termId = termId;
    }

    public String getLangId() {
        return this.langId;
    }

    public void setLangId(String langId) {
        this.langId = langId;
    }

    public String getLexicalValue() {
        return this.lexicalValue;
    }

    public void setLexicalValue(String lexicalValue) {
        this.lexicalValue = lexicalValue;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getTermCreated() {
        return this.termCreated;
    }

    public void setTermCreated(Timestamp termCreated) {
        this.termCreated = termCreated;
    }

    public Integer getTermCreatedBy() {
        return this.termCreatedBy;
    }

    public void setTermCreatedBy(Integer termCreatedBy) {
        this.termCreatedBy = termCreatedBy;
    }

    public Timestamp getTermModified() {
        return this.termModified;
    }

    public void setTermModified(Timestamp termModified) {
        this.termModified = termModified;
    }

    public Integer getTermModifiedBy() {
        return this.termModifiedBy;
    }

    public void setTermModifiedBy(Integer termModifiedBy) {
        this.termModifiedBy = termModifiedBy;
    }

    public Concept getConcept() {
        return this.concept;
    }

    public void setConcept(Concept concept) {
        this.concept = concept;
    }

}