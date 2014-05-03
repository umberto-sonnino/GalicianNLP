package util;

/**
 * 
 */


import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author Federico Scafoglieri & Umberto Sonnino
 *
 */
public class SAXHandler extends DefaultHandler {
	private List<MorphoEntryFromXml>  MorphoEntrylist=new ArrayList<MorphoEntryFromXml>();
	private MorphoEntryFromXml morphoEntry;
	private String content = "";
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
		if(qName.equals("page")){
			this.morphoEntry=new MorphoEntryFromXml();
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
			if(qName.equals("page")){
				if(!this.morphoEntry.getTitle().contains(":")){
					if(this.morphoEntry.getText().contains("{{gl-noun|") 
							|| this.morphoEntry.getText().contains("{{head|gl|noun form")
							|| this.morphoEntry.getText().contains("{{head|gl|plural")){
						String newText=extractInformationGlNoun(this.morphoEntry.getText());
						this.MorphoEntrylist.add(new MorphoEntryFromXml(this.morphoEntry.getTitle(),newText));
					}
					if(this.morphoEntry.getText().contains("{{gl-verb|") 
							|| this.morphoEntry.getText().contains("{{gl-conj") 
							|| this.morphoEntry.getText().contains("{{gl-verb-form")){
						String newText=this.extractInformationGlVerb(this.morphoEntry.getText());
						this.MorphoEntrylist.add(new MorphoEntryFromXml(this.morphoEntry.getTitle(),newText));
					}
					if(this.morphoEntry.getText().contains("{{gl-adj")){
						String newText=extractInformationGlAdjective(this.morphoEntry.getText());
						this.MorphoEntrylist.add(new MorphoEntryFromXml(this.morphoEntry.getTitle(),newText));
					}
					if(this.morphoEntry.getText().contains("{{gl-adv")){
						String newText=extractInformationGlAdverb(this.morphoEntry.getText());
						this.MorphoEntrylist.add(new MorphoEntryFromXml(this.morphoEntry.getTitle(),newText));
					}
					if(this.morphoEntry.getText().contains("{{head|gl|conjunction")){
						String newText=extractInformationGlConjunction(this.morphoEntry.getText());
						this.MorphoEntrylist.add(new MorphoEntryFromXml(this.morphoEntry.getTitle(),newText));
					}
					if(this.morphoEntry.getText().contains("{{gl-proper noun")){
						String newText=extractInformationGlProperNoun(this.morphoEntry.getText());
						this.MorphoEntrylist.add(new MorphoEntryFromXml(this.morphoEntry.getTitle(),newText));
					}
					if(this.morphoEntry.getText().contains("{{gl-pron") || this.morphoEntry.getText().contains("{{head|gl|pronoun")){
						String newText=extractInformationGlProNoun(this.morphoEntry.getText());
						this.MorphoEntrylist.add(new MorphoEntryFromXml(this.morphoEntry.getTitle(),newText));
					}
				}
		}
		if(qName.equals("title")){
			this.morphoEntry.setTitle(content);
			this.content="";
		}
		
		if(qName.equals("text")){
			this.morphoEntry.setText(content);
			this.content="";
		}
		else
			this.content="";
	}
	
	@Override
	public void characters(char[] ch, int start, int length) 
			throws SAXException {
		content = this.content.concat(String.copyValueOf(ch, start, length).trim());
	}
	/**
	 * @return the morphoEntrylist
	 */
	public List<MorphoEntryFromXml> getMorphoEntrylist() {
		return MorphoEntrylist;
	}
	/**
	 * @param morphoEntrylist the morphoEntrylist to set
	 */
	public void setMorphoEntrylist(List<MorphoEntryFromXml> morphoEntrylist) {
		MorphoEntrylist = morphoEntrylist;
	}
	
	/**
	 * Extract Information from Noun
	 * @return
	 */
	public String extractInformationGlNoun(String text){
		
		String first="",second="",third="",fourth="",fifth="",sixth="";
		
		int fromThisIndex= text.indexOf("==Galician==");
		int fromIndex = text.indexOf("{{gl-noun");
		int toIndex = text.indexOf("}}", fromIndex);

		if(fromIndex!=-1 && toIndex!=-1){
			String substring = text.substring(fromIndex, toIndex+2);
			first=substring;
		}
		
		fromIndex = text.indexOf("{{head|gl|noun form");
		toIndex = text.indexOf("}}", fromIndex);

		if(fromIndex!=-1 && toIndex!=-1){
			String substring = text.substring(fromIndex, toIndex+2);
			second=substring;
		}
		
		fromIndex = text.indexOf("{{g|",fromIndex);
		toIndex = text.indexOf("}}", fromIndex);

		if(fromIndex!=-1 && toIndex!=-1){
			String substring = text.substring(fromIndex, toIndex+2);
			third=substring;
		}
		
		fromIndex = text.indexOf("{{head|gl|plural");
		toIndex = text.indexOf("}}", fromIndex);

		if(fromIndex!=-1 && toIndex!=-1){
			String substring = text.substring(fromIndex, toIndex+2);
			fourth=substring;
		}
		
		fromIndex = text.indexOf("{{plural of",fromThisIndex);
		toIndex = text.indexOf("lang=gl}}", fromIndex);

		if(fromIndex!=-1 && toIndex!=-1){
			String substring = text.substring(fromIndex, toIndex+9);
			fifth=substring;
		}

		fromIndex = text.indexOf("{{feminine plural of|",fromThisIndex);
		toIndex = text.indexOf("lang=gl}}", fromIndex);

		if(fromIndex!=-1 && toIndex!=-1){
			String substring = text.substring(fromIndex, toIndex+9);
			sixth=substring;
		}
		
		fromIndex = text.indexOf("{{masculine plural",fromThisIndex);
		toIndex = text.indexOf("lang=gl}}", fromIndex);

		if(fromIndex!=-1 && toIndex!=-1){
			String substring = text.substring(fromIndex, toIndex+9);
			sixth=substring;
		}
		
		return first+second+third+fourth+fifth+sixth;
	}
	
	/**
	 * Extract Information from Verb
	 * @return
	 */
	public String extractInformationGlVerb(String text){
		
		String verb = "";
		String conj = "";
		String verbForm = "";
		String conjOf = "";
		
		int fromIndexVerb=text.indexOf("{{gl-verb|");
		int toIndexVerb=text.indexOf("}}", fromIndexVerb);
		if(fromIndexVerb!=-1 && toIndexVerb!=-1){
			verb = text.substring(fromIndexVerb, toIndexVerb+2);
		}
		
		int fromIndexConj=text.indexOf("{{gl-conj");
		int toIndexConj=text.indexOf("}}", fromIndexConj);
		if(fromIndexConj!=-1 && toIndexConj!=-1){
			conj = text.substring(fromIndexConj, toIndexConj+2);
		}
		
		int fromIndexVerbForm=text.indexOf("{{gl-verb-form");
		int toIndexVerbForm=text.indexOf("}}", fromIndexVerbForm);
		if(fromIndexVerbForm!=-1 && toIndexVerbForm!=-1){
			verbForm = text.substring(fromIndexVerbForm, toIndexVerbForm+2);
		}

		int fromThereIndex=text.indexOf("==Galician==");
		int fromIndexConjOf=text.indexOf("{{conjugation of",fromThereIndex);
		int toIndexConjOf=text.indexOf("lang=gl}}", fromIndexConjOf);
		if(fromIndexConjOf!=-1 && toIndexConjOf!=-1){
			conjOf = text.substring(fromIndexConjOf, toIndexConjOf+9);
		}
		
		return verb + conj + verbForm + conjOf;
	}

	/**
	 * Extract Information from Adjective
	 * @param text
	 * @return
	 */
	public String extractInformationGlAdjective(String text){
		
		int fromIndex = text.indexOf("{{gl-adj");
		int toIndex = text.indexOf("}}", fromIndex);

		if(fromIndex!=-1 && toIndex!=-1){
			String substring = text.substring(fromIndex, toIndex+2);
			return substring;
		}
		
		return "";
	}
	
	/**
	 * Extract Information from Adverb
	 * @param text
	 * @return
	 */
	public String extractInformationGlAdverb(String text){
		
		int fromIndex = text.indexOf("{{gl-adv");
		int toIndex = text.indexOf("}}", fromIndex);

		if(fromIndex!=-1 && toIndex!=-1){
			String substring = text.substring(fromIndex, toIndex+2);
			return substring;
		}
		
		return "";
	}
	
	
	/**
	 * Extract Information from proper noun
	 * @param text
	 * @return
	 */
	public String extractInformationGlProperNoun(String text){
		
		int fromIndex = text.indexOf("{{gl-proper noun");
		int toIndex = text.indexOf("}}", fromIndex);

		if(fromIndex!=-1 && toIndex!=-1){
			String substring = text.substring(fromIndex, toIndex+2);
			return substring;
		}
		
		return "";
	}
	
	/**
	 * Extract Information from conjunction
	 * @param text
	 * @return
	 */
	public String extractInformationGlConjunction(String text){
		
		int fromIndex = text.indexOf("{{head|gl|conjunction");
		int toIndex = text.indexOf("}}", fromIndex);

		if(fromIndex!=-1 && toIndex!=-1){
			String substring = text.substring(fromIndex, toIndex+2);
			return substring;
		}
		
		return "";
	}
	
	/**
	 * Extract Information from conjunction
	 * @param text
	 * @return
	 */
	public String extractInformationGlProNoun(String text){
		
		
		String first="",second="";
		int fromIndex = text.indexOf("{{head|gl|pronoun");
		int toIndex = text.indexOf("}}", fromIndex);

		if(fromIndex!=-1 && toIndex!=-1){
			String substring = text.substring(fromIndex, toIndex+2);
			first=substring;
		}
		
		fromIndex = text.indexOf("{{gl-pron");
		toIndex = text.indexOf("}}", fromIndex);

		if(fromIndex!=-1 && toIndex!=-1){
			String substring = text.substring(fromIndex, toIndex+2);
			second=substring;
		}
		return first+second;
	}
}
