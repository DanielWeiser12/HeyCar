package views;

import java.time.LocalDate;

import control.CarWizardComboBox;
import control.NumOnlyTf;
import enums.CarColor;
import enums.Transmission;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class WizardView extends GridPane {

	private CarWizardComboBox<String> brandNameCBox = new CarWizardComboBox();
	private CarWizardComboBox<String> modelCBox = new CarWizardComboBox();
	private CarWizardComboBox<Transmission> transmissionCBox = new CarWizardComboBox();
	private CarWizardComboBox<String> fuelCBox = new CarWizardComboBox();
	private CarWizardComboBox<CarColor> colorCBox = new CarWizardComboBox();
	private CarWizardComboBox<String> statusCBox = new CarWizardComboBox();

	private DatePicker dateOfReleasePicker = new DatePicker();

	private NumOnlyTf mileageTextField = new NumOnlyTf();
	private NumOnlyTf powerTextField = new NumOnlyTf();
	private NumOnlyTf priceTextField = new NumOnlyTf();

	private Button saveButton = new Button("Save your car");

	public WizardView() {
		this.updated();
	}

	private void updated() {

		Label firstLabel = new Label("Options");
		Label brandNameLabel = new Label("Brand:");
		Label modelLabel = new Label("Model:");
		Label dateOfReleaseLabel = new Label("Date of Release:");
		Label mileageLabel = new Label("Mileage:");
		Label transmissionLabel = new Label("Transmission:");
		Label powerLabel = new Label("Power:");
		Label fuelLabel = new Label("Fuel:");
		Label colorLabel = new Label("Color:");
		Label statusLabel = new Label("Status:");
		Label priceLabel = new Label("Price:");
		firstLabel.setId("label");


		this.dateOfReleasePicker.setPrefWidth(300);
		this.dateOfReleasePicker.setValue(LocalDate.now());

		this.mileageTextField.setPromptText("Please note down the mileage");
		this.mileageTextField.setText("2500");

		this.powerTextField.setPromptText("Please note down the power");
		this.powerTextField.setText("230");

		this.priceTextField.setPromptText("Please note down the price");
		this.priceTextField.setText("2999");


		this.modelCBox.getItems().add("Please choose a brand first");

		this.modelCBox.getSelectionModel().selectFirst();

		this.brandNameCBox.getItems().addAll("Volkswagen", "Skoda", "Audi");

		this.brandNameCBox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {

			this.modelCBox.getItems().clear();

			if (newValue == "Volkswagen") {

				this.modelCBox.getItems().addAll("Golf", "Passat", "ID.3");

			} else if (newValue == "Skoda"){

				this.modelCBox.getItems().addAll("Model1", "Model2", "Model3");

			} else {

				this.modelCBox.getItems().addAll("A8", "A6", "A3");
			}
		});


		this.transmissionCBox.getItems().addAll(Transmission.MANUAL, Transmission.AUTOMATIC);
		this.transmissionCBox.getSelectionModel().selectFirst();
		this.fuelCBox.getItems().addAll("Petrol", "Diesel", "Electric", "Other");
		this.fuelCBox.getSelectionModel().selectFirst();
		this.colorCBox.getItems().addAll(CarColor.BLACK, CarColor.BLUE, CarColor.CYAN, CarColor.GRAY, CarColor.GREEN, CarColor.MAGENTA, CarColor.RED, CarColor.WHITE, CarColor.YELLOW);
		this.colorCBox.getSelectionModel().selectFirst();
		this.statusCBox.getItems().addAll("new", "used car", "damaged car");
		this.statusCBox.getSelectionModel().selectFirst();

		this.setVgap(10);
		this.setHgap(5);


		this.add(firstLabel, 0, 0);
		this.add(brandNameLabel, 0, 1);
		this.add(this.brandNameCBox, 1, 1);
		this.add(modelLabel, 0, 2);
		this.add(this.modelCBox, 1, 2);
		this.add(dateOfReleaseLabel, 0, 3);
		this.add(this.dateOfReleasePicker, 1, 3);

		this.add(mileageLabel, 0, 4);
		this.add(this.mileageTextField, 1, 4);
		this.add(transmissionLabel, 0, 5);
		this.add(this.transmissionCBox, 1, 5);
		this.add(powerLabel, 0, 6);
		this.add(this.powerTextField, 1, 6);
		this.add(fuelLabel, 0, 7);
		this.add(this.fuelCBox, 1, 7);
		this.add(colorLabel, 0, 8);
		this.add(this.colorCBox, 1, 8);
		this.add(statusLabel, 0, 9);
		this.add(this.statusCBox, 1, 9);
		this.add(priceLabel, 0, 10);
		this.add(this.priceTextField, 1, 10);
		this.add(this.saveButton, 0, 15);

	}


	public CarWizardComboBox<String> getBrandNameCBox() {
		return this.brandNameCBox;
	}

	public CarWizardComboBox<String> getModelCBox() {
		return this.modelCBox;
	}

	public CarWizardComboBox<Transmission> getTransmissionCBox() {
		return this.transmissionCBox;
	}

	public CarWizardComboBox<String> getFuelCBox() {
		return this.fuelCBox;
	}

	public CarWizardComboBox<CarColor> getColorCBox() {
		return this.colorCBox;
	}

	public CarWizardComboBox<String> getStatusCBox() {
		return this.statusCBox;
	}

	public DatePicker getDateOfReleasePicker() {
		return this.dateOfReleasePicker;
	}

	public NumOnlyTf getMileageTextField() {
		return this.mileageTextField;
	}

	public NumOnlyTf getPowerTextField() {
		return this.powerTextField;
	}

	public NumOnlyTf getPriceTextField() {
		return this.priceTextField;
	}

	public Button getSaveButton() {
		return this.saveButton;
	}



}
