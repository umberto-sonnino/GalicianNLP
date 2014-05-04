package it.uniroma1.lcl.wimmp.morphoRules.irregularVerbs;

import java.util.List;

import it.uniroma1.lcl.wimmp.MorphoForm;
import it.uniroma1.lcl.wimmp.morphoRules.GalicianMorphoRuleVerbConjER;

public class GalicianMorphoRuleVerbCrer extends GalicianMorphoRuleVerbConjER {

	public GalicianMorphoRuleVerbCrer(String title, String text) {
		super(title, text);

		stem = "cr";
		
		suffixes[6] = "eo";
		suffixes[42] = "ea";
		suffixes[43] = "eas";
		suffixes[44] = "ea";
		suffixes[45] = "eamos";
		suffixes[46] = "eades";
		suffixes[47] = "ean";
		
		suffixes[61] = "ea";
		suffixes[62] = "eamos";
		suffixes[64] = "ean";
		
		suffixes[65] = "eas";
		suffixes[66] = "ea";
		suffixes[67] = "eamos";
		suffixes[68] = "eades";
		suffixes[69] = "ean";
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
