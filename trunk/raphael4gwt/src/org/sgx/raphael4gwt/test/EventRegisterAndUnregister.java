package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Rect;
import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.Text;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Glow;
import org.sgx.raphael4gwt.raphael.event.HoverListener;
import org.sgx.raphael4gwt.raphael.event.MouseEventListener;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.user.client.Window;

public class EventRegisterAndUnregister extends Test{

	private MouseEventListener clickListener1;
	private Rect simpleRect;
	private Rect roundedCornerRect1;
	protected Set roundedCornerRect1Glow;
	protected boolean roundedCornerRect1DoGlow;
	private HoverListener roundedCornerRect1HoverListener;

	
	@Override
	public void test() {
		simpleRect = paper.rect(30, 3, 60, 120);
		simpleRect.setAttribute("fill", "blue");
		clickListener1 = new MouseEventListener() {			
			@Override
			public void notifyMouseEvent(NativeEvent e) {
				Window.alert("clicked and now unregistering click listener");
				simpleRect.unclick(clickListener1);
			}
		};
		simpleRect.click(clickListener1);
		
		roundedCornerRect1DoGlow=true;
		roundedCornerRect1 = paper.rect(230, 162, 160, 60, 20);
		roundedCornerRect1.attr(Attrs.create().fill("red").stroke("brown"));
		roundedCornerRect1HoverListener = new HoverListener() {			
			@Override
			public void hoverOut(NativeEvent e) {
				if(roundedCornerRect1Glow!=null)
					roundedCornerRect1Glow.remove();
			}			
			@Override
			public void hoverIn(NativeEvent e) {
				if(roundedCornerRect1DoGlow)
					roundedCornerRect1Glow = roundedCornerRect1.glow(new Glow(40));
			}
		};
		roundedCornerRect1.hover(roundedCornerRect1HoverListener);
		roundedCornerRect1.click(new MouseEventListener() {			
			@Override
			public void notifyMouseEvent(NativeEvent e) {
				Window.alert("now it won't glow anymore");
				roundedCornerRect1Glow.remove();
				roundedCornerRect1.unhover(roundedCornerRect1HoverListener);
			}
		});
		
		Text text1 = paper.text(300, 120, "blue rect can be clicked only once\nred rect glow on hovering, \nbut if clicked it won't glow any more.");
		text1.attr(Attrs.create().fill("black").fontSize(16));
	}
	

	//test information:
	public EventRegisterAndUnregister(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="Event unregistering";
		this.description="Example that shows how events can be unregistered.";
	}
	
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.EventRegisterAndUnregister().getText();
	}
		
}
