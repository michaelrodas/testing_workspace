package poc.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import poc.dto.JsonStore;

import java.io.IOException;
import java.net.URL;

@Slf4j
public class StoreProviderImpl {

    private StoreProviderImpl() {}

    public static JsonStore getFileMappedToObject() {
        JsonStore jsonStore = null;
        try {
            log.info("Loading stores from JSON file...");
            URL sourceFile = StoreProviderImpl.class.getClassLoader().getResource("stores.json");
            jsonStore = new ObjectMapper().readValue(sourceFile, JsonStore.class);
        } catch (IOException | IllegalArgumentException e) {
            log.error("Unable to load JSON file", e);
        }
        return jsonStore == null ? new JsonStore() : jsonStore;
    }
}
