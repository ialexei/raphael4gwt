package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.base.Point;
import org.sgx.raphael4gwt.raphael.event.DDListener;
import org.sgx.raphael4gwt.raphael.event.HoverListener;
import org.sgx.raphael4gwt.raphael.event.MouseEventListener;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

public class AllMouseEvents extends Test {

	private TextArea ta;

	@Override
	public void test() {
		paper.circle(100,80, 40).attr("fill", "red").
				click(new MouseEventListener() {
			@Override
			public void notifyMouseEvent(NativeEvent e) {
				log("click", e);
			}
		});
		paper.text(100,80, "click me");
		
		paper.circle(200,80, 40).attr("fill", "green").
			dblclick(new MouseEventListener() {			
			@Override
			public void notifyMouseEvent(NativeEvent e) {
				log("double click: ", e);
			}
		});
		paper.text(200,80, "double click me");
		
		paper.circle(300,80, 40).attr("fill", "orange").
			drag(new DDListener() {
				
			@Override
			public void onStart(int x, int y, NativeEvent e) {
				log("drag start", e);
			}
			
			@Override
			public void onMove(int dx, int dy, int x, int y, NativeEvent e) {
				log("drag", e);
			}
			
			@Override
			public void onEnd(NativeEvent e) {
				log("drag end", e);
			}
		});
		paper.text(300,80, "drag me");
	
		
		paper.circle(100,180, 40).attr("fill", "violet").hover(new HoverListener() {			
			@Override
			public void hoverOut(NativeEvent e) {
				log("hover out", e);
			}			
			@Override
			public void hoverIn(NativeEvent e) {
				log("hover in", e);
			}
		});
		paper.text(100,180, "hover over me");
		
		paper.circle(200,180, 40).attr("fill", "yellow").
			mouseMove(new MouseEventListener() {			
			@Override
			public void notifyMouseEvent(NativeEvent e) {
				log("mouse move", e);
			}
		});
		paper.text(200,180, "mouse move");
		
		paper.circle(300,180, 40).attr("fill", "yellow").
			mouseDown(new MouseEventListener() {			
			@Override
			public void notifyMouseEvent(NativeEvent e) {
				log("mouse down", e);
			}
		});
		paper.text(300,180, "mouse down");
	
		
		//create a text area gwt ui widget for loggin events
		VerticalPanel testPanel = GalleryUtil.getInstance().getTestPanel();
		ta = new TextArea();
		ta.setSize("100%", "60px");
		ta.getElement().setId("seba123");
		testPanel.add(ta);
		
		Window.alert(paper.getWidth()+" - "+paper.getHeight());
	}

	protected void log(String msg, NativeEvent e) {
		Point c = Raphael.getCoordsInPaper(paper, e);
		ta.setText(msg+".\nCoords : "+c.getX()+" - "+c.getY());
	}

	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.AllMouseEvents().getText();
	}

	public AllMouseEvents(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="all mouse events";
		this.description="Show all mouse events tests";
		
	}
}
