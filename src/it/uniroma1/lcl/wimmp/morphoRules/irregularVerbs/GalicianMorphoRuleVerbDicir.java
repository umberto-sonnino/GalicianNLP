package it.uniroma1.lcl.wimmp.morphoRules.irregularVerbs;

import java.util.List;

import it.uniroma1.lcl.wimmp.MorphoForm;
import it.uniroma1.lcl.wimmp.morphoRules.GalicianMorphoRuleVerb;

public class GalicianMorphoRuleVerbDicir extends GalicianMorphoRuleVerb {

	private String[] DICIRsuffixes = { 
			"cir", 													// 0 - infinite 
			"cindo", 												// 1 - gerund
			"to", "tos", 											// 2-3 - past participle masculine
			"ta", "tas", 											// 4-5 - past participle feminine
			"go", "s", "", "cimos", "cides", "n", 					// 6-11 - present indicative
			"c�a", "c�as", "c�a", "ciamos", "ciades", "c�an", 			//12-17 imperfect indicative
			"xen", "xeches", "xo", "xemos", "xestes", "xeron", 			//18-23 preterite indicative
			"xera", "xeras", "xera", "xeramos", "xerades", "xeran", 		//24-29 pluperfect indicative
			"irei", "ir�s", "ir�", "iremos", "iredes", "ir�n", 		// 30-35 future indicative 
			"ir�a", "ir�as", "ir�a", "iriamos", "iriades", "ir�an", //36-41 conditional indicative
			"ga", "gas", "ga", "gamos", "gades", "gan", 					//42-47 present subjunctive
			"xese", "xeses", "xese", "x�semos", "x�sedes", "xesen",		//48-53 preterite subjunctive 
			"xer", "xeres", "xer", "xermos", "xerdes", "xeren",			//54-59 future subjunctive
			"", "ga", "gamos", "cide", "gan",							//60-64 affirmative imperative 
			"gas", "ga", "gamos", "gais", "gan",						//65-69 negative imperative
			"cir", "cires", "cir", "cirmos", "cirdes", "ciren" 			//70-75 personal infinitive
	};
	
	public GalicianMorphoRuleVerbDicir(String title, String text) {
		super(title, text);
		
		stem = "di";
		
		suffixes = DICIRsuffixes;
		
	}

	@Override
	public List<MorphoForm> getForms() {
		super.getForms();
		
		setSuffixes();
		
		return forms;
	}
	
	

}
