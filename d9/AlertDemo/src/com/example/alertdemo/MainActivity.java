package com.example.alertdemo;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        b1 =  (Button)findViewById(R.id.button1);
       
        
        b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
			      alertDialogBuilder.setMessage("Are you sure,You wanted to make decision");
			      
			      alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			         @Override
			         public void onClick(DialogInterface arg0, int arg1) {
			            Toast.makeText(MainActivity.this,"You clicked OK button",Toast.LENGTH_LONG).show();
			         }
			      });
			      
			      alertDialogBuilder.setNegativeButton("EXIT",new DialogInterface.OnClickListener() {
			         @Override
			         public void onClick(DialogInterface dialog, int which) {
			            finish();
			         }
			      });
			      
			      alertDialogBuilder.setNeutralButton("STOP",new DialogInterface.OnClickListener() {
				         @Override
				         public void onClick(DialogInterface dialog, int which) {
				        	dialog.cancel();
				         }
				      });
			      
			      AlertDialog alertDialog = alertDialogBuilder.create();
			      alertDialog.show();
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
