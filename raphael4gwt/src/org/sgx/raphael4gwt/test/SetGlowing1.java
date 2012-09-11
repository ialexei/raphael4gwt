package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Circle;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.event.MouseEventListener;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.user.client.Window;
/**
 * 
 * @author sg
 *
 */
public class SetGlowing1 extends Test{

@Override
public void test() {
	final Circle s1 = paper.circle(200,200,100); 
	s1.setAttribute("fill", "red");
	Shape s2 = paper.text(200, 100, "glowoed").attr(Attrs.create().fontSize(22));
	Shape s3 = paper.ellipse(100,120,40,120).attr(Attrs.create().fill("pink")); 
	Shape s4 = paper.text(100,100, "clickus").attr(Attrs.create().fontSize(20)); 
	
	final Set set1 = paper.set();
	set1.push(new Shape[]{s1, s2, s3, s4}); 
	
//	set1.click(new MouseEventListener() {			
//		@Override
//		public void notifyMouseEvent(NativeEvent e) {
//			
//		}
//	});
	
	Set glow1 = set1.glow(); 
	Window.alert("glow size: "+set1.size()); 
	glow1.transform("t10,10"); 
}

//test information:
public String[] getTags() {
	return new String[]{GalleryUtil.TAG_EVENT, GalleryUtil.TAG_SHAPE, GalleryUtil.TAG_SET};
}
public SetGlowing1(Paper paper, int paperWidth, int paperHeight) {
	super(paper, paperWidth, paperHeight);
	this.name="setGlowing";
	this.description="setGlowing";
}

@Override
public String getJavaClassSource() {
	return TestResources.INSTANCE.SetGlowing1().getText();
}

}
