package com.bridgelabz.addressbook;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileSystem {
	
	/**readFile function is used to read the data from JSONFile
	 * @param file
	 * @return JSONObject
	 * @throws IOException
	 * @throws ParseException
	 */
	public JSONObject readFile(String file) throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		FileReader reader = new FileReader(file);
		Object object = parser.parse(reader);
		JSONObject json = (JSONObject) object;
		return json;
	}
	
	/**writeFile function is used to write the data into JSONFile
	 * @param file
	 * @param object
	 * @throws IOException
	 */
	public void writeFile(String file, JSONObject object) throws IOException {
		FileWriter filewriter = new FileWriter(file);
		filewriter.write(object.toJSONString());
		filewriter.close();
	}
}
