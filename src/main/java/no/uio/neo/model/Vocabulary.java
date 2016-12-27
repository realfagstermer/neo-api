package no.uio.neo.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the vocabularies database table.
 * 
 */
@Entity
@Table(name="vocabularies")
@NamedQuery(name="Vocabulary.findAll", query="SELECT v FROM Vocabulary v")
public class Vocabulary  {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="VOCABULARIES_VOCABID_GENERATOR", sequenceName="VOCABULARIES_VOCAB_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VOCABULARIES_VOCABID_GENERATOR")
	@Column(name="vocab_id")
	private String vocabId;

	@Column(name="marc_value")
	private String marcValue;

	private Integer padding;

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

}