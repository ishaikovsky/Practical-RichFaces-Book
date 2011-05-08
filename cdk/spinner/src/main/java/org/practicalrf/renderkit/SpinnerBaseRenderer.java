package org.practicalrf.renderkit;

import java.util.Map;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;

import org.richfaces.component.util.InputUtils;
import org.richfaces.renderkit.RendererBase;

@ResourceDependencies({ @ResourceDependency(name = "jquery.js"),
    @ResourceDependency(library = "org.richfaces", name = "spinner.js") })
public abstract class SpinnerBaseRenderer extends RendererBase {
    public void decode(FacesContext context, UIComponent component) {
        String clientId = component.getClientId(context);
        Map<String, String> requestParameterMap = context.getExternalContext().getRequestParameterMap();
        String newValue = (String) requestParameterMap.get(clientId);
        if (null != newValue) {
            UIInput input = (UIInput) component;
            input.setSubmittedValue(newValue);
        }
    }

    public Object getConvertedValue(FacesContext context, UIComponent component, Object val) throws ConverterException {
        return InputUtils.getConvertedValue(context, component, val);
    }

    public String getInputValue(FacesContext context, UIComponent component) throws ConverterException {
        return InputUtils.getInputValue(context, component);
    }
}
