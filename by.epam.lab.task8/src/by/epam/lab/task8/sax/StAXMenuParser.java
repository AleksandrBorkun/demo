package by.epam.lab.task8.sax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;

import by.epam.lab.task8.entity.Dish;
import by.epam.lab.task8.transfer.MenuTagName;

public class StAXMenuParser {

	public static void main(String[] args) throws FileNotFoundException {

		XMLInputFactory inputFactory = XMLInputFactory.newInstance();

		try {

			InputStream input = new FileInputStream("../by.epam.lab.task8/res/menu-schema.xml");
			XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
			List<Dish> menu = process(reader);
			;

			for (Dish dish : menu) {
				System.out.println(dish.getTitle());
				System.out.println(dish.getPortion());
				;
			}
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}

	private static List<Dish> process(XMLStreamReader reader) throws XMLStreamException {

		List<Dish> menu = new ArrayList<>();
		Dish dish = null;
		MenuTagName elementName = null;
		while (reader.hasNext()) {

			// определение типа прочтенного эл-та

			int type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				elementName = MenuTagName.getElementTagName(reader.getLocalName());

				switch (elementName) {

				case DISH:
					dish = new Dish();
	//				Integer id = Integer.parseInt(reader.getAttributeValue(null, "id"));
	//				dish.setId(id);
					break;
				}
				break;

			case XMLStreamConstants.CHARACTERS:
				String text = reader.getText().trim();

				if (text.isEmpty()) {
					break;
				}

				switch (elementName) {

				case TITLE:
					dish.setTitle(text);
					break;
				case PRICE:
					dish.setPrice(text);
					break;
				case DESCRIPTION:
					dish.setDescription(text);
					break;
				case PORTION:
					dish.setPortion(text);
					break;

				}
				break;

			case XMLStreamConstants.END_ELEMENT:
				elementName = MenuTagName.getElementTagName(reader.getLocalName());

				switch (elementName) {

				case DISH:
					menu.add(dish);
				}

			}

		}
		return menu;
	}

}
