package 테스트.UserDaoTest개선;

import javafx.application.Application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoTest {
    private UserDao dao;
    private User user1;
    private User user2;
    private User user3;

    @Before
    public void setUp(){
        ApplicationContext context = new
                ClassOathXmlApplicationContext("applicationContext.xml");
        this.dao = context.getBean("UserDao", UserDao.class);

        this.user1 =  new User("aaa1","bbb1","ccc1");
        this.user2 =  new User("aaa2","bbb2","ccc2");
        this.user3 =  new User("aaa3","bbb3","ccc3");
    }

    @Test
    public void addAndGet()throws SQLException{

        dao.deleteAll();
        asserThat(dao.getCount(),is(0));

        User user1 =  new User("aaa1","bbb1","ccc1");
        User user2 =  new User("aaa2","bbb2","ccc2");
        User user3 =  new User("aaa3","bbb3","ccc3");

        dao.add(user1);
        asserThat(doa.getCount,is(1));

        User user = dao.get(user1.getId());

        assertThat(user.getName(), is(user.getName()));
        assertThat(user.getPassword(), is(user.getPassword()));


    }
    @Test
    public void count() throws SQLException{


        User user1 =  new User("aaa1","bbb1","ccc1");
        User user2 =  new User("aaa2","bbb2","ccc2");
        User user3 =  new User("aaa3","bbb3","ccc3");

        dao.deleteAll();
        assertThat(dao.getCount(),is(0));

        dao.add(user1);
        dao.add(user2);
        dao.add(user3);
        assertThat(dao.getCount(),is(2));

        User userget1 = dao.get(user1.getId());
        assertTha(userget1.getName(),is(user1.getName()));
        assertTha(userget1.getPassword(),is(user1.getPassword()));

        User userget2 = dao.get(user2.getId());
        assertTha(userget2.getName(),is(user2.getName()));
        assertTha(userget2.getPassword(),is(user2.getPassword()));
    }
    @Test(expected=EmptyResultAccessException.class)
    public void getUserFailure() throws SQLException{

        dao.deleteAll();
        assertThat(dao.getCount(),is(0));

        dao.get("unknow_id");
    }


}
