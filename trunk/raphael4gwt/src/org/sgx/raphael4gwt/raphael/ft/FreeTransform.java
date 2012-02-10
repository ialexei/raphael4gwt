package org.sgx.raphael4gwt.raphael.ft;

import org.sgx.raphael4gwt.raphael.Shape;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * a free transformation handler from https://github.com/ElbertF/Raphael.FreeTransform wrapper.
 * @author sg
 *
 */
public class FreeTransform extends JavaScriptObject {
	protected FreeTransform(){}
	
	public static final String 
			EVENT_ROTATE="rotate", 
			EVENT_ROTATE_START="rotate start", 
			EVENT_ROTATE_END="rotate end",
			
			EVENT_SCALE="scale", 
			EVENT_SCALE_START="scale start",
			EVENT_SCALE_END="scale end",
	
			EVENT_DRAG="drag", 
			EVENT_DRAG_START="drag start",
			EVENT_DRAG_END="drag end";
	
	
/**
 * Update options and callback.
 * @param opts
 * @param c
 */
public native final void setOpts(FTOptions opts, FTCallback c)/*-{
//	this.setOpts
}-*/;
/**
 * Removes handle and deletes all values set by the plugin.
 */
public native final void unplug()/*-{
	this.unplug();
}-*/;
/**
 * Updates handles to reflect the element's transformations.
 */
public native final void updateHandles()/*-{
	this.updateHandles();
}-*/;

//public native final Shape getHandleX()/*-{
//	return this.handles.x.disc;
//}-*/;
//public native final Shape getHandleY()/*-{
//	return this.handles.y.disc;
//}-*/;
//public native final Shape getHandleCenter()/*-{
//	return this.handles.center.disc;
//}-*/;
}
