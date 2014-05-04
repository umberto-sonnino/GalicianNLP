package it.uniroma1.lcl.wimmp.morphoRules;

import it.uniroma1.lcl.wimmp.MorphoForm;
import it.uniroma1.lcl.wimmp.morphoForms.GalicianMorphoFormVerb;

import java.util.List;

public class GalicianMorphoRuleVerbConjIRvarUO extends GalicianMorphoRuleVerbConjIR {

	private String modifiedStem = "";

	public GalicianMorphoRuleVerbConjIRvarUO(String title, String text) {
		super(title, text);
		getModifiedStem();
	}

	private void getModifiedStem() {

		if(text.contains("gl-conj-ir (u-o)")){
			int verbNameIndex = text.indexOf("gl-conj-ir (u-o)");
			int firstPipeIndex = text.indexOf("|", verbNameIndex);
			int secondPipeIndex = text.indexOf("|", firstPipeIndex + 1);
			int parenthesisIndex = text.indexOf("}}", verbNameIndex);

			modifiedStem = text.substring(secondPipeIndex + 1, parenthesisIndex);
		}

	}

	@Override
	public List<MorphoForm> getForms() {
		super.getForms();

		int[] modifiedStemForms = { 7, 8, 11 };

		for(int i = 0; i < modifiedStemForms.length; i++){
			int index = modifiedStemForms[i];
			((GalicianMorphoFormVerb) forms.get(index)).setForm(modifiedStem + suffixes[index]);
		}


		return forms;
	}

}
