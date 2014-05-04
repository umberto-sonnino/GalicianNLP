package it.uniroma1.lcl.wimmp.morphoRules.irregularVerbs;

import java.util.List;

import it.uniroma1.lcl.wimmp.MorphoForm;
import it.uniroma1.lcl.wimmp.morphoForms.GalicianMorphoFormVerb;
import it.uniroma1.lcl.wimmp.morphoRules.GalicianMorphoRuleVerbConjER;

public class GalicianMorphoRuleVerbQuerer extends GalicianMorphoRuleVerbConjER {

	private String modifiedStem1 = "quix", modifiedStem2 = "queir";
	
	public GalicianMorphoRuleVerbQuerer(String title, String text) {
		super(title, text);
		
		String[] PRACERSuffixes = { 
				"er", 													// 0 - infinite 
				"endo", 												// 1 - gerund
				"ido", "idos", 											// 2-3 - past participle masculine
				"ida", "idas", 											// 4-5 - past participle feminine
				"o", "es", "e", "emos", "edes", "en", 					// 6-11 - present indicative
				"’a", "’as", "’a", "iamos", "iades", "’an", 			//12-17 imperfect indicative
				"en", "eches", "o", "emos", "estes", "eron", 			//18-23 preterite indicative
				"era", "eras", "era", "eramos", "erades", "eran", 		//24-29 pluperfect indicative
				"erei", "er‡s", "er‡", "eremos", "eredes", "er‡n", 		// 30-35 future indicative 
				"er’a", "er’as", "er’a", "eriamos", "eriades", "er’an", //36-41 conditional indicative
				"a", "as", "a", "amos", "ades", "an", 					//42-47 present subjunctive
				"ese", "eses", "ese", "Žsemos", "Žsedes", "esen",		//48-53 preterite subjunctive 
				"er", "eres", "er", "ermos", "erdes", "eren",			//54-59 future subjunctive
				"e", "a", "amos", "ede", "an",							//60-64 affirmative imperative 
				"as", "a", "amos", "ades", "an",						//65-69 negative imperative
				"er", "eres", "er", "ermos", "erdes", "eren" 			//70-75 personal infinitive
		};
		
		suffixes = PRACERSuffixes;
		
		this.past = "querido";
		this.present = "quero";
		this.preterite = "quixen";
	}
	
	@Override
	public List<MorphoForm> getForms() {
		super.getForms();
		
		int[] modifiedStemForms1 = { 18, 19, 21, 22, 23, 24, 25, 26, 27, 28, 29,
				48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59};
		
		int[] modifiedStemForms2 = {
				42, 43, 44, 45, 46, 47,
				61, 62, 64, 65, 66, 67, 69 
		};
		
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
