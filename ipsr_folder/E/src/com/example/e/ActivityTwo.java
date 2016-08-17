package com.example.e;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class ActivityTwo extends ListActivity {

	private static  String D;
	private static final String TAG_NAME = "name";
	
	private static final String TAG_STATUS = "status";
	// Creating JSON Parser object
	JSONParser jParser = new JSONParser();

	

	// url to get all person list
	private static String url_all_person = "http://100.77.74.255/android_connect/get_all.php";

	
	ArrayList<HashMap<String, String>>  personList = new ArrayList<HashMap<String, String>>();
	HashMap<String, String> map = new HashMap<String, String>();
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent i2 = getIntent();
		setContentView(R.layout.listview);
		ListView lv = getListView();
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		D = i2.getStringExtra("date");
		params.add(new BasicNameValuePair("dats", D));
		
		JSONObject json = jParser.makeHttpRequest(url_all_person, "POST", params);
		try{
		JSONArray geodata = json.getJSONArray("person");

	     int n = geodata.length();
	    for (int i = 0; i < n; ++i) {
	      JSONObject p = geodata.getJSONObject(i);
	      String name = p.getString("name");
          String status=p.getString("status");
          HashMap<String, String> map = new HashMap<String, String>();
        map.put("name", name);
           map.put("status", status);
			// adding HashList to ArrayList
			personList.add(map);
		
          
	    }
	  
		
	    
	    
		}
	    catch(Exception e){}
		ListAdapter adapter = new SimpleAdapter(
				ActivityTwo.this, personList,
					R.layout.main, new String[] {TAG_NAME,TAG_STATUS},
					new int[] { R.id.text1, R.id.text2 });
			// updating listview
			setListAdapter(adapter);
		
		
		// Hashmap for ListView
		//personList = new ArrayList<HashMap<String, String>>();
       // 
		

		//List<NameValuePair> params = new ArrayList<NameValuePair>();
		//params.add(new BasicNameValuePair("dats", "07/08/2016"));
		//JSONObject json = jParser.makeHttpRequest(url_all_person, "GET", params);
		//try {
			//person = json.getJSONArray(TAG_PERSON);
			//for (int i = 0; i < person.length(); i++) {
				//JSONObject c = person.getJSONObject(i);

				// Storing each json item in variable
				//String id = c.getString(TAG_PID);
				//String name = c.getString(TAG_NAME);
                //String status=c.getString(STAUTUS);
				// creating new HashMap
				//HashMap<String, String> map = new HashMap<String, String>();

				
				//map.put(TAG_NAME, name);
               // map.put(STAUTUS, status);
				// adding HashList to ArrayList
				//personList.add(map);
			
				
				
			//}
			
		   // TextView myText = new TextView(this);
		    
		    //for (int i=0; i<personList.size();i++){
		       // myText.append((CharSequence) personList.get(i));
		       // myText.append("\n");
		  //  }
		    
			//LinearLayout lView = new LinearLayout(this);
			//lView.addView(myText);
			//setContentView(lView);
			//Log.w("mylog",personList.toString());
			
		//} catch (JSONException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}	
	//}//

	

	// Response from Edit Product Activity
	
	}
}
