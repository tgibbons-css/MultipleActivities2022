package css.tgibbons.multipleactivities2022;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    TextView textViewData;
    EditText editTextMessage;
    Button buttonReturn;
    String name;
    Double num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        textViewData = findViewById(R.id.textViewData);
        editTextMessage = findViewById(R.id.editTextMessage);
        buttonReturn = findViewById(R.id.buttonReturn);

        Bundle extras = getIntent().getExtras();
        name = extras.getString("MainName");
        num = extras.getDouble("MainNumber");
        textViewData.setText("Name : " + name + " Number : " + num);

        /***
         *   Handle Return button clicks
         */
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CIS 3334", "Return button clicked");   // log button click for debugging using "CIS 3334" tag
                Intent intent = new Intent();
                //intent.putExtra("NewMessage", name+"@css.edu");
                intent.putExtra("NewMessage", editTextMessage.getText().toString());
                setResult(RESULT_OK, intent);
                finish(); // Close this activity and return to the MainActivity
            }
        });
    }


}