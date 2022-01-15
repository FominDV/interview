package factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryFactory {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        return sessionFactory == null ?
                sessionFactory = new Configuration()
                        .configure()
                        .buildSessionFactory() :
                sessionFactory;
    }

}
