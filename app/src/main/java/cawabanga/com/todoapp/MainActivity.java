package cawabanga.com.todoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.vstechlab.easyfonts.EasyFonts;

public class MainActivity extends AppCompatActivity {

    private TextView AppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppNameTextView = (TextView) findViewById(R.id.app_name);
        AppNameTextView.setTypeface(EasyFonts.caviarDreamsBold(this));

    }
}
