/**
 * 
 */
package util;

import it.uniroma1.lcl.wimmp.MorphoEntry;
import it.uniroma1.lcl.wimmp.MorphoEntry.POS;
import it.uniroma1.lcl.wimmp.MorphoRule;
import it.uniroma1.lcl.wimmp.morphoRules.GalicianMorphoRuleAdjective;
import it.uniroma1.lcl.wimmp.morphoRules.GalicianMorphoRuleAdverb;
import it.uniroma1.lcl.wimmp.morphoRules.GalicianMorphoRuleConjunction;
import it.uniroma1.lcl.wimmp.morphoRules.GalicianMorphoRuleNotFind;
import it.uniroma1.lcl.wimmp.morphoRules.GalicianMorphoRuleNounPlural;
import it.uniroma1.lcl.wimmp.morphoRules.GalicianMorphoRuleNounSingular;
import it.uniroma1.lcl.wimmp.morphoRules.GalicianMorphoRulePronoun;
import it.uniroma1.lcl.wimmp.morphoRules.GalicianMorphoRuleProperNoun;
import it.uniroma1.lcl.wimmp.morphoRules.GalicianMorphoRuleVerbConjAR;
import it.uniroma1.lcl.wimmp.morphoRules.GalicianMorphoRuleVerbConjCAR;
import it.uniroma1.lcl.wimmp.morphoRules.GalicianMorphoRuleVerbConjCER;
import it.uniroma1.lcl.wimmp.morphoRules.GalicianMorphoRuleVerbConjER;
import it.uniroma1.lcl.wimmp.morphoRules.GalicianMorphoRuleVerbConjIAR;
import it.uniroma1.lcl.wimmp.morphoRules.GalicianMorphoRuleVerbConjIR;
import it.uniroma1.lcl.wimmp.morphoRules.GalicianMorphoRuleVerbConjUIR;
import it.uniroma1.lcl.wimmp.morphoRules.GalicianMorphoRuleVerbFindInformation;

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
			if(morpho.getText().contains("{{gl-verb") && morpho.getText().contains("{{conjugation of"))
				morphoRule= new GalicianMorphoRuleVerbFindInformation(morpho.getTitle(),morpho.getText());
			if(morpho.getText().contains("{{gl-conj-ar|"))
				morphoRule= new GalicianMorphoRuleVerbConjAR(morpho.getTitle(),morpho.getText());
			if(morpho.getText().contains("{{gl-conj-car|"))
				morphoRule= new GalicianMorphoRuleVerbConjCAR(morpho.getTitle(),morpho.getText());
			if(morpho.getText().contains("{{gl-conj-cer|"))
				morphoRule= new GalicianMorphoRuleVerbConjCER(morpho.getTitle(),morpho.getText());
			if(morpho.getText().contains("{{gl-conj-er|"))
				morphoRule= new GalicianMorphoRuleVerbConjER(morpho.getTitle(),morpho.getText());
			if(morpho.getText().contains("{{gl-conj-iar|"))
				morphoRule= new GalicianMorphoRuleVerbConjIAR(morpho.getTitle(),morpho.getText());
			if(morpho.getText().contains("{{gl-conj-ir|"))
				morphoRule= new GalicianMorphoRuleVerbConjIR(morpho.getTitle(),morpho.getText());
			if(morpho.getText().contains("{{gl-conj-uir|"))
				morphoRule= new GalicianMorphoRuleVerbConjUIR(morpho.getTitle(),morpho.getText());
									
			regular = true;
		}
		
		if(pos==POS.ADJECTIVE){
			regular = adjectiveIsRegular(morpho.getText());
			morphoRule = new GalicianMorphoRuleAdjective(morpho.getTitle(),morpho.getText(),regular);
		}
		
		if(pos==POS.ADVERB){
			regular = true;
			morphoRule = new GalicianMorphoRuleAdverb(morpho.getTitle(),morpho.getText());
		}
		
		if(pos==POS.CONJUNCTION){
			regular = true;
			morphoRule = new GalicianMorphoRuleConjunction(morpho.getTitle(),morpho.getText());
		}
		
		if(pos==POS.PROPERNOUN){
			regular = false;
			morphoRule = new GalicianMorphoRuleProperNoun(morpho.getTitle(),morpho.getText());
		}
		
		if(pos==POS.PRONOUN){
			regular = false;
			morphoRule = new GalicianMorphoRulePronoun(morpho.getTitle(),morpho.getText());	
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
		if(text.contains("{{gl-adj") || text.contains("{{head|gl|adjective form"))
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
			 ret=false;
		}else
		if(fromIndex2!=-1 && toIndex!=-1){
			ret=false;
		}		
		
		return ret;
	}
	
	private static boolean adjectiveIsRegular(String text){
		
		if(text.contains("pl="))
			return false;
		
		return true;
	}
	
}
