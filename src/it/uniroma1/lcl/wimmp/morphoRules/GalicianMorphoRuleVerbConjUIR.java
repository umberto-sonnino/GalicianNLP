package it.uniroma1.lcl.wimmp.morphoRules;

import it.uniroma1.lcl.wimmp.MorphoForm;

import java.util.List;

public class GalicianMorphoRuleVerbConjUIR extends GalicianMorphoRuleVerbConjIR {

	public GalicianMorphoRuleVerbConjUIR(String title, String text) {
		super(title, text);
		
		String[] UIRSuffixes = {
				"u’r", 													// 0 - infinite 
				"u’ndo", 												// 1 - gerund
				"u’do", "u’do", 											// 2-3 - past participle masculine
				"u’do", "u’do", 											// 4-5 - past participle feminine
				"œo", "œes", "œe", "u’mos", "u’des", "œen", 					// 6-11 - present indicative
				"u’a", "u’as", "u’a", "u•amos", "u•ades", "u’an", 			//12-17 imperfect indicative
				"u’n", "u’ches", "u’u", "u’mos", "u’stes", "u’ron", 			//18-23 preterite indicative
				"u’ra", "u’ras", "u’ra", "uiramos", "uirades", "u’ran", 		//24-29 pluperfect indicative
				"uirei", "uir‡s", "uir‡", "uiremos", "uiredes", "uir‡n", 		// 30-35 future indicative 
				"uir’a", "uir’as", "uir’a", "uiriamos", "uiriades", "uir’an", //36-41 conditional indicative
				"œa", "œas", "œa", "uamos", "uades", "œan", 					//42-47 present subjunctive
				"u’se", "u’ses", "u’se", "u’semos", "u’sedes", "u’sen",		//48-53 preterite subjunctive 
				"u’r", "u’res", "u’r", "u’rmos", "u’rdes", "u’ren",			//54-59 future subjunctive
				"œe", "œa", "uamos", "u’de", "œan",							//60-64 affirmative imperative 
				"œas", "œa", "uamos", "uades", "œan",						//65-69 negative imperative
				"u’r", "u’res", "u’r", "u’rmos", "u’rdes", "u’ren" 			//70-75 personal infinitive
			};
		
		suffixes = UIRSuffixes;
	
	}

	
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
