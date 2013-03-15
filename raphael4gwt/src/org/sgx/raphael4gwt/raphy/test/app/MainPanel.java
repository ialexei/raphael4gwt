package org.sgx.raphael4gwt.raphy.test.app;

import org.sgx.raphael4gwt.raphy.client.Charts;
import org.sgx.raphael4gwt.raphy.client.line.Line;
import org.sgx.raphael4gwt.raphy.client.line.LineChart;
import org.sgx.raphael4gwt.raphy.test.tests.LineChartTest1;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class MainPanel extends Composite {

	private static MainPanelUiBinder uiBinder = GWT.create(MainPanelUiBinder.class);

	interface MainPanelUiBinder extends UiBinder<Widget, MainPanel> {
	}

	@UiField
	Element linechart1El;

	public MainPanel() {

		initWidget(uiBinder.createAndBindUi(this));

		addAttachHandler(new AttachEvent.Handler() {
			@Override
			public void onAttachOrDetach(AttachEvent event) {
				if (event.isAttached()) {
					drawChart1(linechart1El, "300px", "300px");
				}
			}
		});
	}

	public void drawChart1(final Element e, String width, String height) {
		
		new LineChartTest1().test(e);
//		e.getStyle().setProperty("width", width);
//		e.getStyle().setProperty("height", height);
//		e.getStyle().setProperty("display", "block");
//		
//		LineChart chart = Charts.LineChart(e);
//		chart.add_line(Line.create().data(
//				new double[][] { { 1, 828906 }, { 2, 566933 }, { 3, 584150 }, { 4, 1072143 }, { 5, 1622455 },
//						{ 6, 2466746 }, { 7, 2427789 } }));
//		chart.draw();
	}

}
