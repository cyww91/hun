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

public class RenameScreen extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_rename_screen);
		
		//�ڵ鷯 �����
	    Button btn_01 = (Button)findViewById(R.id.button1);
	    Button btn_03 = (Button)findViewById(R.id.button3);
	    Button btn_04 = (Button)findViewById(R.id.button4);
	    
	    //����������  ��ư
  		btn_01.setOnClickListener(new Button.OnClickListener() 
  		{
  			public void onClick(View v) 
  			{
  				Intent intent_add = new Intent( RenameScreen.this, MypageScreen.class);
  				startActivity(intent_add);
  				finish();
  			}
  		});
  		
  		//���� ����  ��ư
  		btn_03.setOnClickListener(new Button.OnClickListener() 
  		{
  			public void onClick(View v) 
  			{
  				Intent intent_add = new Intent( RenameScreen.this, CardSettingScreen.class);
  				startActivity(intent_add);
  				finish();
  			}
  		});
  		
  		//ȯ�漳��  ��ư
  		btn_04.setOnClickListener(new Button.OnClickListener() 
  		{
  			public void onClick(View v) 
  			{
  				Intent intent_add = new Intent( RenameScreen.this, SettingScreen.class);
  				startActivity(intent_add);
  				finish();
  			}
  		});
	}
}
