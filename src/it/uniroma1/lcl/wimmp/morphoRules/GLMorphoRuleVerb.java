package it.uniroma1.lcl.wimmp.morphoRules;

import java.util.ArrayList;
import java.util.List;

import it.uniroma1.lcl.wimmp.MorphoForm;
import it.uniroma1.lcl.wimmp.MorphoRule;
import it.uniroma1.lcl.wimmp.morphoForms.GLMorphoFormVerb;

public abstract class GLMorphoRuleVerb implements MorphoRule {

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




	private String title, text;

	protected String stem, ending;

	protected String present, preterite, past;

	protected List<MorphoForm> forms = new ArrayList<MorphoForm>();

	public GLMorphoRuleVerb(String title, String text){
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
		forms .add(new GLMorphoFormVerb(stem, "infinite", "--")); 	//1

		/*---GERUND---*/
		forms.add(new GLMorphoFormVerb(stem, "gerund", "--")); 	//2

		/*---PAST PARTICIPLE---*/
		if(past.equals("")){
			forms.add(new GLMorphoFormVerb(stem, "masculine past participle" , "singular")); 	//3
			forms.add(new GLMorphoFormVerb(stem, "masculine past participle", "plural")); 
			forms.add(new GLMorphoFormVerb(stem, "feminine past participle", "singular")); 
			forms.add(new GLMorphoFormVerb(stem, "feminine past participle", "plural")); 		//6
		}else
		{
			forms.add(new GLMorphoFormVerb(past, "masculine past participle" , "singular")); 	//3
			forms.add(new GLMorphoFormVerb(past, "masculine past participle", "plural")); 
			forms.add(new GLMorphoFormVerb(past, "feminine past participle", "singular")); 
			forms.add(new GLMorphoFormVerb(past, "feminine past participle", "plural")); 		//6
		}

		/*---INDICATIVE---*/
		//PRESENT
		if(present.equals("")){
			forms.add(new GLMorphoFormVerb(stem, "present indicative", "first singular")); 	//7
		}else{
			forms.add(new GLMorphoFormVerb(present, "present indicative", "first singular")); 	//7
		}
		forms.add(new GLMorphoFormVerb(stem, "present indicative", "second singular"));
		forms.add(new GLMorphoFormVerb(stem, "present indicative", "third singular"));
		forms.add(new GLMorphoFormVerb(stem, "present indicative", "first plural"));
		forms.add(new GLMorphoFormVerb(stem, "present indicative", "second plural"));
		forms.add(new GLMorphoFormVerb(stem, "present indicative", "third plural")); 	//12

		//IMPERFECT
		forms.add(new GLMorphoFormVerb(stem, "imperfect indicative", "first singular"));	//13
		forms.add(new GLMorphoFormVerb(stem, "imperfect indicative", "second singular"));
		forms.add(new GLMorphoFormVerb(stem, "imperfect indicative", "third singular"));
		forms.add(new GLMorphoFormVerb(stem, "imperfect indicative", "first plural"));
		forms.add(new GLMorphoFormVerb(stem, "imperfect indicative", "second plural"));
		forms.add(new GLMorphoFormVerb(stem, "imperfect indicative", "third plural")); //18

		//PRETERITE
		if(preterite.equals("")){
			forms.add(new GLMorphoFormVerb(stem, "preterite indicative", "first singular")); 	//19
		}else{
			forms.add(new GLMorphoFormVerb(preterite, "preterite indicative", "first singular")); 	//19
		}
		forms.add(new GLMorphoFormVerb(stem, "preterite indicative", "second singular"));
		forms.add(new GLMorphoFormVerb(stem, "preterite indicative", "third singular"));
		forms.add(new GLMorphoFormVerb(stem, "preterite indicative", "first plural"));
		forms.add(new GLMorphoFormVerb(stem, "preterite indicative", "second plural"));
		forms.add(new GLMorphoFormVerb(stem, "preterite indicative", "third plural"));		//24

		//PLUPERFECT
		forms.add(new GLMorphoFormVerb(stem, "pluperfect indicative", "first singular"));	//25
		forms.add(new GLMorphoFormVerb(stem, "pluperfect indicative", "second singular"));
		forms.add(new GLMorphoFormVerb(stem, "pluperfect indicative", "third singular"));
		forms.add(new GLMorphoFormVerb(stem, "pluperfect indicative", "first plural"));
		forms.add(new GLMorphoFormVerb(stem, "pluperfect indicative", "second plural"));
		forms.add(new GLMorphoFormVerb(stem, "pluperfect indicative", "third plural"));	//30

		//FUTURE
		forms.add(new GLMorphoFormVerb(stem, "future indicative", "first singular"));		//31
		forms.add(new GLMorphoFormVerb(stem, "future indicative", "second singular"));
		forms.add(new GLMorphoFormVerb(stem, "future indicative", "third singular"));
		forms.add(new GLMorphoFormVerb(stem, "future indicative", "first plural"));
		forms.add(new GLMorphoFormVerb(stem, "future indicative", "second plural"));
		forms.add(new GLMorphoFormVerb(stem, "future indicative", "third plural"));		//36

		//CONDITIONAL
		forms.add(new GLMorphoFormVerb(stem, "conditional indicative", "first singular")); //37
		forms.add(new GLMorphoFormVerb(stem, "conditional indicative", "second singular"));
		forms.add(new GLMorphoFormVerb(stem, "conditional indicative", "third singular"));
		forms.add(new GLMorphoFormVerb(stem, "conditional indicative", "first plural"));
		forms.add(new GLMorphoFormVerb(stem, "conditional indicative", "second plural"));
		forms.add(new GLMorphoFormVerb(stem, "conditional indicative", "third plural"));	//42

		/*---SUBJUNCTIVE---*/
		//PRESENT
		forms.add(new GLMorphoFormVerb(stem, "present subjunctive", "first singular"));		//43
		forms.add(new GLMorphoFormVerb(stem, "present subjunctive", "second singular"));
		forms.add(new GLMorphoFormVerb(stem, "present subjunctive", "third singular"));
		forms.add(new GLMorphoFormVerb(stem, "present subjunctive", "first plural"));
		forms.add(new GLMorphoFormVerb(stem, "present subjunctive", "second plural"));
		forms.add(new GLMorphoFormVerb(stem, "present subjunctive", "third plural"));		//48

		//PRETERITE
		forms.add(new GLMorphoFormVerb(stem, "subjunctive preterite", "first singular"));	//49
		forms.add(new GLMorphoFormVerb(stem, "subjunctive preterite", "second singular"));
		forms.add(new GLMorphoFormVerb(stem, "subjunctive preterite", "third singular"));
		forms.add(new GLMorphoFormVerb(stem, "subjunctive preterite", "first plural"));
		forms.add(new GLMorphoFormVerb(stem, "subjunctive preterite", "second plural"));
		forms.add(new GLMorphoFormVerb(stem, "subjunctive preterite", "third plural"));	//54

		//FUTURE
		forms.add(new GLMorphoFormVerb(stem, "subjunctive future", "first singular"));		//55
		forms.add(new GLMorphoFormVerb(stem, "subjunctive future", "second singular"));
		forms.add(new GLMorphoFormVerb(stem, "subjunctive future", "third singular"));
		forms.add(new GLMorphoFormVerb(stem, "subjunctive future", "first plural"));
		forms.add(new GLMorphoFormVerb(stem, "subjunctive future", "second plural"));
		forms.add(new GLMorphoFormVerb(stem, "subjunctive future", "third plural"));		//60

		/*---IMPERATIVE---*/
		//AFFIRMATIVE
		forms.add(new GLMorphoFormVerb(stem, "imperative affirmative", "second singular"));	//61
		forms.add(new GLMorphoFormVerb(stem, "imperative affirmative", "third singular"));
		forms.add(new GLMorphoFormVerb(stem, "imperative affirmative", "first plural"));
		forms.add(new GLMorphoFormVerb(stem, "imperative affirmative", "second plural"));
		forms.add(new GLMorphoFormVerb(stem, "imperative affirmative", "third plural"));		//65

		//NEGATIVE
		forms.add(new GLMorphoFormVerb(stem, "imperative negative", "second singular"));		//66
		forms.add(new GLMorphoFormVerb(stem, "imperative negative", "third singular"));
		forms.add(new GLMorphoFormVerb(stem, "imperative negative", "first plural"));
		forms.add(new GLMorphoFormVerb(stem, "imperative negative", "second plural"));
		forms.add(new GLMorphoFormVerb(stem, "imperative negative", "third plural"));		//70

		/*---PERSONAL INFINITIVE---*/
		forms.add(new GLMorphoFormVerb(stem, "personal infinitve", "first singular"));		//71
		forms.add(new GLMorphoFormVerb(stem, "personal infinitve", "first singular"));
		forms.add(new GLMorphoFormVerb(stem, "personal infinitve", "third singular"));
		forms.add(new GLMorphoFormVerb(stem, "personal infinitve", "first plural"));
		forms.add(new GLMorphoFormVerb(stem, "personal infinitve", "second plural"));
		forms.add(new GLMorphoFormVerb(stem, "personal infinitve", "third plural"));		//76

		((GLMorphoFormVerb)forms.get(0)).setForm("OLEEEEE");

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

}
