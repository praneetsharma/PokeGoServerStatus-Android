package pokegoserverstatus.com.pokegoserverstatus;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView) findViewById(R.id.textView);

        HandleResponse response = new HandleResponse();
        response.requestServerStatus();

        if (HandleResponse.serverStatus == HandleResponse.DOWN_STATUS) {
            tv.setText("DOWN");
            tv.setBackgroundColor(Color.RED);
            tv.setTextColor(Color.WHITE);
        } else if (HandleResponse.serverStatus == HandleResponse.OVERLOADED_STATUS) {
            tv.setText("OVERLOADED");
            tv.setBackgroundColor(Color.YELLOW);
            tv.setTextColor(Color.WHITE);
        } else if (HandleResponse.serverStatus == HandleResponse.UP_STATUS) {
            tv.setText("UP");
            tv.setBackgroundColor(Color.GREEN);
            tv.setTextColor(Color.WHITE);
        } else {
            tv.setText("UNKNOWN");
            tv.setBackgroundColor(Color.DKGRAY);
            tv.setTextColor(Color.WHITE);
        }
    }
}
