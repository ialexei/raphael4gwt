package org.sgx.raphael4gwt.tut;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.LIElement;
import com.google.gwt.dom.client.Node;
import com.google.gwt.dom.client.NodeList;
/**
 * TOC generation from h1, h2, h3 html elements. Usage
 * 
<pre>
//the element that will contain the generated toc
Element container = Document.get().getElementById("toc");	
//from where do we have to read h1, h2, h3, etc elements to make the toc.
Element tocRoot = Document.get().getElementById("gwteditorsManualMain");		
Toc toc = new Toc(container, tocRoot);
toc.make(); 
</pre> 

 * @author sg
 *
 */
public class Toc {
	Element parentEl, root;
	/**
	 * 
	 * @param parentEl - the element that will contain the generated toc
	 * @param root - from where do we have to read h1, h2, h3, etc elements to make the toc.
	 */
	public Toc(Element parentEl, Element root) {
		super();
		this.parentEl = parentEl;
		this.root = root;
		headers=new HashSet<String>();		
		headers.addAll(Arrays.asList("h1", "h2", "h3", "h4", "h5", "h6")); 
	}

	Set<String> headers; 
	public void make() {
		visit(root, parentEl); 	
	}
	public void visit(Element el, Element container) {
		String tag = el.getTagName()==null?"":el.getTagName().toLowerCase(); 
		if(headers.contains(tag)) {
			setId(el);
			container = insertTocEntry(el, container, tag);
		}
		else {
			//nothing
		}
		
		
		NodeList<Node> childs = el.getChildNodes();
		for (int i = 0; i < childs.getLength(); i++) {
			Node childNode = childs.getItem(i);
			if(childNode.getNodeType()==Node.ELEMENT_NODE) {				
				visit((Element) childNode, container);
			}
		}	
		
			
	}
	private Element insertTocEntry(Element el, Element container, String tag) {

		AnchorElement anchor = Document.get().createAnchorElement();
		anchor.setInnerHTML(el.getInnerHTML()); 
		anchor.setHref("#"+el.getId()); 
		
		//the container is always a ol, so we must insert an li
		LIElement li = Document.get().createLIElement();
		
		int i = Integer.parseInt(tag.substring(1, tag.length())); 		
		String margin = (i*20)+"px"; 
		li.getStyle().setProperty("marginLeft", margin); 
		
		container.appendChild(li); 
		
		li.appendChild(anchor); 
		
		container.appendChild(li); 
		
		return container;
	}

	static int  idcounter=0;
	protected void setId(Element el) {
		if(el.getId()==null||el.getId().equals("")) {
			el.setId("toc_"+idcounter); 
			idcounter++;
		}			
	}

}
