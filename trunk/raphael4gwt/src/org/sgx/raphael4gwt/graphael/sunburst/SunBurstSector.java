package org.sgx.raphael4gwt.graphael.sunburst;

import org.sgx.raphael4gwt.graphael.GShape;
import org.sgx.raphael4gwt.raphael.base.Point;
/**
 * @author sg
 */
public class SunBurstSector extends GShape {
	protected SunBurstSector(){}
	public native final int getLevel()/*-{
		return this.level;
	}-*/;
	public native final double getValue()/*-{
		return this.value;
	}-*/;
	public native final String getLabel()/*-{
		return this.label;
	}-*/;
	public native final Point getMiddle()/*-{
		return this.middle;
	}-*/;

}
