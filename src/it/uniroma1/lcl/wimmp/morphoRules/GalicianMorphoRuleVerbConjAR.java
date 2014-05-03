package it.uniroma1.lcl.wimmp.morphoRules;

import it.uniroma1.lcl.wimmp.MorphoForm;
import it.uniroma1.lcl.wimmp.morphoForms.GalicianMorphoFormVerb;

import java.util.ArrayList;
import java.util.List;

import javax.naming.PartialResultException;

public class GalicianMorphoRuleVerbConjAR extends GalicianMorphoRuleVerb {
	
	
	public GalicianMorphoRuleVerbConjAR(String title, String text) {
		super(title, text);
		
		String[] ARsuffixes = { 
				"ar", 													// 0 - infinite 
				"ando", 												// 1 - gerund
				"ado", "ados", 											// 2-3 - past participle masculine
				"ada", "adas", 											// 4-5 - past participle feminine
				"o", "as", "a", "amos", "ades", "an", 					// 6-11 - present indicative
				"aba", "abas", "aba", "abamos", "abades", "aban", 		//12-17 imperfect indicative
				"ei", "aches", "ou", "amos", "astes", "aron", 			//18-23 preterite indicative
				"ara", "aras", "ara", "aramos", "arades", "aran", 		//24-29 pluperfect indicative
				"arei", "ar‡s", "ar‡", "aremos", "aredes", "ar‡n", 		// 30-35 future indicative 
				"ar’a", "ar’as", "ar’a", "ariamos", "ariades", "ar’an", //36-41 conditional indicative
				"e", "es", "e", "emos", "edes", "en", 					//42-47 present subjunctive
				"ase", "ases", "ase", "‡semos", "‡sedes", "asen",		//48-53 preterite subjunctive 
				"ar", "ares", "ar", "armos", "ardes", "aren",			//54-59 future subjunctive
				"a", "e", "emos", "ade", "en",							//60-64 affirmative imperative 
				"es", "e", "emos", "edes", "en",						//65-69 negative imperative
				"ar", "ares", "ar", "armos", "ardes", "aren" 			//70-75 personal infinitive
		};
		
		suffixes = ARsuffixes;
	}

	//In totale ci sono 76 forme, quindi ci saranno 76 entry, per ogni verbo di questo tipo

	@Override
	public List<MorphoForm> getForms() {
		super.getForms();
		
		setSuffixes();
		setPresent();
		setPastParticiple();
		setPreterite();

		return forms;
	}

	

}
