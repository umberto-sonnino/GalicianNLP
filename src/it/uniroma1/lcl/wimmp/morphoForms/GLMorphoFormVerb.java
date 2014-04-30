package it.uniroma1.lcl.wimmp.morphoForms;

import it.uniroma1.lcl.wimmp.MorphoForm;

public class GLMorphoFormVerb extends MorphoForm {

	private String tense, person;
	
	public GLMorphoFormVerb(String form, String tense, String person) {
		super(form, tense + " " + person);
		
		this.tense = tense;
		this.person = person;
			
	}

	public GLMorphoFormVerb(String form, String info) {
		super(form, info);
	}

}
