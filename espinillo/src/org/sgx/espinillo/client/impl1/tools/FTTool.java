package org.sgx.espinillo.client.impl1.tools;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.sgx.espinillo.client.impl1.Constants;
import org.sgx.espinillo.client.impl1.commands.ChangeShapeAttrsCmd;
import org.sgx.espinillo.client.impl1.commands.CreateShapeCmd;
import org.sgx.espinillo.client.impl1.model.VEditor1;
import org.sgx.espinillo.client.impl1.ui.VEditorWidget;
import org.sgx.espinillo.client.impl1.util.ShapeUtil;
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
import org.sgx.raphael4gwt.raphael.event.ForEachCallback;
import org.sgx.raphael4gwt.raphael.event.MouseEventListener;
import org.sgx.raphael4gwt.raphael.ft.FTAttrs;
import org.sgx.raphael4gwt.raphael.ft.FTCallback;
import org.sgx.raphael4gwt.raphael.ft.FTOptions;
import org.sgx.raphael4gwt.raphael.ft.FTSubject;
import org.sgx.raphael4gwt.raphael.ft.FreeTransform;
import org.sgx.raphael4gwt.raphael.jsutil.JsUtil;
import org.sgx.raphael4gwt.raphael.util.GUIUtil;

import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * installs a free transform handler to the shape. 
 * @author sg
 *
 */
public class FTTool extends AbstractTool {

	static Logger logger = Logger.getLogger("FTTool");
	private Rect mask;
	private Paper paper;
	private MouseEventListener clickHandler;
	protected FreeTransform ft;
	protected Attrs originalAttrs;
	protected Shape feedback;
	protected Shape fs;
	
	public FTTool(Document doc){
		super(doc, Toolbar1.TOOL_FT, Toolbar1.TOOL_FT_LABEL);
	}	
	protected Set filterOnlyShapes(Set els) {
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
	@Override
	public void install() {
		super.install();
		uninstall(); 
		paper = getDocument().getPaper();
		mask = ToolUtil.getInstance().showPaperMask(getDocument());
						
		clickHandler = new MouseEventListener() {
			
			@Override
			public void notifyMouseEvent(final NativeEvent e) {
				//does the samee as selection tool but also installs a free transform in selected shapes.
								
				Point coords = Raphael.getCoordsInPaper(paper, e);				
				
				Set els = ToolUtil.getShapesUnderPoint(paper, coords);
				els=filterOnlyShapes(els);
				getDocument().setSelection(els); 
				fs = els.firstShape();
				if(fs==null)
					return;
				feedback = fs.clone();
				feedback.toFront(); 
//				fs.hide();
//				final Shape els = els2!=null ? els2.firstShape() : null; //only work for one shape selection
				
				getDocument().setSelection(els);
				
				final FTOptions ftOpts = FTOptions.create();
				ftOpts.setRotate(true);
				ftOpts.setAttrs(FTAttrs.create().fill("red").strokeWidth(4).stroke("blue"));
				final FTCallback callback = new FTCallback() {				
					@Override
					public void call(FTSubject s, JsArrayString events) {
//						boolean transformchanged=false;
						if(JsUtil.arrayContains(events, FreeTransform.EVENT_ROTATE_END)|| //rotate
							JsUtil.arrayContains(events, FreeTransform.EVENT_SCALE_END)|| //scale
							JsUtil.arrayContains(events, FreeTransform.EVENT_DRAG_END)) { //translate
							
							doTransformation(s, events);
							uninstall(); 
						}
//						ta.setText(
//							"translate: " + s.getTranslateX()+", "+s.getTranslateY()+
//							", center: "+s.getCx()+", "+s.getCy()+
//							", rotation: "+s.getRotate()+
//							"\nsize: "+s.getHeight()+", "+s.getWidth()+" - "+
//							", scale: "+s.getScaleX()+", "+s.getScaleY()+" - "+
//							"\nEvents: "+events.join(", "));
					}

					
				};
				
				originalAttrs=fs.attr();
				ft = paper.freeTransform(feedback, ftOpts, callback); //install the ft
			}
		};
		mask.click(clickHandler);
	}
	void doTransformation(FTSubject s, JsArrayString events) {
		/* fs is modified already by the FT cause we didn't use any feedback shape.
		 * so we demodify it and execute a ChangeShapeAttrsCmd
		 */							
		Attrs newAttrs = feedback.attr();
		VEditorWidget.getInstance().getStatus().setText("hello: "+s.getRotate()); 
		Window.alert(JsUtil.dump(s, false));
//		Window.alert(JsUtil.get(s, "subject")+"");
//		fs.attr(originalAttrs);
//		fs.show();
		
		ChangeShapeAttrsCmd cmd = new ChangeShapeAttrsCmd(getDocument(), fs, newAttrs);
		getDocument().execute(cmd);
	}
	
	/**
	 * return the union and rest the intersection of both sets
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
			if(feedback!=null) {
				feedback.remove(); 
			}
			if(mask!=null)
				mask.undrag();
			if(clickHandler!=null)
				mask.unclick(clickHandler);
			if(ft!=null)
				ft.unplug();
		} catch (Exception e) {
			
		}
	}
	
}
