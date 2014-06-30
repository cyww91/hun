package com.roha.roha;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.CookieManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainMenuScreen extends Activity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main_menu_screen);
		
		
		
		//�ڵ鷯 �����
		ImageView btn_01 = (ImageView)findViewById(R.id.button_01);
		ImageView btn_02 = (ImageView)findViewById(R.id.button_02);
		ImageView btn_03 = (ImageView)findViewById(R.id.button_03);
		final EditText text_01 = (EditText)findViewById(R.id.editText1);
		
		
			
		//�߸��ϱ� ��ư
		btn_01.setOnClickListener(new Button.OnClickListener() 
		{
			public void onClick(View v) 
			{
				
			}
		});
		
		//�߸�������� ��ư
		btn_02.setOnClickListener(new Button.OnClickListener() 
		{
			public void onClick(View v) 
			{
				Intent intent_add = new Intent(MainMenuScreen.this, MakeScreen.class);
				startActivity(intent_add);
			}
		});
		
		//�˻� �ϱ� ��ư
		btn_03.setOnClickListener(new Button.OnClickListener() 
		{
			public void onClick(View v) 
			{
				final String str = text_01.getText().toString();
				
				 if(str.length() > 0)
				 {
					 Intent intent_add = new Intent(MainMenuScreen.this, PeopleScreen.class);
				     startActivity(intent_add);
				 }
				
				else
				{
					
				}
				

			}
		});

	}
	
public boolean onKeyDown(int keyCode, KeyEvent event) { 
        
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) { 
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
    public void onDestroy() { 
        super.onDestroy(); 
       clearApplicationCache(null); 
       android.os.Process.killProcess(android.os.Process.myPid() ); 
    } 
    
    public void clearApplicationCache(java.io.File dir){  //����� ��� ĳ�� ���� 
        if(dir==null) dir = getCacheDir(); 
        if(dir==null) return; 
        java.io.File[] children = dir.listFiles(); 
        try{ 
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
