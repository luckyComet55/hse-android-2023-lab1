package com.example.homework1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    int colour = getIntent().getIntExtra("clr", Color.WHITE);
    this.getWindow().getDecorView().setBackgroundColor(colour);
    TextView colourField = (TextView) findViewById(R.id.colour_input);
    Button btnSubmit = (Button) findViewById(R.id.btn_submit_colour);
    btnSubmit.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        String str = colourField.getText().toString();
        int colour;
        switch (str) {
          case "red":
            colour = Color.RED;
            break;
          case "green":
            colour = Color.GREEN;
            break;
          case "blue":
            colour = Color.BLUE;
            break;
          default:
            colour = Color.WHITE;
            break;
        }
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        intent.putExtra("clr", colour);
        startActivity(intent);
      }
    });
  }
  
}