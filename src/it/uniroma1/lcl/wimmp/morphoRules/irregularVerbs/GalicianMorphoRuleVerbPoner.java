package it.uniroma1.lcl.wimmp.morphoRules.irregularVerbs;

import java.util.List;

import it.uniroma1.lcl.wimmp.MorphoForm;
import it.uniroma1.lcl.wimmp.morphoForms.GalicianMorphoFormVerb;
import it.uniroma1.lcl.wimmp.morphoRules.GalicianMorphoRuleVerbConjER;

public class GalicianMorphoRuleVerbPoner extends GalicianMorphoRuleVerbConjER {

	private String modifiedStem ="pux";
	
	public GalicianMorphoRuleVerbPoner(String title, String text) {
		super(title, text);
		
		this.present = "po�o";
		this.past = "puxen";
		this.preterite = "posto";
		
		String[] PONERSuffixes = { 
				"er", 													// 0 - infinite 
				"endo", 												// 1 - gerund
				"", "", 											// 2-3 - past participle masculine
				"", "", 											// 4-5 - past participle feminine
				"o", "", "", "emos", "edes", "en", 					// 6-11 - present indicative
				"�a", "�as", "�a", "iamos", "iades", "�an", 			//12-17 imperfect indicative
				"en", "eches", "o", "emos", "estes", "eron", 			//18-23 preterite indicative
				"era", "eras", "era", "eramos", "erades", "eran", 		//24-29 pluperfect indicative
				"erei", "er�s", "er�", "eremos", "eredes", "er�n", 		// 30-35 future indicative 
				"er�a", "er�as", "er�a", "eriamos", "eriades", "er�an", //36-41 conditional indicative
				"a", "as", "a", "amos", "ades", "an", 					//42-47 present subjunctive
				"ese", "eses", "ese", "�semos", "�sedes", "esen",		//48-53 preterite subjunctive 
				"er", "eres", "er", "ermos", "erdes", "eren",			//54-59 future subjunctive
				"e", "a", "amos", "ede", "an",							//60-64 affirmative imperative 
				"as", "a", "amos", "ades", "an",						//65-69 negative imperative
				"er", "eres", "er", "ermos", "erdes", "eren" 			//70-75 personal infinitive
		};
	}

	@Override
	public List<MorphoForm> getForms() {
		super.getForms();
		
		int[] modifiedStemForms1 = { 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29,
				48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59};
		
		for(int i = 0; i < modifiedStemForms1.length; i++){
			int index = modifiedStemForms1[i];
			((GalicianMorphoFormVerb) forms.get(index)).setForm(modifiedStem + suffixes[index]);
		}
		
		((GalicianMorphoFormVerb) forms.get(7)).setForm("pos");
		((GalicianMorphoFormVerb) forms.get(8)).setForm("pon");
		
		
		
		return forms;
	}


}
