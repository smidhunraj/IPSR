package com.example.contextdemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	
	Button b;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		b = (Button)findViewById(R.id.button1);
		
		registerForContextMenu(b);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	public void onCreateContextMenu(ContextMenu menu, View v,ContextMenuInfo info)
	{
	/*	super.onCreateContextMenu(menu, v, info);
		menu.setHeaderTitle("Select Your Option");
		menu.add(0,v.getId(),0,"SAVE");
		menu.add(0,v.getId(),0,"DELETE");*/
		
		MenuInflater min =  new MenuInflater(MainActivity.this);
		min.inflate(R.menu.main, menu);
		
	}
	
	
	public boolean onContextItemSelected(MenuItem mitem)
	{
		switch(mitem.getItemId())
		{
		case R.id.save : Toast.makeText(getBaseContext(), "You Selected SAVE", Toast.LENGTH_LONG).show();
		                 return true;
		
		case R.id.delete : Toast.makeText(getBaseContext(), "You Selected DELETE", Toast.LENGTH_LONG).show();
        return true;

        
        default: return super.onOptionsItemSelected(mitem);
		}
		
		
		
	}

}
