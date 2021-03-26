package rest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import rest.configs.RestTemplateConfig;
import rest.controllers.MyCommunicationController;
import rest.models.User;

import java.util.List;

public class App {
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(RestTemplateConfig.class);
        MyCommunicationController communicationController = context.getBean(MyCommunicationController.class);
        List<User> allUsers = communicationController.getAllUsers();
        answer.append(communicationController.saveNewUser());
//        answer.append(communicationController.updateUser3());
        answer.append(communicationController.editUser());
        answer.append(communicationController.deleteUser3(3));
        System.out.println(answer.toString());
    }
    //5ebfebe7cb975dfcf9
    //5ebfebe7cb975dfcf9
    //5ebfebe7cb975dfcf9
}
