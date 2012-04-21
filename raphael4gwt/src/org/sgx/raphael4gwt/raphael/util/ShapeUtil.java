package org.sgx.raphael4gwt.raphael.util;

import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.event.ForEachCallback;

public class ShapeUtil {
	//print shape info
	public static interface ShapePrinter {
		String print(Shape s);
	}
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
}
