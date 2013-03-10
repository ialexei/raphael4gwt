package org.sgx.raphael4gwt.graphael.org;
/**
 * org charts, http://librerias.logicas.org/lib_gg_orgchart/, are different designed from the rest of charts types.
 * The chart options needs to be in a global variable named oc_style and the function for creating a chart is also global named  oc_render
 * @author sg
 *
 */
public class OrgChart {
public static final native void create(OrgOpts opts, OrgData data)/*-{
	$wnd["oc_data"]=data;
	$wnd["oc_style"]=opts;
	$wnd["oc_render"]();
}-*/;

}
