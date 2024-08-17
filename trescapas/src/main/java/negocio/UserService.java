package negocio;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data.User;
import data.UserDao;
public class UserService {

    private UserDao userDao;
    private User user;
    public UserService() {
        //this.userDao = userDao;
        userDao= new UserDao();
    }

    public User create(int id,String Name,String lastaname ) throws SQLException{
        User user= new User(id,Name,lastaname);
        userDao.createUser(user);
        return user;

    }
    /*
    public List<User> findAll() throws SQLException {
        return this.userDao.findAll();
    }
   */

    public List<Map<String, Object>> findAllMapped() throws SQLException {
        List<User> users = this.userDao.findAll();
        List<Map<String, Object>> result = new ArrayList<>();
        for (User user : users) {
            Map<String, Object> userMap = new HashMap<>();
            userMap.put("id", user.getId());
            userMap.put("name", user.getName());
            userMap.put("lastname",user.getLastname());
            // Agrega otros campos necesarios
            result.add(userMap);
        }
        return result;
    }




    /* public User getUserById(int id) {
        // Aquí puedes agregar lógica adicional si es necesario
        //return userDao.findById(id);
    } */





}
