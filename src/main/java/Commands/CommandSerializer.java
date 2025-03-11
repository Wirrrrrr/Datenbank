package Commands;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CommandSerializer {
    private static final ObjectMapper mapper = new ObjectMapper();

    // Serialisiert ein Command-Objekt in JSON
    public static String serialize(Command<?> command) throws Exception {
        return mapper.writeValueAsString(command);
    }

    // Deserialisiert JSON zurück in ein Command-Objekt
    public static Command<?> deserialize(String json) throws Exception {
        return mapper.readValue(json, Command.class);
    }
}
