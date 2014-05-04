package it.uniroma1.lcl.wimmp.morphoRules.irregularVerbs;

import java.util.List;

import it.uniroma1.lcl.wimmp.MorphoForm;
import it.uniroma1.lcl.wimmp.morphoRules.GalicianMorphoRuleVerbConjER;

public class GalicianMorphoRuleVerbHaber extends GalicianMorphoRuleVerbConjER {

	public GalicianMorphoRuleVerbHaber(String title, String text) {
		super(title, text);
		
		stem = "hab";
		
		String[] HABERSuffixes = { 
				"er", 													// 0 - infinite 
				"endo", 												// 1 - gerund
				"ido", "idos", 											// 2-3 - past participle masculine
				"ida", "idas", 											// 4-5 - past participle feminine
				"o", "es", "e", "emos", "edes", "en", 					// 6-11 - present indicative
				"’a", "’as", "’a", "iamos", "iades", "’an", 			//12-17 imperfect indicative
				"’n", "iches", "eu", "emos", "estes", "eron", 			//18-23 preterite indicative
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
		
		suffixes = HABERSuffixes;
		
	}
	
	@Override
	public List<MorphoForm> getForms() {
		super.getForms(); //fills the entries with just the stem
		
		setSuffixes();
		setPresent();
		setPreterite();
		
		
		
		return forms;
	}

}
