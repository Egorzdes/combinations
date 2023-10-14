package sber_project.proj.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.ArrayList;

public class ArrayListDeserializer extends JsonDeserializer<ArrayList<String>> {

    @Override
    public ArrayList<String> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String value = jsonParser.readValueAs(String.class);
        String[] elements = value.split(",");
        ArrayList<String> arrayList = new ArrayList<>();
        for (String element : elements) {
            arrayList.add(element.trim());
        }
        return arrayList;
    }
}
