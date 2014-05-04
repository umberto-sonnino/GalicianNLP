package it.uniroma1.lcl.wimmp.morphoRules.irregularVerbs;

import java.util.List;

import it.uniroma1.lcl.wimmp.MorphoForm;
import it.uniroma1.lcl.wimmp.morphoRules.GalicianMorphoRuleVerbConjIR;

public class GalicianMorphoRuleVerbOir extends GalicianMorphoRuleVerbConjIR {

	private String[] OIRsuffixes = { 
			"’r", 													// 0 - infinite 
			"’ndo", 												// 1 - gerund
			"’do", "’dos", 											// 2-3 - past participle masculine
			"’da", "’das", 											// 4-5 - past participle feminine
			"io", "es", "e", "’mos", "’des", "en", 					// 6-11 - present indicative
			"’a", "’as", "’a", "•amos", "•ades", "’an", 			//12-17 imperfect indicative
			"’n", "’ches", "’u", "’mos", "’stes", "’ron", 			//18-23 preterite indicative
			"’ra", "’ras", "’ra", "’ramos", "’rades", "’ran", 		//24-29 pluperfect indicative
			"irei", "ir‡s", "ir‡", "iremos", "iredes", "ir‡n", 		// 30-35 future indicative 
			"ir’a", "ir’as", "ir’a", "iriamos", "iriades", "ir’an", //36-41 conditional indicative
			"ia", "ias", "ia", "iamos", "iades", "ian", 					//42-47 present subjunctive
			"’se", "’ses", "’se", "’semos", "’sedes", "’sen",		//48-53 preterite subjunctive 
			"’r", "’res", "’r", "’rmos", "’rdes", "’ren",			//54-59 future subjunctive
			"e", "ia", "iamos", "’de", "ian",							//60-64 affirmative imperative 
			"ias", "ia", "iamos", "iades", "ian",						//65-69 negative imperative
			"’r", "’res", "’r", "’rmos", "’rdes", "’ren" 			//70-75 personal infinitive
	};
	
	
	public GalicianMorphoRuleVerbOir(String title, String text) {
		super(title, text);
		
		suffixes = OIRsuffixes;
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
