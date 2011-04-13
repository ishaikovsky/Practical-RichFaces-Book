package org.richfaces.book.examples;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.richfaces.book.examples.model.GameDescriptor;

@ManagedBean
@SessionScoped
public class ArrangeableHibernateModel extends BaseArrangeableHibernateModel<GameDescriptor> {
	
	public ArrangeableHibernateModel() {
		super(GameDescriptor.class);
	}

}
