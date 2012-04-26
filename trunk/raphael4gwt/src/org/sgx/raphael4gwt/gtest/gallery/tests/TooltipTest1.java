package org.sgx.raphael4gwt.gtest.gallery.tests;

import org.sgx.raphael4gwt.graphael.GPaper;
import org.sgx.raphael4gwt.graphael.GShape;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.gtest.gallery.Test;
/**
 * simple barchart example
 * @author sg
 *
 */
public class TooltipTest1 extends Test {	
	
 
	@Override
	public void test() {
		
	/* in this test we use the auxiliar shapes defined by graphael lik tag, label, flag, popup, etc.
	 * Notice that web both create them using GPaper and also
	 * casting common raphael shaps like circles and rects to GShape and calling 
	 * the auxiliar methods using GShape class:
	 * 
	 * r.drop(400, 150, "$10", 60);
  	 * 
  	 * vs
  	 * 
  	 * ((GShape)r.rect(450, 150, 15, 15).attr(Attrs.create().fill("90-#fff-#000"))).drop();      
	 */
	GPaper r = getGPaper();
		
	  r.tag(50, 150, "$9.99", 130);
	  r.tag(100, 150, "$9.99", 310);
	  r.label(150, 150, "$9.99");
	  r.flag(200, 150, "$9.99", 60);
	  r.flag(250, 150, "$9.99", 240);
	  r.popup(300, 150, "$9.99", "down", 20);
	  r.popup(350, 150, "$9.99", "right");
	  r.drop(400, 150, "$10", 60);
	  ((GShape)r.rect(250, 350, 15, 15).attr(Attrs.create().fill("90-#fff-#000"))).drop();
	  r.blob(50, 350, "$9.99", 60);
	  r.blob(150, 350, "$9.99", 270);
	  ((GShape)r.circle(350, 250, 10).attr(Attrs.create().fill("#ff0000"))).label();
	  ((GShape)r.circle(450, 250, 10).attr(Attrs.create().fill("#ff0000"))).popup();
	  ((GShape)r.circle(500, 250, 10).attr(Attrs.create().fill("#ff0000"))).popup("down");
	  ((GShape)r.circle(140, 350, 10).attr(Attrs.create().fill("#ff0000"))).tag(130);
	  ((GShape)r.circle(240, 330, 10).attr(Attrs.create().fill("#ff0000"))).tag();
	  ((GShape)r.circle(300, 350, 10).attr(Attrs.create().fill("#ff0000"))).blob();
	  ((GShape)r.circle(400, 450, 10).attr(Attrs.create().fill("#ff0000"))).blob(270, 440);
		
	}

	//test class stuff
	public TooltipTest1(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		setName("tooltips1");
		setDescription("show all tooltip shapes built in with graphael");
	}
	GPaper getGPaper() {
		return (GPaper)paper;
	}
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.TooltipTest1().getText();
	}

}
