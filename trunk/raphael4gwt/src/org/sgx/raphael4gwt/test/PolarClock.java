//package org.sgx.raphael4gwt.test;
//
//import org.sgx.raphael4gwt.raphael.Paper;
//import org.sgx.raphael4gwt.raphael.PathCmd;
//import org.sgx.raphael4gwt.raphael.Raphael;
//import org.sgx.raphael4gwt.raphael.Rect;
//import org.sgx.raphael4gwt.raphael.Shape;
//import org.sgx.raphael4gwt.raphael.base.Attrs;
//import org.sgx.raphael4gwt.raphael.base.CustomAttribute;
//import org.sgx.raphael4gwt.test.gallery.GalleryUtil;
//
//import com.google.gwt.user.client.Window;
///**
// * showcase of raphael custom attributes similar to http://raphaeljs.com/polar-clock.html
// * @author sg
// *
// */
//public class PolarClock extends Test {
//	
//	public static class Arc {
//		public Double value, total, R;
//
//		public Arc(Double value, Double total, Double r) {
//			super();
//			this.value = value;
//			this.total = total;
//			R = r;
//		}
//		
//	}
//	@Override
//	public void test() {
//		Raphael.addCustomAttribute(paper, "arc", new CustomAttribute<Arc>() {
//			@Override
//			public Attrs make(Shape s, Arc params) {
//				Attrs attrs = Attrs.create();
//				
//				double alpha = 360 / params.total * params.value,
//                        a = (90 - alpha) * Math.PI / 180,
//                        x = 300 + params.R * Math.cos(a),
//                        y = 300 - params.R * Math.sin(a);
//				String color = "hsb("+ Math.round(params.R) / 200 + "," + params.value / params.total+ ", .75)";
//				PathCmd pc = null;
//                if (params.total == params.value) {
//    				pc = new PathCmd(300,300-params.R);
//    				pc.A(params.R, params.R, 0, 1, 1, 299.99, 300 - params.R);
////                    path = [["M", 300, 300 - R], ["A", R, R, 0, 1, 1, 299.99, 300 - params.R]];
//                } else {
//                	pc = new PathCmd(300,300-params.R);
//    				pc.A(params.R, params.R, 0, 1/*+(alpha > 180)*/, 1, x, y);    				
////                    path = [["M", 300, 300 - R], ["A", R, R, 0, +(alpha > 180), 1, x, y]];
//                }
////                    return {path: path, stroke: color};                   
//				
//				attrs.path(pc.toPathString()).stroke(color);
//				return attrs;
//			}
//		});
//		Rect r = paper.rect(20,20,30,40);
//		r.setAttribute("fill", "red");
//		r.setAttribute("arc", new Arc(1.1,2.2,0.2));
//		
//	}
//
//	//test stuff
//	
//	@Override
//	public String[] getTags() {
//		return new String[]{GalleryUtil.TAG_EVENT};
//	}
//	@Override
//	public String getJavaClassSource() {
//		return TestResources.INSTANCE.CustomAttributesTest1().getText();
//	}
//
//	public PolarClock(Paper paper, int paperWidth, int paperHeight) {
//		super(paper, paperWidth, paperHeight);
//		this.name="custom attrs1";
//		this.description="showcase of raphael custom attributes similar to http://raphaeljs.com/polar-clock.html";
//		
//	}
//}
