package org.sgx.raphael4gwt.graphael.bar;

import org.sgx.raphael4gwt.graphael.GShape;
import org.sgx.raphael4gwt.raphael.Set;
/**
 * 
 * @author sg
 *
 */
public class BarContext extends GShape {
protected BarContext(){}
/**
 * 
 * @return
 */
public native final Bar getBar()/*-{	
	if(this.bar)
		return this.bar;
	else if (this.bars)
		return this.bars.firstShape();
	else return null;
}-*/;
/**
 * note: normalize the js api - for columnHover() Set this.bars for hover() Shape this.bar 
 * @return a Set of Bar
 */
public native final Set getBars()/*-{
//	$wnd.alert(this.bars+" - "+this.bar);
	if(this.bars)
		return this.bars;	
	else {
		var set = this.paper.set();
		set.push(this.bar);
		return set;
	}
}-*/;
//public native final JsArray<Bar> getBars()/*-{
//	return this.bars;
//}-*/;

}
