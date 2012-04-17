package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Gradient;
import org.sgx.raphael4gwt.raphael.base.Stop;
import org.sgx.raphael4gwt.raphael.event.ForEachCallback;
import org.sgx.raphael4gwt.test.image.IconPaths;

import com.google.gwt.user.client.Window;

public class GradientTest1 extends Test {
	
@Override
public void test() {
	Shape rect1 = paper.rect(100,100,100,100, 20), 
		path1 = paper.path(IconPaths.apple), 
		ellipse1 = paper.ellipse(200,200,100,70),
		ellipse2 = paper.ellipse(100,300,100,70);
	
	//fill the rect with a simple linear gradient
	Gradient linearGradient1 = Gradient.linear(0.5, "#ff0000", "#ffff00");
	rect1.attr(Attrs.create().fill(linearGradient1));
	
	/* now a more complicated linear gradient : "0° gradient from white via red 
	 * (at 20%) to black. ". in raphaeljs it is represented with the string. "0-#fff-#f00:20-#000"
	 * We can unse that string here, but I will show you how to do it using Gradient class:
	 */
	Gradient linearGradient2 = Gradient.linear(0, "#fff", new Stop[]{new Stop("#f00", 20)}, "#000");
	path1.attr(Attrs.create().fill(linearGradient2));
	
	Gradient radialGradient1 = Gradient.radial(0.5, 0.3, "#fff", new Stop[]{new Stop("#f00", 20)}, "#000");
	ellipse1.attr(Attrs.create().fill(radialGradient1));
	
	//note that we also can pass the gradient raphael string directly: 
	ellipse2.attr(Attrs.create().fill("r(0.25, 0.75)#fff-#000"));
	
	//test paper foreach()
	final StringBuffer sb = new StringBuffer("shapes in paper: \n"); 
	paper.forEach(new ForEachCallback() {
		
		@Override
		public boolean call(Shape shape, int index) {
			sb.append(shape.getType()+", ");
			return true;
		}
	});
	Window.alert(sb.toString());
	
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
