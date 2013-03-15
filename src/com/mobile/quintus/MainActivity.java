package com.mobile.quintus;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends Activity 
	implements OnSharedPreferenceChangeListener{

    private static final int MENU_SETTINGS = 0;
    private SharedPreferences prefs;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        prefs = PreferenceManager.getDefaultSharedPreferences( this );
        prefs.registerOnSharedPreferenceChangeListener( this );
        
        setContentView(R.layout.activity_main);
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
		return true;
    }
    
    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
  		startActivity(new Intent(this, SetPreferences.class));
  		return true; 
  	}

	@Override
	public void onSharedPreferenceChanged(SharedPreferences arg0, String arg1) {
		System.out.println("pref changed");
		
	}
    
}
