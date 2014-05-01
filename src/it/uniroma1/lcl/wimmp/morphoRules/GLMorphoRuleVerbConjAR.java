package it.uniroma1.lcl.wimmp.morphoRules;

import it.uniroma1.lcl.wimmp.MorphoForm;
import it.uniroma1.lcl.wimmp.morphoForms.GLMorphoFormVerb;

import java.util.ArrayList;
import java.util.List;

import javax.naming.PartialResultException;

public class GLMorphoRuleVerbConjAR extends GLMorphoRuleVerb {
	
	

	private final String[] suffixes = { 
			"ar", 													// 0 - infinite 
			"ando", 												// 1 - gerund
			"ado", "ados", 											// 2-3 - past participle masculine
			"ada", "adas", 											// 4-5 - past participle feminine
			"o", "as", "a", "amos", "ades", "an", 					// 6-11 - present indicative
			"aba", "abas", "aba", "abaamos", "abades", "aban", 			//12-17 imperfect indicative
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
	
	public GLMorphoRuleVerbConjAR(String title, String text) {
		super(title, text);
	}

	//In totale ci sono 76 forme, quindi ci saranno 76 entry, per ogni verbo di questo tipo

	@Override
	public List<MorphoForm> getForms() {
		
		for (int i = 0; i < forms.size(); i++) {
			((GLMorphoFormVerb) forms.get(i)).setForm(stem + suffixes[i]);
		}
		
		if(!present.equals("")){ 
			//FIRST PERSON SINGULAR PRESENT INDICATIVE IS #6
			((GLMorphoFormVerb) forms.get(6)).setForm(present);
		}
		
		if(!past.equals("")){
			//PAST PARTICIPLE GUYS ARE #2-#5
			((GLMorphoFormVerb) forms.get(2)).setForm(past);
			((GLMorphoFormVerb) forms.get(3)).setForm(past);
			((GLMorphoFormVerb) forms.get(4)).setForm(past);
			((GLMorphoFormVerb) forms.get(5)).setForm(past);
		}
		
		if(!preterite.equals("")){
			//FIRST PERSON SINGULAR PRETERITE INDICATIVE IS #18
			((GLMorphoFormVerb) forms.get(18)).setForm(preterite);
		}

		return forms;
	}


}
