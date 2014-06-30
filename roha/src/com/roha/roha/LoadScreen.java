package com.roha.roha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

public class LoadScreen extends Activity 
{
	 @Override
	    protected void onCreate(Bundle savedInstanceState) 
	    {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.activity_load_screen);
	        
	        Handler mHandler = new Handler();
	        mHandler.postDelayed(new Runnable() {
	        
			@Override
			public void run() 
			{
			// TODO Auto-generated method stub
			Intent i = new Intent(LoadScreen.this, MainMenuScreen.class);
			
			startActivity(i);
			finish();
			}         
			},1000);

	    }
}
