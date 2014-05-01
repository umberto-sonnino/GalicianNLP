package it.uniroma1.lcl.wimmp.morphoRules;

import it.uniroma1.lcl.wimmp.MorphoForm;
import it.uniroma1.lcl.wimmp.morphoForms.GLMorphoFormVerb;

import java.util.ArrayList;
import java.util.List;

import javax.naming.PartialResultException;

public class GLMorphoRuleVerbConjAR extends GLMorphoRuleVerb {

	public GLMorphoRuleVerbConjAR(String title, String text) {
		super(title, text);
	}

	//In totale ci sono 76 forme, quindi ci saranno 76 entry, per ogni verbo di questo tipo

	@Override
	public List<MorphoForm> getForms() {

		/*---INFINTIE---*/
		forms.add(new GLMorphoFormVerb(stem + "ar", "infinite", "--")); 	//1

		/*---GERUND---*/
		forms.add(new GLMorphoFormVerb(stem + "ando", "gerund", "--")); 	//2

		/*---PAST PARTICIPLE---*/
		if(!past.equals("")){
			forms.add(new GLMorphoFormVerb(past, "masculine past participle" , "singular")); 	//3
			forms.add(new GLMorphoFormVerb(past, "masculine past participle", "plural")); 
			forms.add(new GLMorphoFormVerb(past, "feminine past participle", "singular")); 
			forms.add(new GLMorphoFormVerb(past, "feminine past participle", "plural")); 		//6
		}else{
			forms.add(new GLMorphoFormVerb(stem + "ado", "masculine past participle" , "singular")); 	//3
			forms.add(new GLMorphoFormVerb(stem + "ados", "masculine past participle", "plural")); 
			forms.add(new GLMorphoFormVerb(stem + "ada", "feminine past participle", "singular")); 
			forms.add(new GLMorphoFormVerb(stem + "adas", "feminine past participle", "plural")); 		//6
		}

		/*---INDICATIVE---*/
		//PRESENT
		if(!present.equals("")){
			forms.add(new GLMorphoFormVerb(present, "present indicative", "first singular")); 	//7
		}else {
			forms.add(new GLMorphoFormVerb(stem + "o", "present indicative", "first singular")); 	//7
		}
		forms.add(new GLMorphoFormVerb(stem + "as", "present indicative", "second singular"));
		forms.add(new GLMorphoFormVerb(stem + "a", "present indicative", "third singular"));
		forms.add(new GLMorphoFormVerb(stem + "amos", "present indicative", "first plural"));
		forms.add(new GLMorphoFormVerb(stem + "ades", "present indicative", "second plural"));
		forms.add(new GLMorphoFormVerb(stem + "an", "present indicative", "third plural")); 	//12

		//IMPERFECT
		forms.add(new GLMorphoFormVerb(stem + "aba", "imperfect indicative", "first singular"));	//13
		forms.add(new GLMorphoFormVerb(stem + "abas", "imperfect indicative", "second singular"));
		forms.add(new GLMorphoFormVerb(stem + "aba", "imperfect indicative", "third singular"));
		forms.add(new GLMorphoFormVerb(stem + "abamos", "imperfect indicative", "first plural"));
		forms.add(new GLMorphoFormVerb(stem + "abades", "imperfect indicative", "second plural"));
		forms.add(new GLMorphoFormVerb(stem + "aban", "imperfect indicative", "third plural")); //18

		//PRETERITE
		if(! preterite.equals("")){
			forms.add(new GLMorphoFormVerb(preterite, "preterite indicative", "first singular")); 	//19
		}else{
			forms.add(new GLMorphoFormVerb(stem + "ei", "preterite indicative", "first singular")); 	//19
		}
		forms.add(new GLMorphoFormVerb(stem + "aches", "preterite indicative", "second singular"));
		forms.add(new GLMorphoFormVerb(stem + "ou", "preterite indicative", "third singular"));
		forms.add(new GLMorphoFormVerb(stem + "amos", "preterite indicative", "first plural"));
		forms.add(new GLMorphoFormVerb(stem + "astes", "preterite indicative", "second plural"));
		forms.add(new GLMorphoFormVerb(stem + "aron", "preterite indicative", "third plural"));		//24

		//PLUPERFECT
		forms.add(new GLMorphoFormVerb(stem + "ara", "pluperfect indicative", "first singular"));	//25
		forms.add(new GLMorphoFormVerb(stem + "aras", "pluperfect indicative", "second singular"));
		forms.add(new GLMorphoFormVerb(stem + "ara", "pluperfect indicative", "third singular"));
		forms.add(new GLMorphoFormVerb(stem + "aramos", "pluperfect indicative", "first plural"));
		forms.add(new GLMorphoFormVerb(stem + "arades", "pluperfect indicative", "second plural"));
		forms.add(new GLMorphoFormVerb(stem + "aran", "pluperfect indicative", "third plural"));	//30

		//FUTURE
		forms.add(new GLMorphoFormVerb(stem + "arei", "future indicative", "first singular"));		//31
		forms.add(new GLMorphoFormVerb(stem + "ar‡s", "future indicative", "second singular"));
		forms.add(new GLMorphoFormVerb(stem + "ar‡", "future indicative", "third singular"));
		forms.add(new GLMorphoFormVerb(stem + "aremos", "future indicative", "first plural"));
		forms.add(new GLMorphoFormVerb(stem + "aredes", "future indicative", "second plural"));
		forms.add(new GLMorphoFormVerb(stem + "ar‡n", "future indicative", "third plural"));		//36

		//CONDITIONAL
		forms.add(new GLMorphoFormVerb(stem + "ar’a", "conditional indicative", "first singular")); //37
		forms.add(new GLMorphoFormVerb(stem + "ar’as", "conditional indicative", "second singular"));
		forms.add(new GLMorphoFormVerb(stem + "ar’a", "conditional indicative", "third singular"));
		forms.add(new GLMorphoFormVerb(stem + "ariamos", "conditional indicative", "first plural"));
		forms.add(new GLMorphoFormVerb(stem + "ariades", "conditional indicative", "second plural"));
		forms.add(new GLMorphoFormVerb(stem + "ar’an", "conditional indicative", "third plural"));	//42

		/*---SUBJUNCTIVE---*/
		//PRESENT
		forms.add(new GLMorphoFormVerb(stem + "e", "present subjunctive", "first singular"));		//43
		forms.add(new GLMorphoFormVerb(stem + "es", "present subjunctive", "second singular"));
		forms.add(new GLMorphoFormVerb(stem + "e", "present subjunctive", "third singular"));
		forms.add(new GLMorphoFormVerb(stem + "emos", "present subjunctive", "first plural"));
		forms.add(new GLMorphoFormVerb(stem + "edes", "present subjunctive", "second plural"));
		forms.add(new GLMorphoFormVerb(stem + "en", "present subjunctive", "third plural"));		//48

		//PRETERITE
		forms.add(new GLMorphoFormVerb(stem + "ase", "subjunctive preterite", "first singular"));	//49
		forms.add(new GLMorphoFormVerb(stem + "ases", "subjunctive preterite", "second singular"));
		forms.add(new GLMorphoFormVerb(stem + "ase", "subjunctive preterite", "third singular"));
		forms.add(new GLMorphoFormVerb(stem + "‡semos", "subjunctive preterite", "first plural"));
		forms.add(new GLMorphoFormVerb(stem + "‡sedes", "subjunctive preterite", "second plural"));
		forms.add(new GLMorphoFormVerb(stem + "asen", "subjunctive preterite", "third plural"));	//54

		//FUTURE
		forms.add(new GLMorphoFormVerb(stem + "ar", "subjunctive future", "first singular"));		//55
		forms.add(new GLMorphoFormVerb(stem + "ares", "subjunctive future", "second singular"));
		forms.add(new GLMorphoFormVerb(stem + "ar", "subjunctive future", "third singular"));
		forms.add(new GLMorphoFormVerb(stem + "armos", "subjunctive future", "first plural"));
		forms.add(new GLMorphoFormVerb(stem + "ardes", "subjunctive future", "second plural"));
		forms.add(new GLMorphoFormVerb(stem + "aren", "subjunctive future", "third plural"));		//60

		/*---IMPERATIVE---*/
		//AFFIRMATIVE
		forms.add(new GLMorphoFormVerb(stem + "a", "imperative affirmative", "second singular"));	//61
		forms.add(new GLMorphoFormVerb(stem + "e", "imperative affirmative", "third singular"));
		forms.add(new GLMorphoFormVerb(stem + "emos", "imperative affirmative", "first plural"));
		forms.add(new GLMorphoFormVerb(stem + "ade", "imperative affirmative", "second plural"));
		forms.add(new GLMorphoFormVerb(stem + "en", "imperative affirmative", "third plural"));		//65

		//NEGATIVE
		forms.add(new GLMorphoFormVerb(stem + "es", "imperative negative", "second singular"));		//66
		forms.add(new GLMorphoFormVerb(stem + "e", "imperative negative", "third singular"));
		forms.add(new GLMorphoFormVerb(stem + "emos", "imperative negative", "first plural"));
		forms.add(new GLMorphoFormVerb(stem + "edes", "imperative negative", "second plural"));
		forms.add(new GLMorphoFormVerb(stem + "en", "imperative negative", "third plural"));		//70

		/*---PERSONAL INFINITIVE---*/
		forms.add(new GLMorphoFormVerb(stem + "ar", "personal infinitive", "first singular"));		//71
		forms.add(new GLMorphoFormVerb(stem + "ares", "personal infinitive", "first singular"));
		forms.add(new GLMorphoFormVerb(stem + "ar", "personal infinitive", "third singular"));
		forms.add(new GLMorphoFormVerb(stem + "armos", "personal infinitive", "first plural"));
		forms.add(new GLMorphoFormVerb(stem + "ardes", "personal infinitive", "second plural"));
		forms.add(new GLMorphoFormVerb(stem + "aren", "personal infinitive", "third plural"));		//76



		return forms;
	}


}
