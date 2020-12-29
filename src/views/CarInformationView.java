package views;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class CarInformationView extends GridPane {

	public CarInformationView() {

		this.updated();
	}

	private void updated() {
		Label testLabel = new Label("Hello, it's me again. Test.");

		this.add(testLabel, 0, 0);

	}



}
