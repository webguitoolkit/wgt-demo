/*
Copyright 2008 Endress+Hauser Infoserve GmbH&Co KG 
Licensed under the Apache License, Version 2.0 (the "License"); 
you may not use this file except in compliance with the License. 
You may obtain a copy of the License at 

http://www.apache.org/licenses/LICENSE-2.0 

Unless required by applicable law or agreed to in writing, software 
distributed under the License is distributed on an "AS IS" BASIS, 
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or 
implied. See the License for the specific language governing permissions 
and limitations under the License.
*/ 
package org.webguitoolkit.patterns.doc.examples;

import org.webguitoolkit.ui.base.WebGuiFactory;
import org.webguitoolkit.ui.controls.AbstractView;
import org.webguitoolkit.ui.controls.container.Canvas;
import org.webguitoolkit.ui.controls.container.ICanvas;
import org.webguitoolkit.ui.controls.event.ClientEvent;
import org.webguitoolkit.ui.controls.event.IActionListener;

public class ControlsView extends AbstractView {

	public ControlsView(WebGuiFactory factory, Canvas viewConnector) {
		super(factory, viewConnector);
	}

	@Override
	protected void createControls(WebGuiFactory factory, ICanvas viewConnector) {
		factory = new WebGuiFactory();

		factory.createButton( viewConnector, null, "Text button", "I'm a button with text", new IActionListener() {
			public void onAction(ClientEvent event) {
				getPage().sendInfo("You clicked " + event.getSource().getId() );
			}
		}, "B1" );

		factory.createButton( viewConnector, "images/wgt/save.gif", null, "I'm a button with icon", new IActionListener() {
			public void onAction(ClientEvent event) {
				getPage().sendInfo("You clicked " + event.getSource().getId() );
			}
		}, "B2");

	}

}
