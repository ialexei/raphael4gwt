package org.sgx.espinillo.client.impl1.tools;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.sgx.espinillo.client.impl1.util.ShapeUtil;
import org.sgx.espinillo.client.impl1.util.ToolUtil;
import org.sgx.espinillo.client.model.Document;
import org.sgx.espinillo.client.model.tool.AbstractTool;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.Rect;
import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Point;
import org.sgx.raphael4gwt.raphael.event.DDListener;
import org.sgx.raphael4gwt.raphael.event.ForEachCallback;
import org.sgx.raphael4gwt.raphael.event.MouseEventListener;

import com.google.gwt.dom.client.NativeEvent;

/**
 * supports both clicking and maquee like selection tool (drag rectangle)
 * @author sg
 *
 */
public class SelectionTool extends AbstractTool {
	static Logger logger = Logger.getLogger("SelectionTool");
	private Rect mask;
//	private Document doc;
	private Paper paper;
	protected Point startCoords;
	protected Shape feedback;
	private Attrs initFeedbackAttrs;	
//	private DDListener ddListener;
	private MouseEventListener clickHandler;
	
	public SelectionTool(Document doc){
		super(doc, Toolbar1.TOOL_SELECTION, Toolbar1.TOOL_SELECTION_LABEL);
	}	
	
	public Attrs getInitFeedbackAttrs() {
		if(initFeedbackAttrs==null) {
			initFeedbackAttrs=Attrs.create().fill("yellow").strokeDashArray(".-");
		}
		return initFeedbackAttrs;
	}

	public void setFeedbackAttrs(Attrs initAttrs) {
		this.initFeedbackAttrs = initAttrs;
	}
	
	@Override
	public void install() {
		super.install();
		
		paper = getDocument().getPaper();
		mask = ToolUtil.getInstance().showPaperMask(getDocument());
		
//		ddListener = new DDListener() {
//			
//			@Override
//			public void onStart(int x, int y, NativeEvent e) {	
//				startCoords = Raphael.getCoordsInPaper(paper, e);
//				feedback = paper.rect(startCoords.getX(), startCoords.getY(), 10, 10).attr(getInitFeedbackAttrs());
//			}
//			
//			@Override
//			public void onMove(int dx, int dy, int x, int y, NativeEvent e) {
//				if(feedback!=null) {
//					Point coords = Raphael.getCoordsInPaper(paper, e);
//					Point d = ToolUtil.absDiff(coords, startCoords);
//					feedback.setAttribute("width", d.getX());
//					feedback.setAttribute("height", d.getY());
//					 
//				}
//			}
//			
//			@Override
//			public void onEnd(NativeEvent e) {
//				ToolUtil.getInstance().hidePaperMask(getDocument());				
//				feedback.remove();
//			}
//		};		
//		mask.drag(ddListener, ToolUtil.DEFAULT_DRAG_THROTTLE);

		
//		ToolUtil.getInstance().hidePaperMask(getDocument());
//		mask.unclick(clickHandler);
		
		clickHandler = new MouseEventListener() {			
			@Override
			public void notifyMouseEvent(NativeEvent e) {				
				
				Point coords = Raphael.getCoordsInPaper(paper, e);				
				Set els = ToolUtil.getShapesUnderPoint(paper, coords);
				
				els = filterOnlyShapes(els);
				
				getDocument().setSelection(els);
			}
		};
		mask.click(clickHandler);
	}
	
	protected Set filterOnlyShapes(Set els) {
		if(els==null)return null;
		if(mask!=null)
			els.exclude(mask); //els are the elements under the click
		els.filter(new ForEachCallback() {			
			@Override
			public boolean call(Shape shape, int index) {
				boolean result = !ShapeUtil.isShape(shape);
				logger.log(Level.INFO, "AAAA: "+result);
				return result;
			}
		});
		return els;
	}

	/**
	 * return the union and rest the interception of both sets
	 * @param curSel
	 * @param els
	 * @return
	 */
	protected Set getSelDiff(Set s1, Set s2) {
		return s1.add(s2).substract(s1.intersect(s2));
	}

	public static Point getPaperPosition(Paper p) {		
		return Raphael.createPoint(p.getCanvasElement().getOffsetLeft()+p.getCanvasElement().getParentElement().getAbsoluteLeft(), 
			p.getCanvasElement().getOffsetTop()+p.getCanvasElement().getParentElement().getAbsoluteTop());
		
	}
	
	@Override
	public void uninstall() {
		super.uninstall();		
		ToolUtil.getInstance().hidePaperMask(getDocument());
		try {
			if(mask!=null)
				mask.undrag();
			if(clickHandler!=null)
				mask.unclick(clickHandler);
			feedback.remove();
		} catch (Exception e) {
			
		}
	}
	
}
