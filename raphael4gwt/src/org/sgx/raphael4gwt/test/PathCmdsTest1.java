package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Path;
import org.sgx.raphael4gwt.raphael.PathCmd;
import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Font;
import org.sgx.raphael4gwt.raphael.event.ForEachCallback;
import org.sgx.raphael4gwt.raphael.util.Util;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;
/**
 * show different types of using the artificial type PathCmd for 
 * programatically create a path in java (using pbjects not string based api)
 * @author sg
 *
 */
public class PathCmdsTest1 extends Test {

	private Path lp1;

	@Override
	public void test() {
		Attrs attrs = Attrs.create().fill("#33ff11").
				stroke("#125566").strokeWidth(5).opacity(0.5);
		
		PathCmd pc1 = new PathCmd(0,0);
		pc1.lineto(new double[][]{{10,20}, {40,40}, {40,50}, {60,20}}).close();
		getPaper().text(250,20, "lineto(new double[][]{{10,20}, \n{40,40}, {40,50}, {60,20}}).close()");		
		getPaper().path(pc1.toPathString()).attr("transform", "t180,30s2").attr(attrs);
		
		PathCmd pc2 = new PathCmd(0,0);
		pc2.smoothQuadBezierCurveTo(new double[][]{{10,20}, {40,40}, {40,50}, {60,20}}).close();
		getPaper().text(450,20, "smoothQuadBezierCurveTo(new \ndouble[][]{{10,20}, {40,40}, {40,50}, {60,20}}).close()");		
		getPaper().path(pc2.toPathString()).attr("transform", "t450,20s2").attr(attrs);
		
		
		//and now a random path
		getPaper().text(400, 400, "a random path");
		PathCmd pc3 = new PathCmd(400,400), aux = pc3;
		for (int i = 0; i < 12; i++) {
			aux=aux.T(Util.randomBetween(370, 400), Util.randomBetween(370, 400));
		}
		aux.close();
		getPaper().path(pc3.toPathString()).attr(attrs.strokeWidth(2));
		
		
		
		//now build a pathcmd from path string
		getPaper().text(80,20,"PathCmd builded \nfrom path string");		
		PathCmd cmd4 = new PathCmd("M20,20L40,40L70,90L20,50L10,10Z");
		lp1 = getPaper().path(cmd4.toPathString());
		
		//another more documented path for docs:		
		/* create a path command. The first command is always a 
		 * "moveto" - we pass coords in constructor
		 */
		PathCmd pc = new PathCmd(10,10); 
		pc.L(20, 20).M(10,180).L(0,0).T(10,100).T(100,10).Z();
		getPaper().path(pc) //make sure pc references the FIRST command
			.attr(Attrs.create().fill("red").transform("t80,400"));
	}
	
	//test stuff

	public PathCmdsTest1(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="path commands";
		this.description="show how to use the artificial type PathCmd for programatically create a path in java (using pbjects not string based api)";		
		
	}
	public String[] getTags() {
		return new String[]{GalleryUtil.TAG_PATH, GalleryUtil.TAG_EXTENSION};
	}
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.PathCmdsTest1().getText();
	}

}
