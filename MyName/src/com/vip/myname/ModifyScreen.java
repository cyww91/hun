package com.vip.myname;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class ModifyScreen extends Activity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_modify_screen);
		
		//핸들러 선언부
		Button btn_02 =(Button)findViewById(R.id.button_2);
	    Button btn_03 = (Button)findViewById(R.id.button_3);
	    Button btn_04 = (Button)findViewById(R.id.button_4);
	    Button btn_05 = (Button)findViewById(R.id.button_5);
	    Button btn_06 = (Button)findViewById(R.id.button_6);
	    
	    
  		btn_02.setOnClickListener(new Button.OnClickListener() 
  		{
  			public void onClick(View v) 
  			{
  				Uri uri = Uri.parse("https://www.kakao.com");
				Intent i = new Intent(Intent.ACTION_VIEW, uri);
				startActivity(i);
  			}
  		});
  		
  		btn_03.setOnClickListener(new Button.OnClickListener() 
  		{
  			public void onClick(View v) 
  			{
  				Uri uri = Uri.parse("https://story.kakao.com");
				Intent i = new Intent(Intent.ACTION_VIEW, uri);
				startActivity(i);
  			}
  		});
  		
  		btn_04.setOnClickListener(new Button.OnClickListener() 
  		{
  			public void onClick(View v) 
  			{
  				Uri uri = Uri.parse("https://www.twitter.com/");
				Intent i = new Intent(Intent.ACTION_VIEW, uri);
				startActivity(i);
  			}
  		});
  		
  		btn_05.setOnClickListener(new Button.OnClickListener() 
  		{
  			public void onClick(View v) 
  			{
  				Uri uri = Uri.parse("https://www.facebook.com/");
				Intent i = new Intent(Intent.ACTION_VIEW, uri);
				startActivity(i);
  			}
  		});
  		
  		btn_06.setOnClickListener(new Button.OnClickListener() 
  		{
  			public void onClick(View v) 
  			{
  				Uri uri = Uri.parse("https://www.me2day.net/");
				Intent i = new Intent(Intent.ACTION_VIEW, uri);
				startActivity(i);
  			}
  		});
	    
	}
}
