package com.javacodegeeks.android.fragmentstest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;


public class MainActivity extends Activity {
	
	Button b1,b2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

      setContentView(R.layout.activity_main);
      
      b1 =  (Button)findViewById(R.id.button1);
      
      b2 =  (Button)findViewById(R.id.button2);
      
      b1.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			show_frag_one();
		}
	});
      
      
      b2.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			show_frag_two();
		}
	});
	}
	 
	protected void show_frag_two() {
		// TODO Auto-generated method stub
		 Fragment fr;
		 fr = new FragmentTwo();
		 FragmentManager fm = getFragmentManager();
	     FragmentTransaction fragmentTransaction = fm.beginTransaction();
	     fragmentTransaction.replace(R.id.fragment_place, fr);
	     fragmentTransaction.commit();
	}

	protected void show_frag_one() {
		// TODO Auto-generated method stub
		 Fragment fr;
		 fr = new FragmentOne();
		 FragmentManager fm = getFragmentManager();
	     FragmentTransaction fragmentTransaction = fm.beginTransaction();
	     fragmentTransaction.replace(R.id.fragment_place, fr);
	     fragmentTransaction.commit();
	}

	
   
}
