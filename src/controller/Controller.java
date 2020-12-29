package controller;

import database.DbDMLStatements;
import entities.Car;
import entities.CarBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import views.CarInformationView;
import views.CarTableView;
import views.MainView;
import views.WizardView;

public class Controller {

	Stage PrimaryStage;
	CarTableView carTableView;
	WizardView wizardView;
	CarInformationView carInformationView;
	DbDMLStatements dbDMLStatements;

	public Controller(Stage primaryStage) {

		MainView mainView = new MainView();
		Scene scene = new Scene(mainView);
		scene.getStylesheets().add(this.getClass().getResource("/application/application.css").toExternalForm());
		this.PrimaryStage = primaryStage;
		primaryStage.sizeToScene();
		primaryStage.setTitle("Moe's and Daniel's HeyCar");
		primaryStage.setScene(scene);
		primaryStage.show();

		this.carTableView = mainView.getCarTableView();
		this.wizardView = mainView.getWizardView();
		this.carInformationView = mainView.getCarInformationView();

		this.loadCarsIntoTableView();

		this.saveButtonAction();

	}

	public void loadCarsIntoTableView() {

		ObservableList allCarsFromDb = FXCollections.observableArrayList(DbDMLStatements.getAllCarsFromDb());

		this.carTableView.getCarTableView().setItems(allCarsFromDb);

	}

	public void saveButtonAction() {
		this.wizardView.getSaveButton().setOnAction(event -> {
			Car ourCar = new CarBuilder().withBrandName(this.wizardView.getBrandNameCBox().getSelectionModel().getSelectedItem())
					.withModel(this.wizardView.getModelCBox().getSelectionModel().getSelectedItem())
					.withDateOfRelease(this.wizardView.getDateOfReleasePicker().getValue())
					.withMileage(Integer.parseInt(this.wizardView.getMileageTextField().getText()))
					.withTransmission(this.wizardView.getTransmissionCBox().getSelectionModel().getSelectedItem())
					.withPower(Integer.parseInt(this.wizardView.getPowerTextField().getText()))
					.withFuel(this.wizardView.getFuelCBox().getSelectionModel().getSelectedItem())
					.withColor(this.wizardView.getColorCBox().getSelectionModel().getSelectedItem())
					.withStatus(this.wizardView.getStatusCBox().getSelectionModel().getSelectedItem())
					.withPrice(Double.parseDouble(this.wizardView.getPowerTextField().getText())).create();
			System.out.println(ourCar);
			this.showCarInTableView(ourCar);
			DbDMLStatements.insertCarIntoDb(ourCar);

		});

	}

	public void showCarInTableView(Car car) {

		ObservableList<Car> carList = FXCollections.observableArrayList();
		//		List<Car> allCarList = new ArrayList<>(carList);

		carList.add(car);

		System.out.println(carList);

		carList.forEach(element -> {

			this.carTableView.getCarTableView().getItems().add(element);


		});

	}
}

