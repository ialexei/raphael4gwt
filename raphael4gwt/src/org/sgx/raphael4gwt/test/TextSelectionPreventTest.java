package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;
/**
 * show how to prevent user text selection of text on browsers like chrome. " +
 * It also shows how to use the shape:getNode() for in this case setting css to a 
 * shape as if it where an HTML element
 * 
 * @author sg
 *
 */
public class TextSelectionPreventTest extends Test {

	@Override
	public void test() {
		Attrs attr = Attrs.create().fontSize(32);
		paper.text(220,100, "You can select this text with the mouse").attr(attr);
		Shape text2 = paper.text(220,200, "You can't select this text with the mouse").attr(attr);
		
		String [] props = {"user-select", "-webkit-touch-callout", "-webkit-user-select"};
		for (int i = 0; i < props.length; i++) 
			text2.node().getStyle().setProperty(props[i], "none");
		

	}


	//test params
	public String[] getTags() {
		return new String[]{GalleryUtil.TAG_SHAPE, GalleryUtil.TAG_EVENT};
	}
	public TextSelectionPreventTest(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="text selection prevent";
		this.description="show how to prevent user text selection of text on browsers like chrome. " +
				"It also shows how to use the shape:getNode() for in this case setting css to a shape as if it where an HTML element";		
	}

	
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.TextSelectionPreventTest().getText();
	}

}
