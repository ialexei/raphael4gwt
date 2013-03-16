package org.sgx.raphael4gwt.raphy.client.pathmenu;

import org.sgx.raphael4gwt.raphy.client.RaphyChart;

public class PathMenu extends RaphyChart{
protected PathMenu(){}
public final native PathMenu add(PathMenuItem item)/*-{
	this.add(item); 
	return this;
}-*/;
}
