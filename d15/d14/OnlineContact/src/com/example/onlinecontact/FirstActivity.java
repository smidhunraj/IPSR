package com.example.onlinecontact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends Activity{
	
	Button a,d,v;
	
	protected void onCreate(Bundle sis)
	{
		
		super.onCreate(sis);
		setContentView(R.layout.first);
		
		a = (Button)findViewById(R.id.button1);
		d = (Button)findViewById(R.id.button2);
		v = (Button)findViewById(R.id.button3);
		
		a.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent in = new Intent(getApplicationContext(),MainActivity.class);
				startActivity(in);
			}
		});
		
		
		
		d.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent in = new Intent(getApplicationContext(),DeleteActivity.class);
				startActivity(in);
			}
		});
		
		
       v.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent in = new Intent(getApplicationContext(),AllContactsActivity.class);
				startActivity(in);
			}
		});
		
		
	}

}
