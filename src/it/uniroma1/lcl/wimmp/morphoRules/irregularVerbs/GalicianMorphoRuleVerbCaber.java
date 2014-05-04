package it.uniroma1.lcl.wimmp.morphoRules.irregularVerbs;

import java.util.List;

import it.uniroma1.lcl.wimmp.MorphoForm;
import it.uniroma1.lcl.wimmp.morphoForms.GalicianMorphoFormVerb;
import it.uniroma1.lcl.wimmp.morphoRules.GalicianMorphoRuleVerbConjER;

public class GalicianMorphoRuleVerbCaber extends GalicianMorphoRuleVerbConjER {

	private String modifiedStem1= "coub", modifiedStem2 = "caib";
	
	public GalicianMorphoRuleVerbCaber(String title, String text) {
		super(title, text);
		
		suffixes[19] = "eches";
		suffixes[20] = "o";
		
	}

	@Override
	public List<MorphoForm> getForms() {
		super.getForms();
		
		setSuffixes();
		setPresent();
		setPreterite();
		
		int[] modifiedStemForms1 = { 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59 };
		int[] modifiedStemForms2 = { 42, 43, 44, 45, 46, 47, 61, 62, 64, 65, 66, 67, 68, 69 };
		
		for(int i = 0; i < modifiedStemForms1.length; i++){
			int index = modifiedStemForms1[i];
			((GalicianMorphoFormVerb) forms.get(index)).setForm(modifiedStem1 + suffixes[index]);
		}
		
		for(int i = 0; i < modifiedStemForms2.length; i++){
			int index = modifiedStemForms2[i];
			((GalicianMorphoFormVerb) forms.get(index)).setForm(modifiedStem2 + suffixes[index]);
		}
		
		return forms;
	}

	
	
}
