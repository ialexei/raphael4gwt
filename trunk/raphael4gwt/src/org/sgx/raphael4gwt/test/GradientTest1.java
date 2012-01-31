package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Rect;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Gradient;
import org.sgx.raphael4gwt.raphael.base.Stop;
import org.sgx.raphael4gwt.test.image.IconPaths;

import com.google.gwt.user.client.Window;

public class GradientTest1 extends Test {
	
@Override
public void test() {
	Shape rect1 = paper.rect(100,100,100,100, 20), 
		path1 = paper.path(IconPaths.apple);
	
	//fill the rect with a simple linear gradient
	Gradient linearGradient1 = Gradient.linear(0.5, "#ff0000", "#ffff00");
	rect1.attr(Attrs.create().fill(linearGradient1));
	
	/* now a more complicated linear gradient : "0° gradient from white via red 
	 * (at 20%) to black. ". in raphaeljs it is represented with the string. "0-#fff-#f00:20-#000"
	 * We can unse that string here, but I will show you how to do it using Gradient class:
	 */
	Gradient linearGradient2 = Gradient.linear(0, "#fff", new Stop[]{new Stop("#f00", 20)}, "#000");
	path1.attr(Attrs.create().fill(linearGradient2));
	
	
}	

//the following is only information about the test case:

public GradientTest1(Paper paper, int paperWidth, int paperHeight) {
	super(paper, paperWidth, paperHeight);
	this.name="gradients";
	this.description="show some shapes filled with different gradient types";
	
}

@Override
public String getJavaClassSource() {
	return TestResources.INSTANCE.GradientTest1().getText();
}

}
