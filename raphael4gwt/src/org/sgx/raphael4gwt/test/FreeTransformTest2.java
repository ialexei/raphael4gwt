package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Attr;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Path;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.ft.FTCallback;
import org.sgx.raphael4gwt.raphael.ft.FTOptions;
import org.sgx.raphael4gwt.raphael.ft.FTSnap;
import org.sgx.raphael4gwt.raphael.ft.FTSubject;
import org.sgx.raphael4gwt.raphael.ft.FreeTransform;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;
import org.sgx.raphael4gwt.test.image.IconPaths;

import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
/**
 * raphael4gwt support free transform raphaeljs extension from 
 * https://github.com/ElbertF/Raphael.FreeTransform. 
 * this shows how to use it.
 * @author sg
 *
 */
public class FreeTransformTest2 extends Test implements FTCallback {

	private TextArea ta;

	@Override
	public void test() {		
		final Path p = paper.path(IconPaths.question).attr(new Attr().fill("red")).cast();
		final FTOptions ftOpts = FTOptions.create().setDraw(new String[]{"bbox", "circle"}).
			setSnap(new FTSnap(30, 20, 50)).setSnapDist(new FTSnap(0, 0, 30));
		final FreeTransform ft = paper.freeTransform(p, ftOpts, this);
		ftOpts.attrs().setScale("");
		ft.apply();
//		p.attr(Attrs.create().transform("s3.0t200,200")); 
//		ft.updateHandles(); 
//		ft.setRotate(45);
//		ft.apply(); 
//		p.attr(Attrs.create().transform("t100,100,s2.0")); 
//	}
	
	//create a text area gwt ui widget for loggin events
	VerticalPanel testPanel = GalleryUtil.getInstance().getTestPanel();
	ta = new TextArea();
	ta.setSize("100%", "60px");
	ta.getElement().setId("seba123");
	testPanel.add(ta);
	
//		/* Example: we will draw a lot of shapes (icons) and add free transform 
//		 * handles to each of them, registering and logging user changes  using 
//		 * the free transformer handles. 
//		 */
		
//		String[] iconPaths = new String[] {
//			IconPaths.question, IconPaths.i, IconPaths.dollar, IconPaths.temp, 
//			IconPaths.thunder, IconPaths.snow,  IconPaths.hail,  IconPaths.rain,
//			IconPaths.cloudy, IconPaths.sun, IconPaths.undo, 
//			IconPaths.merge, 
//		};
				
//		int stepX = paperWidth/10;
//		int stepY = paperWidth/10;
//		int x = 30, y = 100;
//
//		for (int i = 0; i < iconPaths.length; i++) {
//			x+=stepX;
//			if(x>paperWidth-40) {
//				x=0;
//				y+=stepY;
//			}
//			final Path p = paper.path(iconPaths[0]).attr(new Attr().fill("red").transform("t100,100s3.0")).cast();
//			p.translate(x, y);	
//			p.scale(2.0,2.0);
//			
//			final FTOptions ftOpts = FTOptions.create();
//			ftOpts.setScale(s)
//			ftOpts.setRotate(true);
//			ftOpts.setAttrs(Attrs.create().fill("red").strokeWidth(4).stroke("blue"));
//			final FTCallback callback = new FTCallback() {				
//				@Override
//				public void call(FTSubject s, JsArrayString events) {
//					ta.setText(
//						"translate: " + s.getTranslateX()+", "+s.getTranslateY()+
//						", center: "+s.getCx()+", "+s.getCy()+
//						", rotation: "+s.getRotate()+
//						"\nsize: "+s.getHeight()+", "+s.getWidth()+" - "+
//						", scale: "+s.getScaleX()+", "+s.getScaleY()+" - "+
//						"\nEvents: "+events.join(", "));
//				}
//			};
//			final FreeTransform ft = paper.freeTransform(p, ftOpts, callback);
//			//don't forget to call updateHandles in the free transform object!
//			ft.updateHandles(); 
//		}
		
//		//create a text area gwt ui widget for loggin events
//		VerticalPanel testPanel = GalleryUtil.getInstance().getTestPanel();
//		ta = new TextArea();
//		ta.setSize("100%", "60px");
//		ta.getElement().setId("seba123");
//		testPanel.add(ta);
	}

	@Override
	public void call(FTSubject ft, JsArrayString events) {
		// TODO Auto-generated method stub
		
	}
	
	
	//test only stuff:
	public String[] getTags() {
		return new String[]{GalleryUtil.TAG_FT};
	}
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.FreeTransformTest2().getText();
	}

	public FreeTransformTest2(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="FreeTransformTest2";
		this.description="FreeTransformTest2";		
	}



}
