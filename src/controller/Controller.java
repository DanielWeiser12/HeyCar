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

/**
 * This is the controller of the MVC-Pattern. It connects the view with the
 * model. All important methods for the functionality of HeyCar are mentioned in
 * this class.
 *
 * @author Mohammed Al-Ashtal, Daniel Weiser
 *
 */

public class Controller {

	private Stage PrimaryStage;
	private CarTableView carTableView;
	private WizardView wizardView;
	private CarInformationView carInformationView;
	private DbDMLStatements dbDMLStatements;

	/*
	 * The Controller method initializes the primary stage and adds the different
	 * views to the mainview. The tableview gets filled with the cars from the
	 * database and the save-button is set on action.
	 */

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
		this.getCarInformation();

	}

	/*
	 * This method loads the cars from the database into the tableview.
	 */

	public void loadCarsIntoTableView() {

		ObservableList<Car> allCarsFromDb = FXCollections.observableArrayList(DbDMLStatements.getAllCarsFromDb());

		this.carTableView.getCarTableView().setItems(allCarsFromDb);

	}

	/*
	 * The save button gets its functionality.
	 */

	public void saveButtonAction() {
		this.wizardView.getSaveButton().setOnAction(event -> {
			Car ourCar = new CarBuilder().withBrandName(this.wizardView.getBrandNameCBox().getSelectionModel().getSelectedItem()).withBrandName(this.wizardView.getBrandTextField().getText())
					.withModel(this.wizardView.getModelCBox().getSelectionModel().getSelectedItem()).withModel(this.wizardView.getModelTextField().getText())
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

			this.wizardView.getBrandNameCBox().getItems().addAll(DbDMLStatements.getAllBrandsFromDb());

		});

	}

	/*
	 * The created car of the carwizardview is shown in the tableview.
	 */

	public void showCarInTableView(Car car) {

		ObservableList<Car> carList = FXCollections.observableArrayList();
		//		List<Car> allCarList = new ArrayList<>(carList);

		carList.add(car);

		System.out.println(carList);

		carList.forEach(element -> {

			this.carTableView.getCarTableView().getItems().add(element);


		});

	}
	// selected row of the tableView - and getting the items of it
	private void getCarInformation() {

		this.carTableView.getCarTableView().getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

			if(newValue != null) {


				Car selectedCar = newValue;

				System.out.println(selectedCar.getBrandName());


				this.carInformationView.setCarInformation(selectedCar);

			}

		});
	}
}

