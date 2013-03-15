package com.mobile.quintus;

import android.app.Activity;
import android.os.Bundle;

public class SetPreferences extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		this.setTitle(R.string.action_settings);
		
		getFragmentManager().beginTransaction().replace(android.R.id.content,
                new PrefsFragment()).commit();
		
	}
}
