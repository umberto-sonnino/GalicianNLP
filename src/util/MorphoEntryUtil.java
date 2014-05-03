/**
 * 
 */
package util;

import it.uniroma1.lcl.wimmp.MorphoEntry;
import it.uniroma1.lcl.wimmp.MorphoEntry.POS;
import it.uniroma1.lcl.wimmp.MorphoRule;
import it.uniroma1.lcl.wimmp.morphoRules.GalicianMorphoRuleNotFind;
import it.uniroma1.lcl.wimmp.morphoRules.GalicianMorphoRuleNounPlural;
import it.uniroma1.lcl.wimmp.morphoRules.GalicianMorphoRuleNounSingular;

/**
 * @author Federico Scafoglieri & Umberto Sonnino
 *
 */
public class MorphoEntryUtil {
	
	/**
	 * Create a new morphoEntry(Title,POS,regular,rule);
	 * 
	 * @param morpho
	 * @return
	 */
	public static MorphoEntry MorphoEntryResult(MorphoEntryFromXml morpho){
		//Change this to add more information and create a great morphoEntry!
		POS pos=findEnWiktionaryPOS(morpho.getText());
		boolean regular = false;
		MorphoRule morphoRule = new GalicianMorphoRuleNotFind();
		
		if(pos==POS.NOUN){
			if(morpho.getText().contains("plural of")){
				morphoRule= new GalicianMorphoRuleNounSingular(morpho.getTitle(),morpho.getText());
			}
			else{
				regular=nounIsRegular(morpho.getText());
				morphoRule= new GalicianMorphoRuleNounPlural(morpho.getTitle(),morpho.getText(),regular);
			}
		}
		
		if(pos==POS.VERB){
			regular = true;
		}
		
		if(pos==POS.ADJECTIVE){
			regular = true;
		}
		
		if(pos==POS.ADVERB){
			regular = true;
		}
		
		if(pos==POS.CONJUNCTION){
			regular = true;
		}
		
		if(pos==POS.PROPERNOUN){
			regular = false;
		}
		
		if(pos==POS.PRONOUN){
			regular = true;
		}
		
		if(pos==null){
			regular = false;
		}
		
		return new MorphoEntry(morpho.getTitle(),pos,regular,morphoRule);
	}
	
	/**
	 * on en-wiktionary POS can be:
	 * -noun if there is gl-noun
	 * -verb if there is adj
	 * -adjective if there is gl-adj
	 * 
	 * @param text
	 * @return
	 */
	private static POS findEnWiktionaryPOS(String text){
		if(text.contains("{{gl-noun|") || text.contains("{{head|gl|noun form") || text.contains("{{head|gl|plural"))
			return POS.NOUN;
		if(text.contains("{{gl-verb") ||text.contains("{{gl-conj") || text.contains("{{gl-verb-form"))
			return POS.VERB;
		if(text.contains("{{gl-adj") )
			return POS.ADJECTIVE;
		if(text.contains("{{gl-adv"))
			return POS.ADVERB;
		if(text.contains("{{head|gl|conjunction"))
			return POS.CONJUNCTION;
		if(text.contains("{{gl-proper noun"))
			return POS.PROPERNOUN;
		if(text.contains("{{gl-pron") || text.contains("{{head|gl|pronoun"))
			return POS.PRONOUN;
		return null;
		
		
	}
	
	private static boolean nounIsRegular(String text){
		
		boolean ret=true;
		String findException="";
		
		int fromIndex=text.indexOf("|m|");
		int fromIndex2=text.indexOf("|f|");
		int toIndex=-1;
		if(fromIndex!=-1){
			toIndex=text.indexOf("}}", fromIndex);
		}
		if(fromIndex2!=-1){
			toIndex=text.indexOf("}}", fromIndex2);
		}
		
		if(fromIndex!=-1 && toIndex!=-1){
			 findException= text.substring(fromIndex+3, toIndex);
			 ret=false;
		}else
		if(fromIndex2!=-1 && toIndex!=-1){
			findException= text.substring(fromIndex2+3, toIndex);
			ret=false;
		}		
		
		System.out.println(findException);
		
		return ret;
	}
	
}