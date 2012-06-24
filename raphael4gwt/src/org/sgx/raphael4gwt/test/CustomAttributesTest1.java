//package org.sgx.raphael4gwt.test;
//
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//import org.sgx.raphael4gwt.raphael.Paper;
//import org.sgx.raphael4gwt.raphael.Raphael;
//import org.sgx.raphael4gwt.raphael.Shape;
//import org.sgx.raphael4gwt.raphael.base.Attrs;
//import org.sgx.raphael4gwt.raphael.base.CustomAttribute;
//import org.sgx.raphael4gwt.test.gallery.GalleryUtil;
//
//import com.google.gwt.dom.client.AnchorElement;
//import com.google.gwt.dom.client.Document;
//import com.google.gwt.dom.client.Style.Unit;
//import com.google.gwt.user.client.ui.RootPanel;
///**
// * examples at http://raphaeljs.com/reference.html#Paper.customAttributes in java
// * @author sg
// *
// */
//public class CustomAttributesTest1 extends Test {
//	static Logger logger = Logger.getLogger("CustomAttributesTest1");
//	
//	
//	/**
//	 * a class for representing a custom attribute 
//	 */
//	static class Hsb {
//		public int h, s, b;
//		public Hsb(int h, int s, int b) {
//			super();
//			this.h = h;
//			this.s = s;
//			this.b = b;
//		}		
//	}
//	
//	static class Hue {
//		public double val;
//		public Hue(double val) {
//			this.val=val;
//		}
//	}
//	
//	@Override
//	public void test() {
//		
//		final AnchorElement anchor = Document.get().createAnchorElement();
//		RootPanel.get().getElement().appendChild(anchor);
//		anchor.getStyle().setMargin(20, com.google.gwt.dom.client.Style.Unit.PX);
//		anchor.setId("anchor1");
//		anchor.setInnerText("halksajdlkasjdlkasjd");
////		final TextArea ta = new TextArea();
////		RootPanel.get().add(ta);
//		
//		
//		
//		//define a new custom attr (valid for paths only) that will add an ark at the end of a path
//		Raphael.addCustomAttribute(paper, "hue", new CustomAttribute() {
//			@Override
//			public Attrs make(Shape context, Object params) {
//				if(params instanceof Hue) {
//					String s = "hsb("+((Hue)params).val+", 0.75, 1)";
//					return Attrs.create().fill(s);
//				}
//				else return Attrs.create();
//			}
//		});
//		Shape r = paper.rect(20,20,130,240).attr("fill", "red");	
//		r.setAttribute("hue", 0.1);
//		r.animate(Attrs.create().set("hue", 0.9), 2000);
//		//and now animate our custom attribute
//				
//				
//		
//		
////		//define a new custom attr (valid for paths only) that will add an ark at the end of a path
////		Raphael.addCustomAttribute(paper, "hue", new CustomAttribute() {
////			@Override
////			public Attrs make(Shape context, Object num_) {
////				Double num=(Double)num_;
////				logger.log(Level.SEVERE, context+" - "+num);
////				if(num!=null) {
////				num = num % 1;
//////				ta.setText(ta.getText()+" - "+num);
////				String s = "hsb("+num+", 0.75, 1)";
////				return Attrs.create().fill(s);
////				}
////				else return Attrs.create();
////			}
////		});
////		Shape r = paper.rect(20,20,130,240).attr("fill", "red");	
////		r.setAttribute("hue", 0.1);
////		r.animate(Attrs.create().set("hue", 0.9), 200);
////		//and now animate our custom attribute
//	}
//
//	//test stuff
//	
//	@Override
//	public String[] getTags() {
//		return new String[]{GalleryUtil.TAG_CUSTOMATTR};
//	}
//	@Override
//	public String getJavaClassSource() {
//		return TestResources.INSTANCE.CustomAttributesTest1().getText();
//	}
//
//	public CustomAttributesTest1(Paper paper, int paperWidth, int paperHeight) {
//		super(paper, paperWidth, paperHeight);
//		this.name="custom attrs1";
//		this.description="examples at http://raphaeljs.com/reference.html#Paper.customAttributes in java";
//		
//	}
//}
