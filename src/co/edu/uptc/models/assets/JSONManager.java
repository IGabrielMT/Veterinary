package co.edu.uptc.models.assets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Collection;

@SuppressWarnings("ALL")
public class JSONManager {
    public static void createJSONFileByCollection(String fileName, Collection<?> collection) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();

        String json = gson.toJson(collection);
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Collection<?> createCollectionByJSONFile(String fileName, Class<?> clazz) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();

        try {
            // Read the content of the file into a string
            String jsonContent = new String(Files.readAllBytes(Paths.get(fileName)));

            // Create a Type that represents a collection of clazz
            Type collectionType = TypeToken.getParameterized(Collection.class, clazz).getType();

            // Pass the string and the Type to the fromJson method
            return gson.fromJson(jsonContent, collectionType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
