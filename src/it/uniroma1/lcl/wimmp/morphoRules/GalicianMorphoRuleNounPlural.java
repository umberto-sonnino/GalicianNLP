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
public class GalicianMorphoRuleNounPlural extends GalicianMorphoRuleNoun {
	
	boolean regular;

	public GalicianMorphoRuleNounPlural(String title,String text,boolean regular){
		super(title,text);
		this.regular=regular;
	}
	
	@Override
	public List<MorphoForm> getForms() {
		ArrayList<MorphoForm> al=new ArrayList<MorphoForm>();
		
		
		String gender="";
		String uncontable="";
		
		if(super.getText().contains("|m"))
			gender="masculine";
		
		if(super.getText().contains("|f"))
			gender="feminine";
		
		if(super.getText().contains("|-")){
			uncontable="uncontable";
		}
		
		if(uncontable!=""){
			al.add(new MorphoForm(super.getTitle(),gender+" "+ uncontable +" plural"));
		}else
		if(regular)
			al.add(new MorphoForm(super.getTitle()+"s",gender+" plural"));
		else{
			String findException="";
			
			int fromIndex=super.getText().indexOf("|m|");
			int fromIndex2=super.getText().indexOf("|f|");
			int toIndex=-1;
			if(fromIndex!=-1){
				toIndex=super.getText().indexOf("}}", fromIndex);
			}
			if(fromIndex2!=-1){
				toIndex=super.getText().indexOf("}}", fromIndex2);
			}
			
			if(fromIndex!=-1 && toIndex!=-1){
				if(fromIndex+3<toIndex)
					findException= super.getText().substring(fromIndex+3, toIndex);
			}else
			if(fromIndex2!=-1 && toIndex!=-1){
				if(fromIndex2+3<toIndex)
					findException= super.getText().substring(fromIndex2+3, toIndex);
			}		
			
			al.add(new MorphoForm(findException,gender+" plural"));
		}
		
		return al;
	}
}
