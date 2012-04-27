package org.sgx.espinillo.client.impl1.tools;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.sgx.espinillo.client.impl1.Constants;
import org.sgx.espinillo.client.impl1.commands.CreateShapeCmd;
import org.sgx.espinillo.client.impl1.util.ToolUtil;
import org.sgx.espinillo.client.model.Document;
import org.sgx.espinillo.client.model.tool.AbstractTool;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.PathCmd;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.Rect;
import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Point;
import org.sgx.raphael4gwt.raphael.event.DDListener;
import org.sgx.raphael4gwt.raphael.event.MouseEventListener;
import org.sgx.raphael4gwt.raphael.util.GUIUtil;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * draw shapes using smoothQuadBezierCurveTo curves
 * @author sg
 *
 */
public class TextTool extends AbstractTool {

	static Logger logger = Logger.getLogger("PathTool");
	private Rect mask;
//	private Document doc;
	private Paper paper;
//	protected Point startCoords;
//	protected Shape feedback;
//	private Attrs initFeedbackAttrs;	
//	private DDListener ddListener;
	private MouseEventListener clickHandler;
	
	public TextTool(Document doc){
		super(doc, Toolbar1.TOOL_TEXT);
	}	
	
//	public Attrs getInitFeedbackAttrs() {
//		if(initFeedbackAttrs==null) {
//			initFeedbackAttrs=Attrs.create().fill("yellow").strokeDashArray(".-");
//		}
//		return initFeedbackAttrs;
//	}
//
//	public void setFeedbackAttrs(Attrs initAttrs) {
//		this.initFeedbackAttrs = initAttrs;
//	}
	
	@Override
	public void install() {
		super.install();
		
		paper = getDocument().getPaper();
		mask = ToolUtil.getInstance().showPaperMask(getDocument());
						
		clickHandler = new MouseEventListener() {			
			@Override
			public void notifyMouseEvent(final NativeEvent e) {
				
				GUIUtil.openTextEntryDialog("Enter the text", 
					"Enter the text. Use \\n for new lines", 
					new GUIUtil.TextEntryDialogAcceptListener() {						
					@Override
					public void notifyAccept(String text, DialogBox db) {
						Point coords = Raphael.getCoordsInPaper(paper, e);
						Attrs attrs = Attrs.create().text(text).
							x(coords.getX()).y(coords.getY());
						CreateShapeCmd cmd = new CreateShapeCmd(getDocument(), 
							Constants.SHAPE_TEXT, attrs);
						db.hide();
						try {
							getDocument().execute(cmd);
						}catch (Exception ex) {
							logger.log(Level.SEVERE, "exec createshapecommand err ----");
						}
					}
				});
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
//			feedback.remove();
		} catch (Exception e) {
			
		}
	}
	
}
