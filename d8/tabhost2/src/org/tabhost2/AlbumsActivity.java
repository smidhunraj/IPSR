package org.tabhost2;

import android.app.Activity;
import android.app.TabActivity;
import android.os.Bundle;

public class AlbumsActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album);
    }
}