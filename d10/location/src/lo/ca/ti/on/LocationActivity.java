package lo.ca.ti.on;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LocationActivity extends Activity {
	String result;
	private static final long MINIMUM_DISTANCE_CHANGE_FOR_UPDATES = 1; // in Meters
	private static final long MINIMUM_TIME_BETWEEN_UPDATES = 1000; // in Milliseconds
	
	
	protected LocationManager locationManager;
	
	protected Button retrieveLocationButton;
	protected TextView t1;
	protected TextView t2;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        

        retrieveLocationButton = (Button) findViewById(R.id.button1);
       
        t1=(TextView)findViewById(R.id.lat);
        
        t2=(TextView)findViewById(R.id.lon);
        
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        
        locationManager.requestLocationUpdates(
        		LocationManager.GPS_PROVIDER, 
        		MINIMUM_TIME_BETWEEN_UPDATES, 
        		MINIMUM_DISTANCE_CHANGE_FOR_UPDATES,
        		new MyLocationListener()
        );
        
        
		retrieveLocationButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				showCurrentLocation();
			}
		});        
        
    }    

	protected void showCurrentLocation() {

		Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

		if (location != null) {
			
			
			
			float lat = (float) (location.getLatitude());
			float lng = (float) (location.getLongitude());
			
			
		
			t1.setText(String.valueOf(lat));
			t2.setText(String.valueOf(lng));
			
			result=getUserLocation(t1.getText().toString(),t2.getText().toString());
			
			Toast.makeText(getBaseContext(), result, Toast.LENGTH_LONG).show();
			
			
			
		}

	}   

	private class MyLocationListener implements LocationListener {

		public void onLocationChanged(Location location) {
			
			
			
			float lat = (float) (location.getLatitude());
			float lng = (float) (location.getLongitude());
			
			
		
			t1.setText(String.valueOf(lat));
			t2.setText(String.valueOf(lng));
			
			
		
			
		}

		public void onStatusChanged(String s, int i, Bundle b) {
			Toast.makeText(LocationActivity.this, "Provider status changed",
					Toast.LENGTH_LONG).show();
		}

		public void onProviderDisabled(String s) {
			Toast.makeText(LocationActivity.this,
					"Provider disabled by the user. GPS turned off",
					Toast.LENGTH_LONG).show();
		}

		public void onProviderEnabled(String s) {
			Toast.makeText(LocationActivity.this,
					"Provider enabled by the user. GPS turned on",
					Toast.LENGTH_LONG).show();
		}

	}
	
	public static String getUserLocation(String lat, String lon) {
		System.out.println("service started");
        String userlocation = null;
        String readUserFeed = readUserLocationFeed(lat.trim() + ","+ lon.trim());
        try {
            JSONObject Strjson = new JSONObject(readUserFeed);
            JSONArray jsonArray = new JSONArray(Strjson.getString("results"));
            userlocation = jsonArray.getJSONObject(1)
                    .getString("formatted_address").toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.i("User Location ", userlocation);
        return userlocation;
    }



      public static String readUserLocationFeed(String address) {
        StringBuilder builder = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("http://maps.google.com/maps/api/geocode/json?latlng="+ address + "&sensor=false");
        try {
            HttpResponse response = client.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200) {
                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                String line;
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
            } else {
                Log.e(LocationActivity.class.toString(), "Failed to download file");
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
    
}