package 테스트.UserDaoTest개선;

import javafx.application.Application;

import java.sql.SQLException;

public class UserDaoTest {
    public void addAndGet()throws SQLException{
        ApplicationContext context = new
                ClassOathXmlApplicationContext("applicationContext.xml");
        UserDao dao = context.getBean("UserDao", UserDao.class);

        User user = new User();
        user.setId("gyumee");
        user.setName("박상철");
        user.setPassword("springno1");

        doa.add(user);

        user user2 = dao.get(user.getId());

        assertThat(user2.getName(), is(user.getName()));
        assertThat(user2.getPassword(), is(user.getPassword()));

    }
}
