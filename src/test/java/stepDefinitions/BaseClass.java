package stepDefinitions;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.util.Properties;



public class BaseClass {


	// --------------Creating ConfigProperties File-----------------
	public static File file = new File("./src/test/resources/data/properties/config.properties");
	public static FileInputStream fis = null;
	public static Properties prop = new Properties();

	static {

		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// IMPLICITLY WAIT

	public static long getImplicitlyWait() {
		String implicitlyWait = prop.getProperty("IMPLICIT_WAIT");
		if (implicitlyWait != null)
			return Long.parseLong(implicitlyWait);
		else
			throw new RuntimeException("implicitlyWait not specified in the config.prop file.");
	}

	public Properties readPropertyFile(File file){
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public JSONObject readJSONFile(String fileName) {
		JSONParser jsonParser = new JSONParser();
		Object obj;
		JSONObject jsonObj = new JSONObject();
		try (FileReader reader = new FileReader(fileName)) {
			obj = jsonParser.parse(reader);
			jsonObj = (JSONObject) obj;
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return jsonObj;
	}

}
