package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;
//import org.sgx.raphael4gwt.raphael.PathCmd;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.event.Callback;
import org.sgx.raphael4gwt.raphael.pathobj.PathObject;
import org.sgx.raphael4gwt.raphael.util.Util;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;
/**
 * using path, PathCmd, animations and transformations for bringing paths into life.
 * @author sg
 *
 */
public class LivePathTest extends Test implements Callback {

private Shape lp1;
private int minx, maxy, maxx, miny, x, y, pointCount;
private int ms;

@Override
public void test() {
	maxx=400; maxy=400; minx=70; miny=70; pointCount=15;
	Attrs attrs = Attrs.create().fill("#33ff11").
			stroke("#125566").strokeWidth(5).opacity(0.8);
	
	//and now a random path
	getPaper().text(400, 400, "a very strange thing");
	PathObject pathObj1 = PathObject.create(400,400); 
	for (int i = 0; i < 24; i++) {
		pathObj1.T(Util.randomBetween(370, 400), Util.randomBetween(370, 400));
	}
	pathObj1.z(); 
	lp1 = getPaper().path(pathObj1).attr(attrs.strokeWidth(2));
	
	call(lp1);
}

/** 
 * animation finish callback
 */
@Override
public void call(Shape src) {
	
	x = Util.randomBetween(minx, maxx);
	y = Util.randomBetween(miny, maxy);
	pointCount=Util.randomBetween(3, 33);
	ms =  Util.randomBetween(1000,3000);
	
	PathObject p = PathObject.create(x,  y);
	for (int i = 0; i < pointCount; i++) {
		p.T(Util.randomBetween(x,y), Util.randomBetween(x,y));
	}
		
	Attrs attrs = Attrs.create().
		path(p).
		strokeWidth(Util.randomBetween(2, 12)).
		stroke(randomColor()).
		fill(randomColor());
	
	String easing = Raphael.EASING_ALL[Util.randomBetween(0, Raphael.EASING_ALL.length-1)];
	lp1.animate(attrs, ms, easing, this);
}


//test stuff
public String[] getTags() {
	return new String[]{GalleryUtil.TAG_SHAPE, GalleryUtil.TAG_ANIM, GalleryUtil.TAG_PATH};
}
public LivePathTest(Paper paper, int paperWidth, int paperHeight) {
	super(paper, paperWidth, paperHeight);
	this.name="live paths";
	this.description="using path, PathCmd, animations and " +
		"transformations for bringing paths into life.";		
	
}

@Override
public String getJavaClassSource() {
	return TestResources.INSTANCE.LivePathTest().getText();
}

}
