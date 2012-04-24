package org.sgx.raphael4gwt.raphael.util;

import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.event.ForEachCallback;

public class ShapeUtil {
	//print shape info
	public static interface ShapePrinter {
		String print(Shape s);
	}
//	private static Shape sh;
	public static String printSet(Set set, final ShapePrinter p) {
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
//	/**
//	 * recurses a set till a normal shape is found and returned.
//	 * @param s
//	 * @return
//	 */
//	public static Shape getFirstShape(Set s) {
//		sh = null;
//		s.forEach(new ForEachCallback() {			
//			@Override
//			public boolean call(Shape shape, int index) {
//				String type = shape.getType();
//				if(type==null)
//					return true;
//				if(type.equals("set")) {
//					sh=getFirstShape((Set)shape);
//					if(sh!=null)
//						return false;
//					else
//						return true;
//				}
//				else {
//					sh=shape;
//					return false;
//				}
//			}
//		});
//		return sh;
//	}
}
