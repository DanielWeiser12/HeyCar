package views;

import javafx.scene.layout.HBox;

public class MainView extends HBox {

	WizardView wizardView = new WizardView();
	CarTableView carTableView = new CarTableView();
	CarInformationView carInformationView = new CarInformationView();


	public MainView() {

		this.updated();

	}


	private void updated() {

		this.getChildren().add(this.wizardView);
		this.getChildren().add(this.carTableView);
		this.getChildren().add(this.carInformationView);

	}


	public WizardView getWizardView() {
		return this.wizardView;
	}


	public CarTableView getCarTableView() {
		return this.carTableView;
	}


	public CarInformationView getCarInformationView() {
		return this.carInformationView;
	}

}
