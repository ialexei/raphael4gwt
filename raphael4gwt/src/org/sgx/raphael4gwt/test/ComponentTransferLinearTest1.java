package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Shape;
//import org.sgx.raphael4gwt.raphael.svg.BrightnessComponentTransfer;
//import org.sgx.raphael4gwt.raphael.svg.FEComponentTransfer;
//import org.sgx.raphael4gwt.raphael.svg.FEComponentTransferLinear;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;
import org.sgx.raphael4gwt.test.image.TestImageResources;
/**
 * show how to use Shape.componentTransferLinear. It only works in SVG (all but IE<9)
 * @author sg
 *
 */
public class ComponentTransferLinearTest1 extends Test{
	@Override
	public void test() {
		
//		Shape img = paper.image(TestImageResources.INSTANCE.smallLion(), 210, 210, 220, 220);
//		
//		Shape img1 = paper.image(TestImageResources.INSTANCE.smallLion(), 10, 10, 220, 220);		
//		double bright = 1.6; //1.0 to 4.0 
//		img1.componentTransferLinear("bright1", 
//			FEComponentTransferLinear.create(bright, 0.0, bright, 0.0, bright, -1)); 
//		
//		Shape img3 = paper.image(TestImageResources.INSTANCE.smallLion(), 210, 10, 220, 220);
//		img3.componentTransferLinear("other1", 
//			FEComponentTransferLinear.create(4.0, -1.0, 4.0, -1.0, 4.0, -1.0)); 
//		
//		Shape img4 = paper.image(TestImageResources.INSTANCE.smallLion(), 10, 210, 220, 220);
//		img4.componentTransferLinear("brightness1", 
//			BrightnessComponentTransfer.create(4.0)); 
	}

	//test information:
	public String[] getTags() {
		return new String[]{GalleryUtil.TAG_EXTENSION, GalleryUtil.TAG_SVG};
	}
	public ComponentTransferLinearTest1(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="ComponentTransferLinear1";
		this.description="testing extensions ComponentTransferLinear (svg only)";
	}
	
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.ComponentTransferLinearTest1().getText();
	}

}
