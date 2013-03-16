= raphy-charts - http://softwarebyjosh.com/raphy-charts/= 

= Introduction = 

this project is totally independent on GRaphael4Gwt
it depends on Raphael4Gwt


= UIBINDER=

For using the raphy modules from UIBInder & GWT Widgets, you must ensure the parent widget is attached to the DOM
before render the charts inside. For example: 

	public MyWidgetWithChartInside() {
		initWidget(uiBinder.createAndBindUi(this));		
		addAttachHandler(new AttachEvent.Handler() {			
			@Override
			public void onAttachOrDetach(AttachEvent event) {
				DO_SHOW_CHARTS();
			}
		}); 
	}
	
An example: org.sgx.raphael4gwt.raphy.test.app.RunTest