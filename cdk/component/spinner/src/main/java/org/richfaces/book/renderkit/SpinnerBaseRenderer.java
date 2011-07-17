package org.richfaces.book.renderkit;

import java.util.Map;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;

import org.richfaces.book.component.AbstractSpinnerComponent;
import org.richfaces.component.util.InputUtils;
import org.richfaces.renderkit.InputRendererBase;

@ResourceDependencies({
		@ResourceDependency(name = "jquery.js"),
		@ResourceDependency(library = "org.richfaces.book", name = "spinner.js"),
		@ResourceDependency(library = "org.richfaces.book", name = "spinner.ecss") })
public abstract class SpinnerBaseRenderer extends InputRendererBase {
	public void decode(FacesContext context, UIComponent component) {
		String clientId = component.getClientId(context);
		Map<String, String> requestParameterMap = context.getExternalContext()
				.getRequestParameterMap();
		String newValue = (String) requestParameterMap.get(clientId);
		if (null != newValue) {
			AbstractSpinnerComponent input = (AbstractSpinnerComponent) component;
			input.setSubmittedValue(newValue);
		}
	}

	public Object getConvertedValue(FacesContext context,
			UIComponent component, Object val) throws ConverterException {
		return InputUtils.getConvertedValue(context, component, val);
	}

	public String getInputValue(FacesContext context, UIComponent component)
			throws ConverterException {
		return InputUtils.getInputValue(context, component);
	}
}
