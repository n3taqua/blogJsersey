package service;

import model.Categories;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtils;

import java.util.List;

public class CategoriesService {
    private final SessionFactory factory= HibernateUtils.getSessionFactory();
    private final Session session=factory.getCurrentSession();
    public List<Categories> getAll(){
                List<Categories> list=List.of();
        try {
            session.getTransaction().begin();
            String hql="From Categories";
            list=session.createQuery(hql,Categories.class).list();
            session.getTransaction().commit();

        }
        catch (Exception e){
            session.getTransaction().rollback();
        }
        return list;
    }
    public Categories get(int id){
        try {
            session.getTransaction().begin();
            Categories categories=session.load(Categories.class,id);
            session.getTransaction().commit();
            return categories;
        }
        catch (Exception e){
            session.getTransaction().rollback();
        }
        return null;
    }
    public void delete(int id){
        try{
            session.getTransaction().begin();
            Categories categories=session.load(Categories.class,id);
            session.delete(categories);
            session.getTransaction().commit();
        }
        catch (Exception e){
            session.getTransaction().rollback();
        }

    }
    public void add(Categories categories){
        try {
            session.getTransaction().begin();
            session.save(categories);
            session.getTransaction().commit();
        }
        catch (Exception e){
            session.getTransaction().rollback();
        }

    }
    public void update(Categories categories){
        try {

            session.getTransaction().begin();
            session.update(categories);
            session.getTransaction().commit();
        }
        catch (Exception e){
            session.getTransaction().rollback();
        }

    }
}
