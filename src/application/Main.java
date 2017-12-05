package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;


public class Main extends Application {
	Stage ventana1;

	@Override
	public void start(Stage primaryStage) {
		try {
			ventana1 = primaryStage;
			pantallaPrincipal();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
	private void pantallaPrincipal(){

		try {
			FXMLLoader carga1 = new FXMLLoader(getClass().getResource("../vistas/principal.fxml"));
			AnchorPane panel1 = carga1.load();

			Font.loadFont(getClass().getResourceAsStream("Recursos/fuentes/FunSized.ttf"),20);
			Font.loadFont(getClass().getResourceAsStream("Recursos/fuentes/KOMTXT__.ttf"),20);
			ventana1.setScene(new Scene(panel1));
			ventana1.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
