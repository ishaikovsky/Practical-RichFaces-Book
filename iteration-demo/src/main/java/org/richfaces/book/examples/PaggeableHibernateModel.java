package org.richfaces.book.examples;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;
import org.richfaces.book.examples.model.GameDescriptor;
@ManagedBean
@SessionScoped
public class PaggeableHibernateModel extends
		BasePageableHibernateModel<GameDescriptor> {

	public PaggeableHibernateModel() {
		super(GameDescriptor.class);
	}

	@ManagedProperty(value = "#{gamesHibernateBean.hibernateSession}")
	private Session hibernateSession;

	public void setHibernateSession(Session hibernateSession) {
		this.hibernateSession = hibernateSession;
	}

	@Override
	protected Session getSession() {
		return hibernateSession;
	}
}
