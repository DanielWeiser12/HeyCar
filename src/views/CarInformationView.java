package views;

import entities.Car;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * The view with the information of the selected car.
 *
 * @author Mohammed Al-Ashtal, Daniel Weiser
 *
 */

public class CarInformationView extends GridPane {

	public CarInformationView() {

		this.updated();
	}

	private void updated() {
		Label testLabel = new Label("Hello, it's me again. Test.");

		this.add(testLabel, 0, 0);




		//		TableView newView = this.carTableView.getCarTableView();

		//		if (this.carTableView.getCarInformation().getBrandName() != null) {
		//			brandNameLabel.setText("empty");
		//		} else {
		//
		//			brandNameLabel.setText(this.carTableView.getCarInformation().getBrandName());
		//		}

	}

	public void setCarInformation(Car selectedCar) {

		Label carIdLabel = new Label();
		Label brandNameLabel = new Label(selectedCar.getBrandName());
		Label modelLabel = new Label();
		Label dateOfReleaseLabel = new Label();
		Label mileageLabel = new Label();
		Label transmissionLabel = new Label();
		Label powerLabel = new Label();
		Label fuelLabel = new Label();
		Label colorLabel = new Label();
		Label statusLabel = new Label();
		Label priceLabel = new Label();

		this.add(brandNameLabel, 0, 1);
	}
}
