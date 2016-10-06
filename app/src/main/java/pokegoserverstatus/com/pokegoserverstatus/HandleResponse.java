package pokegoserverstatus.com.pokegoserverstatus;

import android.util.Log;

import org.json.JSONException;

public class HandleResponse implements HandleResponseInterface {

    public static int serverStatus = -1;

    @Override
    public void handleResponse(String response) throws JSONException {
        String value = response.split("h2")[1].split("=")[1].split("\"")[1];
        if(value.equals("green"))
            this.serverStatus = 2;
        else if(value.equals("yellow") || value.equals("orange"))
            this.serverStatus = 1;
        else if(value.equals("red"))
            this.serverStatus = 0;
    }

    @Override
    public void handleError() {
        Log.d("Something Happened", "Error!!!?!");
    }

    public void requestServerStatus() {
        Request createUserRequest = new Request(this);
        createUserRequest.executeGetRequest();
    }
}
