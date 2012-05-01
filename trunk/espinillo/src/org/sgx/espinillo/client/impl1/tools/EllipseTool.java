package org.sgx.espinillo.client.impl1.tools;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.sgx.espinillo.client.impl1.Constants;
import org.sgx.espinillo.client.impl1.commands.CreateShapeCmd;
import org.sgx.espinillo.client.impl1.util.ToolUtil;
import org.sgx.espinillo.client.model.Document;
import org.sgx.espinillo.client.model.tool.AbstractTool;
import org.sgx.espinillo.client.util.Util;
import org.sgx.raphael4gwt.raphael.Ellipse;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.Rect;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Point;
import org.sgx.raphael4gwt.raphael.event.DDListener;

import com.google.gwt.dom.client.NativeEvent;
/**
 * 
 * @author sg
 *
 */
public class EllipseTool extends AbstractTool {

	static Logger logger = Logger.getLogger("EllipseTool");
	private Rect mask;
	private Paper paper;
	protected Point startCoords;
	protected Ellipse feedback;
	private Attrs initFeedbackAttrs;
	private DDListener ddListener;
	
	public EllipseTool(Document d){
		super(d, Toolbar1.TOOL_ELLIPSE, Toolbar1.TOOL_ELLIPSE_LABEL);
	}	
	
	public Attrs getInitFeedbackAttrs() {
		if(initFeedbackAttrs==null) {
			initFeedbackAttrs=Attrs.create().fill("#44ff99");
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
		
		ddListener = new DDListener() {
			
			@Override
			public void onStart(int x, int y, NativeEvent e) {	
//				logger.log(Level.INFO, "drag start");
				startCoords = Raphael.getCoordsInPaper(paper, e);
				feedback = paper.ellipse(startCoords.getX(), startCoords.getY(), 10, 10);
				feedback.attr(getInitFeedbackAttrs());
			}
			
			@Override
			public void onMove(int dx, int dy, int x, int y, NativeEvent e) {
				if(feedback!=null) {
					Point coords = Raphael.getCoordsInPaper(paper, e);
					Point d = ToolUtil.absDiff(coords, startCoords);
					feedback.setAttribute("rx", d.getX());
					feedback.setAttribute("ry", d.getY());
				}
			}
			
			@Override
			public void onEnd(NativeEvent e) {		
				
				ToolUtil.getInstance().hidePaperMask(getDocument());
				Attrs attrs = feedback.attr();
				CreateShapeCmd cmd = new CreateShapeCmd(getDocument(), 
					Constants.SHAPE_ELLIPSE, attrs);
				
				try {
					getDocument().execute(cmd);
				} catch (Exception ex) {
					logger.log(Level.SEVERE, "exec createshapecommand err ----");
					ex.printStackTrace();
					throw new RuntimeException(ex);
				}
				feedback.remove();
			}
		};
		mask.drag(ddListener, ToolUtil.DEFAULT_DRAG_THROTTLE);
	}

	@Override
	public void uninstall() {	
		super.uninstall();
		try {
			if(mask!=null)
				mask.undrag();
			if(feedback!=null)
				feedback.remove();
//				editedShape.hide();
			ToolUtil.getInstance().hidePaperMask(getDocument());
		} catch (Exception e) {
			
		}		
	}

}
