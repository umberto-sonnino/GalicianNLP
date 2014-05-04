package it.uniroma1.lcl.wimmp.morphoRules.irregularVerbs;

import java.util.List;

import it.uniroma1.lcl.wimmp.MorphoForm;
import it.uniroma1.lcl.wimmp.morphoForms.GalicianMorphoFormVerb;
import it.uniroma1.lcl.wimmp.morphoRules.GalicianMorphoRuleVerbConjIRvarEI;

public class GalicianMorphoRuleVerbPedir extends
		GalicianMorphoRuleVerbConjIRvarEI {

	public GalicianMorphoRuleVerbPedir(String title, String text) {
		super(title, text);
		
		suffixes[2] = "ido";
		suffixes[3] = "ido";
		suffixes[4] = "ido";
		suffixes[5] = "ido";
		
	}
	
	@Override
	public List<MorphoForm> getForms() {
		super.getForms();
		
		int[] modifiedStemForms = { 6, 7, 8, 11, 42, 43, 44, 45, 46, 47, 
				60, 61, 62, 64, 65, 66, 67, 68, 69 };
		
		for(int i = 0; i < modifiedStemForms.length; i++){
			int index = modifiedStemForms[i];
			((GalicianMorphoFormVerb) forms.get(index)).setForm(modifiedStem + suffixes[index]);
		}
		
		
		return forms;
	}
}
