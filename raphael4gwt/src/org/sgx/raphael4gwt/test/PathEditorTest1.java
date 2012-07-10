package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.PathCmd;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Arrow;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Point;
import org.sgx.raphael4gwt.raphael.event.MouseEventListener;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.user.client.Window;

public class PathEditorTest1 extends Test {

	protected PathCmd initCmd;
	protected PathCmd currentCmd;
	private Shape feedback;

	@Override
	public void test() {	
		
//		doOptsPanel();
		Arrow arrow1 = new Arrow();
		arrow1.setType(Arrow.TYPE_BLOCK);
		arrow1.setLength(Arrow.LENGTH_LONG);
		arrow1.setWidth(Arrow.WIDTH_NARROW);
		Window.alert(arrow1.toString());
		Shape mask = paper.rect(0,0,1000,1000).
			attr(Attrs.create().fill("#ffffff").arrowEnd(arrow1));
		initCmd = null; 
		currentCmd=null;
		feedback = paper.path("M0,0").attr(Attrs.create().
				fill("#ffffff").arrowEnd(arrow1).strokeWidth(5).
				strokeDashArray(Raphael.STROKE_DASHARRAY_DASH_DASH_POINT_POINT)); 
		MouseEventListener clickHandler = new MouseEventListener() {			
			private boolean firstClick=true;

			@Override
			public void notifyMouseEvent(NativeEvent e) {
				Point coords = Raphael.getCoordsInPaper(paper, e);		
				if(firstClick) {
					initCmd = new PathCmd(coords);
					currentCmd=initCmd;
					firstClick=false;
				}
				else {
					currentCmd=currentCmd.smoothQuadBezierCurveTo(coords);
				}
				updateFeedback();
			}
		};
		MouseEventListener dblclickHandler = new MouseEventListener() {			
			@Override
			public void notifyMouseEvent(NativeEvent e) {
				currentCmd=currentCmd.close();
				updateFeedback();
			}
		};
		mask.click(clickHandler);
		mask.dblclick(dblclickHandler);
	}
	
	
	protected void updateFeedback() {
		feedback.attr("path", feedback.getAttribute("path")+
				currentCmd.toPathString());
	}


	//test stuff

	@Override
	public String[] getTags() {
		return new String[]{GalleryUtil.TAG_PATH, GalleryUtil.TAG_EVENT};
	}
	public PathEditorTest1(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="path tool 1";
		this.description="a test app that try to bring a path editing tool";		
	}

	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.PathEditorTest1().getText();
	}

}
