package no.uio.neo.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the languages database table.
 * 
 */
@Entity
@Table(name="languages")
@NamedQuery(name="Language.findAll", query="SELECT l FROM Language l")
public class Language  {
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

}