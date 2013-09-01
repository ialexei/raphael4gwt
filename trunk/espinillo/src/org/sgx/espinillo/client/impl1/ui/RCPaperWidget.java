package org.sgx.espinillo.client.impl1.ui;

import java.util.ArrayList;
import java.util.List;

import org.sgx.raphael4gwt.raphael.event.PaperListener;
import org.sgx.raphael4gwt.raphael.widget.PaperWidget;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;

/**
 * a paper widget that accepts right click (context menu)
 * @author sg
 *
 */
public class RCPaperWidget extends PaperWidget {

	public RCPaperWidget(int paperWidth, int paperHeight) {
		super(paperWidth, paperHeight);
		sinkEvents(Event.ONCONTEXTMENU);
	}
	
	List<ContextClickHandler> contextClicktClickHandlers= new ArrayList<ContextClickHandler>();

    public void addContextClickHandler(ContextClickHandler theContextClickHandler ){
        contextClicktClickHandlers.add(theContextClickHandler);
    }
    void removeContextClickHandler(ContextClickHandler theContextClickHandler ){
        contextClicktClickHandlers.remove(theContextClickHandler);
    }

    @Override
    public void onBrowserEvent(Event theEvent) {
        int anEventType = DOM.eventGetType(theEvent);
        if(anEventType == Event.ONCONTEXTMENU) {
            //Window.alert("context=Right Click detected");
            for(int i=0; i<contextClicktClickHandlers.size();i++){
                contextClicktClickHandlers.get(i).handleContextClick(theEvent);
            }
            theEvent.stopPropagation();// This will stop the event from being propagated
            theEvent.preventDefault();
        } else {
            // other browser events
            super.onBrowserEvent(theEvent);
        }
    }
}
