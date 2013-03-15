package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.Text;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Rectangle;
import org.sgx.raphael4gwt.raphael.util.Util;
import org.sgx.raphael4gwt.raphael.widget.PaperWidget;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;

import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.MouseWheelEvent;
import com.google.gwt.event.dom.client.MouseWheelHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * demonstrate the paper view port using the arrow keys or mouse dragging 
 * for moving and the mouse wheel for zooming (or ctrl + ctrl-
 * 
 * notice how mouse wheel listener is registered in gwt, not using the dom but the java class...
 * @author sg
 *
 */
public class PaperViewBoxTest1 extends Test implements MouseWheelHandler {

	private Rectangle paperViewbox;
	private Text statusText;
	@Override
	public void test() {
		int paperWidth = paper.getWidth(); 
		int paperHeight = paper.getHeight();
		//some random complex drawing...
		for (int i = 0; i < 30; i++) {
			paper.ellipse(Util.randomBetween(0,paperWidth), Util.randomBetween(0,paperHeight), 
					Util.randomBetween(40,180), Util.randomBetween(40,180)).
					attr(Attrs.create().fill(Util.randomColor()).
					stroke(Util.randomColor()).
					strokeWidth(Util.randomBetween(3,13)));
		}
		paper.text(100, 200, "use arrows for moving, and \nctrl-arrows or mouse wheel to zoom.").
			attr(Attrs.create().fontSize(17));
		
		/* we can use a paper widget for registering an keybopard event listener in gwt.
		 * because it is a FocusPanel 
		 */
		PaperWidget paperWidget = getPaperWidget();
//		paperWidget.setFocus(true);
		
		TextBox keyEntry = new TextBox(); 

		VerticalPanel testPanel = GalleryUtil.getInstance().getMainPanel().getTestPanel();
		testPanel.add(new HTML(
				"<b>showing a big drawing using paper's viewbox attribute. </b>" +
				"Focus the next input box for key pressing, and then move with arrow keys and zoom with ctrl-up and ctrl-down. " +
				"this way you can zoom-in zoom-out and move like in a game complex game board. ")); 
		testPanel.add(keyEntry); 
		
		
		paperViewbox = Raphael.createRectangle(0, 0, paperWidth, paperHeight);
		paper.setViewBox(paperViewbox, true);
		
		paper.text(200,200,"current coords: ").attr(Attrs.create().fontSize(17));
		statusText = paper.text(200,250,"");
		statusText.attr(Attrs.create().text(paperViewbox.print()));
		
		keyEntry.addKeyPressHandler(new KeyPressHandler() {			
			@Override
			public void onKeyPress(KeyPressEvent event) {
				int keyCode = event.getNativeEvent().getKeyCode();
//				Window.alert("keypressed: "+keyCode+" - "+event.isControlKeyDown());
				//left
				if(keyCode==37) {
					if(event.isControlKeyDown()) {
						paperViewbox.setHeight(paperViewbox.getHeight()-10);
						paperViewbox.setWidth(paperViewbox.getWidth()-10);
					}
					else {
						paperViewbox.setX(paperViewbox.getX()-10);
					}
				}
				//up
				else if(keyCode==38) {
					if(event.isControlKeyDown()) {
						paperViewbox.setHeight(paperViewbox.getHeight()+10);
						paperViewbox.setWidth(paperViewbox.getWidth()+10);
					}
					else {
						paperViewbox.setY(paperViewbox.getY()-10);
					}
				}
				//right
				else if(keyCode==39) {
					if(event.isControlKeyDown()) {
						paperViewbox.setHeight(paperViewbox.getHeight()+10);
						paperViewbox.setWidth(paperViewbox.getWidth()+10);
					}
					else {
						paperViewbox.setX(paperViewbox.getX()+10);
					}
				}
				//down
				else if(keyCode==40) {
					if(event.isControlKeyDown()) {
						paperViewbox.setHeight(paperViewbox.getHeight()-10);
						paperViewbox.setWidth(paperViewbox.getWidth()-10);
					}
					else {
						paperViewbox.setY(paperViewbox.getY()+10);
					}
				}
				
				paper.setViewBox(paperViewbox, false);
				event.preventDefault();
			}
		});

		keyEntry.setFocus(true); 
	}


	@Override
	public void onMouseWheel(MouseWheelEvent event) {
		if(event.getDeltaY()<0) {
			paperViewbox.setHeight(paperViewbox.getHeight()-10);
			paperViewbox.setWidth(paperViewbox.getWidth()-10);
		}
		else if(event.getDeltaY()>0){
			paperViewbox.setHeight(paperViewbox.getHeight()+10);
			paperViewbox.setWidth(paperViewbox.getWidth()+10);
		}
	}
	
	
	//test stuff
	@Override
	public String[] getTags() {
		return new String[]{GalleryUtil.TAG_EVENT};
	}
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.PaperViewportTest1().getText();
	}
	public PaperViewBoxTest1(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="paper viewport";
		this.description="shows how to use paper viewport";
		
	}


}
