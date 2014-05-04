package it.uniroma1.lcl.wimmp.morphoRules.irregularVerbs;

import java.util.List;

import it.uniroma1.lcl.wimmp.MorphoForm;
import it.uniroma1.lcl.wimmp.morphoForms.GalicianMorphoFormVerb;
import it.uniroma1.lcl.wimmp.morphoRules.GalicianMorphoRuleVerbConjER;
import it.uniroma1.lcl.wimmp.morphoRules.GalicianMorphoRuleVerbConjIR;

public class GalicianMorphoRuleVerbVer extends GalicianMorphoRuleVerbConjER {

	public GalicianMorphoRuleVerbVer(String title, String text) {
		super(title, text);

		String[] ERSuffixes = { 
				"er", 													// 0 - infinite 
				"endo", 												// 1 - gerund
				"isto", "isto", 											// 2-3 - past participle masculine
				"isto", "isto", 											// 4-5 - past participle feminine
				"exo", "es", "e", "emos", "edes", "en", 					// 6-11 - present indicative
				"’a", "’as", "’a", "iamos", "iades", "’an", 			//12-17 imperfect indicative
				"’n", "iches", "iu", "imos", "istes", "iron", 			//18-23 preterite indicative
				"ira", "iras", "ira", "iramos", "irades", "iran", 		//24-29 pluperfect indicative
				"erei", "er‡s", "er‡", "eremos", "eredes", "er‡n", 		// 30-35 future indicative 
				"er’a", "er’as", "er’a", "eriamos", "eriades", "er’an", //36-41 conditional indicative
				"exa", "exas", "exa", "examos", "exades", "exan", 					//42-47 present subjunctive
				"ise", "ises", "ise", "isemos", "isedes", "isen",		//48-53 preterite subjunctive 
				"ir", "ires", "ir", "irmos", "irdes", "iren",			//54-59 future subjunctive
				"e", "a", "amos", "ede", "an",							//60-64 affirmative imperative 
				"as", "a", "amos", "ades", "an",						//65-69 negative imperative
				"er", "eres", "er", "ermos", "erdes", "eren" 			//70-75 personal infinitive
		};
		
		suffixes = ERSuffixes;
		
	}
	
	@Override
	public List<MorphoForm> getForms() {
		super.getForms(); //fills the entries with just the stem
		
		setSuffixes();
		setPresent();
		setPastParticiple();
		setPreterite();
		
		((GalicianMorphoFormVerb)forms.get(61)).setForm("--");
		((GalicianMorphoFormVerb)forms.get(62)).setForm("--");
		((GalicianMorphoFormVerb)forms.get(64)).setForm("--");
		((GalicianMorphoFormVerb)forms.get(65)).setForm("--");
		((GalicianMorphoFormVerb)forms.get(66)).setForm("--");
		((GalicianMorphoFormVerb)forms.get(67)).setForm("--");
		((GalicianMorphoFormVerb)forms.get(68)).setForm("--");
		((GalicianMorphoFormVerb)forms.get(69)).setForm("--");
		
		return forms;
	}

}
