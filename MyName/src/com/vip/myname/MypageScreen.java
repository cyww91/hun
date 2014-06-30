package com.vip.myname;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.os.Build;

public class MypageScreen extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_mypage_screen);
		
		//�ڵ鷯 �����
	    Button btn_02 = (Button)findViewById(R.id.button2);
	    Button btn_03 = (Button)findViewById(R.id.button3);
	    Button btn_04 = (Button)findViewById(R.id.button4);
	    Button btn_05 = (Button)findViewById(R.id.button5);
	    Button btn_06 = (Button)findViewById(R.id.button6);
	    Button btn_07 = (Button)findViewById(R.id.button7);
  		
  		//��������  ��ư
  		btn_02.setOnClickListener(new Button.OnClickListener() 
  		{
  			public void onClick(View v) 
  			{
  				Intent intent_add = new Intent(MypageScreen.this, RenameScreen.class);
  				startActivity(intent_add);
  				finish();
  			}
  		});
  		
  		//���� ����  ��ư
  		btn_03.setOnClickListener(new Button.OnClickListener() 
  		{
  			public void onClick(View v) 
  			{
  				Intent intent_add = new Intent(MypageScreen.this, CardSettingScreen.class);
  				startActivity(intent_add);
  				finish();
  			}
  		});
  		
  		//ȯ�漳��  ��ư
  		btn_04.setOnClickListener(new Button.OnClickListener() 
  		{
  			public void onClick(View v) 
  			{
  				Intent intent_add = new Intent( MypageScreen.this, SettingScreen.class);
  				startActivity(intent_add);
  				finish();
  			}
  		});
  		
  		//���԰���  ��ư
  		btn_05.setOnClickListener(new Button.OnClickListener() 
  		{
  			public void onClick(View v) 
  			{
  				Intent intent_add = new Intent(MypageScreen.this, ModifyScreen.class);
  				startActivity(intent_add);
  				finish();
  			}
  		});
  		
  		//�������� ��ư
  		btn_06.setOnClickListener(new Button.OnClickListener() 
  		{
  			public void onClick(View v) 
  			{
  				Uri uri = Uri.parse("https://www.google.com/calendar/render?hl=ko");
				Intent i = new Intent(Intent.ACTION_VIEW, uri);
				startActivity(i);
  			}
  		});
  		
  		//�ٹ�����  ��ư
  		btn_07.setOnClickListener(new Button.OnClickListener() 
  		{
  			public void onClick(View v) 
  			{
 				 Uri uri = Uri.parse("content://media/internal/images/media");
  			     Intent intent = new Intent(Intent.ACTION_VIEW, uri);
  			     startActivity(intent);
  			}
  		});
	}
}
