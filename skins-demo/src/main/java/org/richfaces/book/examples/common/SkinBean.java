/**
 *
 */
package org.richfaces.book.examples.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * @author ishaikovsky
 */
@ManagedBean(name = "skinBean")
@SessionScoped
public class SkinBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2399884208294434812L;
	private static final String SKIN_VIEW_PARAMETER = "skin";
	@ManagedProperty(value = "blueSky")
	private String skin;
	private List<String> skins;
	private boolean standardSkinningEnabled = true; 
	private boolean skinningClassesEnabled = true;
	
	public SkinBean() {
		skins = new ArrayList<String>();
		skins.add("blueSky");
		skins.add("classic");
		skins.add("deepMarine");
		skins.add("emeraldTown");
		skins.add("japanCherry");
		skins.add("ruby");
        skins.add("wine");
        skins.add("newyork");
	}

	private String getViewParameter(String name) {
		FacesContext fc = FacesContext.getCurrentInstance();
		String param = (String) fc.getExternalContext()
				.getRequestParameterMap().get(name);
		if (param != null && param.trim().length() > 0) {
			return param;
		} else {
			return null;
		}
	}

	public String getSkin() {
		String currentSkin = getViewParameter(SKIN_VIEW_PARAMETER);
		if (currentSkin != null) {
			skin = currentSkin;
		}
		return skin;
	}

	public void setSkin(String skin) {
		this.skin = skin;
	}

	public List<String> getSkins() {
		return skins;
	}

	public boolean isStandardSkinningEnabled() {
        return standardSkinningEnabled;
    }
	
	public void setStandardSkinningEnabled(boolean standardSkinningEnabled) {
        this.standardSkinningEnabled = standardSkinningEnabled;
    }
	
	public boolean isSkinningClassesEnabled() {
        return skinningClassesEnabled;
    }
	
	public void setSkinningClassesEnabled(boolean skinningClassesEnabled) {
        this.skinningClassesEnabled = skinningClassesEnabled;
    }
	
}
