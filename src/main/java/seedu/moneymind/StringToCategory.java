package seedu.moneymind;

import java.util.ArrayList;

/**
 * Converts a String from file.txt to an ArrayList of Category objects.
 */
public class StringToCategory extends CategoryToString{
    /**
     * Converts a String from file.txt to an ArrayList of Category objects.
     * 
     * @param inputFromFile String from file.txt
     * @return ArrayList of Category objects
     */
    public static ArrayList<Category> stringToCategory(String inputFromFile) {
        // ArrayList of Categories objects, to be returned
        ArrayList<Category> categories = new ArrayList<>();

        // Reads inputFromFile line by line
        String[] lines = inputFromFile.split(System.lineSeparator());
        for (String string : lines) {
            // Creates a new Category object if the line is a new category, ignoring the save file symbol
            if (string.startsWith(CATEGORY_NAME)) {
                categories.add(new Category(string.substring(CATEGORY_NAME.length())));
            } else if (string.startsWith(NEXT_VARIABLE)) {
                // Remove the first next variable symbol
                string = string.substring(NEXT_VARIABLE.length());
                // Splits the line into 3 parts, each part being a variable of an Event object
                String[] eventDetails = string.split(NEXT_VARIABLE);
                // Creates a new Event object
                Event event = new Event(eventDetails[0], Integer.parseInt(eventDetails[1]),
                        Integer.parseInt(eventDetails[2]));
                // Adds an Event object to the last Category object in the ArrayList
                categories.get(categories.size() - 1).addEvent(event);
            }
        }
        return categories;
    }
}
