package com.example.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Second extends Activity  {
	
	 Button b;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.second);
			b=(Button)findViewById(R.id.p);
			b.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent in=new Intent(getApplicationContext(),MainActivity.class);
					startActivity(in);
					finish();
				}
			});
			
			
		}
		public void onBackPressed(){
			this.finish();
		}
	

}
