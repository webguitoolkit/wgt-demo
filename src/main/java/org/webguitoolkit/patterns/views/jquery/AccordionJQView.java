package org.webguitoolkit.patterns.views.jquery;

import org.webguitoolkit.patterns.views.SourceView;
import org.webguitoolkit.ui.base.WebGuiFactory;
import org.webguitoolkit.ui.controls.AbstractView;
import org.webguitoolkit.ui.controls.container.ICanvas;
import org.webguitoolkit.ui.controls.event.ClientEvent;
import org.webguitoolkit.ui.controls.jquery.BaseJQControl;
import org.webguitoolkit.ui.controls.jquery.IJQListener;
import org.webguitoolkit.ui.controls.jquery.accordion.Accordion;
import org.webguitoolkit.ui.controls.jquery.accordion.AccordionTab;
import org.webguitoolkit.ui.controls.util.json.JSONObject;

public class AccordionJQView extends AbstractView {
	private static final long serialVersionUID = 1L;

	public AccordionJQView(WebGuiFactory factory, ICanvas viewConnector) {
		super(factory, viewConnector);
	}

	@Override
	protected void createControls(WebGuiFactory factory, ICanvas viewConnector) {
		// button to show the source code of this class
		factory.createButton(viewConnector, "./images/iconText.gif", "Source Code", "Source Code", new SourceView(factory, viewConnector,
				this.getClass().getName()));

		Accordion accordion = new Accordion();
		viewConnector.add(accordion);
//		tabStrip.getStyle().addWidth("400px");
//		tabStrip.setOnMouseOver();
		
		AccordionTab tab = new AccordionTab();
		accordion.add(tab);
		tab.setHeaderKey("test1");
		
		factory.createLabel(tab, "test");
		factory.createText(tab, "");

		tab = new AccordionTab();
		accordion.add(tab);
		tab.setHeaderKey("test2");
		
		factory.createLabel(tab, "test2");
		factory.createText(tab, "");
		
		accordion.setListener("change",new IJQListener() {
//			private static final long serialVersionUID = 1L;
			
			public void onAction(BaseJQControl baseJQControl, String action, JSONObject uiObject, ClientEvent event) {
				System.out.println( uiObject.toString() );
			}
		});
				
	}

}
