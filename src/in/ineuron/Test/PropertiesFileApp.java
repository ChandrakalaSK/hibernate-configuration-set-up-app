package in.ineuron.Test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.ineuron.Model.Student;
import in.ineuron.Util.HibernateUtil;

public class PropertiesFileApp {
public static void main(String[] args) throws IOException {
		
		SessionFactory sessionFactory=null;
		Session session=null;
		int id=2;
		
		try {
		Configuration configuration=new Configuration();//by default hibernate seraches for hibernate properties file
		
		configuration.configure();
		
		//Provided the information about mapping file
		configuration.addAnnotatedClass(Student.class);
		
		sessionFactory =configuration.buildSessionFactory();
		
		session =sessionFactory.openSession();
		
		Student student=session.get(Student.class,id);
		
	
		
		if(student != null)
		{
			System.out.println("Before updation in the table :: " + student);
			
			
		}
		else
		{
			System.out.println("Record available for the given id :: " + id);
		}
		}
		catch (HibernateException e) {
			e.printStackTrace();
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			
			
			
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
