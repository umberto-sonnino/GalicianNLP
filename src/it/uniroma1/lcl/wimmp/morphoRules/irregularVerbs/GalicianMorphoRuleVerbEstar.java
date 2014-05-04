package it.uniroma1.lcl.wimmp.morphoRules.irregularVerbs;

import java.util.List;

import it.uniroma1.lcl.wimmp.MorphoForm;
import it.uniroma1.lcl.wimmp.morphoForms.GalicianMorphoFormVerb;
import it.uniroma1.lcl.wimmp.morphoRules.GalicianMorphoRuleVerbConjAR;

public class GalicianMorphoRuleVerbEstar extends GalicianMorphoRuleVerbConjAR {

	private String modifiedStem = "estiv";

	public GalicianMorphoRuleVerbEstar(String title, String text) {
		super(title, text);

		suffixes[7] = "‡s";
		suffixes[8] = "‡";

		suffixes[42] = "ea";
		suffixes[43] = "eas";
		suffixes[44] = "ea";
		suffixes[45] = "eamos";
		suffixes[46] = "eades";
		suffixes[47] = "ean";
		
		suffixes[60] = "‡";
		suffixes[61] = "ea";
		suffixes[62] = "eamos";
		suffixes[64] = "ean";
		suffixes[65] = "eas";
		suffixes[66] = "ea";
		suffixes[67] = "eamos";
		suffixes[68] = "eades";
		suffixes[69] = "ean";

		//WITH Modified Stem
		suffixes[19] = "eches";
		suffixes[20] = "o";
		suffixes[21] = "emos";
		suffixes[22] = "estes";
		suffixes[23] = "eron";
		suffixes[24] = "era";
		suffixes[25] = "eras";
		suffixes[26] = "era";
		suffixes[27] = "eramos";
		suffixes[28] = "erades";
		suffixes[29] = "eran";
		
		suffixes[48] = "ese";
		suffixes[49] = "eses";
		suffixes[50] = "ese";
		suffixes[51] = "Žsemos";
		suffixes[52] = "Žsedes";
		suffixes[53] = "esen";
		suffixes[54] = "er";
		suffixes[55] = "eres";
		suffixes[56] = "er";
		suffixes[57] = "ermos";
		suffixes[58] = "erdes";
		suffixes[59] = "eren";
		
		suffixes[70] = "ese";
		suffixes[71] = "eses";
		suffixes[72] = "ese";
		suffixes[73] = "Žsemos";
		suffixes[74] = "Žsedes";
		suffixes[75] = "esen";

	}
	
	@Override
	public List<MorphoForm> getForms() {
		super.getForms();
		
		setSuffixes();
		setPresent();
		setPreterite();
		
		int[] modifiedStemForms = { 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59,
				70, 71, 72, 73, 74, 75 };
		
		for(int i = 0; i < modifiedStemForms.length; i++){
			int index = modifiedStemForms[i];
			((GalicianMorphoFormVerb) forms.get(index)).setForm(modifiedStem + suffixes[index]);
		}
		
		return forms;
	}

}
