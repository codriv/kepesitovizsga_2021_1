package hu.nive.ujratervezes.kepesitovizsga.phonebook;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Phonebook {

    public void exportPhonebook(Map<String, String> contacts, String output) {
        if (contacts == null || output == null) {
            throw new IllegalArgumentException("Parameter is null!");
        } else {
            Path path = Path.of(output);
            List<String> entries = new ArrayList<>();
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                entries.add(String.join(": ", entry.getKey(), entry.getValue()));
            }
            writeFile(path, entries);
        }
    }

    private void writeFile(Path path, List<String> entries) {
        try {
            Files.write(path, entries);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file!");
        }
    }
}
