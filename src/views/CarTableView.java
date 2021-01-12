package views;

import java.time.LocalDate;

import entities.Car;
import enums.CarColor;
import enums.Transmission;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

/**
 * The view of the tableview which shows the cars.
 *
 * @author Mohammed Al-Ashtal, Daniel Weiser
 *
 */

public class CarTableView extends GridPane {

	TableView<Car> carTableView = new TableView<Car>();
	CarInformationView carInformationView;

	public CarTableView() {

		this.updated();

	}

	/*
	 * This method creates the tableview.
	 */

	private void updated() {

		Label testLabel = new Label("Hello, I'am the CarTableView");

		this.add(testLabel, 0, 0);

		this.setPadding(new Insets(10,10,10,10));
		this.setVgap(15);


		TableColumn<Car, Integer> carIdColumn = new TableColumn<>("Car ID");
		TableColumn<Car, String> brandNameColumn = new TableColumn<>("Brandname");
		TableColumn<Car, String> modelColumn = new TableColumn<>("Model");
		TableColumn<Car, LocalDate> dateOfReleaseColumn = new TableColumn<>("Date of Release");
		TableColumn<Car, Integer> mileageColumn = new TableColumn<>("Mileage");
		TableColumn<Car, Transmission> transmissionColumn = new TableColumn<>("Transmission");
		TableColumn<Car, Integer> powerColumn = new TableColumn<>("Power");
		TableColumn<Car, String> fuelColumn = new TableColumn<>("Fuel");
		TableColumn<Car, CarColor> colorColumn = new TableColumn<>("Color");
		TableColumn<Car, String> statusColumn = new TableColumn<>("Status");
		TableColumn<Car, Double> priceColumn = new TableColumn<>("Price");

		carIdColumn.setCellValueFactory(new PropertyValueFactory<>("carId"));
		brandNameColumn.setCellValueFactory(new PropertyValueFactory<>("brandName"));
		modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
		dateOfReleaseColumn.setCellValueFactory(new PropertyValueFactory<>("dateOfRelease"));
		mileageColumn.setCellValueFactory(new PropertyValueFactory<>("mileage"));
		transmissionColumn.setCellValueFactory(new PropertyValueFactory<>("transmission"));
		powerColumn.setCellValueFactory(new PropertyValueFactory<>("power"));
		fuelColumn.setCellValueFactory(new PropertyValueFactory<>("fuel"));
		colorColumn.setCellValueFactory(new PropertyValueFactory<>("color"));
		statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

		this.carTableView.getColumns().add(carIdColumn);
		this.carTableView.getColumns().add(brandNameColumn);
		this.carTableView.getColumns().add(modelColumn);
		this.carTableView.getColumns().add(dateOfReleaseColumn);
		this.carTableView.getColumns().add(mileageColumn);
		this.carTableView.getColumns().add(transmissionColumn);
		this.carTableView.getColumns().add(powerColumn);
		this.carTableView.getColumns().add(fuelColumn);
		this.carTableView.getColumns().add(colorColumn);
		this.carTableView.getColumns().add(statusColumn);
		this.carTableView.getColumns().add(priceColumn);


		this.add(this.carTableView, 0, 1);


	}


	public TableView<Car> getCarTableView() {
		return this.carTableView;
	}

	public void setCarTableView(TableView<Car> carTableView) {
		this.carTableView = carTableView;
	}

}
