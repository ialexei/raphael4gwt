package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Image;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Path;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.event.HoverListener;
import org.sgx.raphael4gwt.raphael.event.MouseEventListener;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;
import org.sgx.raphael4gwt.test.gallery.IconPaths;
import org.sgx.raphael4gwt.test.gallery.GalleryResources;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
/**
 * @author sg
 *
 */
public class MouseCoordsOnHoverTest extends Test {
	
	private Shape rect;
	private Label mouseCoordsLabel;
	
	@Override
	public void test() {
		rect = paper.rect(0,0,paper.getWidth(), paper.getHeight()).attr(
			Attrs.create().fill("yellow")
		);
		rect.mouseMove(new MouseEventListener() {			
			@Override
			public void notifyMouseEvent(NativeEvent e) {
				mouseCoordsLabel.setText("inPaper: "+
						Raphael.getCoordsInPaper(paper, e).print());
			}
		}, 500); //throttle mousemove handler
		VerticalPanel testPanel = GalleryUtil.getInstance().getTestPanel();
		testPanel.add(new Label("mouse coords: "));
		
		mouseCoordsLabel=new Label("");
		testPanel.add(mouseCoordsLabel);
	}
	
	//test information:
	public String[] getTags() {
		return new String[]{GalleryUtil.TAG_EVENT};
	}
	public MouseCoordsOnHoverTest(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="mouse coords";
		this.description="shows mouse coords on mouse hover and show how to 'throttle' your intensive mouse events type like mousemove. ";		
	}		
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.MouseCoordsOnHoverTest().getText();
	}

}
