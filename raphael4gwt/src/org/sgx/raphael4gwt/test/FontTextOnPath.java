package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Path;
import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Font;
import org.sgx.raphael4gwt.raphael.base.Point;

public class FontTextOnPath extends Test {

	@Override
	public void test() {
		
		/* make some text follow a path */
		Font anchorFont = paper.getFont("Anchor Steam NF");
		Set text1 = paper.print(120,330,"a text that follows a path", anchorFont, 40);
		
		//the path where we want to place the text
		Path p = paper.path(
			"M 50 100 C 100 50 150 0 200 50" +
		" C 250 100 300 150 350 100" +
		" C 400 50 450 50 450 50");
		p.attr(Attrs.create().stroke("none"));//hide the path
		
		/* for each letter, we add an absolute translation to its 
		 * transformation string and also add an absolute rotation 
		 * to correspond to path angle of derivative. */
		for(int i = 0; i<text1.size(); i++) {
			Shape letter = text1.item(i);
		    
			//get the point of a letter on the path
			Point newP = p.getPointAtLength(letter.getBBox().getX());
			
			String newTransformation = letter.getTransform()+	        		
				"T"+(newP.getX()-letter.getBBox().getX())+","+
				(newP.getY()-letter.getBBox().getY()-letter.getBBox().getHeight());
			
			//also rotate the letter to correspond the path angle of derivative
			newTransformation+="R"+
				(newP.getAlpha()<360 ? 180+newP.getAlpha() : newP.getAlpha());
			
			letter.setTransform(newTransformation);	        
		}		
	}

	//test stuff

	public FontTextOnPath(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="text on path";
		this.description="text on a path using cufon fonts";		
	}

	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.FontTest2().getText();
	}

}
