package org.sgx.raphael4gwt.raphael;

import com.google.gwt.core.client.JavaScriptObject;
/**
 * named set extension
 * @author sg
 *
 */
public class NamedSet<K> extends JavaScriptObject {
protected NamedSet(){}

public final native Set getSet()/*-{
	return this.set;
}-*/;

public final native JavaScriptObject getData()/*-{
	return this.data;
}-*/;


public final native void put(K k, Shape s)/*-{
	this.put(k, s);
}-*/;

public final native void putAll(NamedSet<K> ns)/*-{
	this.putAll(ns);
}-*/;

public final native Shape remove(K k)/*-{
	return this.remove(k);
}-*/;

public final native NamedSet<K> removeAll(NamedSet<K> ns)/*-{
	return this.removeAll(ns);
}-*/;

}
