package no.uio.ub.neo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the languages database table.
 * 
 */
@Entity
@Table(name="languages")
@NamedQuery(name="Language.findAll", query="SELECT l FROM Language l")
public class Language implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="LANGUAGES_LANGID_GENERATOR", sequenceName="LANGUAGES_LANG_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LANGUAGES_LANGID_GENERATOR")
	@Column(name="lang_id")
	private String langId;

	@Column(name="label_en")
	private String labelEn;

	@Column(name="label_nb")
	private String labelNb;

	@Column(name="label_nn")
	private String labelNn;

	//bi-directional many-to-one association to Term
	@OneToMany(mappedBy="language")
	private List<Term> terms;

	public Language() {
	}

	public String getLangId() {
		return this.langId;
	}

	public void setLangId(String langId) {
		this.langId = langId;
	}

	public String getLabelEn() {
		return this.labelEn;
	}

	public void setLabelEn(String labelEn) {
		this.labelEn = labelEn;
	}

	public String getLabelNb() {
		return this.labelNb;
	}

	public void setLabelNb(String labelNb) {
		this.labelNb = labelNb;
	}

	public String getLabelNn() {
		return this.labelNn;
	}

	public void setLabelNn(String labelNn) {
		this.labelNn = labelNn;
	}

	public List<Term> getTerms() {
		return this.terms;
	}

	public void setTerms(List<Term> terms) {
		this.terms = terms;
	}

	public Term addTerm(Term term) {
		getTerms().add(term);
		term.setLanguage(this);

		return term;
	}

	public Term removeTerm(Term term) {
		getTerms().remove(term);
		term.setLanguage(null);

		return term;
	}

}