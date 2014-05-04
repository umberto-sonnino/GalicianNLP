package it.uniroma1.lcl.wimmp.morphoRules.irregularVerbs;

import java.util.List;

import it.uniroma1.lcl.wimmp.MorphoForm;
import it.uniroma1.lcl.wimmp.morphoRules.GalicianMorphoRuleVerbConjIR;

public class GalicianMorphoRuleVerbParir extends GalicianMorphoRuleVerbConjIR {

	public GalicianMorphoRuleVerbParir(String title, String text) {
		super(title, text);
		
		suffixes[0] = "";
		suffixes[2] = "ido";
		suffixes[3] = "ido";
		suffixes[4] = "ido";
		suffixes[5] = "ido";
		
		
		
	}

	@Override
	public List<MorphoForm> getForms() {
		super.getForms();
		
		setSuffixes();
		setPresent();
		
		return forms;
	}
	
	

}
