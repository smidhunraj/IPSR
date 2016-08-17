package com.example.e;



import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.view.View.OnClickListener;
import android.util.Log;
public class TakeAttendance extends Activity implements OnClickListener {
	 JSONArray jo= new JSONArray();
	 String message;
	 String status[] = new String[5];
	 String names[]={"Anoop","Kala","Raman","Preeta","Usha"};
	int j=0;
	String datee;
    @SuppressLint("InlinedApi") @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScrollView sv = new ScrollView(this);
        final LinearLayout  ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        sv.addView(ll);
        for(int i = 0; i < 5; i++) {
            CheckBox cb = new CheckBox(this);
            cb.setText(names[i]);
            ll.addView(cb);
            cb.setId(i);
            }
            this.setContentView(sv);
       
           // LinearLayout ll = (LinearLayout)findViewById(R.id.layout);
            final EditText edtView = new EditText(this);
            edtView.setHint("Please enter the date");
          
            ll.addView(edtView);
            
          
             
            Button btn = new Button(this);
            btn.setText("Submit");
            //btn.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
            ll.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                        	
                        	  for (int i = 0; i < 5; i++) {
                                 CheckBox cb = (CheckBox) ll.getChildAt(i);
                                 if(cb.isChecked()){
                                	status[i]="present"; 
                                	 
                                 }
                                 else
                                 {
                                	status[i]="absent"; 
                                 }
                                 
                        	  }
                        	  datee= edtView.getText().toString();
                             	try {
                        			getJSONArray();
                        		} catch (FileNotFoundException e) {
                        			// TODO Auto-generated catch block
                        			e.printStackTrace();
                        		} catch (UnsupportedEncodingException e) {
                        			// TODO Auto-generated catch block
                        			e.printStackTrace();
                        		} catch (JSONException e) {
                        			// TODO Auto-generated catch block
                        			e.printStackTrace();
                        		}
                        		
                                 
                                
                             
                        	  String str = Integer.toString(j);
                        	  Log.w("myApp",str);
                          finish();
                        	 // Toast.makeText(getApplicationContext(),j,Toast.LENGTH_SHORT).show();
                         //code
            }
            });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	
		
	
	  public void getJSONArray() throws JSONException, FileNotFoundException, UnsupportedEncodingException {
              
	       /* JSONArray jo= new JSONArray();

	        JSONObject obj1= new JSONObject();
	        obj1.put("A","a");

	        JSONObject obj2= new JSONObject();
	        obj2.put("B","b");

	        JSONObject obj3= new JSONObject();
	        obj3.put("B","c");

	        jo.put(obj1);
	        jo.put(obj2);
	        jo.put(obj3);

	        System.out.println(jo.toString());*/
	        
	        
	        /*-----------------------------*/
		  /*JSONArray ja = new JSONArray();
	        for(int p=0;p<5;p++){
	        	JSONObject jo1= new JSONObject ();
	       String strr= Integer.toString(p);
	       String strr2=Integer.toString(p+1);
	        jo1.put("name", strr );
	        jo1.put("status", strr2);

	        
	        ja.put(jo1);
	        }*/

	        JSONArray ja = new JSONArray();
	        /*-----------------------------*/
	        
	        for(int p=0;p<5;p++){
	        	JSONObject jo1= new JSONObject ();
	       jo1.put("name", names[p] );
          jo1.put("status",status[p]);
          jo1.put("dats",datee);
	        
	        ja.put(jo1);
	         
	      // mainObj.put("employees", ja);
	        }
	        message= ja.toString();
	         Log.w("myApp1",message);
	      /*  try{
	             // create new file
	             String content = ja.toString();
	             Log.w("myApp1",content);
	             String path="E:\\a\\hi.json";
	             File file = new File(path);

	                // if file doesn't exists, then create it
	                if (!file.exists()) {
	                    file.createNewFile();
	                }

	                FileWriter fw = new FileWriter(file.getAbsoluteFile());
	                BufferedWriter bw = new BufferedWriter(fw);
	                // write in file
	                bw.write(content);
	                // close connection
	                bw.close();
	          }catch(Exception e){
	           
	          }
				
				*/
	        new Thread(new Runnable() {
	            @Override
	            public void run() {
	                OutputStream os = null;
	                InputStream is = null;
	                HttpURLConnection conn = null;
	                try {
	                    //constants
	                    URL url = new URL("http://100.77.74.255/android_connect/fmjson.php");
	                    

	                    conn = (HttpURLConnection) url.openConnection();
	                    conn.setReadTimeout( 10000 /*milliseconds*/ );
	                    conn.setConnectTimeout( 15000 /* milliseconds */ );
	                    conn.setRequestMethod("POST");
	                    conn.setDoInput(true);
	                    conn.setDoOutput(true);
	                    conn.setFixedLengthStreamingMode(message.getBytes().length);

	                    //make some HTTP header nicety
	                    conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
	                    conn.setRequestProperty("X-Requested-With", "XMLHttpRequest");

	                    //open
	                    conn.connect();

	                    //setup send
	                    os = new BufferedOutputStream(conn.getOutputStream());
	                    os.write(message.getBytes());
	                    //clean up
	                    os.flush();

	                    //do something with response
	                    is = conn.getInputStream();
	                    //String contentAsString = readIt(is,len);
	                } catch (IOException e) {
	                    e.printStackTrace();
	                } finally {
	                    //clean up
	                    try {
	                        os.close();
	                        is.close();
	                    } catch (IOException e) {
	                        e.printStackTrace();
	                    }

	                    conn.disconnect();
	                }
	            }
	        }).start();
				

	    }


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}


	

	
}
