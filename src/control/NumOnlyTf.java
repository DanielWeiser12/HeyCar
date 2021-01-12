package control;

import javafx.scene.control.TextField;

/**
 * This class defines that in this specific textfield only numbers can be used.
 *
 * @author Mohammed Al-Ashtal, Daniel Weiser
 *
 */

public class NumOnlyTf extends TextField {

	public NumOnlyTf() {

	}

	@Override
	public void replaceText(int start, int end, String text) {
		if (text.matches("[0-9]") || text.matches("")) {
			super.replaceText(start, end, text);
		}
	}
}