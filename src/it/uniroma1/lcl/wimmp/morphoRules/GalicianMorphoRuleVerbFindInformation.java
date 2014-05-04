/**
 * 
 */
package it.uniroma1.lcl.wimmp.morphoRules;

import it.uniroma1.lcl.wimmp.MorphoForm;
import it.uniroma1.lcl.wimmp.MorphoRule;

import java.util.ArrayList;
import java.util.List;

/**
 * @author federicoscafoglieri
 *
 */
public class GalicianMorphoRuleVerbFindInformation implements MorphoRule{

	String title;
	String text;
	
	/**
	 * @param title
	 * @param text
	 */
	public GalicianMorphoRuleVerbFindInformation(String title, String text) {
		// TODO Auto-generated constructor stub
		this.title=title;
		this.text=text;
	}
	
	@Override
	public List<MorphoForm> getForms() {
		ArrayList<MorphoForm> al=new ArrayList<MorphoForm>();
		String subtext1="";
		String subtext2="";
		
		
		int fromIndexConjOf=text.indexOf("{{conjugation of");
		int toIndexConjOf=-1;
		if(fromIndexConjOf!=-1)
			toIndexConjOf=text.indexOf("}}", fromIndexConjOf);
		if(fromIndexConjOf!=-1 && toIndexConjOf!=-1){
			subtext1 = text.substring(fromIndexConjOf, toIndexConjOf+2);
		}
		
		fromIndexConjOf=text.indexOf("{{conjugation of",toIndexConjOf);
		toIndexConjOf=-1;
		if(fromIndexConjOf!=-1)
			toIndexConjOf=text.indexOf("}}", fromIndexConjOf);
		if(fromIndexConjOf!=-1 && toIndexConjOf!=-1){
			subtext2 = text.substring(fromIndexConjOf, toIndexConjOf+2);
		}
		
		
		
		String result1=findString(subtext1);
		String result2=findString(subtext2);
		
		if(!result1.equals(""))
			al.add(new MorphoForm(this.title,result1));
		if(!result2.equals(""))
			al.add(new MorphoForm(this.title,result2));
		return al;
	}
	
	private static String findString(String subtext){
		String mode="";
		String time="";
		String person="";
		String verb="";
		
		//find verb
		int fromIndexVerb=subtext.indexOf("{{conjugation of|");
		int toIndexVerb=-1;
		if(fromIndexVerb!=-1)
			toIndexVerb=subtext.indexOf("|", fromIndexVerb+17);
		if(fromIndexVerb!=-1 && toIndexVerb!=-1){
			verb = " of " + subtext.substring(fromIndexVerb+17, toIndexVerb);
		}
		
		
		
		//Person
		if(subtext.contains("|1|") || subtext.contains("first"))
			person="first person ";
		if(subtext.contains("|2|") || subtext.contains("second"))
			person="second person ";
		if(subtext.contains("|3|") || subtext.contains("third"))
			person="third person ";
		
		if(subtext.contains("|s|"))
			person=person.concat("singular ");
		if(subtext.contains("|p|"))
			person=person.concat("plural ");
		
		
		//Mode
		if(subtext.contains("|inf"))
			mode="infinite";
		if(subtext.contains("|part"))
			mode="participle";
		if(subtext.contains("|gerund"))
			mode="gerund";
		if(subtext.contains("|ind"))
			mode="indicative";
		if(subtext.contains("|imp"))
			mode="imperative";
		if(subtext.contains("|sub") || subtext.contains("|subjunctive"))
			mode="subjunctive";
		if(subtext.contains("|personal"))
			mode="personal "+mode;
		
		
		//Time
		if(subtext.contains("|pres"))
			time="present ";
		if(subtext.contains("|imperf"))
			time="imperfect ";
		if(subtext.contains("|pret"))
			time="preterite ";
		if(subtext.contains("|fut"))
			time="future ";
		if(subtext.contains("|cond"))
			time="conditional ";
		if(subtext.contains("|pluperf"))
			time="pluperfect ";
		
		return person+time+mode+verb;
	}

}
