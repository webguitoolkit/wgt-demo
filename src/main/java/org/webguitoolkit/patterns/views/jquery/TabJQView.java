package org.webguitoolkit.patterns.views.jquery;

import org.webguitoolkit.patterns.views.SourceView;
import org.webguitoolkit.ui.base.WebGuiFactory;
import org.webguitoolkit.ui.controls.AbstractView;
import org.webguitoolkit.ui.controls.container.ICanvas;
import org.webguitoolkit.ui.controls.event.ClientEvent;
import org.webguitoolkit.ui.controls.jquery.tab.IJQTabListener;
import org.webguitoolkit.ui.controls.jquery.tab.JQueryTab;
import org.webguitoolkit.ui.controls.jquery.tab.JQueryTabstrip;

public class TabJQView extends AbstractView {
	private static final long serialVersionUID = 1L;

	public TabJQView(WebGuiFactory factory, ICanvas viewConnector) {
		super(factory, viewConnector);
	}

	@Override
	protected void createControls(WebGuiFactory factory, ICanvas viewConnector) {
		// button to show the source code of this class
		factory.createButton(viewConnector, "./images/iconText.gif", "Source Code", "Source Code", new SourceView(factory, viewConnector,
				this.getClass().getName()));

		JQueryTabstrip tabStrip = new JQueryTabstrip();
		viewConnector.add(tabStrip);
		tabStrip.getStyle().addWidth("400px");
		tabStrip.setCollapsable(true);
//		tabStrip.setOnMouseOver();
		
		JQueryTab tab = new JQueryTab();
		tabStrip.add(tab);
		tab.setHeaderKey("test1");
		
		factory.createLabel(tab, "test");
		factory.createText(tab, "");

		tab = new JQueryTab();
		tabStrip.add(tab);
		tab.setHeaderKey("test2");
		
		factory.createLabel(tab, "test2");
		factory.createText(tab, "");
		
		tabStrip.setListener(new IJQTabListener() {
			private static final long serialVersionUID = 1L;

			public void onTabChange(JQueryTab old, JQueryTab selected, ClientEvent event) {
				System.out.println( selected.getId() );
			}
		});
		
		tabStrip.selectTab(1);

	}

}
