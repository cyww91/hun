package com.family.family;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainScreen extends Activity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main_screen);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		//핸들러 선언부
		Button btn_01 = (Button)findViewById(R.id.button1);
		Button btn_02 = (Button)findViewById(R.id.button2);
		
		//친가 버튼
		btn_01.setOnClickListener(new Button.OnClickListener() 
		{
			public void onClick(View v) 
			{
				Intent intent_add = new Intent(MainScreen.this, FatherScreen.class);
				startActivity(intent_add);
			}
		});
		
		//외가 버튼
		btn_02.setOnClickListener(new Button.OnClickListener() 
		{
			public void onClick(View v) 
			{
				Intent intent_add = new Intent(MainScreen.this, MotherScreen.class);
				startActivity(intent_add);
			}
		});
	}

}
