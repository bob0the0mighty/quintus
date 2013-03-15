package com.mobile.quintus;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity 
	implements OnSharedPreferenceChangeListener{

	//easier than dealing with R array nonsense
    private static final String DEFAULT		 	= "default";
    private static final String BAD_URL			= "Malformed URL";
    private static final String BAD_CONNECTION	= "Connection Problems";
    private static final String ERR_TITLE		= "Error";
    
    private Drawable		  	background;
	private SharedPreferences 	prefs;
	private View 			  	mainView;
	private AlertDialog.Builder	errAlert;
	private String			 	errString;
	
	private class AsyncImageGetter extends AsyncTask<String, Void, Bitmap> {
		
		@Override
		protected Bitmap doInBackground(String... arg0) {
			errString = "";
			try {
				URL url = new URL( arg0[0] );
		        try {
					HttpURLConnection connection;
					connection = (HttpURLConnection) url.openConnection();
					connection.setDoInput(true);
			        connection.connect();
			        InputStream input = connection.getInputStream();
			        Bitmap myBitmap = BitmapFactory.decodeStream(input);
			        return myBitmap;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//System.err.println("IO Exception on HTTP connection");
					errString = BAD_CONNECTION;
					return BitmapFactory.decodeResource( getResources(), R.drawable.ic_launcher );
				} 
			} catch (MalformedURLException e) {
				e.printStackTrace();
				//System.err.println(BAD_URL);
				errString = BAD_URL;
				return BitmapFactory.decodeResource( getResources(), R.drawable.ic_launcher );
			}
		}

		protected void onPostExecute(Bitmap result) {
			background = new BitmapDrawable( getResources() ,result);
			mainView.setBackgroundDrawable( background );
			if(!errString.isEmpty()) {
				errAlert.setMessage( errString );
				errAlert.create().show();
			}
		}
	}

	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        prefs = PreferenceManager.getDefaultSharedPreferences( this );
        prefs.registerOnSharedPreferenceChangeListener( this );
        
        errAlert = new AlertDialog.Builder( this );
        errAlert.setTitle( ERR_TITLE );
        
        setContentView(R.layout.activity_main);
        
        mainView = findViewById( R.id.mainBackground );
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

	@SuppressWarnings("deprecation")
	@Override
	public void onSharedPreferenceChanged(SharedPreferences arg0, String arg1) {
		Drawable background = getResources().getDrawable( R.drawable.ic_launcher );
		System.out.println(prefs.getString(arg1, "null"));
		if(prefs.getString(arg1, "null").equals(DEFAULT)) {
			mainView.setBackgroundDrawable( background );
		} else {
			new AsyncImageGetter().execute( prefs.getString( arg1, "null" ));
		}
	}
    
}
