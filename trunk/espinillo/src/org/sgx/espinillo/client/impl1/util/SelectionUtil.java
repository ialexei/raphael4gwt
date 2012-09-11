package org.sgx.espinillo.client.impl1.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.sgx.espinillo.client.impl1.tools.SelectionTool;
import org.sgx.espinillo.client.util.Util;
import org.sgx.gwteditors.client.util.LWMap;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Rectangle;
import org.sgx.raphael4gwt.raphael.event.ForEachCallback;
/**
 * keep trac of each shape selection editedShape for each shape
 * @author sebastian
 *
 */
public class SelectionUtil {
	static Logger logger = Logger.getLogger("SelectionUtil");
private static SelectionUtil instance;

private SelectionUtil() {
	selectionFeedbacks=LWMap.create();
	defSelFeedbackAttrs=Attrs.create().strokeDashArray("-.").fill("none");
}

public static SelectionUtil getInstance() {
	if (null == instance) {
		instance = new SelectionUtil();
	}
	return instance;
}
Attrs defSelFeedbackAttrs;
//VEditor ved;
LWMap<String, Shape> selectionFeedbacks;
int hpadding=4, vpadding=4;

public Shape getSelectionFeedback(Paper paper, Shape s) {
	String sid = ShapeUtil.getInstance().getShapeId(s);
	Shape sf = selectionFeedbacks.get(sid);
	if(sf==null) {
		sf = newSelectionFeedback(paper, s);
		selectionFeedbacks.put(sid, sf);
	}
	Rectangle bb = s.getBBox(false);
	sf.attr(Attrs.create().x(bb.getX()).y(bb.getY()).
		width(bb.getWidth()).height(bb.getHeight()));
	sf.toFront();
	sf.show();
	return sf;
}
public void updateSelectionFeedbacks(final Paper paper, Set shapes) {
	logger.log(Level.INFO, "updateSelectionFeedbacks"); 
	shapes.forEach(new ForEachCallback() {		
		@Override
		public boolean call(Shape el, int index) {
			updateSelectionFeedback(paper, el);
			return true;
		}
	});
}
public void updateSelectionFeedback(Paper paper, Shape el) {
	Shape sf = getSelectionFeedback(paper, el);
	Rectangle bb = sf.getBBox();
	sf.attr(Attrs.create().x(bb.getX()).y(bb.getY()).
		width(bb.getWidth()).height(bb.getHeight()));
}

public Set getSelectionFeedbacks(final Paper paper, Set shapes) {
	final Set set = paper.set();
	shapes.forEach(new ForEachCallback() {		
		@Override
		public boolean call(Shape el, int index) {
			Shape sf = getSelectionFeedback(paper, el);
			if(sf!=null) {
				set.push(sf);
			}
			return true;
		}
	});
	return set;
}
protected Shape newSelectionFeedback(Paper paper,Shape s) {
	Rectangle bb = s.getBBox();
	bb.setHeight(bb.getHeight()+hpadding/2);
	bb.setWidth(bb.getWidth()+vpadding/2);
	bb.setX(bb.getX()-hpadding/2);
	bb.setY(bb.getY()-vpadding/2);
	
//	logger.log(Level.INFO, "newSelectionFeedback of "+s.getType()+" - bbox: "+bb.print()+" - shape id : "+ShapeUtil.getInstance().getShapeId(s));
	Shape r = paper.rect(bb).attr(getDefaultSelectionFeedbackAttrs());
	r.setData(ShapeUtil.CLASS, ShapeUtil.CLASS_SELFEEDBACK);
	r.toFront();
	r.show();
	return r;
}

private Attrs getDefaultSelectionFeedbackAttrs() {
	return defSelFeedbackAttrs;
}

public void hideSelectionFeedbacks(Set selFeedbacks) {
	selFeedbacks.toBack();
	selFeedbacks.hide();
}
}
