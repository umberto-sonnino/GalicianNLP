package it.uniroma1.lcl.wimmp.morphoRules;

import it.uniroma1.lcl.wimmp.MorphoForm;
import it.uniroma1.lcl.wimmp.morphoForms.GalicianMorphoFormVerb;

import java.util.List;

import javax.naming.PartialResultException;

public class GalicianMorphoRuleVerbConjER extends GalicianMorphoRuleVerb {

	private String modifiedStem = "houb";

	public GalicianMorphoRuleVerbConjER(String title, String text) {
		super(title, text);
		
		String[] ERSuffixes = { 
				"er", 													// 0 - infinite 
				"endo", 												// 1 - gerund
				"ido", "idos", 											// 2-3 - past participle masculine
				"ida", "idas", 											// 4-5 - past participle feminine
				"o", "es", "e", "emos", "edes", "en", 					// 6-11 - present indicative
				"’a", "’as", "’a", "iamos", "iades", "’an", 			//12-17 imperfect indicative
				"en", "eches", "o", "emos", "estes", "eron", 			//18-23 preterite indicative
				"era", "eras", "era", "eramos", "erades", "eran", 		//24-29 pluperfect indicative
				"erei", "er‡s", "er‡", "eremos", "eredes", "er‡n", 		// 30-35 future indicative 
				"er’a", "er’as", "er’a", "eriamos", "eriades", "er’an", //36-41 conditional indicative
				"a", "as", "a", "amos", "ades", "an", 					//42-47 present subjunctive
				"ese", "eses", "ese", "Žsemos", "Žsedes", "esen",		//48-53 preterite subjunctive 
				"er", "eres", "er", "ermos", "erdes", "eren",			//54-59 future subjunctive
				"", "", "", "", "",							//60-64 affirmative imperative 
				"", "", "", "", "",						//65-69 negative imperative
				"er", "eres", "er", "ermos", "erdes", "eren" 			//70-75 personal infinitive
		};
		
		suffixes = ERSuffixes;
		
	}

	@Override
	public List<MorphoForm> getForms() {
		super.getForms(); //fills the entries with just the stem
		
		setSuffixes();
		setPresent();
		setPastParticiple();
		setPreterite();
		
		int[] modifiedStemForms = { 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 
				48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59};
		
		for(int i = 0; i < modifiedStemForms.length; i++){
			int index = modifiedStemForms[i];
			((GalicianMorphoFormVerb) forms.get(index)).setForm(modifiedStem + suffixes[index]);
		}
		
		((GalicianMorphoFormVerb) forms.get(6)).setForm("has");
		((GalicianMorphoFormVerb) forms.get(7)).setForm("ha, hai");
		((GalicianMorphoFormVerb) forms.get(11)).setForm("han");
		
		((GalicianMorphoFormVerb) forms.get(42)).setForm("haxa");
		((GalicianMorphoFormVerb) forms.get(43)).setForm("haxas");
		((GalicianMorphoFormVerb) forms.get(44)).setForm("haxa");
		((GalicianMorphoFormVerb) forms.get(45)).setForm("haxamos");
		((GalicianMorphoFormVerb) forms.get(46)).setForm("haxades");
		((GalicianMorphoFormVerb) forms.get(47)).setForm("haxan");
		
		//NO IMPERATIVES
		for(int j = 60; j<70; j++)
			((GalicianMorphoFormVerb) forms.get(j)).setForm("--");
		
		
		return forms;
	}

}
