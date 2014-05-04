package it.uniroma1.lcl.wimmp.morphoRules;

import it.uniroma1.lcl.wimmp.MorphoForm;
import it.uniroma1.lcl.wimmp.morphoForms.GalicianMorphoFormVerb;

import java.util.List;

public class GalicianMorphoRuleVerbConjIRvarEI extends GalicianMorphoRuleVerbConjIR{

	protected String modifiedStem = "";
	
	public GalicianMorphoRuleVerbConjIRvarEI(String title, String text) {
		super(title, text);
		getModifiedStem();
		
	}

	protected void getModifiedStem() {
		
		if(text.contains("gl-conj-ir (e-i)")){
			int verbNameIndex = text.indexOf("gl-conj-ir (e-i)");
			int firstPipeIndex = text.indexOf("|", verbNameIndex);
			int secondPipeIndex = text.indexOf("|", firstPipeIndex + 1);
			int parenthesisIndex = text.indexOf("}}", verbNameIndex);
			
			modifiedStem = text.substring(secondPipeIndex + 1, parenthesisIndex);
		}
		
	}
	
	@Override
	public List<MorphoForm> getForms() {
		super.getForms();
		
		int[] modifiedStemForms = { 6, 42, 43, 44, 45, 46, 47, 61, 62, 63, 64, 65, 66, 67, 68, 69 };
		
		for(int i = 0; i < modifiedStemForms.length; i++){
			int index = modifiedStemForms[i];
			((GalicianMorphoFormVerb) forms.get(index)).setForm(modifiedStem + suffixes[index]);
		}
		
		
		return forms;
	}
}
