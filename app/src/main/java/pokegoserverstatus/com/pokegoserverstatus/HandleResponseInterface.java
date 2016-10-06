package pokegoserverstatus.com.pokegoserverstatus;

import org.json.JSONException;

public interface HandleResponseInterface {
    void handleResponse(String response) throws JSONException;
    void handleError();
}
