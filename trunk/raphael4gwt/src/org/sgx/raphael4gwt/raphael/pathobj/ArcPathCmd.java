package org.sgx.raphael4gwt.raphael.pathobj;

public class ArcPathCmd extends PathCmd {
protected ArcPathCmd(){}
public static final native ArcPathCmd createAbs(double rx, double ry, double xAxisRotation, 
		double largeArcFlanc, double sweepFlag, double x, double y)/*-{
	return ["A", rx, ry, xAxisRotation, largeArcFlanc, sweepFlag, x, y]; 
}-*/;
public static final native ArcPathCmd createRel(double rx, double ry, double xAxisRotation, 
		double largeArcFlanc, double sweepFlag, double x, double y)/*-{
	return ["a", rx, ry, xAxisRotation, largeArcFlanc, sweepFlag, x, y]; 
}-*/;

public final native boolean isAbsolute()/*-{
	return this[0]=="A"; 
}-*/;
}
