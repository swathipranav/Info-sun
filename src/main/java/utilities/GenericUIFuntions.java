package utilities;

public class GenericUIFuntions extends WebActions {

	public void waitForInvisibilityOfSaveButton() {
		for (int i = 1; i <= 100; i++) {
			if (!isElementDisplayed(facility.savebtn1)) {
				break;
			}
		}
	}

}
