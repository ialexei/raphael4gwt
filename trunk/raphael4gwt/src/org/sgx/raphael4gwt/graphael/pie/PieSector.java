package org.sgx.raphael4gwt.graphael.pie;

import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.Text;

import com.google.gwt.core.client.JavaScriptObject;
/**
 * Pie chart sector information. 
 * Sector object from g.pie.js is:
<pre>
sector: sector,
cover: cover,
cx: cx,
cy: cy,
mx: sector.middle.x,
my: sector.middle.y,
mangle: sector.mangle,
r: r,
value: values[j],
total: total,
label: that.labels && that.labels[j]
</pre>
 * @author sg
 *
 */
public final class PieSector extends JavaScriptObject {

	protected PieSector(){}
	
	public native Shape getLabelIcon()/*-{
		return this.label?this.label[0]:null;
	}-*/;
	public native Text getLabelText()/*-{
		return this.label?this.label[1]:null;
	}-*/;
	public native Shape getSector()/*-{
		return this.sector;
	}-*/;
	public native Shape getCover()/*-{
		return this.cover;
	}-*/;
	public native Shape getSectorMangle()/*-{
		return this.mangle;
	}-*/;
	public native int getCx()/*-{
		return this.cx;
	}-*/;
	public native int getCy()/*-{
		return this.cy;
	}-*/;
	/**
	 * @return middle point x coord of the sector.
	 */
	public native int getMx()/*-{
		return this.mx;
	}-*/;
	/**
	 * @return middle point y coord of the sector.
	 */
	public native int getMy()/*-{
		return this.my;
	}-*/;
	/**
	 * 
	 * @return sector radius
	 */
	public native int getR()/*-{
		return this.r;
	}-*/;
	/**
	 * 
	 * @return sector value
	 */
	public native double getValue()/*-{
		return this.value;
	}-*/;
	public native double getTotal()/*-{
		return this.total;
	}-*/;
}
