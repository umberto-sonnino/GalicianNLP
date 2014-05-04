package it.uniroma1.lcl.wimmp.morphoRules.irregularVerbs;

import java.util.List;

import it.uniroma1.lcl.wimmp.MorphoForm;
import it.uniroma1.lcl.wimmp.morphoRules.GalicianMorphoRuleVerbConjIR;

public class GalicianMorphoRuleVerbRir extends GalicianMorphoRuleVerbConjIR {

	private String[] RIRsuffixes = { 
			"ir", 													// 0 - infinite 
			"indo", 												// 1 - gerund
			"ido", "idos", 											// 2-3 - past participle masculine
			"ida", "idas", 											// 4-5 - past participle feminine
			"o", "is", "i", "imos", "ides", "in", 					// 6-11 - present indicative
			"’a", "’as", "’a", "iamos", "iades", "’an", 			//12-17 imperfect indicative
			"’n", "iches", "iu", "imos", "istes", "iron", 			//18-23 preterite indicative
			"ira", "iras", "ira", "iramos", "irades", "iran", 		//24-29 pluperfect indicative
			"irei", "ir‡s", "ir‡", "iremos", "iredes", "ir‡n", 		// 30-35 future indicative 
			"ir’a", "ir’as", "ir’a", "iriamos", "iriades", "ir’an", //36-41 conditional indicative
			"’a", "’as", "’a", "iamos", "iades", "ian", 					//42-47 present subjunctive
			"ise", "ises", "ise", "’semos", "’sedes", "isen",		//48-53 preterite subjunctive 
			"ir", "ires", "ir", "irmos", "irdes", "iren",			//54-59 future subjunctive
			"i", "’a", "iamos", "ide", "’an",							//60-64 affirmative imperative 
			"’as", "’a", "’amos", "iades", "’an",						//65-69 negative imperative
			"ir", "ires", "ir", "irmos", "irdes", "iren" 			//70-75 personal infinitive
	};
	
	public GalicianMorphoRuleVerbRir(String title, String text) {
		super(title, text);
		
		suffixes = RIRsuffixes;
		
		this.past = "rido";
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
