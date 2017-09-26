package com.example.mgl.helloworld;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ToggleButton;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mySound;

    protected void onPause() {
        super.onPause();
        mySound.release();
    }

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySound = MediaPlayer.create(this, R.raw.beethoven5);

        ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleButton2);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ImageView imageView = (ImageView) findViewById(R.id.imageView);
                if (isChecked) {
                    imageView.setImageResource(R.drawable.mohib2);
                } else {
                    imageView.setImageResource(R.drawable.mohib1);
                }
            }
        });
    }

    /** Called when the user taps the Send button*/
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText3);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }



    public void playSound(View view) {
        mySound.start();
    }
}
