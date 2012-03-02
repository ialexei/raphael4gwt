package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Ellipse;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Point;
import org.sgx.raphael4gwt.raphael.event.MouseEventListener;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.user.client.Window;

public class MouseRelativeCoordsTest extends Test {
	

@Override
public void test() {
	paper.text(200, 100, "click ellipse to see some coords related to different things");
	
	final Ellipse ellipse1 = paper.ellipse(130,200, 120, 80);
	ellipse1.attr(Attrs.create().fill("red"));
	ellipse1.translate(100,100);
	ellipse1.click(new MouseEventListener() {			
		@Override
		public void notifyMouseEvent(NativeEvent e) {
			Point p1 = Raphael.getCoordsInPaper(paper, e);
			Point p2 = Raphael.getCoordsInShape(paper, ellipse1, e);
			Point p3 = Raphael.getCoordsInShape(paper, ellipse1, true, e);
			Window.alert("COORDS\n" +
				"Relative to browser's window: "+e.getClientX()+", "+e.getClientY()+"\n" +
				"Relative to paper: "+p1.print()+
				"Relative to clicked shape without transform: "+p2.print()+"\n"+
				"Relative to clicked shape with transform: "+p3.print()
			);
		}
	});
}


//test information:

public MouseRelativeCoordsTest(Paper paper, int paperWidth, int paperHeight) {
	super(paper, paperWidth, paperHeight);
	this.name="relative coords";
	this.description="test showing how to obtain mouse event coordinates relative to html document, paper or shape";
	
}
@Override
public String getJavaClassSource() {
	return TestResources.INSTANCE.MouseRelativeCoordsTest().getText();
}

}
