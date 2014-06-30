package com.vip.myname;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.os.Build;

public class LoginScreen extends Activity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_login_screen);
		
		//핸들러 선언부
		Button btn_01 = (Button)findViewById(R.id.button1);
		Button btn_02 = (Button)findViewById(R.id.button_join);
		
		
		//로그인 버튼
		btn_01.setOnClickListener(new Button.OnClickListener() 
		{
			public void onClick(View v) 
			{
				Intent intent_add = new Intent( LoginScreen.this, MainMenuScreen.class);
				startActivity(intent_add);
			}
		});
		
		//로그인 버튼
		btn_02.setOnClickListener(new Button.OnClickListener() 
		{
			public void onClick(View v) 
			{
				Intent intent_add = new Intent( LoginScreen.this, InfoScreen.class);
				startActivity(intent_add);
			}
		});
	}

}
