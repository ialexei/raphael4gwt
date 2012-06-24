package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Attr;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.Rect;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;

import com.google.gwt.core.client.JsonUtils;
/**
 * setting attributes showcase
 * @author sg
 *
 */
public class AttributesTest1 extends Test {

	@Override
	public void test() {
		Rect r1 = paper.rect(10,10,200,100,20); 
		
		//0 overhead - user Attrs.create().fill();
		r1.attr(Attrs.create().fill("red").stroke("blue"));
		
		//a la java - use the wrapper Attr: new Attr().create();
		r1.attr(new Attr().cursor("pointer").strokeWidth(10).
			strokeDashArray(Raphael.STROKE_DASHARRAY_DASH_DASH_POINT));
		
		//evaluate a valid json string: 
		r1.attr(JsonUtils.safeEval("{transform: 'r55'}").<Attrs>cast());
		
	}

	
	//test stuff
	@Override
	public String[] getTags() {
		return new String[]{};
	}
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.AttributesTest1().getText();
	}
	public AttributesTest1(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="attributes1";
		this.description="show different ways of setting attributes to a shape.";
		
	}
}
