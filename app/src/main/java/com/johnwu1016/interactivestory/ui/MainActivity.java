package com.johnwu1016.interactivestory.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.johnwu1016.interactivestory.R;

public class MainActivity extends AppCompatActivity {

    private TextView nameFiled;
    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameFiled = (TextView) findViewById(R.id.nameEditText);
        startButton = (Button) findViewById(R.id.startButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameFiled.getText().toString();

                startStory(name);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        nameFiled.setText("");
    }

    private void startStory(String name) {
        Intent intent = new Intent(this, StoryActivity.class);
        Resources resources = getResources();
        String key = resources.getString(R.string.key_name);
        intent.putExtra(key, name);
        startActivity(intent);
    }
}
