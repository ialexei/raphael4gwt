package org.sgx.raphael4gwt.test;

import java.util.HashMap;
import java.util.Map;

import org.sgx.raphael4gwt.raphael.Circle;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.base.Glow;
import org.sgx.raphael4gwt.raphael.event.DDListener;
import org.sgx.raphael4gwt.raphael.event.HoverListener;
import org.sgx.raphael4gwt.raphael.util.Util;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;

import com.google.gwt.dom.client.NativeEvent;

public class CircleGlowingAndDraggin extends Test{

	private int paperAbsX;
	private int paperAbsY;
	
	@Override
	public void test() {
		int circleCount=20;
		final Map<Circle, Set> glows = new HashMap<Circle, Set>();
		for (int i = 0; i < circleCount; i++) {
			final Circle c = paper.circle(Util.randomBetween(0, paperWidth), 
					Util.randomBetween(0, paperHeight), Util.randomBetween(10, 80));
			final Glow glow = new Glow();
			glow.setWidth(Util.randomBetween(5, 60));
			glow.setColor(randomColor());
			
			//paper absolute coords in the document are needed for draggind the element.
			paperAbsX = paper.getCanvasElement().getAbsoluteLeft();
			paperAbsY = paper.getCanvasElement().getAbsoluteTop();
			
			//on circle hovering we want to glow the circle:
			c.hover(new HoverListener() {				
				@Override
				public void hoverOut(NativeEvent e) {
					glows.get(c).remove();
				}				
				@Override
				public void hoverIn(NativeEvent e) {
					Set glowSet = c.glow(glow);
					glows.put(c, glowSet);
				}
			});
			
			//make the circle draggable:
			c.drag(new DDListener() {	
				@Override
				public void onStart(int x, int y, NativeEvent e) {					
				}				
				@Override
				public void onMove(int dx, int dy, int x, int y, NativeEvent e) {
					c.setAttribute("cx", x-paperAbsX);
					c.setAttribute("cy", y-paperAbsY);
				}
				@Override
				public void onEnd(NativeEvent e) {
				}
			});
			c.setAttribute("fill", randomColor());
		}
	}
	
	//test stuff
	public String[] getTags() {
		return new String[]{GalleryUtil.TAG_EVENT};
	}
	public CircleGlowingAndDraggin(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="Circles, Glowing and Dragging";
		this.description="an example that show Circles, Glowing and Mouse Dragging";
	}
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.CircleGlowingAndDraggin().getText();
	}

}
