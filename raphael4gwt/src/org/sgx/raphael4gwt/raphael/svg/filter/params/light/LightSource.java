package org.sgx.raphael4gwt.raphael.svg.filter.params.light;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Abstract base class for all Light Sources, like DistantLight, PointLight, SpotLight.
 * 
 * <p>
 * A light source element is one that can specify light source information for an ‘feDiffuseLighting’ or ‘feSpecularLighting’ element. The following light source elements are
 * defined in SVG 1.1: ‘feDistantLight’, ‘fePointLight’ and ‘feSpotLight’.
 * </p>
 * 
 * @author sg
 * 
 */
public class LightSource extends JavaScriptObject {
	protected LightSource() {
	}


}
