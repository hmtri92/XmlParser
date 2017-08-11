package tls.ida.testHibernate;

//import java.util.List;

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
//			query.setParameter("strClientID", "33712");
//			List<TlsLicAuthDTO> lst = query.list();
//			TlsLicAuthDTO lic = (TlsLicAuthDTO) lst.get(0);
//			
//			lic.getStrCnt();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
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
