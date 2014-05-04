package it.uniroma1.lcl.wimmp.morphoRules.irregularVerbs;

import java.util.List;

import it.uniroma1.lcl.wimmp.MorphoForm;
import it.uniroma1.lcl.wimmp.morphoForms.GalicianMorphoFormVerb;
import it.uniroma1.lcl.wimmp.morphoRules.GalicianMorphoRuleVerbConjIR;

public class GalicianMorphoRuleVerbVir extends GalicianMorphoRuleVerbConjIR {

	private String[] VIRsuffixes = { 
			"ir", 													// 0 - infinite 
			"indo", 												// 1 - gerund
			"ido", "idos", 											// 2-3 - past participle masculine
			"ido", "idas", 											// 4-5 - past participle feminine
			"e–o", "Žs", "Žn", "imos", "ides", "e–en", 					// 6-11 - present indicative
			"’–a", "’–as", "’–a", "’–amos", "’–ades", "’–an", 			//12-17 imperfect indicative
			"’n", "i–eches", "eu", "i–emos", "i–estes", "i–eron", 			//18-23 preterite indicative
			"i–era", "i–eras", "i–era", "i–eramos", "i–erades", "i–eran", 		//24-29 pluperfect indicative
			"irei", "ir‡s", "ir‡", "iremos", "iredes", "ir‡n", 		// 30-35 future indicative 
			"ir’a", "ir’as", "ir’a", "iriamos", "iriades", "ir’an", //36-41 conditional indicative
			"e–a", "e–as", "e–a", "e–amos", "e–ades", "e–an", 					//42-47 present subjunctive
			"i–ese", "i–eses", "i–ese", "’–esemos", "’–esedes", "i–esen",		//48-53 preterite subjunctive 
			"i–er", "i–eres", "i–er", "i–ermos", "i–erdes", "i–eren",			//54-59 future subjunctive
			"en", "--", "--", "inde", "--",							//60-64 affirmative imperative 
			"--", "--", "--", "--", "--",						//65-69 negative imperative
			"ir", "ires", "ir", "irmos", "irdes", "iren" 			//70-75 personal infinitive
	};
	
	public GalicianMorphoRuleVerbVir(String title, String text) {
		super(title, text);
		suffixes = VIRsuffixes;
		
		this.past = "vido";
	}
	
	@Override
	public List<MorphoForm> getForms() {
		super.getForms(); //fills the entries with just the stem
		
		setSuffixes();
		setPresent();
		setPastParticiple();
		setPreterite();
		
		((GalicianMorphoFormVerb)forms.get(61)).setForm("--");
		((GalicianMorphoFormVerb)forms.get(62)).setForm("--");
		((GalicianMorphoFormVerb)forms.get(64)).setForm("--");
		((GalicianMorphoFormVerb)forms.get(65)).setForm("--");
		((GalicianMorphoFormVerb)forms.get(66)).setForm("--");
		((GalicianMorphoFormVerb)forms.get(67)).setForm("--");
		((GalicianMorphoFormVerb)forms.get(68)).setForm("--");
		((GalicianMorphoFormVerb)forms.get(69)).setForm("--");
		
		return forms;
	}

}
