package it.uniroma1.lcl.wimmp.galician.morphoRules;

public abstract class GalicianMorphoRulesVerb {

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
	private final String VERB = "gl-verb";

	protected String stem, ending;

	protected String present, preterite, past;

	public GalicianMorphoRulesVerb(String title, String text){
		this.title = title;
		this.text = text;

		getStemAndEnding();
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
			else if( parenthesisIndex == -1){
				return text.substring(exceptionIndex + exception.length(), parenthesisIndex);
			}
		}
		return "";

	}

}
