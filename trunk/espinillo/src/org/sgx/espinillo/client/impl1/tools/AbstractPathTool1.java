package org.sgx.espinillo.client.impl1.tools;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.sgx.espinillo.client.impl1.Constants;
import org.sgx.espinillo.client.impl1.commands.CreateShapeCmd;
import org.sgx.espinillo.client.impl1.util.ToolUtil;
import org.sgx.espinillo.client.model.Document;
import org.sgx.espinillo.client.model.tool.AbstractTool;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Path;
import org.sgx.raphael4gwt.raphael.PathCmd;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.Rect;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Point;
import org.sgx.raphael4gwt.raphael.event.MouseEventListener;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.user.client.Window;

public abstract class AbstractPathTool1 extends AbstractTool {
	static Logger logger = Logger.getLogger("AbstractPathTool1");
	private Rect mask;
	private Paper paper;
	protected Point startCoords;
	protected Path editedShape;
	private Attrs initFeedbackAttrs;
	private MouseEventListener clickHandler, dblclickHandler;
	boolean firstClick=true;
	private PathCmd initCmd;
	private PathCmd currentCmd;
	private MouseEventListener moveHandler;
	protected String shapeOriginalPath;
	
	public AbstractPathTool1(Document doc){
		super(doc, Toolbar1.TOOL_LINE);
		firstClick=true;
	}	
	
	public Attrs getInitFeedbackAttrs() {
		if(initFeedbackAttrs==null) {
			initFeedbackAttrs=Attrs.create().strokeWidth(2).
					strokeDashArray(".").fill("red");
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
		initCmd = null; 
		currentCmd=null;
		editedShape = paper.path("M0,0"); //empty path editedShape
		clickHandler = new MouseEventListener() {			
			@Override
			public void notifyMouseEvent(NativeEvent e) {
				Point coords = Raphael.getCoordsInPaper(paper, e);		
				if(firstClick) {
					initCmd = new PathCmd(coords);
					currentCmd=initCmd;
					firstClick=false;
				}
				else {
					currentCmd=doNextCommand(coords, currentCmd);
				}
				String ps = editedShape.getAttribute("path")+
						currentCmd.toPathString();
				editedShape.attr("path", ps);
				shapeOriginalPath=ps;
//				editedShape.show();
			}
		};
		dblclickHandler = new MouseEventListener() {			
			@Override
			public void notifyMouseEvent(NativeEvent e) {
				Point coords = Raphael.getCoordsInPaper(paper, e);
//				currentCmd.remove();
				currentCmd=doCloseCommand(coords, currentCmd);
				
				Attrs attrs = Attrs.create().path(initCmd.toPathString());
				CreateShapeCmd csc = new CreateShapeCmd(getDocument(), 
						Constants.SHAPE_PATH, attrs);				
				try {
					getDocument().execute(csc);
				} catch (Exception ex) {
					logger.log(Level.SEVERE, "exec createshapecommand err ----");
					ex.printStackTrace();
					throw new RuntimeException(ex);
				}
				editedShape.remove();				
			}
		};
		moveHandler = new MouseEventListener() {	


			@Override
			public void notifyMouseEvent(NativeEvent e) {
				if(firstClick) 
					return;				
				if(shapeOriginalPath!=null)
					editedShape.setAttribute("path", shapeOriginalPath);
				
				Point coords = Raphael.getCoordsInPaper(paper, e);
				
//				shapeOriginalPath = editedShape.getAttribute("path");
//				PathCmd lastCmd = currentCmd;
				PathCmd aux = new PathCmd(0,0); 
				aux=doNextCommand(coords, aux);				
//				Attrs attrs = Attrs.create().path(initCmd.toPathString());
				editedShape.attr("path", shapeOriginalPath+
						aux.toPathString());
//				lastCmd.setNext(null);//delete this last
//				currentCmd=lastCmd;//restore
			}
		};
		mask.click(clickHandler);
		mask.dblclick(dblclickHandler);
//		mask.mouseMove(moveHandler, 300);
	}
	
//	public abstract PathCmd simulateNextCommand(Point coords, PathCmd c);
	public abstract PathCmd doNextCommand(Point coords, PathCmd c);
	public abstract PathCmd doCloseCommand(Point coords, PathCmd c);
	
	
	@Override
	public void uninstall() {
		super.uninstall();		
		ToolUtil.getInstance().hidePaperMask(getDocument());
		try {
			if(mask!=null)
				mask.undrag();
			if(clickHandler!=null)
				mask.unclick(clickHandler);
			if(dblclickHandler!=null)
				mask.undblclick(dblclickHandler);
			editedShape.remove();
		} catch (Exception e) {
			
		}
	}
}
