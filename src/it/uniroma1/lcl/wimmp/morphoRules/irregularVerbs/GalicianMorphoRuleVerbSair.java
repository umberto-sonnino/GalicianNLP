package it.uniroma1.lcl.wimmp.morphoRules.irregularVerbs;

import java.util.List;

import it.uniroma1.lcl.wimmp.MorphoForm;
import it.uniroma1.lcl.wimmp.morphoRules.GalicianMorphoRuleVerbConjIR;

public class GalicianMorphoRuleVerbSair extends GalicianMorphoRuleVerbConjIR {

	public GalicianMorphoRuleVerbSair(String title, String text) {
		super(title, text);
	
	}

	@Override
	public List<MorphoForm> getForms() {
		super.getForms();
		
		setSuffixes();
		
		setPresent();
		setPastParticiple();
		setPreterite();
		
		return forms;
	}
	
}
