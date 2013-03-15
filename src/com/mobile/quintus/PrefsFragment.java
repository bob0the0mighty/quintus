package com.mobile.quintus;

import android.os.Bundle;
import android.preference.PreferenceFragment;

public class PrefsFragment extends PreferenceFragment {
	
	public void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  
		  // Load the preferences from an XML resource
		  addPreferencesFromResource(R.xml.preferences);
	}
}
