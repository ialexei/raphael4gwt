package org.sgx.raphael4gwt.test;

import java.util.HashMap;
import java.util.Map;

import org.sgx.raphael4gwt.raphael.Circle;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.base.Glow;
import org.sgx.raphael4gwt.raphael.event.DDListener;
import org.sgx.raphael4gwt.raphael.event.HoverListener;
import org.sgx.raphael4gwt.raphael.util.Util;

import com.google.gwt.dom.client.NativeEvent;

public class DragAndSnap extends Test{

	private int paperAbsX;
	private int paperAbsY;

	public DragAndSnap(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="Drag and snap to grid";
		this.description="this example shows dragging of elements snaping to a 50px grid.";
	}

	@Override
	public void test() {
		int circleCount=10;
		final int gridSize=70;
		final int tolerance=26;
		
		for (int i = 0; i < circleCount; i++) {
			final Circle c = paper.circle(Util.randomBetween(0, paperWidth), 
					Util.randomBetween(0, paperHeight), Util.randomBetween(10, 80));
			final Glow glow = new Glow();
			glow.setWidth(Util.randomBetween(5, 60));
			glow.setColor(randomColor());
			
			//paper absolute coords in the document are needed for draggind the element.
			paperAbsX = paper.getCanvasElement().getAbsoluteLeft();
			paperAbsY = paper.getCanvasElement().getAbsoluteTop();
			
			//make the circle draggable:			
			c.drag(new DDListener() {	
				@Override
				public void onStart(int x, int y, NativeEvent e) {					
				}				
				@Override
				public void onMove(int dx, int dy, int x, int y, NativeEvent e) {
					int absx=x-paperAbsX, absy=y-paperAbsY;
					absx = Raphael.snapTo(gridSize, absx, tolerance);
					absy = Raphael.snapTo(gridSize, absy, tolerance);
					c.setAttribute("cx", absx);
					c.setAttribute("cy", absy);
				}
				@Override
				public void onEnd(NativeEvent e) {
				}
			});
			c.setAttribute("fill", randomColor());
		}
		
		//draw a simple grid:
		for(int i = 0; i<paperWidth; i+=gridSize) {
			paper.rect(i, 0, 1, paperHeight);
		}
		for(int i = 0; i<paperHeight; i+=gridSize) {
			paper.rect(0, i, paperWidth, 1);
		}
		
		paper.text(200, 100, "these circles are draggable but in a grid of size "+gridSize+"px");
	}

	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.CircleGlowingAndDraggin().getText();
	}

}
