package com.sai.samples.views;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class SpinnerView extends Activity {
	String[] vehicles = 
	{
		"car",
		"bus",
		"bike",
		"train",
		
	};
	
	Spinner sp;
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        sp = (Spinner)findViewById(R.id.Spinner01); 
        ArrayAdapter<String> adapter =    	new ArrayAdapter<String> (this, 
        			android.R.layout.simple_spinner_dropdown_item,vehicles);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				int item = sp.getSelectedItemPosition();
				Toast.makeText(getBaseContext(), 
						"You have selected the book: " + vehicles[item], 
						Toast.LENGTH_SHORT).show();
			}

			public void onNothingSelected(AdapterView<?> arg0) {
			}
        	
        });
    }
}