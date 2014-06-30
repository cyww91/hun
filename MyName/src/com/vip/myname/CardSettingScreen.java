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
import android.os.Build;

public class CardSettingScreen extends Activity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_card_setting_screen);
		
		//핸들러 선언부
	    Button btn_01 = (Button)findViewById(R.id.button1);
	    Button btn_02 = (Button)findViewById(R.id.button2);
	    Button btn_04 = (Button)findViewById(R.id.button4);
	    
	    //마이페이지  버튼
  		btn_01.setOnClickListener(new Button.OnClickListener() 
  		{
  			public void onClick(View v) 
  			{
  				Intent intent_add = new Intent( CardSettingScreen.this, MypageScreen.class);
  				startActivity(intent_add);
  				finish();
  			}
  		});
  		
  		//받은명함  버튼
  		btn_02.setOnClickListener(new Button.OnClickListener() 
  		{
  			public void onClick(View v) 
  			{
  				Intent intent_add = new Intent( CardSettingScreen.this, RenameScreen.class);
  				startActivity(intent_add);
  				finish();
  			}
  		});
  		
  		//환경설정  버튼
  		btn_04.setOnClickListener(new Button.OnClickListener() 
  		{
  			public void onClick(View v) 
  			{
  				Intent intent_add = new Intent( CardSettingScreen.this, SettingScreen.class);
  				startActivity(intent_add);
  				finish();
  			}
  		});
	}

}
