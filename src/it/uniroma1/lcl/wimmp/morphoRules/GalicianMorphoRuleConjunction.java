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
public class GalicianMorphoRuleConjunction implements MorphoRule {
	
	String title;
	String text;
	
	
	public GalicianMorphoRuleConjunction(String title,String text){
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
		return al;
	}

}
