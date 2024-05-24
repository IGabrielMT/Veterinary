package co.edu.uptc.model.assets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

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
            return (ArrayList<?>) gson.fromJson(fileName, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
