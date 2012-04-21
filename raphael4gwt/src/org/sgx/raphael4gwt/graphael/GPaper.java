package org.sgx.raphael4gwt.graphael;

import org.sgx.raphael4gwt.graphael.pie.PieOpts;
import org.sgx.raphael4gwt.graphael.pie.Piechart;
import org.sgx.raphael4gwt.raphael.Paper;

/**
 * if you are working with grtaphael (i.e if you inherith GRaphael4Gwt module
 * then you only have to cast a normal raphael Paper to GPaper.
 * @author sg
 *
 */
public class GPaper extends Paper {
	
protected GPaper(){}
	
public final native Piechart piechart(double x, double y, double r, double[] vals)/*-{	
	return this.piechart(x, y, r, @org.sgx.raphael4gwt.raphael.jsutil.JsUtil::toJsArray([D)(vals));
}-*/;

public final native Piechart piechart(double x, double y, double r,  double[] vals, PieOpts opts)/*-{
	return this.piechart(x, y, r, 
		@org.sgx.raphael4gwt.raphael.jsutil.JsUtil::toJsArray([D)(vals),
		opts.@org.sgx.raphael4gwt.graphael.pie.PieOpts::toNative()()
	);
}-*/;

}
