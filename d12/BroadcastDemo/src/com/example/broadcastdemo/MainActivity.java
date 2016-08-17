package com.example.broadcastdemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.content.Intent;
import android.view.View;

public class MainActivity extends Activity {

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      }
   
   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      getMenuInflater().inflate(R.menu.main, menu);
      return true;
      }
   
   // broadcast a custom intent. 
  public void broadcastIntent(View view){
      Intent intent = new Intent();
      intent.setAction("com.example.CUSTOM_INTENT");
      sendBroadcast(intent);
   }
}
