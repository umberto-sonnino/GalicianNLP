package it.uniroma1.lcl.wimmp.morphoRules;

import it.uniroma1.lcl.wimmp.MorphoForm;
import it.uniroma1.lcl.wimmp.morphoForms.GalicianMorphoFormVerb;

import java.util.List;

public class GalicianMorphoRuleVerbConjIR extends GalicianMorphoRuleVerb {

	private final String[] suffixes = { 
			"ir", 													// 0 - infinite 
			"indo", 												// 1 - gerund
			"ido", "idos", 											// 2-3 - past participle masculine
			"ida", "idas", 											// 4-5 - past participle feminine
			"o", "es", "e", "imos", "ides", "en", 					// 6-11 - present indicative
			"’a", "’as", "’a", "iamos", "iades", "’an", 			//12-17 imperfect indicative
			"’n", "iches", "iu", "imos", "istes", "iron", 			//18-23 preterite indicative
			"ira", "iras", "ira", "iramos", "irades", "iran", 		//24-29 pluperfect indicative
			"irei", "ir‡s", "ir‡", "iremos", "iredes", "ir‡n", 		// 30-35 future indicative 
			"ir’a", "ir’as", "ir’a", "iriamos", "iriades", "ir’an", //36-41 conditional indicative
			"a", "as", "a", "amos", "ades", "an", 					//42-47 present subjunctive
			"ise", "ises", "ise", "’semos", "’sedes", "isen",		//48-53 preterite subjunctive 
			"ir", "ires", "ir", "irmos", "irdes", "iren",			//54-59 future subjunctive
			"e", "a", "amos", "ide", "an",							//60-64 affirmative imperative 
			"as", "a", "amos", "ades", "an",						//65-69 negative imperative
			"ir", "ires", "ir", "irmos", "irdes", "iren" 			//70-75 personal infinitive
	};
	

	public GalicianMorphoRuleVerbConjIR(String title, String text) {
		super(title, text);
	}

	
	@Override
	public List<MorphoForm> getForms() {
		super.getForms();
		
		for (int i = 0; i < forms.size(); i++) {
			((GalicianMorphoFormVerb) forms.get(i)).setForm(stem + suffixes[i]);
		}
		
		if(!present.equals("")){ 
			//FIRST PERSON SINGULAR PRESENT INDICATIVE IS #6
			((GalicianMorphoFormVerb) forms.get(6)).setForm(present);
		}
		
		if(!past.equals("")){
			//PAST PARTICIPLE GUYS ARE #2-#5
			((GalicianMorphoFormVerb) forms.get(2)).setForm(past);
			((GalicianMorphoFormVerb) forms.get(3)).setForm(past);
			((GalicianMorphoFormVerb) forms.get(4)).setForm(past);
			((GalicianMorphoFormVerb) forms.get(5)).setForm(past);
		}
		
		if(!preterite.equals("")){
			//FIRST PERSON SINGULAR PRETERITE INDICATIVE IS #18
			((GalicianMorphoFormVerb) forms.get(18)).setForm(preterite);
		}
		
		return forms;
	}
	
	
}
