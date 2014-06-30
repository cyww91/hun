package com.vip.myname;

import android.app.Activity;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.CookieManager;
import android.widget.Button;
import android.os.Build;

public class MainMenuScreen extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main_menu_screen);
		
		//�ڵ鷯 �����
	    Button btn_01 = (Button)findViewById(R.id.button1);
	    Button btn_02 = (Button)findViewById(R.id.button2);
	    Button btn_03 = (Button)findViewById(R.id.button3);
	    Button btn_04 = (Button)findViewById(R.id.button4);
	    
	    //����������  ��ư
  		btn_01.setOnClickListener(new Button.OnClickListener() 
  		{
  			public void onClick(View v) 
  			{
  				Intent intent_add = new Intent( MainMenuScreen.this, MypageScreen.class);
  				startActivity(intent_add);
  			}
  		});
  		
  		//��������  ��ư
  		btn_02.setOnClickListener(new Button.OnClickListener() 
  		{
  			public void onClick(View v) 
  			{
  				Intent intent_add = new Intent( MainMenuScreen.this, RenameScreen.class);
  				startActivity(intent_add);
  			}
  		});
  		
  		//���� ����  ��ư
  		btn_03.setOnClickListener(new Button.OnClickListener() 
  		{
  			public void onClick(View v) 
  			{
  				Intent intent_add = new Intent( MainMenuScreen.this, CardSettingScreen.class);
  				startActivity(intent_add);
  			}
  		});
  		
  		//ȯ�漳��  ��ư
  		btn_04.setOnClickListener(new Button.OnClickListener() 
  		{
  			public void onClick(View v) 
  			{
  				Intent intent_add = new Intent( MainMenuScreen.this, SettingScreen.class);
  				startActivity(intent_add);
  			}
  		});
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{ 
	        
	        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) 
	        { 
	            new AlertDialog.Builder(this) 
	            .setIcon(android.R.drawable.ic_dialog_alert) 
	            .setTitle("���α׷� ����") 
	            .setMessage("���α׷��� ���� �Ͻðڽ��ϱ�?") 
	            .setPositiveButton("��", 
	            new DialogInterface.OnClickListener()  
	            { 
	                @Override 
	                public void onClick( DialogInterface dialog, int which ) 
	                { 
	                    moveTaskToBack(true); 
	                    finish(); 
	                } 
	            } 
	            
	            ).setNegativeButton("�ƴϿ�", null ).show(); 
	            return true; 
	        }

	        return super.onKeyDown(keyCode, event); 
	    } 
	    
	    @Override 
	    public void onDestroy()
	    { 
	        super.onDestroy(); 
	       clearApplicationCache(null); 
	       android.os.Process.killProcess(android.os.Process.myPid() ); 
	    } 
	    
	    public void clearApplicationCache(java.io.File dir)
	    {  
	    	//����� ��� ĳ�� ���� 
	        if(dir==null) dir = getCacheDir(); 
	        if(dir==null) return; 
	        java.io.File[] children = dir.listFiles(); 
	        try
	        { 
	            CookieManager cookieManager = CookieManager.getInstance(); 
	            cookieManager.removeSessionCookie(); 
	            
	            for(int i=0;i<children.length;i++) 
	                if(children[i].isDirectory()) 
	                    clearApplicationCache(children[i]); 
	                else children[i].delete(); 
	        } 
	        
	        catch(Exception e){} 
	    }

}
