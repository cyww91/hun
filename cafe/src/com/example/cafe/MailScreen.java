package com.example.cafe;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.webkit.CookieManager;
import android.widget.Button;

public class MailScreen extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_mail_screen);
		
		Button btn_cafe= (Button)findViewById(R.id.cafe_button);
		Button btn_profile= (Button)findViewById(R.id.profile_button);
		Button btn_mail= (Button)findViewById(R.id.mail_button);
		Button btn_friend= (Button)findViewById(R.id.friend_button);
		Button btn_setting= (Button)findViewById(R.id.setting_button);
		
		
		
		//카페 찾기 버튼
		btn_cafe.setOnClickListener(new Button.OnClickListener() 
		{
			public void onClick(View v) 
			{
				Intent intent_add = new Intent(MailScreen.this, CafeScreen.class);
				startActivity(intent_add);
				finish();
			}
		});
		
		
		//프로필 버튼
		btn_profile.setOnClickListener(new Button.OnClickListener() 
		{
			public void onClick(View v) 
			{
				Intent intent_add = new Intent(MailScreen.this, ProfileScreen.class);
				startActivity(intent_add);
				finish();
			}
		});
		
		
		//친구목록 버튼
		btn_friend.setOnClickListener(new Button.OnClickListener() 
		{
			public void onClick(View v) 
			{
				Intent intent_add = new Intent(MailScreen.this, FriendScreen.class);
				startActivity(intent_add);
				finish();
			}
		});
		
		//환경설정 버튼
		btn_setting.setOnClickListener(new Button.OnClickListener() 
		{
			public void onClick(View v) 
			{
				Intent intent_add = new Intent(MailScreen.this, SettingScreen.class);
				startActivity(intent_add);
				finish();
			}
		});
	}
	
//	@Override 
//    public boolean onKeyDown(int keyCode, KeyEvent event) { 
//        
//        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) { 
//            new AlertDialog.Builder(this) 
//            .setIcon(android.R.drawable.ic_dialog_alert) 
//            .setTitle("프로그램 종료") 
//            .setMessage("프로그램을 종료 하시겠습니까?") 
//            .setPositiveButton("예", 
//            new DialogInterface.OnClickListener()  
//            { 
//                @Override 
//                public void onClick( DialogInterface dialog, int which ) 
//                { 
//                    moveTaskToBack(true); 
//                    finish(); 
//                } 
//            } 
//            ).setNegativeButton("아니요", null ).show(); 
//            return true; 
//        }
//
//        return super.onKeyDown(keyCode, event); 
//    } 
//    
//    @Override 
//    public void onDestroy() { 
//        super.onDestroy(); 
//       clearApplicationCache(null); 
//       android.os.Process.killProcess(android.os.Process.myPid() ); 
//    } 
//    
//    public void clearApplicationCache(java.io.File dir){  //종료시 모든 캐쉬 삭제 
//        if(dir==null) dir = getCacheDir(); 
//        if(dir==null) return; 
//        java.io.File[] children = dir.listFiles(); 
//        try{ 
//            CookieManager cookieManager = CookieManager.getInstance(); 
//            cookieManager.removeSessionCookie(); 
//            
//            for(int i=0;i<children.length;i++) 
//                if(children[i].isDirectory()) 
//                    clearApplicationCache(children[i]); 
//                else children[i].delete(); 
//        } 
//        catch(Exception e){} 
//    }


}
