package com.testHibernate;

//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;

public class TestHibernate {
//	private ServiceRegistry serviceRegistry = null;
//	private SessionFactory sessionFactory = null;
//	private Session session = null;
//	
//	public static void main(String[] args) {
//		TestHibernate test = new TestHibernate();
//		test.test();
//	}
//	
//	
//	public TestHibernate() {
//		init();
//	}
//
//	public void init() {
//		try {
//			buildSession();
//			session = sessionFactory.openSession();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	private void buildSession() throws Exception {
//        Configuration configuration = new Configuration().configure();
//        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//    }
//	
//	public void test() {
//		try {
//			Query query = getSession().getNamedQuery("getBlkList");
//			Map parameterObject = new HashMap();
//			parameterObject.put("strClientID", "33712");
//			query = setParam(query, parameterObject);
//			
//			List<Object> lst = query.list();
//			TestDTO lic = (TestDTO) lst.get(0);
//			
//			System.out.println(lic.getStrCnt());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	private Query setParam(Query query, Object parameterObject) {
//		if (parameterObject instanceof Map) {
//			Map map = (Map)parameterObject;
//			
//			Iterator it = map.entrySet().iterator();
//			while (it.hasNext()) {
//				Entry entry = (Entry) it.next();
//				query.setParameter((String)entry.getKey(), entry.getValue());
//			}
//		}
//		
//		
//		return query;
//	}
//
//	public Session getSession() {
//		return session;
//	}
//
//	public void setSession(Session session) {
//		this.session = session;
//	}

}
