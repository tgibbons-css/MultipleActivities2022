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

        Bundle extras = getIntent().getExtras();
        name = extras.getString("MainName");
        num = extras.getDouble("MainNumber");
        textViewData.setText("Name : " + name + " Number : " + num);

    }

    @Override
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra("NewName", name+"@css.edu");
        intent.putExtra("NewNum", num * 2);
        setResult(RESULT_OK, intent);
        super.finish();
    }
}