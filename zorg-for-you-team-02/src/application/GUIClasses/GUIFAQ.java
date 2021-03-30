package application.GUIClasses;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.sql.*;
import java.util.ArrayList;

public class GUIFAQ {

    private String zoekterm, antwoorden, antwoord, sVraag_id;
    private final TextArea taOutput;
    private final TextField txtZoek;
    private int vraag_id;
    private ArrayList<String> antwoordenLijst;

    public GUIFAQ(Stage primaryStage) throws Exception {
        GridPane root = new GridPane();
        Scene scene = new Scene(root, 300, 275);

        taOutput = new TextArea();

        txtZoek = new TextField();
        txtZoek.setPromptText("Voer zoekterm(en) in");

        Button btnZoek = new Button("Zoek");
        btnZoek.setOnAction(s-> {
            search();
        });

        root.add(txtZoek, 0,0);
        root.add(btnZoek, 1,0);
        root.add(taOutput, 0,1);

        scene.setOnKeyPressed(s-> {
            KeyCode keyCode = s.getCode();
            if(keyCode.equals(KeyCode.ENTER)) {
                search();
            }
        });

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void search() {
        antwoordenLijst = new ArrayList<>();
        antwoorden = "";
        antwoord = "";
        sVraag_id = "";
        taOutput.setText("");

        try {
            //zoektermen ophalen uit textField
            zoekterm = txtZoek.getText();

            //controleren of is ingevuld of niet
            if (zoekterm.equals("")) {
                taOutput.setText("Vul een zoekterm in");
            } else {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://sql11.freesqldatabase.com/sql11395386", "sql11395386", "pMb5y6tPZQ");

                //query opstellen
                String query = "SELECT antwoord, id FROM hulp_vragen WHERE vraag LIKE '%" + zoekterm + "%' OR zoektermen LIKE '%" + zoekterm + "%' OR categorie LIKE '%" + zoekterm + "%'";

                //conn wordt aangemaakt bij de database connectie
                Statement stZoek = con.createStatement();

                //query uitvoeren en java result set aanmaken
                ResultSet rsZoek = stZoek.executeQuery(query);

                //door resultset heen wandelen zolang er een volgend resultaat is
                while (rsZoek.next()) {
                    //data ophalen uit database en plaatsen in arraylist
                    vraag_id = rsZoek.getInt("id");
                    antwoord = rsZoek.getString("antwoord");
                    sVraag_id = Integer.toString(vraag_id);

                    antwoordenLijst.add(antwoord + " | " + sVraag_id);
                }

                System.out.println(antwoordenLijst);

                for (String s : antwoordenLijst) {
                    //uitprinten van de variabelen uit database
                    s = s + "\n" + taOutput.getText();
                    taOutput.setText(s);
                }

                //statement sluiten
                stZoek.close();
            }

        } catch (Exception e) {
            //error teruggeven
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

}
