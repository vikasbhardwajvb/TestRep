import com.google.gson.Gson;

public class JsonParser {

    private final Gson gson;

    public JsonParser() {
        this.gson = new Gson();
    }

    public <T> T parseJsonToList(String json, Class<T> modelClass) {
        return gson.fromJson(json, modelClass);
    }
}
