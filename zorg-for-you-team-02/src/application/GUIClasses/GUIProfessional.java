package application.GUIClasses;

import application.BackEndClasses.LeftPanel;
import application.abstractClasses.LeftPanelGUI;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GUIProfessional extends LeftPanelGUI {

    public GUIProfessional(){
        setUpLeftPanel();

        Pane root2 = new Pane();

        Button btnFAQ = new Button("FAQ");
        btnFAQ.setLayoutX(100);
        btnFAQ.setLayoutY(80);

        Button btnChat = new Button("Chat");
        btnChat.setLayoutX(100);
        btnChat.setLayoutY(175);

        Button btnNoodNummers = new Button("Noodnummers");
        btnNoodNummers.setLayoutX(100);
        btnNoodNummers.setLayoutY(272.5);

        root2.getChildren().addAll(btnFAQ, btnChat, btnNoodNummers);
        root2.getStylesheets().add("application/stylesheets/styleOptMenu.css");

        root.setCenter(root2);

        Stage primaryStage = new Stage();
        primaryStage.setTitle("Professional Scherm");
        primaryStage.setScene(new Scene(root,600,600));
        primaryStage.show();

        new LeftPanel(btnYouth, btnHome, btnProfessional, btnRefugee, btnSenior, primaryStage);
    }
}
