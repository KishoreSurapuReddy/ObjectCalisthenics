package com.bridgelabz.addressbook;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@JsonSerialize 
public class AddressBookDAOImpl implements AddressBookDAO {
	Scanner scanner = new Scanner(System.in);
	String addressFile = "/home/user/Desktop/addressbook.json";
	
	public void addPerson(Person person, String firstName) throws IOException, ParseException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibilityChecker(mapper.getSerializationConfig().getDefaultVisibilityChecker().
				withFieldVisibility(JsonAutoDetect.Visibility.ANY).withGetterVisibility(JsonAutoDetect.Visibility.NONE)
				                .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
				                .withCreatorVisibility(JsonAutoDetect.Visibility.NONE));
		String jsoninstring = null;
		try {
			jsoninstring = mapper.writeValueAsString(person);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writeDetailsToJson(jsoninstring,firstName);
	}

	@SuppressWarnings("unchecked")
	private void writeDetailsToJson(String jsoninstring, String firstName) throws IOException, ParseException {
		String fileReader = addressFile;
		JSONObject jsonobject = readFile(fileReader);
		JSONArray array = new JSONArray();
		array.add(jsoninstring);
		jsonobject.put(firstName, array);
		writeFile(addressFile, jsonobject);
	}

	@Override
	public void deletePerson(String firstName) throws IOException, ParseException {
		String fileReader = addressFile;
		JSONObject jsonobject = readFile(fileReader);
		jsonobject.remove(firstName);
		String filewriter = addressFile;
		writeFile(filewriter, jsonobject);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void editPerson(String firstName) throws IOException, ParseException {
		try {
			String fileReader = addressFile;
			JSONObject jsonobject = readFile(fileReader);
			if (jsonobject.get(firstName) != null) {
				JSONArray jsonarray = (JSONArray) jsonobject.get(firstName);
				JSONObject json = (JSONObject) new JSONParser().parse((String) jsonarray.get(0));
				json.forEach((key, value) -> {
					if (!key.equals(firstName)) {
						System.out.println(key + "\t\t" + value);
						int num = 0;
						try {
							System.out.println("enter 1 to edit the details or press any key");
							num = scanner.nextInt();
						} catch (Exception e) {
							System.out.println("enter digits only..");
						}
						if (num == 1) {
							System.out.println("enter the details :");
							if (key.equals("zipCode") || key.equals("phoneNumber")) {
								json.put(key, scanner.nextInt());
							} else {
								json.put(key, scanner.next());
							}
						}
					}
				});
				System.out.println("after change :");
				json.forEach((key, value) -> System.out.println(key + "\t\t" + value));
				jsonarray.add(json);
				jsonobject.put(firstName, jsonarray);
				String filewriter = addressFile;
				writeFile(filewriter, jsonobject);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void searchEntries(String firstname) throws IOException, ParseException {
		try {
			String fileReader = addressFile;
			JSONObject jsonobject = readFile(fileReader);
			JSONArray jsonarray = null;
			try {
				jsonarray = (JSONArray) jsonobject.get(firstname);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(jsonarray);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void saveAddressBook(String addressBookName) throws IOException, ParseException {
		try {
			String fileReader = addressFile;
			JSONObject jsonobject = readFile(fileReader);
			FileWriter filewriter = new FileWriter("/home/user/Desktop/" + addressBookName + ".json");
			filewriter.write(jsonobject.toJSONString());
			filewriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public JSONObject readFile(String file) throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		FileReader reader = new FileReader(file);
		Object object = parser.parse(reader);
		JSONObject json = (JSONObject) object;
		return json;
	}
	
	public void writeFile(String file, JSONObject object) throws IOException {
		FileWriter filewriter = new FileWriter(file);
		filewriter.write(object.toJSONString());
		filewriter.close();
	}
}
