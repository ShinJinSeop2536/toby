package 테스트.UserDaoTest개선;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public UserDao(){}

    public void add(User user ) throws SQLException {
//        Connection c  = dataSource.getConnection();
//
//        PreparedStatement ps  = c .prepareStatement("delete from users");
//
//        ps.execute();
//        ps.close();;
//        c.close();
    }
    public User get(String id) throws SQLException {

    public void deleteAll() throws SQLException {
        Connection c  = dataSource.getConnection();

        PreparedStatement ps  = c .prepareStatement("select *from users");
        ResultSet rs = ps.executeQuery();

        User user = null;
        if(rs.next()){
            user = new User();
            user.setId(rs.getString("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
        }
        rs.close();
        ps.close();;
        c.close();

        if(user==null) throw new EmptyResultDataAccessException();

        return user;
    }

    public int getCount() throws SQLException{
        Connection c  = dataSource.getConnection();

        PreparedStatement ps  = c .prepareStatement("select count(*) from user");
        ResultSet rs = ps.executeQuery();
        int count =  rs.getInt();

        rs.close();;
        ps.close();;
        c.close();

        return count;
    }

    public void deleteAll() throws SQLException{
        Connection c  = dataSource.getConnection();

        PreparedStatement ps  = c .prepareStatement("=delete from users");
        ps.executeUpdate();
        ps.close();;
        c.close();

    }
}
