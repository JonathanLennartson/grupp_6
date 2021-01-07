package skidor;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class XMLhandler {
	private static final String SERIALIZED_FILE_NAME = "Competitors.xml";

	static XMLEncoder encoder = null;
	static XMLDecoder decoder = null;
	static ArrayList<Competitor> list;

	public static void encode(ArrayList<Competitor> name) {
		try {
			encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(SERIALIZED_FILE_NAME)));
			System.out.println("File stream opened and XMLEncoder created");

		} catch (FileNotFoundException fileNotFound) {
			System.out.println("Ett fel har inträffat: " + SERIALIZED_FILE_NAME + " kunde inte hittas eller öppnas.");
		}
		encoder.writeObject(name);
		System.out.println("Object written");
		encoder.flush();
		encoder.close();
		System.out.println("File stream closed");

	}

	@SuppressWarnings("unchecked")
	public static void decode() {
		try {
			decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(SERIALIZED_FILE_NAME)));
			System.out.println("File stream opened and XMLDecoder created");

		} catch (FileNotFoundException e) {
			System.out.println("Ett fel har inträffat: " + SERIALIZED_FILE_NAME + " kunde inte hittas eller öppnas.");
		}

		XMLhandler.list = new ArrayList<Competitor>();
		try {
			list = (ArrayList<Competitor>) decoder.readObject();
			System.out.println("File decoded");
			decoder.close();
			System.out.println("File stream closed");

		} catch (NullPointerException e) {

		}
	}

}
