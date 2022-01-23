package utils;
import entitites.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class DbContextVova {
    private static SessionFactory sessionFactory;
    private DbContextVova() {}
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure(); //new Configuration().configure("hibernate.cfg.xml");

                configuration.addAnnotatedClass(Role.class);
                configuration.addAnnotatedClass(Author.class);
                configuration.addAnnotatedClass(Book.class);


                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Exception!" + e);
            }
        }
        return sessionFactory;
    }
}