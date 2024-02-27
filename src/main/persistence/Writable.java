package persistence;

import org.json.JSONObject;

/*
Citation: adapted from Felix
Interface for classes in the package that need to be converted to JSON
 */
public interface Writable {
    /*
    EFFECTS: returns this as JSON object
     */
    JSONObject toJson();
}

