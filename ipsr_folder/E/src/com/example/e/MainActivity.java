package com.example.e;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
   EditText eText;
   Button btn1,btn2;
   
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.start);
      eText = (EditText) findViewById(R.id.edittext);
      btn1 = (Button) findViewById(R.id.button1);
      btn1.setOnClickListener(new OnClickListener() {
         public void onClick(View v) {
        	 Intent i1 = new Intent(getApplicationContext(),TakeAttendance.class);
				
				startActivity(i1);
				
         }
      });
      btn2 = (Button) findViewById(R.id.button2);
      btn2.setOnClickListener(new OnClickListener() {
         public void onClick(View v) {
        	 Intent i2 = new Intent(getApplicationContext(),ViewAttendance.class);
				
				startActivity(i2);
				
         }
      });
   }
   
   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu; this adds items to the action bar,if it is present.
      getMenuInflater().inflate(R.menu.main, menu);
      return true;
   }
}