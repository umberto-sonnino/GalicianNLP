package it.uniroma1.lcl.wimmp.morphoRules.irregularVerbs;

import java.util.List;

import it.uniroma1.lcl.wimmp.MorphoForm;
import it.uniroma1.lcl.wimmp.morphoForms.GalicianMorphoFormVerb;
import it.uniroma1.lcl.wimmp.morphoRules.GalicianMorphoRuleVerbConjER;

public class GalicianMorphoRuleVerbSer extends GalicianMorphoRuleVerbConjER {

	private String modifiedStem1 = "f", modifiedStem2 = "sex";
	
	public GalicianMorphoRuleVerbSer(String title, String text) {
		super(title, text);
		this.stem = "s";
		this.past = "sido";
		
		String[] SERSuffixes = { 
				"er", 													// 0 - infinite 
				"endo", 												// 1 - gerund
				"ido", "ido", 											// 2-3 - past participle masculine
				"ido", "ido", 											// 4-5 - past participle feminine
				"on", "es", "é", "emos", "edes", "en", 					// 6-11 - present indicative
				"era", "eras", "era", "eramos", "erades", "eran", 			//12-17 imperfect indicative
				"un", "uches", "oi", "omos", "ostes", "oron", 			//18-23 preterite indicative
				"ora", "oras", "ora", "oramos", "orades", "oran", 		//24-29 pluperfect indicative
				"erei", "erás", "erá", "eremos", "eredes", "erán", 		// 30-35 future indicative 
				"ería", "erías", "ería", "eriamos", "eriades", "erían", //36-41 conditional indicative
				"a", "as", "a", "amos", "ades", "an", 					//42-47 present subjunctive
				"ose", "oses", "ose", "ósemos", "ósedes", "osen",		//48-53 preterite subjunctive 
				"or", "ores", "or", "ormos", "ordes", "oren",			//54-59 future subjunctive
				"sé", "a", "amos", "ede", "an",							//60-64 affirmative imperative 
				"as", "a", "amos", "ades", "an",						//65-69 negative imperative
				"er", "eres", "er", "ermos", "erdes", "eren" 			//70-75 personal infinitive
		};

		suffixes = SERSuffixes;
	}

	@Override
	public List<MorphoForm> getForms() {
		super.getForms();
		
		int[] modifiedStemForms1 = { 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29,
				48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59};
		
		int[] modifiedStemForms2 = { 42, 43, 44, 45, 46, 47, 
				61, 62, 64, 65, 66, 67, 68, 69 };
		
		int[] modifiedStemForms3 = { 7, 8, 12, 13, 14, 15, 16, 17, 60 };
		
		for(int i = 0; i < modifiedStemForms1.length; i++){
			int index = modifiedStemForms1[i];
			((GalicianMorphoFormVerb) forms.get(index)).setForm(modifiedStem1 + suffixes[index]);
		}
		
		for(int i = 0; i < modifiedStemForms2.length; i++){
			int index = modifiedStemForms2[i];
			((GalicianMorphoFormVerb) forms.get(index)).setForm(modifiedStem2  + suffixes[index]);
		}
		
		for(int i = 0; i < modifiedStemForms3.length; i++){
			int index = modifiedStemForms3[i];
			((GalicianMorphoFormVerb) forms.get(index)).setForm(suffixes[index]);
		}
		
		return forms;
	}
	
}
