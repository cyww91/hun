package com.example.cafe;


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

public class MainScreen extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main_screen);
		
		Button btn_main= (Button)findViewById(R.id.main_button);
		
		btn_main.setOnClickListener(new Button.OnClickListener() 
		{
			public void onClick(View v) 
			{
				Intent intent_add = new Intent(MainScreen.this, MainMenuScreen.class);
				startActivity(intent_add);
			}
		});
	}
	
	@Override 
    public boolean onKeyDown(int keyCode, KeyEvent event) { 
        
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) { 
            new AlertDialog.Builder(this) 
            .setIcon(android.R.drawable.ic_dialog_alert) 
            .setTitle("프로그램 종료") 
            .setMessage("프로그램을 종료 하시겠습니까?") 
            .setPositiveButton("예", 
            new DialogInterface.OnClickListener()  
            { 
                @Override 
                public void onClick( DialogInterface dialog, int which ) 
                { 
                    moveTaskToBack(true); 
                    finish(); 
                } 
            } 
            ).setNegativeButton("아니요", null ).show(); 
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
    
    public void clearApplicationCache(java.io.File dir){  //종료시 모든 캐쉬 삭제 
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
