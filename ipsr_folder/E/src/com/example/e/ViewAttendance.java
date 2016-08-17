package com.example.e;







import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;

public class ViewAttendance extends Activity {
	 EditText eText;
	   Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eText = (EditText) findViewById(R.id.edittext);
        btn = (Button) findViewById(R.id.button);
       
           btn.setOnClickListener(new View.OnClickListener() {
   			
   			@Override
   			public void onClick(View view) {
   				// Launching create new product activity
   			  String str = eText.getText().toString();
   				Intent i = new Intent(getApplicationContext(),ActivityTwo.class);
   				i.putExtra("date",str);
				startActivity(i);
				
   			}
   		});
		
        
        
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}