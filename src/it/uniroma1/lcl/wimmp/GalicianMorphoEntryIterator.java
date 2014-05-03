package it.uniroma1.lcl.wimmp;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLStreamException;

import org.xml.sax.SAXException;

import util.MorphoEntryFromXml;
import util.MorphoEntryUtil;
import util.SAXHandler;

/**
 * @author Federico Scafoglieri & Umberto Sonnino
 *
 */
public class GalicianMorphoEntryIterator extends MorphoEntryIterator {
	
	List<MorphoEntryFromXml> al;
	int index=0;
	
	/**
	 * @param dumps
	 * @throws XMLStreamException 
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public GalicianMorphoEntryIterator(String[] dumps) throws XMLStreamException, SAXException, IOException, ParserConfigurationException {
		super(dumps);
		
	    SAXParserFactory parserFactor = SAXParserFactory.newInstance();
	    SAXParser parser = parserFactor.newSAXParser();
	    SAXHandler handler = new SAXHandler();
	    //parser.parse(new File("prova.xml"),handler);
        parser.parse("enwiktionary-latest-pages-articles.xml",handler);
	     
	    al=handler.getMorphoEntrylist();
	    
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
		if(index<al.size())
			return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#next()
	 */
	@Override
	public MorphoEntry next() {
		MorphoEntryFromXml morpho=al.get(index);
		System.out.println(morpho.getTitle());
		MorphoEntry me=MorphoEntryUtil.MorphoEntryResult(morpho);
		index++;
		return me;
	}
}
