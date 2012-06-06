package org.sgx.espinillo.client.impl1.test;

import org.sgx.espinillo.client.impl1.ui.VEditorWidget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * this is a gwt transparent component that gowa in front of the raphael paper
 * and catch right clicks for showing the shape context menu
 * 
 * @author sg
 */
public class PaperOverlay extends HTML {

	private Widget target; //the overlayed widget.

	public PaperOverlay(Widget target) {
		super();
		this.target=target; 
		Style sty = this.getElement().getStyle();
//		setPixelSize(target.getOffsetWidth(), target.getOffsetHeight());
		sty.setDisplay(Style.Display.BLOCK);
		sty.setPosition(Style.Position.ABSOLUTE);
		sty.setWidth(target.getOffsetWidth(), Style.Unit.PX);
		sty.setHeight(target.getOffsetHeight(), Style.Unit.PX);
		sty.setLeft(target.getAbsoluteLeft(), Style.Unit.PX);
		sty.setTop(target.getAbsoluteTop(), Style.Unit.PX);
		sty.setBackgroundColor("red");
		setHTML("&nbsp;");
	}

	@Override
	public void onBrowserEvent(Event event) {
		Window.alert("browser event");
		if (DOM.eventGetType(event) == Event.ONCLICK
				&& DOM.eventGetCtrlKey(event)) {

		}
		if (DOM.eventGetButton(event) == Event.BUTTON_RIGHT) {
			GWT.log("Event.BUTTON_RIGHT", null);
			onRightClickBroker(this, event);
		}
		sinkEvents(Event.ONMOUSEUP | Event.ONDBLCLICK | Event.ONCONTEXTMENU);
		super.onBrowserEvent(event);
	}

	private void onRightClickBroker(HTML aThis, Event event) {

		final PopupPanel popupPanel = new PopupPanel();
		popupPanel.setPixelSize(85, 100);

		Command showPlayerCommand = new Command() {
			public void execute() {

				popupPanel.hide();
				VEditorWidget.getInstance().paperWidget.remove(popupPanel);

			}
		};

		VEditorWidget.getInstance().rightClickFired = true;
		// Window.alert("audio icon right clicked");
		MenuBar popupMenuBar = new MenuBar(true);
		MenuItem playerItem = new MenuItem("Play", true, showPlayerCommand);

		popupMenuBar.addItem(playerItem);
		popupMenuBar.setVisible(true);
		popupPanel.add(popupMenuBar);

		DOM.setStyleAttribute(popupPanel.getElement(), "background-color",
				"gray");
		DOM.setStyleAttribute(popupPanel.getElement(), "border-color",
				"gray gray gray gray");
		DOM.setStyleAttribute(popupPanel.getElement(), "border-width",
				"1px 3px 3px 1px");
		DOM.setStyleAttribute(popupPanel.getElement(), "border-style",
				"solid solid solid solid");
		DOM.setStyleAttribute(playerItem.getElement(), "font-weight", "normal");
		DOM.setStyleAttribute(playerItem.getElement(), "font-size", "80%");

		popupPanel.setVisible(true);
		popupPanel.getElement().setId("popuppanel1");
//		popupPanel.set
//		, event.getClientX(),	event.getClientY()
		VEditorWidget.getInstance().paperWidget.add(popupPanel);

	}
}
