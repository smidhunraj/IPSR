package com.example.test;


import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	Button  b,b2;
	
	String msg = "Message From First Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
         b = (Button)findViewById(R.id.n);
         b2 = (Button)findViewById(R.id.w);
         
         b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent in = new Intent(getApplicationContext(),SecondActivity.class);
				in.putExtra("mssg", msg);
				startActivity(in);
				finish();
			}
		});
         
         
         
         b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			//	Intent in = new Intent(getApplicationContext(),SecondActivity.class);
			//	Intent in = new Intent(Intent.ACTION_VIEW);
			//	in.setData(Uri.parse("https://www.facebook.com"));
				Intent in = new Intent(Intent.ACTION_CALL);
				in.setData(Uri.parse("tel:9567675677"));
				startActivity(in);
				
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    public boolean onOptionsItemSelected(MenuItem item)
    {
        
        switch (item.getItemId())
        {
        case R.id.action_settings:
        	// Single menu item is selected do something
        	// Ex: launching new activity/screen or show alert message
            Toast.makeText(MainActivity.this, "Settings is Selected", Toast.LENGTH_SHORT).show();
            return true;
        
        default:
            return super.onOptionsItemSelected(item);
        }
    }
    
}
