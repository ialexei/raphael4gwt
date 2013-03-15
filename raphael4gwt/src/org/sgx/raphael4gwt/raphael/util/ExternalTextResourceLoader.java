package org.sgx.raphael4gwt.raphael.util;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.resources.client.ExternalTextResource;
import com.google.gwt.resources.client.ResourceCallback;
import com.google.gwt.resources.client.ResourceException;
import com.google.gwt.resources.client.TextResource;
/**
 * let the user load several ExternalTextResources. If anything fails, all fails.
 * @author sg
 *
 */
public class ExternalTextResourceLoader {
	public static interface Listener {
		void onSuccess();
		void onFailure(Exception e);
	}
	public static final String STATUS_ZERO="zero", STATUS_LADING="loading", STATUS_LOADED="loaded"; 
	Map<ExternalTextResource, String> res;
	private Listener listener;
	boolean error=false;
	public ExternalTextResourceLoader(){
		 error=false;
		res=new HashMap<ExternalTextResource, String>();
	}
	public void add(ExternalTextResource... resources) {
		for (int i = 0; i < resources.length; i++) {
			res.put(resources[i], STATUS_ZERO); 
		}
	}
	public void loadAll(Listener l) {
		this.listener=l;
		for(final ExternalTextResource r : res.keySet()) {
			if(!error) {
			try {
				res.put(r, STATUS_LADING); 
				r.getText(new ResourceCallback<TextResource>() {					
					@Override
					public void onSuccess(TextResource resource) {
						res.put(r, STATUS_LOADED); 
						if(checkAllLoaded()) {
							listener.onSuccess(); 
						}
					}					
					@Override
					public void onError(ResourceException e) {
						listener.onFailure(e); 
						error=true; 
					}
				});
			} catch (ResourceException e) {
				listener.onFailure(e); 
				e.printStackTrace();
				error=true; 
			} 
			}
		}
	}
	protected boolean checkAllLoaded() {
		for(ExternalTextResource r : res.keySet()) {
			if(!res.get(r).equals(STATUS_LOADED))
				return false;
		}
		return true;
	}
}
