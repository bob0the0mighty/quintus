package com.mobile.quintus;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.Preference.OnPreferenceChangeListener;

public class PreferenceScreen extends PreferenceActivity {

	private static final String PREFS_BASE 	= "Quintus";
	private static final String ANSWERS 	= "";
	private static final String DEFAULT 	= null;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

//	    PreferenceManager manager = getPreferenceManager();
//	
//	    manager.setSharedPreferencesName(PREFS_BASE);
//	
//	    addPreferencesFromResource(R.xml.prefs);
//	    
//	    initializePrefViews(manager.getSharedPreferences());
	}

	private void initializePrefViews( SharedPreferences sharedPrefs ) {
		
//		/*Preference pref = (Preference) findPreference( ANSWERS );
//		
//		( (EditTextPreference) pref ).getEditText().setHint( DEFAULT );
//		( (EditTextPreference) pref ).getEditText().setSingleLine( true );	
//		
//		pref.setSummary( sharedPrefs.getString( ANSWERS, DEFAULT ) );
//    
//		pref.setOnPreferenceChangeListener(new OnPreferenceChangeListener() {
//
//		  @Override
//		  public boolean onPreferenceChange(Preference preference,
//		              Object newValue) {
//			      try {
//				    	int temp = Integer.parseInt( (String) newValue, Integer.parseInt( DEFAULT ) );
//				      if( 0 >= temp ) {
//				      	return false;
//				      }
//				      preference.setSummary( (String)newValue );
//				      return true;
//			      } catch( NumberFormatException nfex ) {
//			      	//System.err.println("Error parsing string to int");
//		      	return false;
//		      } 
//		  } 
//		});*/
    
	}
}
