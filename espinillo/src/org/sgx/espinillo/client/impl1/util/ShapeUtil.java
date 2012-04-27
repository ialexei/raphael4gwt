package org.sgx.espinillo.client.impl1.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.sgx.raphael4gwt.raphael.Circle;
import org.sgx.raphael4gwt.raphael.Ellipse;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Rect;
import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.event.ForEachCallback;

/**
 * all tools must use these methods for creating/deleting shapes
 * 
 * TODO: reuse removed shapes
 * @author sg
 *
 */
public class ShapeUtil {
	
static Logger logger = Logger.getLogger("ShapeUtil");
	
public static final String ID_PREFIX = "espinilloImpl1Shape-", 
	ID_NAME ="espinilloImpl1Id", 
	CLASS_NAME = "espinilloImpl1Class", 
	CLASS_SHAPE="shape", 
	CLASS_SELFEEDBACK="selection editedShape", 
	CLASS_MASK="mask";

private static ShapeUtil instance;

private ShapeUtil() {
	counter=0;
}

public static ShapeUtil getInstance() {
	if (null == instance) {
		instance = new ShapeUtil();
	}
	return instance;
}
int counter;
protected Shape first;

private Shape setId(Shape e) {
	e.setData(ID_NAME, ID_PREFIX+incrCounter());
	return e;
}
public String getShapeId(Shape s) {
	return s.getData(ID_NAME)+"";
}

private int incrCounter() {
	return counter++;
}

private Shape initShape(Shape s) {
	s.attr(Attrs.create().clipRect("0 0 9999 9999"));
	s.setData(CLASS_NAME, CLASS_SHAPE);
	return setId(s);
}
public Circle newCircle(Paper paper, int cx, int cy, int r) {
	Shape e = paper.circle(cx, cy, r);	
	return (Circle) initShape(e);
}


public Shape getFirst(Set s) {
	first = null;
	s.forEach(new ForEachCallback() {			
		@Override
		public boolean call(Shape shape, int index) {
			first=shape;
			return false;
		}
	});
	return first;
}

public Ellipse newEllipse(Paper p, double x, double y, double rx, double ry) {
	Shape e = p.ellipse(x, y, rx, ry);
	return (Ellipse)initShape(e);
}

public Rect newRect(Paper p, double x, double y, int w, int h) {
	Shape e = p.rect(x, y, w, h);
	return (Rect)initShape(e);
}
public Shape newPath(Paper paper) {
	Shape e = paper.path();
	return initShape(e);
}

public Shape newText(Paper paper) {
	Shape e = paper.text(0,0,"");
	return initShape(e);
}
public static boolean isShape(Shape shape) {
	Object d = shape.getData(CLASS_NAME);
	logger.log(Level.INFO, "isShape: "+d+"="+CLASS_SHAPE);
	return d!=null && d.equals(CLASS_SHAPE);
}


//print shape info
public static interface ShapePrinter {
	String print(Shape s);
}
public static String printShape(Set set, final ShapePrinter p) {
	final StringBuffer sb = new StringBuffer("Set{");
	set.forEach(new ForEachCallback() {		
		@Override
		public boolean call(Shape shape, int index) {
			sb.append(p.print(shape)+", ");
			return true;
		}
	});
	sb.append("}");
	return sb.toString();
}



}
