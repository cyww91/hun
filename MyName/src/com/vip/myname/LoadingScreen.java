package com.vip.myname;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.os.Build;

public class LoadingScreen extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_loading_screen);
		
	    Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
        
		@Override
		public void run() 
		{
		// TODO Auto-generated method stub
		Intent i = new Intent(LoadingScreen.this, LoginScreen.class);
		
		startActivity(i);
		finish();
		}         
		},1000);
	}


}
