package service;

import model.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtils;

import java.util.List;

public class UserService {
    private final SessionFactory factory= HibernateUtils.getSessionFactory();
    private final Session session=factory.getCurrentSession();
    public List<User> getAll(){
        List<User> list=List.of();
        try {
            session.getTransaction().begin();
            String hql="From User";
            list=session.createQuery(hql,User.class).list();
            session.getTransaction().commit();

        }
        catch (Exception e){
            session.getTransaction().rollback();
        }
        return list;
    }
    public User get(int id){
        try {
            session.getTransaction().begin();
            User User=session.load(User.class,id);
            session.getTransaction().commit();
            return User;
        }
        catch (Exception e){
            session.getTransaction().rollback();
        }
        return null;
    }
    public void delete(int id){
        try{
            session.getTransaction().begin();
            User User=session.load(User.class,id);
            session.delete(User);
            session.getTransaction().commit();
        }
        catch (Exception e){
            session.getTransaction().rollback();
        }

    }
    public void add(User user){
        try {
            session.getTransaction().begin();
            session.save(user);
            session.getTransaction().commit();
        }
        catch (Exception e){
            session.getTransaction().rollback();
        }

    }
    public void update(User user){
        try {

            session.getTransaction().begin();
            session.update(user);
            session.getTransaction().commit();
        }
        catch (Exception e){
            session.getTransaction().rollback();
        }

    }
}
