package pokegoserverstatus.com.pokegoserverstatus;

import android.util.Log;

import org.json.JSONException;

public class HandleResponse implements HandleResponseInterface {

    public static int serverStatus = -1;

    public static int DOWN_STATUS = 0;
    public static int OVERLOADED_STATUS = 1;
    public static int UP_STATUS = 2;

    @Override
    public void handleResponse(String response) throws JSONException {
        String value = response.split("h2")[1].split("=")[1].split("\"")[1];
        if (value.charAt(0) == 'g')
            this.serverStatus = UP_STATUS;
        else if (value.charAt(0) == 'y' || value.charAt(0) == 'o')
            this.serverStatus = OVERLOADED_STATUS;
        else if (value.charAt(0) == 'r')
            this.serverStatus = DOWN_STATUS;
        /*if(value.equals("green"))
            this.serverStatus = 2;
        else if(value.equals("yellow") || value.equals("orange"))
            this.serverStatus = 1;
        else if(value.equals("red"))
            this.serverStatus = 0;*/
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
