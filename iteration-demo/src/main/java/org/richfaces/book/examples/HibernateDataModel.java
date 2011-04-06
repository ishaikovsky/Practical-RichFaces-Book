package org.richfaces.book.examples;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.hibernate.Session;
import org.richfaces.book.examples.model.GameDescriptor;

@ManagedBean
@SessionScoped
public class HibernateDataModel extends BaseArrangeableHibernateDataModel<GameDescriptor> {
	
	@ManagedProperty(value="#{hibernateBean.hibernateSession}")
	private Session hibernateSession;
	
	public HibernateDataModel() {
		super(GameDescriptor.class);
	}

	public void setHibernateSession(Session hibernateSession) {
		this.hibernateSession = hibernateSession;
	}
	
	@Override
	protected Session getSession() {
		return hibernateSession;
	}

}
