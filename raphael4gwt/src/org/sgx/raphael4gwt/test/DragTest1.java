package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Circle;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.base.Glow;
import org.sgx.raphael4gwt.raphael.base.Point;
import org.sgx.raphael4gwt.raphael.event.DDListener;
import org.sgx.raphael4gwt.raphael.util.Util;

import com.google.gwt.dom.client.NativeEvent;

public class DragTest1 extends Test{

	@Override
	public void test() {
		final Circle c = paper.circle(200,200,100); 
		c.setAttribute("fill", "red");
				
		/* make the circle draggable : register a drag and 
		 * drop listener on the figure */
		c.drag(new DDListener() {	
			@Override
			public void onStart(int x, int y, NativeEvent e) {}				
			@Override
			public void onMove(int dx, int dy, int x, int y, NativeEvent e) {
				/* we want to move the circle so its center is just where the mouse 
				 * pointer is. so we use Raphael.getCoordsInPaper for getting the 
				 * mouse event coords in the paper. */
				Point coords = Raphael.getCoordsInPaper(paper, e);
				c.setAttribute("cx", coords.getX());
				c.setAttribute("cy", coords.getY());
			}
			@Override
			public void onEnd(NativeEvent e) {}
		});
		paper.text(200, 100, "simple drag test");
	}

	//test information:
	
	public DragTest1(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="drag&drop";
		this.description="simple drag and drop example - how to drag a raphael figure.";
	}
	
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.DragTest1().getText();
	}

}
