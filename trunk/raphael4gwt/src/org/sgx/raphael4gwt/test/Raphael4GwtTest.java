package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Circle;
import org.sgx.raphael4gwt.raphael.Constants;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.Text;
import org.sgx.raphael4gwt.raphael.base.Animation;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Glow;
import org.sgx.raphael4gwt.raphael.event.Callback;
import org.sgx.raphael4gwt.raphael.event.DDListener;
import org.sgx.raphael4gwt.raphael.event.MouseEventListener;
import org.sgx.raphael4gwt.raphael.jsutil.JsUtil;
import org.sgx.raphael4gwt.raphael.util.Util;
import org.sgx.raphael4gwt.test.gallery.MainPanel;
import org.sgx.raphael4gwt.test.image.TestImageResources;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Raphael4GwtTest implements EntryPoint {

	String attr1 = "world";
	
	@Override
	public void onModuleLoad() {
//		test1();
//		testPutPaperInPanel();
//		testDD1();
//		testTest();
		testMainPanel();
//		testAnim1();
//		testImageBundle();
	}
	
	private void testImageBundle() {
System.out.println(TestImageResources.INSTANCE.smallLion().getSafeUri().asString());
System.out.println(TestImageResources.INSTANCE.edit16().getSafeUri().asString());
System.out.println(TestImageResources.INSTANCE.preferences().getSafeUri().asString());
		Image img = new Image(TestImageResources.INSTANCE.smallLion());
		RootPanel.get().add(img);
	}

	private void testMainPanel() {
		RootPanel.get().add(new MainPanel());
	}

	private void testTest() {
		VerticalPanel vp = new VerticalPanel();
		RootPanel.get().add(vp);
		int pwidth = 500, pheight=500;
		Paper paper = Raphael.paper(20, 20, pwidth, pheight);
//		new CircleGlowingAndDraggin(paper, pwidth, pheight).test();
		new EventRegisterAndUnregister(paper, pwidth, pheight).test();
	}

	private void testAnim1() {
		VerticalPanel vp = new VerticalPanel();
		RootPanel.get().add(vp);
		
		Paper paper = Raphael.paper(20, 20, 500, 500);
		Circle circle1 = paper.circle(250,250, 60);
		circle1.setAttribute("cx", 30+"");
		
		Animation anim1 = Raphael.animation(JsUtil.obj("cx", 400), 5000, 
				Raphael.EASING_BOUNCE, new Callback() {			
			@Override
			public void call() {
				Window.alert("anim finished");
			}
		});
		circle1.animate(anim1);
	}


	private void testDD1() {
		VerticalPanel vp = new VerticalPanel();
		RootPanel.get().add(vp);
		final TextArea ta = new TextArea();
		vp.add(ta);
		
		SimplePanel paperPanel = new SimplePanel();
		paperPanel.setWidth("100%");
		paperPanel.setHeight("100%");
		vp.add(paperPanel);
		
		Paper paper = Raphael.paper(paperPanel.getElement(), 500, 500);
		Circle circle1 = paper.circle(250,250, 100);
		circle1.setAttribute("fill", "red");
		
		circle1.drag(new DDListener() {			
			@Override
			public void onStart(int x, int y, NativeEvent e) {
				ta.setText("DD onStart: "+x+", "+y);
			}			
			@Override
			public void onMove(int dx, int dy, int x, int y, NativeEvent e) {
				ta.setText("DD onMove: "+dx+", "+dy+", "+x+", "+y);
			}			
			@Override
			public void onEnd(NativeEvent e) {
				ta.setText("DD onEnd: "+e.getButton());
			}
		});
	}

	private void test1() {
		VerticalPanel vp = new VerticalPanel();
		RootPanel.get().add(vp);
		
		Paper paper = Raphael.paper(20, 20, 500, 500);
		Circle circle1 = paper.circle(250,250, 60);
		circle1.setAttribute("fill", "red");
		circle1.mouseDown(new MouseEventListener() {
			String s1 = "hello";
			@Override
			public void notifyMouseEvent(NativeEvent e) {
				Window.alert(s1+" "+attr1+" mouse clicked the circle at: "+e.getClientX()+", "+e.getClientY());
				
			}
		});
//		Glow glow1 = new Glow(30);
		Set glow1Set = circle1.glow( new Glow(30));
		glow1Set.scale(2.2, 1.43);
		final Circle circle2 = paper.circle(20, 300, 30);
		circle2.attr( Attrs.create().fill("blue") );
		circle2.drag(new DDListener() {			
			@Override
			public void onStart(int x, int y, NativeEvent e) {
				
			}			
			@Override
			public void onMove(int dx, int dy, int x, int y, NativeEvent e) {
				circle2.setAttribute("cx", x+"");
				circle2.setAttribute("cy", y+"");
			}			
			@Override
			public void onEnd(NativeEvent e) {
			}
		});
		Text text1 = paper.text(120, 30, "in this example\n you should see \n2 circles red and blue\nred has a click handler\nand blue draggable");
		
		text1.attr(Attrs.create().fill("black").fontSize(16));
	}

	private void testPutPaperInPanel() {
		VerticalPanel vp = new VerticalPanel();
		RootPanel.get().add(vp);
		
		SimplePanel paperPanel = new SimplePanel();
		paperPanel.setWidth("100%");
		paperPanel.setHeight("100%");
//		paperPanel.getElement().setId("paperPanel");
		vp.add(paperPanel);
		
		Paper paper = Raphael.paper(paperPanel.getElement(), 500, 500);
		Circle circle1 = paper.circle(250,250, 100);
		circle1.setAttribute("fill", "red");
	}

}
