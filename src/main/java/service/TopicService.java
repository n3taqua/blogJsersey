package service;

import model.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtils;

import java.util.List;

public class TopicService {
    private final SessionFactory factory= HibernateUtils.getSessionFactory();
    private final Session session=factory.getCurrentSession();
    public List<Topic> getAllByCategories(int id){
        List<Topic> list=List.of();
        try {
            session.getTransaction().begin();
            String hql="From Topic As t where t.categories.id=:id";
            list=session.createQuery(hql,Topic.class).list();
            session.getTransaction().commit();

        }
        catch (Exception e){
            session.getTransaction().rollback();
        }
        return list;
    }

    public List<Topic> getAll(){
        List<Topic> list=List.of();
        try {
            session.getTransaction().begin();
            String hql="From Topic";
            list=session.createQuery(hql,Topic.class).list();
            session.getTransaction().commit();

        }
        catch (Exception e){
            session.getTransaction().rollback();
        }
        return list;
    }
    public Topic get(int id){
        try {
            session.getTransaction().begin();
            Topic Topic=session.load(Topic.class,id);
            session.getTransaction().commit();
            return Topic;
        }
        catch (Exception e){
            session.getTransaction().rollback();
        }
        return null;
    }
    public void delete(int id){
        try{
            session.getTransaction().begin();
            Topic Topic=session.load(Topic.class,id);
            session.delete(Topic);
            session.getTransaction().commit();
        }
        catch (Exception e){
            session.getTransaction().rollback();
        }

    }
    public void add(Topic topic){
        try {
            session.getTransaction().begin();
            session.save(topic);
            session.getTransaction().commit();
        }
        catch (Exception e){
            session.getTransaction().rollback();
        }

    }
    public void update(Topic topic){
        try {

            session.getTransaction().begin();
            session.update(topic);
            session.getTransaction().commit();
        }
        catch (Exception e){
            session.getTransaction().rollback();
        }

    }
}
