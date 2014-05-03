package it.uniroma1.lcl.wimmp.morphoRules;

import it.uniroma1.lcl.wimmp.MorphoForm;
import it.uniroma1.lcl.wimmp.MorphoRule;
import it.uniroma1.lcl.wimmp.morphoForms.GalicianMorphoFormVerb;

import java.util.ArrayList;
import java.util.List;

public abstract class GalicianMorphoRuleVerb implements MorphoRule {

	/*
	 *	Let's assume that the verbs have this form:
	 *	{{gl-verb|STEM|ENDING|pres=1ps PRESENT INDICATIVE|pret=1ps preterite indicative|part=past participle}}
	 *	1ps is the first person singular
	 *	Example using unnamed parameters for cantar (“to sing”) :
	 *		{{ gl-verb | cant | ar }}
	 * 	
	 *	Example using named parameters for satisfacer (“to satisfy”) :
	 *		{{ gl-verb | satisfac | er | pres=satisfago | pret=satisfixen | part=satisfeito }}
	 *	satisfacer (first-person sg present satisfago, first-person sg preterite satisfixen, past participle satisfeito)
	 */




	private String title;

	protected String text;

	protected String stem, ending;

	protected String present, preterite, past;

	protected List<MorphoForm> forms = new ArrayList<MorphoForm>();
	
	protected String[] suffixes = {
			"", 					// 0 - infinite 
			"", 					// 1 - gerund
			"", "", 				// 2-3 - past participle masculine
			"", "", 				// 4-5 - past participle feminine
			"", "", "", "", "", "",	// 6-11 - present indicative
			"", "", "", "", "", "",	//12-17 imperfect indicative
			"", "", "", "", "", "",	//18-23 preterite indicative
			"", "", "", "", "", "", //24-29 pluperfect indicative
			"", "", "", "", "", "", // 30-35 future indicative 
			"", "", "", "", "", "", //36-41 conditional indicative
			"", "", "", "", "", "",	//42-47 present subjunctive
			"", "", "", "", "", "",	//48-53 preterite subjunctive 
			"", "", "", "", "", "",	//54-59 future subjunctive
			"", "", "", "", "",		//60-64 affirmative imperative 
			"", "", "", "", "",		//65-69 negative imperative
			"", "", "", "", "", "" 	//70-75 personal infinitive
	};

	public GalicianMorphoRuleVerb(String title, String text){
		this.title = title;
		this.text = text;

		getStemAndEnding();

		this.present = findException("pres=");
		this.preterite = findException("pret=");
		this.past = findException("part=");
	}


	@Override
	public List<MorphoForm> getForms() {

		/*---INFINTE---*/
		forms .add(new GalicianMorphoFormVerb(stem, "infinite", "--")); 	//1

		/*---GERUND---*/
		forms.add(new GalicianMorphoFormVerb(stem, "gerund", "--")); 	//2

		/*---PAST PARTICIPLE---*/
		if(past.equals("")){
			forms.add(new GalicianMorphoFormVerb(stem, "masculine past participle" , "singular")); 	//3
			forms.add(new GalicianMorphoFormVerb(stem, "masculine past participle", "plural")); 
			forms.add(new GalicianMorphoFormVerb(stem, "feminine past participle", "singular")); 
			forms.add(new GalicianMorphoFormVerb(stem, "feminine past participle", "plural")); 		//6
		}else
		{
			forms.add(new GalicianMorphoFormVerb(past, "masculine past participle" , "singular")); 	//3
			forms.add(new GalicianMorphoFormVerb(past, "masculine past participle", "plural")); 
			forms.add(new GalicianMorphoFormVerb(past, "feminine past participle", "singular")); 
			forms.add(new GalicianMorphoFormVerb(past, "feminine past participle", "plural")); 		//6
		}

		/*---INDICATIVE---*/
		//PRESENT
		if(present.equals("")){
			forms.add(new GalicianMorphoFormVerb(stem, "present indicative", "first singular")); 	//7
		}else{
			forms.add(new GalicianMorphoFormVerb(present, "present indicative", "first singular")); 	//7
		}
		forms.add(new GalicianMorphoFormVerb(stem, "present indicative", "second singular"));
		forms.add(new GalicianMorphoFormVerb(stem, "present indicative", "third singular"));
		forms.add(new GalicianMorphoFormVerb(stem, "present indicative", "first plural"));
		forms.add(new GalicianMorphoFormVerb(stem, "present indicative", "second plural"));
		forms.add(new GalicianMorphoFormVerb(stem, "present indicative", "third plural")); 	//12

		//IMPERFECT
		forms.add(new GalicianMorphoFormVerb(stem, "imperfect indicative", "first singular"));	//13
		forms.add(new GalicianMorphoFormVerb(stem, "imperfect indicative", "second singular"));
		forms.add(new GalicianMorphoFormVerb(stem, "imperfect indicative", "third singular"));
		forms.add(new GalicianMorphoFormVerb(stem, "imperfect indicative", "first plural"));
		forms.add(new GalicianMorphoFormVerb(stem, "imperfect indicative", "second plural"));
		forms.add(new GalicianMorphoFormVerb(stem, "imperfect indicative", "third plural")); //18

		//PRETERITE
		if(preterite.equals("")){
			forms.add(new GalicianMorphoFormVerb(stem, "preterite indicative", "first singular")); 	//19
		}else{
			forms.add(new GalicianMorphoFormVerb(preterite, "preterite indicative", "first singular")); 	//19
		}
		forms.add(new GalicianMorphoFormVerb(stem, "preterite indicative", "second singular"));
		forms.add(new GalicianMorphoFormVerb(stem, "preterite indicative", "third singular"));
		forms.add(new GalicianMorphoFormVerb(stem, "preterite indicative", "first plural"));
		forms.add(new GalicianMorphoFormVerb(stem, "preterite indicative", "second plural"));
		forms.add(new GalicianMorphoFormVerb(stem, "preterite indicative", "third plural"));		//24

		//PLUPERFECT
		forms.add(new GalicianMorphoFormVerb(stem, "pluperfect indicative", "first singular"));	//25
		forms.add(new GalicianMorphoFormVerb(stem, "pluperfect indicative", "second singular"));
		forms.add(new GalicianMorphoFormVerb(stem, "pluperfect indicative", "third singular"));
		forms.add(new GalicianMorphoFormVerb(stem, "pluperfect indicative", "first plural"));
		forms.add(new GalicianMorphoFormVerb(stem, "pluperfect indicative", "second plural"));
		forms.add(new GalicianMorphoFormVerb(stem, "pluperfect indicative", "third plural"));	//30

		//FUTURE
		forms.add(new GalicianMorphoFormVerb(stem, "future indicative", "first singular"));		//31
		forms.add(new GalicianMorphoFormVerb(stem, "future indicative", "second singular"));
		forms.add(new GalicianMorphoFormVerb(stem, "future indicative", "third singular"));
		forms.add(new GalicianMorphoFormVerb(stem, "future indicative", "first plural"));
		forms.add(new GalicianMorphoFormVerb(stem, "future indicative", "second plural"));
		forms.add(new GalicianMorphoFormVerb(stem, "future indicative", "third plural"));		//36

		//CONDITIONAL
		forms.add(new GalicianMorphoFormVerb(stem, "conditional indicative", "first singular")); //37
		forms.add(new GalicianMorphoFormVerb(stem, "conditional indicative", "second singular"));
		forms.add(new GalicianMorphoFormVerb(stem, "conditional indicative", "third singular"));
		forms.add(new GalicianMorphoFormVerb(stem, "conditional indicative", "first plural"));
		forms.add(new GalicianMorphoFormVerb(stem, "conditional indicative", "second plural"));
		forms.add(new GalicianMorphoFormVerb(stem, "conditional indicative", "third plural"));	//42

		/*---SUBJUNCTIVE---*/
		//PRESENT
		forms.add(new GalicianMorphoFormVerb(stem, "present subjunctive", "first singular"));		//43
		forms.add(new GalicianMorphoFormVerb(stem, "present subjunctive", "second singular"));
		forms.add(new GalicianMorphoFormVerb(stem, "present subjunctive", "third singular"));
		forms.add(new GalicianMorphoFormVerb(stem, "present subjunctive", "first plural"));
		forms.add(new GalicianMorphoFormVerb(stem, "present subjunctive", "second plural"));
		forms.add(new GalicianMorphoFormVerb(stem, "present subjunctive", "third plural"));		//48

		//PRETERITE
		forms.add(new GalicianMorphoFormVerb(stem, "subjunctive preterite", "first singular"));	//49
		forms.add(new GalicianMorphoFormVerb(stem, "subjunctive preterite", "second singular"));
		forms.add(new GalicianMorphoFormVerb(stem, "subjunctive preterite", "third singular"));
		forms.add(new GalicianMorphoFormVerb(stem, "subjunctive preterite", "first plural"));
		forms.add(new GalicianMorphoFormVerb(stem, "subjunctive preterite", "second plural"));
		forms.add(new GalicianMorphoFormVerb(stem, "subjunctive preterite", "third plural"));	//54

		//FUTURE
		forms.add(new GalicianMorphoFormVerb(stem, "subjunctive future", "first singular"));		//55
		forms.add(new GalicianMorphoFormVerb(stem, "subjunctive future", "second singular"));
		forms.add(new GalicianMorphoFormVerb(stem, "subjunctive future", "third singular"));
		forms.add(new GalicianMorphoFormVerb(stem, "subjunctive future", "first plural"));
		forms.add(new GalicianMorphoFormVerb(stem, "subjunctive future", "second plural"));
		forms.add(new GalicianMorphoFormVerb(stem, "subjunctive future", "third plural"));		//60

		/*---IMPERATIVE---*/
		//AFFIRMATIVE
		forms.add(new GalicianMorphoFormVerb(stem, "imperative affirmative", "second singular"));	//61
		forms.add(new GalicianMorphoFormVerb(stem, "imperative affirmative", "third singular"));
		forms.add(new GalicianMorphoFormVerb(stem, "imperative affirmative", "first plural"));
		forms.add(new GalicianMorphoFormVerb(stem, "imperative affirmative", "second plural"));
		forms.add(new GalicianMorphoFormVerb(stem, "imperative affirmative", "third plural"));		//65

		//NEGATIVE
		forms.add(new GalicianMorphoFormVerb(stem, "imperative negative", "second singular"));		//66
		forms.add(new GalicianMorphoFormVerb(stem, "imperative negative", "third singular"));
		forms.add(new GalicianMorphoFormVerb(stem, "imperative negative", "first plural"));
		forms.add(new GalicianMorphoFormVerb(stem, "imperative negative", "second plural"));
		forms.add(new GalicianMorphoFormVerb(stem, "imperative negative", "third plural"));		//70

		/*---PERSONAL INFINITIVE---*/
		forms.add(new GalicianMorphoFormVerb(stem, "personal infinitve", "first singular"));		//71
		forms.add(new GalicianMorphoFormVerb(stem, "personal infinitve", "first singular"));
		forms.add(new GalicianMorphoFormVerb(stem, "personal infinitve", "third singular"));
		forms.add(new GalicianMorphoFormVerb(stem, "personal infinitve", "first plural"));
		forms.add(new GalicianMorphoFormVerb(stem, "personal infinitve", "second plural"));
		forms.add(new GalicianMorphoFormVerb(stem, "personal infinitve", "third plural"));		//76

		return forms;
	}

	protected void getStemAndEnding(){
		if(text.contains("gl-verb")){

			int verbIndex = text.indexOf("gl-verb") + "gl-verb|".length();
			int stemEnding = text.indexOf("|", verbIndex);
			stem = text.substring(verbIndex, stemEnding);

			stemEnding++; //getting past the | in the string
			int verbEndingIndex = text.indexOf("|", stemEnding);
			int parenthesisIndex = text.indexOf("}}", verbIndex);

			if(parenthesisIndex < verbEndingIndex || verbEndingIndex == -1)
				ending = text.substring(stemEnding, parenthesisIndex);
			else
				ending = text.substring(stemEnding, verbEndingIndex);

		}

	}

	protected String findException(String exception){

		if(text.contains(exception)){
			int exceptionIndex = text.indexOf(exception);
			int pipeIndex = text.indexOf("|", exceptionIndex);
			int parenthesisIndex = text.indexOf("}}", exceptionIndex);

			if(pipeIndex != -1 && pipeIndex < parenthesisIndex){
				return text.substring(exceptionIndex + exception.length(), pipeIndex);
			}
			else if( parenthesisIndex > -1){
				return text.substring(exceptionIndex + exception.length(), parenthesisIndex);
			}
		}
		return "";

	}
	
	protected void setPresent(){
		if(!present.equals("")){ 
			//FIRST PERSON SINGULAR PRESENT INDICATIVE IS #6
			((GalicianMorphoFormVerb) forms.get(6)).setForm(present);
		}
	}
	
	
	protected void setPastParticiple(){
		
		if(!past.equals("")){
			//PAST PARTICIPLE GUYS ARE #2-#5
			((GalicianMorphoFormVerb) forms.get(2)).setForm(past);
			((GalicianMorphoFormVerb) forms.get(3)).setForm(past);
			((GalicianMorphoFormVerb) forms.get(4)).setForm(past);
			((GalicianMorphoFormVerb) forms.get(5)).setForm(past);
		}
		
	}
	
	protected void setPreterite(){
		if(!preterite.equals("")){
			//FIRST PERSON SINGULAR PRETERITE INDICATIVE IS #18
			((GalicianMorphoFormVerb) forms.get(18)).setForm(preterite);
		}

	}
	
	protected void setSuffixes(){
		for (int i = 0; i < forms.size(); i++) {
			((GalicianMorphoFormVerb) forms.get(i)).setForm(stem + suffixes[i]);
		}
	}

}
