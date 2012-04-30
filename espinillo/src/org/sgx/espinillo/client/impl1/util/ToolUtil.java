package org.sgx.espinillo.client.impl1.util;

import java.util.HashMap;
import java.util.Map;

import org.sgx.espinillo.client.impl1.ui.VEditorWidget;
import org.sgx.espinillo.client.model.Document;
import org.sgx.espinillo.client.model.tool.Tool;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.Rect;
import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Point;
import org.sgx.raphael4gwt.raphael.base.Rectangle;
import org.sgx.raphael4gwt.raphael.event.ForEachCallback;
import org.sgx.raphael4gwt.raphael.event.MouseEventListener;

import com.google.gwt.dom.client.NativeEvent;

public class ToolUtil {
	
	private static ToolUtil instance;

	private ToolUtil() {
//		currentTool=new HashMap<Document, Tool>();
	}

	public static ToolUtil getInstance() {
		if (null == instance) {
			instance = new ToolUtil();
		}
		return instance;
	}
//	Map<Document, Tool> currentTool;
	
	public static final int DEFAULT_DRAG_THROTTLE = 100;
	private static final int MASK_MOVE_THROTTLE = 100;
	
	private Rect _pMask = null;

	/**
	 * this is the method for creating the mask
	 * @param d
	 * @return
	 */
	public Rect showPaperMask(Document d) {
		if(_pMask==null||_pMask.isRemoved()) {
			_pMask=createPaperMask(d);
			_pMask.setData(ShapeUtil.CLASS_NAME, ShapeUtil.CLASS_MASK);
		}
		_pMask.toFront();
		return _pMask;
	}

	public Shape getPaperMask(Document d) {
		if(_pMask==null) {
			showPaperMask(d);//creates
			hidePaperMask(d);
		}
		return _pMask;
	}
	
	private Rect createPaperMask(final Document d) {
		Rect r = (Rect) d.getPaper().rect(0,0,d.getPaper().getWidth(),d.getPaper().getHeight()).
			attr(Attrs.create().opacity(0.2).fill("#ffffff"));
		r.mouseMove(new MouseEventListener() {		
			@Override
			public void notifyMouseEvent(NativeEvent e) {
				Point c = Raphael.getCoordsInPaper(d.getPaper(), e);
				VEditorWidget.getInstance().getStatus().setText(c.print());
			}
		}, MASK_MOVE_THROTTLE);
		return r;
	}
	public Rect hidePaperMask(Document d) {
		_pMask.toBack();
//		_pMask.hide();
		return _pMask;
	}
	
	
	
	
	
	
	
	//static utilities
	
	public static Point absDiff(Point p1, Point p2) {
		return Raphael.createPoint(Math.abs(p1.getX()-p2.getX()), 
				Math.abs(p1.getY()-p2.getY()));
	}
	public static Set getShapesUnderPoint(Paper p, Point coords) {
		return getShapesUnderPoint(p, coords.getX(), coords.getY(), false);
	}
	
	public static Set getShapesUnderPoint(Paper p, Point coords, boolean isWithoutTransform) {
		return getShapesUnderPoint(p, coords.getX(), coords.getY(), isWithoutTransform);
	}
	
	public static Set getShapesUnderPoint(Paper p, final double x, final double y, final boolean isWithoutTransform) {
		final Set set = p.set();
		p.forEach(new ForEachCallback() {			
			@Override
			public boolean call(Shape shape, int index) {
				Rectangle bb = shape.getBBox(isWithoutTransform);
				if(x>bb.getX()&&x<bb.getX()+bb.getWidth()&&y>bb.getY()&&y<bb.getY()+bb.getHeight())
					 set.push(shape);
				return true;
			}
		});
		return set;
	}

	
}
