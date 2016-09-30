package com.wxine.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wxine.domain.User;

@Component
@Transactional
public class UserDao {
	@PersistenceContext
	private  EntityManager entityManager;
	
	public  Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	public List<User> findAllIsFriend(){  
		 DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		 dc.add( Property.forName("isfriend").eq(true));
	     Criteria criteria = dc.getExecutableCriteria(getSession());
	     List<User> user = criteria.list();
		 return user;
	}
	public List<User> findAllnoFriend(){
		 DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		 dc.add( Property.forName("isfriend").eq(false));
	     Criteria criteria = dc.getExecutableCriteria(getSession());
	     List<User> user = criteria.list();  
	     return user;
	}
	public int countFriend(){
	    DetachedCriteria dc = DetachedCriteria.forClass(User.class);
	    dc.add( Property.forName("isfriend").eq(true));
	    Criteria criteria = dc.getExecutableCriteria(getSession());
	    List<User> list = criteria.list();
		return list.size();
	}
	public User findById(String id) {
		User user = (User)getSession().get(User.class, id);
		return user;
	}
	public void insert(User user) {
		getSession().save(user);
	}
	public void merge(User user) {
		getSession().update(user);
	}

}
