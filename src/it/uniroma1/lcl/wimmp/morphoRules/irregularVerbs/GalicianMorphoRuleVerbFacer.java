package it.uniroma1.lcl.wimmp.morphoRules.irregularVerbs;

import java.util.List;

import it.uniroma1.lcl.wimmp.MorphoForm;
import it.uniroma1.lcl.wimmp.morphoRules.GalicianMorphoRuleVerbConjCER;

public class GalicianMorphoRuleVerbFacer extends GalicianMorphoRuleVerbConjCER {

	public GalicianMorphoRuleVerbFacer(String title, String text) {
		
		super(title, text);
		stem = getStem();
		
		String[] FACERSuffixes = {
			
				"acer", 													// 0 - infinite 
				"acendo", 												// 1 - gerund
				"eito", "eitos", 										// 2-3 - past participle masculine
				"eita", "eitas", 										// 4-5 - past participle feminine
				"ago", "as", "ai", "acemos", "acedes", "an", 			// 6-11 - present indicative
				"acía", "acías", "acía", "aciamos", "aciades", "acían", 		//12-17 imperfect indicative
				"ixen", "ixeches", "ixo", "ixemos", "ixestes", "ixeron", 	//18-23 preterite indicative
				"ixera", "ixeras", "ixera", "ixeramos", "ixerades", "ixeran", //24-29 pluperfect indicative
				"arei", "arás", "ará", "aremos", "aredes", "arán", // 30-35 future indicative 
				"aría", "arías", "aría", "ariamos", "ariades", "arían", //36-41 conditional indicative
				"aga", "agas", "aga", "agamos", "agades", "agan", 			//42-47 present subjunctive
				"ixese", "ixeses", "ixese", "ixésemos", "ixésedes", "ixesen",	//48-53 preterite subjunctive 
				"ixer", "ixeres", "ixer", "ixermos", "ixerdes", "ixeren",		//54-59 future subjunctive
				"ai", "aga", "agamos", "acede", "agan",						//60-64 affirmative imperative 
				"agas", "aga", "agamos", "agades", "agan",					//65-69 negative imperative
				"acer", "aceres", "acer", "acermos", "acerdes", "aceren" 		//70-75 personal infinitive
				
		};
		
		suffixes = FACERSuffixes;
		
	}
	

	private String getStem() {
		int glConjIndex = text.indexOf("gl-conj (dicir)");
		int pipeIndex = text.indexOf("|", glConjIndex) + 1;
		int endingIndex = text.indexOf("}}",  pipeIndex);
		
		return text.substring(pipeIndex, endingIndex);
	}


	@Override
	public List<MorphoForm> getForms() {

		super.getForms();

		setSuffixes();
		setPresent();
		setPreterite();
		
		return forms;
	}
	
}
