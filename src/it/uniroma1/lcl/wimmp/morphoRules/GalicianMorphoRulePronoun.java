/**
 * 
 */
package it.uniroma1.lcl.wimmp.morphoRules;

import java.util.ArrayList;
import java.util.List;

import it.uniroma1.lcl.wimmp.MorphoForm;
import it.uniroma1.lcl.wimmp.MorphoRule;

/**
 * @author federicoscafoglieri
 *
 */
public class GalicianMorphoRulePronoun implements MorphoRule {
	
	String title;
	String text;
	
	public GalicianMorphoRulePronoun(String title,String text){
		this.title=title;
		this.text=text;
	}
		
	/* (non-Javadoc)
	 * @see it.uniroma1.lcl.wimmp.MorphoRule#getForms()
	 */
	@Override
	public List<MorphoForm> getForms() {
		// TODO Auto-generated method stub
		ArrayList<MorphoForm> al=new ArrayList<MorphoForm>();
		
		String gender=findPart("|g=");
		String dative=findPart("|dat=");
		String accusative=findPart("|acc=");
		
		if(gender.equals("m"))
			gender="masculine";
		if(gender.equals("f"))
			gender="feminile";
		
		al.add(new MorphoForm(this.title,"nominative "+gender));
		
		if(!dative.equals(""))
			al.add(new MorphoForm(this.title,"dative "+gender));
		if(!accusative.equals(""))
			al.add(new MorphoForm(this.title,"accusative "+gender));

		return al;
	}
	
	private String findPart(String part){
		String findException="";
		int toIndex=-1;
		int toIndexAlternative=-1;
		
		int fromIndex=this.text.indexOf(part);
		if(fromIndex!=-1){
			toIndex=this.text.indexOf("|", fromIndex+1);
			toIndexAlternative=this.text.indexOf("}}", fromIndex+1);
		}
		
		if(fromIndex!=-1 && toIndex!=-1){
			findException= this.text.substring(fromIndex+part.length(), toIndex);
		}else
		if(fromIndex!=.1 && toIndexAlternative!=-1){
			findException= this.text.substring(fromIndex+part.length(), toIndexAlternative);
		}
		
		return findException;
	}

}
