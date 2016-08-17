package com.example.samplenotif;



import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	Button b;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (Button)findViewById(R.id.button1);
        
        b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				createNotif();
			}

			
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public void createNotif() {
		// TODO Auto-generated method stub
        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        
        int icon = R.drawable.ic_launcher;
        CharSequence text = "New Message";
        CharSequence contentTitle = "This is a message for test ";
        CharSequence contentText = "These are the comntents of the message .";
        long when = System.currentTimeMillis();
        
        Intent intent = new Intent(this, nxt.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, 0);
        Notification notification = new Notification(icon,text,when);
        
      /*  long[] vibrate = {0,100,200,300};
        notification.vibrate = vibrate;
        
        notification.ledARGB = Color.RED;
        notification.ledOffMS = 300;
        notification.ledOnMS = 300;
        
        notification.defaults |= Notification.DEFAULT_LIGHTS;*/
        //notification.flags |= Notification.FLAG_SHOW_LIGHTS;
        
        notification.setLatestEventInfo(this, contentTitle, contentText, contentIntent);
        
        notificationManager.notify(Constants.NOTIFICATION_ID, notification);
		
	}
}
