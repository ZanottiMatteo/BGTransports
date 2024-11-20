package utility;

import java.io.File;

public class Control {

	public static Boolean control(String json) {
		File jsonFile = new File(json);
		if (!jsonFile.exists()) {
			return false;
		}
		return true;
	}
}
