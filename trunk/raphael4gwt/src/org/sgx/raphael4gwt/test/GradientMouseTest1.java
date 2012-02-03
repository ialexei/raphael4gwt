package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Ellipse;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.Text;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Gradient;
import org.sgx.raphael4gwt.raphael.base.Point;
import org.sgx.raphael4gwt.raphael.base.Rectangle;
import org.sgx.raphael4gwt.raphael.base.Stop;
import org.sgx.raphael4gwt.raphael.event.MouseEventListener;

import com.google.gwt.dom.client.NativeEvent;

public class GradientMouseTest1 extends Test {

	
	@Override
	public void test() {
		final Text text1 = paper.text(200, 100, "Move the mouse over the ellipse...");
		
		//an ellipse filled with gradient translated 100,100 : 
		
		final Ellipse ellipse1 = paper.ellipse(130,200, 120, 180);
		final Gradient radialGradient1 = Gradient.radial(
			0.5, 0.3, "#fff", new Stop[]{new Stop("#f00", 20), new Stop("#f00", 60)}, "#000");
		ellipse1.attr(Attrs.create().fill(radialGradient1));		
		ellipse1.translate(100,100);		
		
		ellipse1.mouseMove(new MouseEventListener() {			
			@Override
			public void notifyMouseEvent(NativeEvent e) {			
				Rectangle bb = ellipse1.getBBox(false);				
				Point p2 = Raphael.getCoordsInShape(paper, ellipse1, e);
				int xoffset = (bb.getWidth() - p2.getX())/2, 
					yoffset = (bb.getHeight() - p2.getY())/2;
				text1.setAttribute("text", "gradients offsets : "+xoffset+", "+yoffset);
				radialGradient1.getStops()[0].setOffset(xoffset);
				radialGradient1.getStops()[1].setOffset(yoffset);
				ellipse1.attr(Attrs.create().fill(radialGradient1));	
				
			}
		});
		
		
	}

	
	//test information:
	public GradientMouseTest1(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="gradient mouse";
		this.description="show gradient changes on mouse events";
		
	}		
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.GradientMouseTest1().getText();
	}

}
