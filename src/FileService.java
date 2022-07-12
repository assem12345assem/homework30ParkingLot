import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class FileService {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path PATH = Paths.get("./parkingLot.json");
    public static List<ParkingLog> readFile() {
        Type itemsMapType = new TypeToken<Map<String, List<ParkingLog>>>() {}.getType();
        String json;
        try {
            json = Files.readString(PATH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<ParkingLog> parkingLot = GSON.fromJson(json, itemsMapType);
        return parkingLot;
    }

    public static void writeFile(List<ParkingLog> parkingLogs) {
        String json =GSON.toJson(parkingLogs);
        try {
            byte[] arr = json.getBytes();
            Files.write(PATH, arr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
