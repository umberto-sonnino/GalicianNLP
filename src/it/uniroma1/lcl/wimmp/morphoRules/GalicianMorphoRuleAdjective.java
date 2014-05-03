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
public class GalicianMorphoRuleAdjective implements MorphoRule {
	
	String title;
	String text;
	boolean regular;
	
	public GalicianMorphoRuleAdjective(String title,String text,boolean regular){
		this.title=title;
		this.text=text;
		this.regular=regular;
	}

	/* (non-Javadoc)
	 * @see it.uniroma1.lcl.wimmp.MorphoRule#getForms()
	 */
	@Override
	public List<MorphoForm> getForms() {
		// TODO Auto-generated method stub
		ArrayList<MorphoForm> al=new ArrayList<MorphoForm>();
		
		String stem=this.findPart("|m=");
		if(stem.equals(""))
			stem=this.findPart("|f=");
		
		if(regular){
			if(this.text.contains("|f=")){
				al.add(new MorphoForm(this.title,"masculine singular"));
				al.add(new MorphoForm(this.title+"s","masculine plural"));
				al.add(new MorphoForm(stem,"feminile singular"));
				al.add(new MorphoForm(stem+"s","feminile plural"));
			}
			
			if(this.text.contains("|m=")){
				al.add(new MorphoForm(this.title,"feminile singular"));
				al.add(new MorphoForm(this.title+"s","feminile plural"));
				al.add(new MorphoForm(stem,"masculine singular"));
				al.add(new MorphoForm(stem+"s","masculine plural"));
			}
		}
		
		if(!regular){
			String plural=this.findPart("pl=");
			if(this.text.contains("|f=")){
				al.add(new MorphoForm(this.title,"masculine singular"));
				al.add(new MorphoForm(plural,"masculine plural"));
				al.add(new MorphoForm(stem,"feminile singular"));
				al.add(new MorphoForm(plural,"feminile plural"));
			}
			if(this.text.contains("|m=")){
				al.add(new MorphoForm(this.title,"feminile singular"));
				al.add(new MorphoForm(plural,"feminile plural"));
				al.add(new MorphoForm(stem,"masculine singular"));
				al.add(new MorphoForm(plural,"masculine plural"));
			}
		}
		
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
