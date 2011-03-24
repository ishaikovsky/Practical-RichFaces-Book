package org.richfaces.book.examples;

import org.richfaces.model.CalendarDataModelItem;

public class CalendarModelItem implements CalendarDataModelItem {
	private boolean enabled;
	private String styleClass;

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	@Override
	public String getStyleClass() {
		return styleClass;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	@Override
	public Object getData() {
		return null;
	}

	@Override
	public boolean hasToolTip() {
		return false;
	}

	@Override
	public Object getToolTip() {
		return null;
	}

	@Override
	public int getDay() {
		return 0;
	}
}
