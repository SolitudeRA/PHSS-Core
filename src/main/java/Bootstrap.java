import controller.UserController;
import org.springframework.boot.SpringApplication;

public class Bootstrap {
    public static void main(String args[]) throws Exception {
        SpringApplication.run(UserController.class, args);
    }
}
