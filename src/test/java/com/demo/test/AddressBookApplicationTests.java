package com.demo.test;

import com.demo.data.utility.HibernateUtility;
import com.demo.domain.model.User;
import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressBookApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void  testUserCreation()
	{
		Session session =  HibernateUtility.getSessionFactory().openSession();
		session.beginTransaction();

		User user = new User();
		user.setFirstName("demo");
		user.setLastName("user");
		user.setEmail("demo@mail.com");

		int createdId = (int) session.save(user);
		session.getTransaction().commit();

		User createdUser = session.get(User.class, createdId);
		session.close();

		System.out.println(user.getEmail());
		System.out.println(createdUser.getEmail());

		assert(createdUser.getEmail().equals(user.getEmail()));
	}

}
