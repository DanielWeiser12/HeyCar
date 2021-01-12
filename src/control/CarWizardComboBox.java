package control;

import javafx.scene.control.ComboBox;

/**
 * This class is a specific ComboBox with uniform width.
 *
 * @author Mohammed Al-Ashtal, Daniel Weiser
 *
 */

public class CarWizardComboBox<T> extends ComboBox<T> {

	public CarWizardComboBox() {
		super();
		this.setPrefWidth(300);
	}

}
