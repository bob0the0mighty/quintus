package com.mobile.quintus;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

    private static final int MENU_SETTINGS = 0;
	
    
    private SharedPreferences prefs;


	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        prefs = getPreferences( MODE_PRIVATE );
        
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	// Inflate the menu; this adds items to the action bar if it is present.
		MenuItem item = menu.add(Menu.NONE, MENU_SETTINGS, 0, R.string.menu_item_settings);
		item.setIcon(android.R.drawable.ic_menu_preferences);
		return true;
    }
    
    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
  		startActivity(new Intent(this, PreferenceScreen.class));
  		return true; 
  	}
    
}
