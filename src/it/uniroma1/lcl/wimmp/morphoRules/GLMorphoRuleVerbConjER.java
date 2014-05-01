package it.uniroma1.lcl.wimmp.morphoRules;

import it.uniroma1.lcl.wimmp.MorphoForm;
import it.uniroma1.lcl.wimmp.morphoForms.GLMorphoFormVerb;

import java.util.List;

import javax.naming.PartialResultException;

public class GLMorphoRuleVerbConjER extends GLMorphoRuleVerb {

	private final String[] suffixes = { 
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
	
	public GLMorphoRuleVerbConjER(String title, String text) {
		super(title, text);
	}

	@Override
	public List<MorphoForm> getForms() {
		super.getForms(); //fills the entries with just the stem
		
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
		
		for(MorphoForm form: forms){
			GLMorphoFormVerb temp = (GLMorphoFormVerb)form;
			System.out.println("FORM: " + temp.getForm() + "; TENSE: " + temp.getTense() + "; PERSON: " + temp.getPerson());
		}
		
		return forms;
	}

}
