package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Ellipse;
import org.sgx.raphael4gwt.raphael.Image;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Path;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Point;
import org.sgx.raphael4gwt.raphael.event.DDListener;
import org.sgx.raphael4gwt.raphael.event.HoverListener;
import org.sgx.raphael4gwt.raphael.event.MouseEventListener;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;
import org.sgx.raphael4gwt.test.image.IconPaths;
import org.sgx.raphael4gwt.test.image.TestImageResources;

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
public class DrawAndClick extends Test {
	
	private Shape rect;
	private Label mouseCoordsLabel;
	protected Ellipse ellipse;
	private Shape mask;
	
	@Override
	public void test() {
		rect = paper.rect(0,0,paper.getWidth(), paper.getHeight()).attr(
			Attrs.create().fill("yellow")
		);
		paper.text(100,100, "Now, first draw an ellipse draggind \n" +
				"and then try to click it so we can test \n" +
				"paper.getElementByPoint()");
		rect.mouseMove(new MouseEventListener() {			
			@Override
			public void notifyMouseEvent(NativeEvent e) {
				mouseCoordsLabel.setText("inPaper: "+
						Raphael.getCoordsInPaper(paper, e).print());
			}
		});
		VerticalPanel testPanel = GalleryUtil.getInstance().getTestPanel();
		testPanel.add(new Label("mouse coords: "));
		
		installDragEllipse();
		
		
		/* second usecase step : select the shape by clicking it. 
		 * what we do is: 1) create a "mask" rect for */
		
		mouseCoordsLabel=new Label("");
		testPanel.add(mouseCoordsLabel);
	}

	/** first usecase step - draw an ellipse using drag and drop:*/
	private void installDragEllipse() {
		rect.drag(new DDListener() {			
			@Override
			public void onStart(int x, int y, NativeEvent e) {
				Point coords = Raphael.getCoordsInPaper(paper, e);
				ellipse = paper.ellipse(coords.getX(), coords.getY(), 0,0);
			}
			
			@Override
			public void onMove(int dx, int dy, int x, int y, NativeEvent e) {
				ellipse.attr(Attrs.create().rx(dx).ry(dy));
			}
			
			@Override
			public void onEnd(NativeEvent e) {
				installSelectionTool();
			}
		}, 400); //throttle D&D!;
	}
	/* second usecase step - select a shape by clicking. 
	 * what we do is to install a rect mask for receive the click
	 * and then ask shapes below the coords
	 */
	protected void installSelectionTool() {
		mask = paper.rect(0,0,paper.getWidth(), paper.getHeight()).attr(
			Attrs.create().fill("blue").opacity(0.2)
		);
		mask.click(new MouseEventListener() {			
			@Override
			public void notifyMouseEvent(NativeEvent e) {	
				Set els = paper.getElementsByPoint(Raphael.getCoordsInPaper(paper, e));
				Window.alert("selected elements: "+els.print());
			}
		});
	}

	//test information:
	public DrawAndClick(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="draw&select";
		this.description="basic editing usecase: draw a shape dragging and then select it clicking it. test of function paper.getElementByPoint";		
	}		
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.DrawAndClick().getText();
	}

}
