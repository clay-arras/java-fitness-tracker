package persistence;

import org.json.JSONObject;

// Citation: adapted from Felix
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}

