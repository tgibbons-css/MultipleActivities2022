package css.tgibbons.multipleactivities2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textViewData;
    String name;
    Double num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewData = (TextView) findViewById(R.id.textViewData);

        // Get data from Main Activity
        Bundle extras = getIntent().getExtras();
        name = extras.getString("MainName");
        num = extras.getDouble("MainNumber");
        textViewData.setText("Name : " + name + " Number : " + num);
    }

}