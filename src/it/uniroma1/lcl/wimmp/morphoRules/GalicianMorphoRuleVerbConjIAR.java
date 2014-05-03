package it.uniroma1.lcl.wimmp.morphoRules;

import it.uniroma1.lcl.wimmp.MorphoForm;

import java.util.List;

public class GalicianMorphoRuleVerbConjIAR extends GalicianMorphoRuleVerbConjAR {

	public GalicianMorphoRuleVerbConjIAR(String title, String text) {
		super(title, text);
		
		String[] IARSuffixes = {
				"iar", 													// 0 - infinite 
				"iando", 												// 1 - gerund
				"iado", "iados", 											// 2-3 - past participle masculine
				"iada", "iadas", 											// 4-5 - past participle feminine
				"’o", "’as", "’a", "iamos", "iades", "’an", 					// 6-11 - present indicative
				"iaba", "iabas", "iaba", "iabamos", "iabades", "iaban", 		//12-17 imperfect indicative
				"iei", "iaches", "iou", "iamos", "iastes", "iaron", 			//18-23 preterite indicative
				"iara", "iaras", "iara", "iaramos", "iarades", "iaran", 		//24-29 pluperfect indicative
				"iarei", "iar‡s", "iar‡", "iaremos", "iaredes", "iar‡n", 		// 30-35 future indicative 
				"iar’a", "iar’as", "iar’a", "iariamos", "iariades", "iar’an", //36-41 conditional indicative
				"’e", "’es", "’e", "’emos", "’edes", "’en", 					//42-47 present subjunctive
				"iase", "iases", "iase", "i‡semos", "i‡sedes", "iasen",		//48-53 preterite subjunctive 
				"iar", "iares", "iar", "iarmos", "iardes", "iaren",			//54-59 future subjunctive
				"’a", "’e", "’emos", "’ade", "’en",							//60-64 affirmative imperative 
				"’es", "’e", "’emos", "’edes", "’en",						//65-69 negative imperative
				"iar", "iares", "iar", "iarmos", "iardes", "iaren" 			//70-75 personal infinitive
		};
		
		suffixes = IARSuffixes;
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
