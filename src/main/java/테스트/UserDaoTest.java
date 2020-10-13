package study;

import org.h2.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class UserDaoTest
{
    public static void main( String[] args ) throws SQLException, ClassNotFoundException {
        ApplicationContext context  = new GenericXmlApplicationContext(""applicationContext.xml);
        UserDao Dao = Gontext.getBean("UserDao", UserDao.class);

        User user = new User();
        user.setId("user");
        user.setName("백기선");
        user.setPassword("married");

        dao.add(user);

        System.out.println(user.getId()+"등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getPassword());

        System.out.println(user2.getId()+"조회 성공");

        //자바에서 가장 손쉽게 실행 가능한 main메소드를 이용하낟.
        //테스트할 대상인 UserDao의 오브젝트를 가져와 메소드를 호출한다.
        //태스트에 사용할 입력 값을 직접 코드에서 만들어 넣어준다.
        //테스트의 결과를 콘솔에 출력해준다.
        //가 간계의 작업이 에러 없이 끝나면 콘솔에 성공 메시지로 출력해준다.
    }
}
