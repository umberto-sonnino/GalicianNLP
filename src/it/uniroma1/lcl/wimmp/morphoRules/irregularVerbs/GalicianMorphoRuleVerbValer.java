package it.uniroma1.lcl.wimmp.morphoRules.irregularVerbs;

import java.util.List;

import it.uniroma1.lcl.wimmp.MorphoForm;
import it.uniroma1.lcl.wimmp.morphoForms.GalicianMorphoFormVerb;
import it.uniroma1.lcl.wimmp.morphoRules.GalicianMorphoRuleVerbConjER;

public class GalicianMorphoRuleVerbValer extends GalicianMorphoRuleVerbConjER {

	public GalicianMorphoRuleVerbValer(String title, String text) {
		super(title, text);

		String[] ERSuffixes = { 
				"aler", 													// 0 - infinite 
				"alendo", 												// 1 - gerund
				"isto", "isto", 											// 2-3 - past participle masculine
				"isto", "isto", 											// 4-5 - past participle feminine
				"allo", "ales", "ale", "alemos", "aledes", "alen", 					// 6-11 - present indicative
				"al’a", "al’as", "al’a", "aliamos", "aliades", "al’an", 			//12-17 imperfect indicative
				"al’n", "aliches", "aleu", "alemos", "alestes", "aleron", 			//18-23 preterite indicative
				"alera", "aleras", "alera", "aleramos", "alerades", "aleran", 		//24-29 pluperfect indicative
				"alerei", "aler‡s", "aler‡", "aleremos", "aleredes", "aler‡n", 		// 30-35 future indicative 
				"aler’a", "aler’as", "aler’a", "aleriamos", "aleriades", "aler’an", //36-41 conditional indicative
				"alla", "allas", "alla", "allamos", "allades", "allan", 					//42-47 present subjunctive
				"alese", "aleses", "alese", "alesemos", "alesedes", "alesen",		//48-53 preterite subjunctive 
				"aler", "aleres", "aler", "alermos", "alerdes", "aleren",			//54-59 future subjunctive
				"ale", "--", "--", "alede", "--",							//60-64 affirmative imperative 
				"--", "--", "--", "--", "--",						//65-69 negative imperative
				"aler", "aleres", "aler", "alermos", "alerdes", "aleren" 			//70-75 personal infinitive
		};
		
		suffixes = ERSuffixes;
	
		this.preterite = "val’n";
		this.past = "valido";
		
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
