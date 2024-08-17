package presentation;



import negocio.UserService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public class Main {

    public static void main(String[] args) throws SQLException {
        UserService userService = new UserService();
        //User user = userService.getUserById(1);
        //userService.create(1, "ale");
        //System.out.println("User: "+ userService.findAll());
        //List<UserPresentation> users = userService.findAll();
        List<Map<String, Object>> users = userService.findAllMapped();

        // Recorre la lista y imprime cada usuario
        //for (User user : users) {
        //    System.out.println("ID: " + user.getId() + ", Name: " + user.getName());
       // }
        for (Map<String, Object> userMap : users) {
            // Itera sobre las entradas del mapa y las imprime
            for (Map.Entry<String, Object> entry : userMap.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            System.out.println("------------"); // Separador para cada usuario
        }
    }
}
