package css.tgibbons.multipleactivities2022;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    EditText editTextNumber;
    TextView textViewResult;

    // constant to determine which sub-activity returns
    private static final int CIS3334_REQUEST_CODE = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextNumber = (EditText) findViewById(R.id.editTextNumber);
        textViewResult = (TextView) findViewById(R.id.textViewResult);
    }

    public void onButtonClick( View view) {
        // Call the second activity
        String name = editTextName.getText().toString();
        Double num = Double.parseDouble( editTextNumber.getText().toString() );
        Intent secActIntent = new Intent(this, SecondActivity.class);
        secActIntent.putExtra("MainName", name);
        secActIntent.putExtra("MainNumber", num);
        //startActivity(secActIntent)     // if no result is returned
        startActivityForResult(secActIntent, CIS3334_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == CIS3334_REQUEST_CODE) {
            if (data.hasExtra("NewName")) {
                String result = data.getExtras().getString("NewName");
                if (result != null && result.length() > 0) {
                    textViewResult.setText("New name : " + result);
                    Toast.makeText(this, result, Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}