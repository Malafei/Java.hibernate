package program;

import entitites.Author;
import entitites.Book;
import entitites.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.DbContextVova;
import org.hibernate.query.Query;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Session context = DbContextVova.getSessionFactory().openSession();
        //System.out.println("Hello");
        //Role role = new Role();
        //role.setName("admin");
        //context.save(role);
//        Query query = context.createQuery("From Role");
//        List<Role> roles = query.list();
//        for (Role role : roles)
//        {
//            System.out.println(role);
//        }


        //context.close();
        Author ivan = new Author();
        ivan.setFullName("Ivanko Pidlyi");
        Author petr = new Author();
        petr.setFullName("Petr Pidlabuznyi");

        Book potter = new Book();
        potter.setName("gary poter");
        potter.setAuthor(ivan);

        Book rusiy = new Book();
        rusiy.setName("rusalca poter");
        rusiy.setAuthor(ivan);

        Book slavik = new Book();
        slavik.setName("slavik poter");
        slavik.setAuthor(petr);

        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory = DbContextVova.getSessionFactory();
            session = sessionFactory.openSession();
            System.out.println("Session open");
            tx = session.beginTransaction();
            session.save(petr);
            session.save(ivan);
            session.save(potter);
            session.save(rusiy);
            session.save(slavik);


            tx.commit();

        }catch (Exception ex){
            System.out.println("Exception" + ex.getMessage());
            ex.printStackTrace();
        }finally {
            if (!sessionFactory.isClosed()){
                System.out.println("Closing SessionFactory");
                sessionFactory.close();
            }
        }

    }
}
