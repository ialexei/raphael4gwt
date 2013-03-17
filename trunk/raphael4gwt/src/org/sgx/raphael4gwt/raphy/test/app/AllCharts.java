package org.sgx.raphael4gwt.raphy.test.app;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class AllCharts extends Composite {

	private static AllChartsUiBinder uiBinder = GWT.create(AllChartsUiBinder.class);

	interface AllChartsUiBinder extends UiBinder<Widget, AllCharts> {
	}

	@UiField
	Element toc;

	public AllCharts() {
		initWidget(uiBinder.createAndBindUi(this));
		new Toc(toc, toc.getParentElement()).make();
	}

}
