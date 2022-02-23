package css.tgibbons.multipleactivities2022;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    EditText editTextNumber;
    TextView textViewResult;
    Button buttonSecondAct;
    Button buttonThirdAct;
    Intent thirdIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextNumber = findViewById(R.id.editTextNumber);
        textViewResult = findViewById(R.id.textViewResult);

        setupButton2();
        setupButton3();

    }

    private void setupButton2() {
        buttonSecondAct = findViewById(R.id.buttonSecondAct);
        /***
         *   Handle Second Activity button click
         */
        buttonSecondAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CIS 3334", "Second Act button clicked");   // log button click for debugging using "CIS 3334" tag
                // Call the second activity
                String name = editTextName.getText().toString();
                Double num = Double.parseDouble( editTextNumber.getText().toString() );
                Intent secActIntent = new Intent(v.getContext(), SecondActivity.class);
                secActIntent.putExtra("MainName", name);
                secActIntent.putExtra("MainNumber", num);
                startActivity(secActIntent);     // if no result is returned
            }
        });
    }

    private void setupButton3() {
        buttonThirdAct = findViewById(R.id.buttonThirdAct);
        /***
         *   Handle Third Activity button click
         */
        buttonThirdAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CIS 3334", "Third Act button clicked");   // log button click for debugging using "CIS 3334" tag
                String name = editTextName.getText().toString();
                Double num = Double.parseDouble( editTextNumber.getText().toString() );

                // Call the Third activity
                thirdIntent = new Intent(v.getContext(), ThirdActivity.class);
                thirdIntent.putExtra("MainName", name);
                thirdIntent.putExtra("MainNumber", num);
                //startActivity(secActIntent);     // if no result is returned
                thirdActivityResultLauncher.launch(thirdIntent);
            }
        });
    }

    /***
     *   Setup the callback for the third activity
     */
    ActivityResultLauncher<Intent> thirdActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Log.d("CIS 3334", "In onActivityResult code = "+ result.getResultCode());
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        // Get the data returned from the third activity
                        Intent data = result.getData();
                        Bundle extras = data.getExtras();
                        String msg = extras.getString("NewMessage");
                        textViewResult.setText(msg);
                    }
                }
            });

}