package vistas;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class principalControlador implements Initializable{

	@FXML
	private AnchorPane panelLateral,fondo, difuminado;
	@FXML
	private ImageView mostrarPanel;

	public void trasladaImagenes(double duracion,Node node,double ejeX){
		TranslateTransition traslado = new TranslateTransition(Duration.seconds(duracion),node);
		traslado.setByX(ejeX);
		traslado.play();
	}
	int mostrando =0;
	public void initialize(URL location, ResourceBundle resources){
		trasladaImagenes(0.5,panelLateral,-200);
		difuminado.setVisible(false);
		FadeTransition fadeTransition=new FadeTransition(Duration.seconds(0.5),difuminado);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

		fondo.setOnMouseClicked(event ->{
			if (mostrando == 1) {
				difuminado.setVisible(false);
				FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(0.5),difuminado);
	            fadeTransition1.setFromValue(0.20);
	            fadeTransition1.setToValue(0);
	            fadeTransition1.play();
				trasladaImagenes(0.5,panelLateral,-200);
				mostrando--;
			}
		});
	}


	@FXML
	public void mostrarPanelLateral(ActionEvent evento){
		if (mostrando == 0) {
			difuminado.setVisible(true);
			FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(0.5),difuminado);
            fadeTransition1.setFromValue(0);
            fadeTransition1.setToValue(0.15);
            fadeTransition1.play();
			trasladaImagenes(0.5,panelLateral,+200);
			mostrando++;

		}else{
			difuminado.setVisible(false);
			FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(0.5),difuminado);
            fadeTransition1.setFromValue(0.20);
            fadeTransition1.setToValue(0);
            fadeTransition1.play();
			trasladaImagenes(0.5,panelLateral,-200);
			mostrando--;
		}


	}
}
