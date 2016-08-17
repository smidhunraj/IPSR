
package com.example.ldexample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.text.util.Linkify.MatchFilter;
import android.text.util.Linkify.TransformFilter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    @Override
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
    
        
        LinearLayout mainLayout = (LinearLayout)findViewById(R.id.ll);
        TextView myWebSite=new TextView(this);
       myWebSite.setText("http://www.facebook.com");
       Linkify.addLinks(myWebSite, Linkify.WEB_URLS);
       mainLayout.addView(myWebSite);
        
        
        
        
        
        
        TextView myPhone=new TextView(this);
        myPhone.setText("55544554454");
        Linkify.addLinks(myPhone, Linkify.PHONE_NUMBERS);
        mainLayout.addView(myPhone);
        
        TextView myEmail=new TextView(this);
        myEmail.setText("aviyehuda@gmail.com");
        Linkify.addLinks(myEmail,Linkify.EMAIL_ADDRESSES);
        mainLayout.addView(myEmail);
        
        
        TextView myLocation=new TextView(this);
        myLocation.setText("436 MayField AVe,STandford,CA");
        Linkify.addLinks(myLocation, Linkify.MAP_ADDRESSES);
        mainLayout.addView(myLocation);
        
        
       ;
        
        
        TextView myCustomLink=new TextView(this);
        Pattern pattern=Pattern.compile("[a-zA-Z]+&");
        myCustomLink.setText("press Linkify& or on Android& to search it on google");
        Linkify.addLinks(myCustomLink,pattern,"http://www.google.com/search?q=");

        
        MatchFilter myMatchFilter = new MatchFilter() {
			
			@Override
			public boolean acceptMatch(CharSequence cs, int start, int end) {
				return start > 48; 
			}
		};
		
        
        TextView myCustomLink2=new TextView(this);
        Pattern pattern2=Pattern.compile("[a-zA-Z]+");
        myCustomLink2.setText("press one of these words to search it on google:Android linkify dzone");
         Linkify.addLinks(myCustomLink2,pattern2,"http://www.google.ie/search?q=",myMatchFilter,null);
         mainLayout.addView(myCustomLink2);
         
         
         
		TransformFilter myTransformFilter=new TransformFilter(){
			@Override
			public String transformUrl(Matcher match,String url)
			{
				return url.substring(1);
			}
			
		};
		
	     
        
        TextView myCustomLink3=new TextView(this);
        Pattern pattern3=Pattern.compile("\\$[a-zA-Z]+");
        myCustomLink3.setText("press $Linkify or on $Android to search it on google");
        Linkify.addLinks(myCustomLink3,pattern3,"http://www.google.ie/search?q=",null,myTransformFilter);
        mainLayout.addView(myCustomLink3);
    }
}