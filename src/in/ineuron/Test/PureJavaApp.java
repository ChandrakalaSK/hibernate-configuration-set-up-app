package in.ineuron.Test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.ineuron.Model.Student;
import in.ineuron.Util.HibernateUtil;

public class PureJavaApp {

	public static void main(String[] args) throws IOException {
		
		SessionFactory sessionFactory=null;
		Session  session=null;
		
		int id=2;
		
		try {
		
			//Setting properties for configuration object using pure java code.
			Configuration configuration = new Configuration();
			configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
			configuration.setProperty("hibernate.connection.url", "jdbc:mysql:///octbatch");
			configuration.setProperty("hibernate.connection.username", "root");
			configuration.setProperty("hibernate.connection.password", "root");
			
			configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
			configuration.setProperty("hibernate.show_sql", "true");
			configuration.setProperty("hibernate.format_sql", "true");
			configuration.setProperty("hibernate.hbm2ddl.auto", "update");
			
			configuration.configure();
			
			//Provided mapping information about mapping file
			configuration.addAnnotatedClass(Student.class);
			
			 sessionFactory = configuration.buildSessionFactory();
			
			session = sessionFactory.openSession();
			
		Student student=session.get(Student.class,id);
		System.out.println("Before updation in the table :: " + student);
		
		if(student != null)
		{
			
			
			System.out.println("After updation in the table :: " + student);
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
			
			
			
			
		}

	}
}

