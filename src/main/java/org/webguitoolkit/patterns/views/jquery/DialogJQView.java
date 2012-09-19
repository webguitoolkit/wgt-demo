package org.webguitoolkit.patterns.views.jquery;

import org.webguitoolkit.patterns.views.SourceView;
import org.webguitoolkit.ui.base.WebGuiFactory;
import org.webguitoolkit.ui.controls.AbstractView;
import org.webguitoolkit.ui.controls.container.ICanvas;
import org.webguitoolkit.ui.controls.jquery.dialog.Dialog;

public class DialogJQView extends AbstractView {
	private static final long serialVersionUID = 1L;

	public DialogJQView(WebGuiFactory factory, ICanvas viewConnector) {
		super(factory, viewConnector);
	}

	@Override
	protected void createControls(WebGuiFactory factory, ICanvas viewConnector) {
		// button to show the source code of this class
		factory.createButton(viewConnector, "./images/iconText.gif", "Source Code", "Source Code", new SourceView(factory, viewConnector,
				this.getClass().getName()));

		Dialog d = new Dialog();
		viewConnector.add(d);
		
		factory.createLabel(d, "test");
		factory.createText(d, "");
				
	}

}
