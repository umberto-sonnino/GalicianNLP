package it.uniroma1.lcl.wimmp.morphoRules.irregularVerbs;

import it.uniroma1.lcl.wimmp.MorphoForm;

import java.util.List;

public class GalicianMorphoRuleVerbPor extends GalicianMorphoRuleVerbPoner {

	//alternate form for PONER, so just do what it does
	
	public GalicianMorphoRuleVerbPor(String title, String text) {
		super(title, text);
	}

	@Override
	public List<MorphoForm> getForms() {
		return super.getForms();
	}
	
	

}
