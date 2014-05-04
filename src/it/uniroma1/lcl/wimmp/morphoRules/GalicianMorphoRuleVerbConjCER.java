package it.uniroma1.lcl.wimmp.morphoRules;

import it.uniroma1.lcl.wimmp.MorphoForm;
import it.uniroma1.lcl.wimmp.morphoForms.GalicianMorphoFormVerb;

import java.util.List;

public class GalicianMorphoRuleVerbConjCER extends GalicianMorphoRuleVerbConjER {

	public GalicianMorphoRuleVerbConjCER(String title, String text) {
		super(title, text);
		
		String[] CERsuffixes = {
				"cer", 													// 0 - infinite 
				"cendo", 												// 1 - gerund
				"cido", "cidos", 										// 2-3 - past participle masculine
				"cida", "cidas", 										// 4-5 - past participle feminine
				"zo", "ces", "ce", "cemos", "cedes", "cen", 			// 6-11 - present indicative
				"cía", "cías", "cía", "ciamos", "ciades", "cían", 		//12-17 imperfect indicative
				"cín", "ciches", "ceu", "cemos", "cestes", "ceron", 	//18-23 preterite indicative
				"cera", "ceras", "cera", "ceramos", "cerades", "ceran", //24-29 pluperfect indicative
				"cerei", "cerás", "cerá", "ceremos", "ceredes", "cerán", // 30-35 future indicative 
				"cería", "cerías", "cería", "ceriamos", "ceriades", "cerían", //36-41 conditional indicative
				"za", "zas", "za", "zamos", "zades", "zan", 			//42-47 present subjunctive
				"cese", "ceses", "cese", "césemos", "césedes", "cesen",	//48-53 preterite subjunctive 
				"cer", "ceres", "cer", "cermos", "cerdes", "ceren",		//54-59 future subjunctive
				"ce", "za", "zamos", "cede", "zan",						//60-64 affirmative imperative 
				"zas", "za", "zamos", "zades", "zan",					//65-69 negative imperative
				"cer", "ceres", "cer", "cermos", "cerdes", "ceren" 		//70-75 personal infinitive
		};
		
		suffixes = CERsuffixes;
		
		getDifferentStem();
	}


	private void getDifferentStem() {
		if(text.contains("gl-conj-cer")){
			
			int glConjCERIndex = text.indexOf("gl-conj-cer") + "gl-conj-cer".length() + 1;
			int parenthesisIndex = text.indexOf("}}", glConjCERIndex);
			
			stem = text.substring(glConjCERIndex, parenthesisIndex);
		}
	}


	@Override
	public List<MorphoForm> getForms() {

		super.getForms();

		for (int i = 0; i < forms.size(); i++) {
			((GalicianMorphoFormVerb) forms.get(i)).setForm(stem + suffixes[i]);
		}

		setPresent();
		setPastParticiple();
		setPreterite();
		
		return forms;
	}
	
}
