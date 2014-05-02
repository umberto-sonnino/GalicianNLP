package it.uniroma1.lcl.wimmp.morphoForms;

import it.uniroma1.lcl.wimmp.MorphoForm;

public class GalicianMorphoFormVerb extends MorphoForm {

	private String tense, person;
	
	public GalicianMorphoFormVerb(String form, String tense, String person) {
		super(form, tense + " " + person);
		
		this.tense = tense;
		this.person = person;
		
	}

	public GalicianMorphoFormVerb(String form, String info) {
		super(form, info);
	}

	public String getTense() {
		return tense;
	}

	public String getPerson() {
		return person;
	}

	public void setTense(String tense) {
		this.tense = tense;
	}

	public void setPerson(String person) {
		this.person = person;
	}
	
}
