package com.tasnim.aast;


public class Main {

    public static void main(String[] args) {
        DonationSystem donationSystem = new DonationSystem();
       donationSystem.singUpIndividual("asas","asa","asas","asas","arrrrrr","arsani", "12345",true, "Ahmed", "Essam");
        System.out.println(donationSystem.loginIndividual("ahmed","1234"));
    }
}


//package com.tasnim.aast;
//
//        import javafx.application.Application;
//        import javafx.fxml.FXMLLoader;
//        import javafx.scene.Parent;
//        import javafx.scene.Scene;
//        import javafx.stage.Stage;
//
//        import java.io.File;
//        import java.net.URL;
//
//public class Main extends Application {
//
//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        URL url = new File("src/com/tasnim/aast/sample.fxml").toURI().toURL();
//        Parent root = FXMLLoader.load(url);        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
//    }
//
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}
