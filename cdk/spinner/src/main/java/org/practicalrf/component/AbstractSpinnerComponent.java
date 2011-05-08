package org.practicalrf.component;

import javax.faces.component.UIInput;

import org.richfaces.cdk.annotations.Attribute;
import org.richfaces.cdk.annotations.JsfComponent;
import org.richfaces.cdk.annotations.JsfRenderer;

@JsfComponent(type = "org.practicalrf.Spinner", family = "javax.faces.Input", renderer = @JsfRenderer(template = "spinner.template.xml"))
public abstract class AbstractSpinnerComponent extends UIInput {
    @Attribute
    public abstract boolean isDisabled();

    @Attribute(defaultValue = "1")
    public abstract String getStep();

    @Attribute(defaultValue = "0")
    public abstract String getMinValue();

    @Attribute(defaultValue = "100")
    public abstract String getMaxValue();
}
