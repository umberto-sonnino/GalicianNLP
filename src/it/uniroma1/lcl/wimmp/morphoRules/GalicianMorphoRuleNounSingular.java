/**
 * 
 */
package it.uniroma1.lcl.wimmp.morphoRules;

import it.uniroma1.lcl.wimmp.MorphoForm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author federicoscafoglieri
 *
 */
public class GalicianMorphoRuleNounSingular extends GalicianMorphoRuleNoun {

	/**
	 * @param title
	 * @param text
	 */
	public GalicianMorphoRuleNounSingular(String title, String text) {
		super(title, text);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<MorphoForm> getForms() {
		ArrayList<MorphoForm> al=new ArrayList<MorphoForm>();
		
		String gender="";
		String person="";
		
		if(super.getText().contains("|g=f-p}}"))
			gender= "femminine plural";
		if(super.getText().contains("|g=m-p}}"))
			gender= "masculine plural";
		if(super.getText().contains("|m-p"))
			gender= "masculine plural ";
		if(super.getText().contains("|f-p"))
			gender=gender.concat("femminile plural");
		
		al.add(new MorphoForm(super.getTitle(),gender + person));
		
		String pluralGenderPerson="";
		String pluralOf="";
		
		int fromIndex=-1;
		int toIndex=-1;
		
		fromIndex = text.indexOf("{{plural of|");
		toIndex = text.indexOf("|lang=gl}}", fromIndex);
		if(fromIndex!=-1 && toIndex!=-1){
			String substring = text.substring(fromIndex+12, toIndex);
			pluralGenderPerson="singular";
			pluralOf=substring;
		}
		
		fromIndex = text.indexOf("{{feminine plural of|");
		toIndex = text.indexOf("|lang=gl}}", fromIndex);
		if(fromIndex!=-1 && toIndex!=-1){
			String substring = text.substring(fromIndex+21, toIndex);
			pluralGenderPerson="feminine singular";
			pluralOf=substring;
		}
		
		fromIndex = text.indexOf("{{masculine plural of|");
		toIndex = text.indexOf("|lang=gl}}", fromIndex);
		if(fromIndex!=-1 && toIndex!=-1){
			String substring = text.substring(fromIndex+22, toIndex);
			pluralGenderPerson="masculine singular";
			pluralOf=substring;
		}
		
		al.add(new MorphoForm(pluralOf,pluralGenderPerson));
		
		return al;
	}

}
