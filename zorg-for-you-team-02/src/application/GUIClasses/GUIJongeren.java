package application.GUIClasses;

import application.BackEndClasses.Jongeren;
import application.BackEndClasses.LeftPanel;
import application.abstractClasses.LeftPanelGUI;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GUIJongeren extends LeftPanelGUI {

    public GUIJongeren(Stage primaryStage) {
        setUpLeftPanel();

        Pane root2 = new Pane();

        root.setCenter(root2);

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

        primaryStage.setTitle("4-you");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

        new LeftPanel(btnYouth, btnHome, btnProfessional, btnRefugee, btnSenior, primaryStage);
        new Jongeren(btnChat, btnFAQ, btnNoodNummers, primaryStage);
    }
}
