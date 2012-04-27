package org.sgx.espinillo.client.impl1.tools;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.sgx.espinillo.client.impl1.util.SelectionUtil;
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
import org.sgx.raphael4gwt.raphael.base.Rectangle;
import org.sgx.raphael4gwt.raphael.event.DDListener;
import org.sgx.raphael4gwt.raphael.event.ForEachCallback;
import org.sgx.raphael4gwt.raphael.event.MouseEventListener;

import com.google.gwt.dom.client.NativeEvent;

/**
 * supports both clicking and maquee like selection tool (drag rectangle)
 * @author sg
 *
 */
public class PathTool extends AbstractTool {
	static Logger logger = Logger.getLogger("PathTool");
	private Rect mask;
//	private Document doc;
	private Paper paper;
	protected Point startCoords;
	protected Shape feedback;
	private Attrs initFeedbackAttrs;	
	private DDListener ddListener;
	private MouseEventListener clickHandler;
	
	public PathTool(Document doc){
		super(doc, Toolbar1.TOOL_SELECTION);
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
						
		clickHandler = new MouseEventListener() {			
			@Override
			public void notifyMouseEvent(NativeEvent e) {
				
				Point coords = Raphael.getCoordsInPaper(paper, e);				
				Set els = ToolUtil.getShapesUnderPoint(paper, coords);					
				els.exclude(mask); //els are the elements under the click
				
				getDocument().setSelection(els);
			}
		};
		mask.click(clickHandler);
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
