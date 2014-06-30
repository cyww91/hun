package com.roha.roha;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

public class PhotoScreen extends Activity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_photo_screen);
		
		//핸들러 선언부
		ImageView btn_01 = (ImageView)findViewById(R.id.button_01);
		ImageView btn_02 = (ImageView)findViewById(R.id.button_02);
		ImageView btn_06 = (ImageView)findViewById(R.id.button_06);
		
		//추모하기 버튼
		btn_01.setOnClickListener(new Button.OnClickListener() 
		{
			public void onClick(View v) 
			{
				Intent intent_add = new Intent(PhotoScreen.this, MainMenuScreen.class);
				startActivity(intent_add);
				finish();
			}
		});
		
		//추모공간제작 버튼
		btn_02.setOnClickListener(new Button.OnClickListener() 
		{
			public void onClick(View v) 
			{
				Intent intent_add = new Intent(PhotoScreen.this, MakeScreen.class);
				startActivity(intent_add);
				finish();
			}
		});
		
		//이름 버튼
		btn_06.setOnClickListener(new Button.OnClickListener() 
		{
			public void onClick(View v) 
			{
				
				Uri uri = Uri.parse("http://bestfo.wix.com/father1");
				Intent i = new Intent(Intent.ACTION_VIEW, uri);
				startActivity(i);
			}
		});
	}
}
