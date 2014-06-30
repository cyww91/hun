package com.example.cafe;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.CookieManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Spinner;

@SuppressLint("ShowToast")
public class CafeScreen extends Activity 
{
	 Spinner spinner01;        // Spinner
	 Spinner spinner02;        // Spinner
	 int cafeId = 0;
    
	 private void populateSpinners() 
	 {
        ArrayAdapter<CharSequence> fAdapter;
        fAdapter = ArrayAdapter.createFromResource(this,R.array.town,android.R.layout.simple_spinner_item);
        fAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner01.setAdapter(fAdapter);
    }
    
    private void populateSubSpinners(int itemNum) 
    {
    	ArrayAdapter<CharSequence> fAdapter;
    	fAdapter = ArrayAdapter.createFromResource(this, itemNum, android.R.layout.simple_spinner_item);
        fAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner02.setAdapter(fAdapter);
    } 
    
    private OnItemSelectedListener spinSelectedlistener = new OnItemSelectedListener() 
    {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,int position, long id) 
            {
                switch(position){
                case (0):
                    populateSubSpinners(R.array.town_no);
                    break;
                case (1):
                    populateSubSpinners(R.array.town_seoul);
                    break;
                case (2):
                    populateSubSpinners(R.array.town_busan);
                    break;
                case (3):
                    populateSubSpinners(R.array.town_ulsan);
                    break;
                case (4):
                    populateSubSpinners(R.array.town_deagu);
                    break;
                case (5):
                    populateSubSpinners(R.array.town_daejeon);
                    break;
                case (6):
                    populateSubSpinners(R.array.town_gwangiu);
                    break;
                case (7):
                    populateSubSpinners(R.array.town_incheon);
                    break;
                }
            }
            
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
            
        };

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_cafe_screen);
		
		Button btn_cafe= (Button)findViewById(R.id.cafe_button);
		Button btn_profile= (Button)findViewById(R.id.profile_button);
		Button btn_mail= (Button)findViewById(R.id.mail_button);
		Button btn_friend= (Button)findViewById(R.id.friend_button);
		Button btn_setting= (Button)findViewById(R.id.setting_button);
		
		//Spinner01초기화
        spinner01 = (Spinner)findViewById(R.id.spinner1);
        populateSpinners();
        
        //Spinner02초기화
        spinner02 = (Spinner)findViewById(R.id.spinner2);
        populateSubSpinners(R.array.town);
        
        spinner01.setOnItemSelectedListener(spinSelectedlistener);
          
        //카페 리스트
        
        Button btn_list= (Button)findViewById(R.id.find_button);
        btn_list.setOnClickListener(new Button.OnClickListener() 
		{    	
			@Override
			public void onClick(View v) 
			{
				 if(spinner01.getSelectedItemPosition() == 2 && spinner02.getSelectedItemPosition() == 16)
		  	       {
					  ScrollView cafe = (ScrollView)findViewById(R.id.scrollView1);
					  cafe.setScaleY(1);
					 
					  ImageView oncafe = (ImageView)findViewById(R.id.oncafe);
		  	    	  oncafe.setImageResource(R.drawable.oncafe);
					 
					  ImageView cafe1 = (ImageView)findViewById(R.id.cafelist1);
		  	    	  cafe1.setImageResource(R.drawable.angel);
		  	    	 		  	    	  
		  	    	  ImageView cafe2 = (ImageView)findViewById(R.id.cafelist2);
		  	    	  cafe2.setImageResource(R.drawable.starbucks);
		  	    	 
		  	    	  
		  	    	  ImageView cafe3 = (ImageView)findViewById(R.id.cafelist3);
		  	    	  cafe3.setImageResource(R.drawable.caffebene);
		  	    	  
		  	    	  
		  	    	  ImageView cafe4 = (ImageView)findViewById(R.id.cafelist4);
		  	    	  cafe4.setImageResource(R.drawable.ediya);
		  	    	  
		  	    	  
		  	    	  ImageView cafe5 = (ImageView)findViewById(R.id.cafelist5);
		  	    	  cafe5.setImageResource(R.drawable.tomntoms);
		  	    	  
		  	    	cafe1.setOnClickListener(new Button.OnClickListener()
		  	    	  {
							@Override
							public void onClick(View v) 
							{				
								cafeId = 1;
								if(cafeId == 1)
								{
									Button btn_open= (Button)findViewById(R.id.open_button);
							 		btn_open.setOnClickListener(new Button.OnClickListener() 
									{
										public void onClick(View v) 
										{
											ImageView cafe = (ImageView)findViewById(R.id.cafe);
											cafe.setImageResource(R.drawable.angel2);
											cafe.setScaleY(1);
											
											ImageView map = (ImageView)findViewById(R.id.map);
											map.setImageResource(R.drawable.map);
											map.setScaleY(1);
											
									 		map.setOnClickListener(new Button.OnClickListener() 
											{
												public void onClick(View v) 
												{
													ImageView cafe_map = (ImageView)findViewById(R.id.cafe_map);
													cafe_map.setImageResource(R.drawable.map_angel);
													cafe_map.setScaleY(1);
												}
											
											});	
									 		
									 		ImageView cafe_map = (ImageView)findViewById(R.id.cafe_map);
											cafe_map.setOnClickListener(new Button.OnClickListener() 
											{
												public void onClick(View v) 
												{
													ImageView cafe_map= (ImageView)findViewById(R.id.cafe_map);
													//cafe_map.setImageResource(0);	
													cafe_map.setScaleY((float)0.001);
												}
											});	
											
											Button btn_open= (Button)findViewById(R.id.open_button);
											btn_open.setBackgroundResource(R.drawable.cafe_close);
										
									 		btn_open.setOnClickListener(new Button.OnClickListener() 
											{
												public void onClick(View v) 
												{
													Button btn_open= (Button)findViewById(R.id.open_button);
													btn_open.setBackgroundResource(R.drawable.open_button);
													
													ImageView cafe = (ImageView)findViewById(R.id.cafe);
													cafe.setScaleY((float)0.001);
													
													ImageView map = (ImageView)findViewById(R.id.map);
													map.setScaleY((float)0.001);
													
													ImageView cafe_map= (ImageView)findViewById(R.id.cafe_map);
													cafe_map.setScaleY((float)0.001);
												}
											
											});											
										}
									});
								}
							}
		  	    	  });
		  	    	
		  	    	cafe2.setOnClickListener(new Button.OnClickListener()
		  	    	  {
							@Override
							public void onClick(View v) 
							{
								cafeId = 2;
								if(cafeId == 2)
								{
									Button btn_open= (Button)findViewById(R.id.open_button);
							 		btn_open.setOnClickListener(new Button.OnClickListener() 
									{
										public void onClick(View v) 
										{
											ImageView cafe = (ImageView)findViewById(R.id.cafe);
											cafe.setImageResource(R.drawable.starbucks2);
											cafe.setScaleY(1);
											
											ImageView map = (ImageView)findViewById(R.id.map);
											map.setImageResource(R.drawable.map);
											map.setScaleY(1);
											
									 		map.setOnClickListener(new Button.OnClickListener() 
											{
												public void onClick(View v) 
												{
													ImageView cafe_map = (ImageView)findViewById(R.id.cafe_map);
													cafe_map.setImageResource(R.drawable.map_star);	
													cafe_map.setScaleY(1);
												}
											
											});	
									 		
									 		ImageView cafe_map = (ImageView)findViewById(R.id.cafe_map);
											cafe_map.setOnClickListener(new Button.OnClickListener() 
											{
												public void onClick(View v) 
												{
													ImageView cafe_map= (ImageView)findViewById(R.id.cafe_map);
													//cafe_map.setImageResource(0);
													cafe_map.setScaleY((float)0.001);
												}
											});	
											
											Button btn_open= (Button)findViewById(R.id.open_button);
											btn_open.setBackgroundResource(R.drawable.cafe_close);
										
									 		btn_open.setOnClickListener(new Button.OnClickListener() 
											{
												public void onClick(View v) 
												{
													Button btn_open= (Button)findViewById(R.id.open_button);
													btn_open.setBackgroundResource(R.drawable.open_button);
													
													ImageView cafe = (ImageView)findViewById(R.id.cafe);
													cafe.setScaleY((float)0.001);
													
													ImageView map = (ImageView)findViewById(R.id.map);
													map.setScaleY((float)0.001);
													
													ImageView cafe_map= (ImageView)findViewById(R.id.cafe_map);
													cafe_map.setScaleY((float)0.001);
												}
											
											});											
										}
									});
								}
							}
		  	    	  });
		  	    	
		  	    	cafe3.setOnClickListener(new Button.OnClickListener()
		  	    	  {
							@Override
							public void onClick(View v) 
							{
								cafeId = 3;
								if(cafeId == 3)
								{
									Button btn_open= (Button)findViewById(R.id.open_button);
							 		btn_open.setOnClickListener(new Button.OnClickListener() 
									{
										public void onClick(View v) 
										{
											ImageView cafe = (ImageView)findViewById(R.id.cafe);
											cafe.setImageResource(R.drawable.caffebene2);
											cafe.setScaleY(1);
											
											ImageView map = (ImageView)findViewById(R.id.map);
											map.setImageResource(R.drawable.map);
											map.setScaleY(1);
											
									 		map.setOnClickListener(new Button.OnClickListener() 
											{
												public void onClick(View v) 
												{
													ImageView cafe_map = (ImageView)findViewById(R.id.cafe_map);
													cafe_map.setImageResource(R.drawable.map_cafe);	
													cafe_map.setScaleY(1);
												}
											
											});	
									 		
									 		ImageView cafe_map = (ImageView)findViewById(R.id.cafe_map);
											cafe_map.setOnClickListener(new Button.OnClickListener() 
											{
												public void onClick(View v) 
												{
													ImageView cafe_map= (ImageView)findViewById(R.id.cafe_map);
													//cafe_map.setImageResource(0);
													cafe_map.setScaleY((float)0.001);
												}
											});	
											
											Button btn_open= (Button)findViewById(R.id.open_button);
											btn_open.setBackgroundResource(R.drawable.cafe_close);
										
									 		btn_open.setOnClickListener(new Button.OnClickListener() 
											{
												public void onClick(View v) 
												{
													Button btn_open= (Button)findViewById(R.id.open_button);
													btn_open.setBackgroundResource(R.drawable.open_button);
													
													ImageView cafe = (ImageView)findViewById(R.id.cafe);
													cafe.setScaleY((float)0.001);
													
													ImageView map = (ImageView)findViewById(R.id.map);
													map.setScaleY((float)0.001);
													
													ImageView cafe_map= (ImageView)findViewById(R.id.cafe_map);
													cafe_map.setScaleY((float)0.001);
												}
											
											});											
										}
									});
								}
							}
		  	    	  });
		  	    	
		  	    	cafe4.setOnClickListener(new Button.OnClickListener()
		  	    	  {
							@Override
							public void onClick(View v) 
							{
								cafeId = 4;
								if(cafeId == 4)
								{
									Button btn_open= (Button)findViewById(R.id.open_button);
							 		btn_open.setOnClickListener(new Button.OnClickListener() 
									{
										public void onClick(View v) 
										{
											ImageView cafe = (ImageView)findViewById(R.id.cafe);
											cafe.setImageResource(R.drawable.ediya2);
											cafe.setScaleY(1);
											
											ImageView map = (ImageView)findViewById(R.id.map);
											map.setImageResource(R.drawable.map);
											map.setScaleY(1);
											
									 		map.setOnClickListener(new Button.OnClickListener() 
											{
												public void onClick(View v) 
												{
													ImageView cafe_map = (ImageView)findViewById(R.id.cafe_map);
													cafe_map.setImageResource(R.drawable.map_ediya);
													cafe_map.setScaleY(1);
												}
											
											});	
									 		
									 		ImageView cafe_map = (ImageView)findViewById(R.id.cafe_map);
											cafe_map.setOnClickListener(new Button.OnClickListener() 
											{
												public void onClick(View v) 
												{
													ImageView cafe_map= (ImageView)findViewById(R.id.cafe_map);
													//cafe_map.setImageResource(0);	
													cafe_map.setScaleY((float)0.001);
												}
											});	
											
											Button btn_open= (Button)findViewById(R.id.open_button);
											btn_open.setBackgroundResource(R.drawable.cafe_close);
										
									 		btn_open.setOnClickListener(new Button.OnClickListener() 
											{
												public void onClick(View v) 
												{
													Button btn_open= (Button)findViewById(R.id.open_button);
													btn_open.setBackgroundResource(R.drawable.open_button);
													
													ImageView cafe = (ImageView)findViewById(R.id.cafe);
													cafe.setScaleY((float)0.001);
													
													ImageView map = (ImageView)findViewById(R.id.map);
													map.setScaleY((float)0.001);
													
													ImageView cafe_map= (ImageView)findViewById(R.id.cafe_map);
													cafe_map.setScaleY((float)0.001);
												}
											
											});											
										}
									});
								}
							}
		  	    	  });
		  	    	
		  	    	cafe5.setOnClickListener(new Button.OnClickListener()
		  	    	  {
							@Override
							public void onClick(View v) 
							{
								cafeId = 5;
								if(cafeId == 5)
								{
									Button btn_open= (Button)findViewById(R.id.open_button);
							 		btn_open.setOnClickListener(new Button.OnClickListener() 
									{
										public void onClick(View v) 
										{
											ImageView cafe = (ImageView)findViewById(R.id.cafe);
											cafe.setImageResource(R.drawable.tomntoms2);
											cafe.setScaleY(1);
											
											ImageView map = (ImageView)findViewById(R.id.map);
											map.setImageResource(R.drawable.map);
											map.setScaleY(1);
											
									 		map.setOnClickListener(new Button.OnClickListener() 
											{
												public void onClick(View v) 
												{
													ImageView cafe_map = (ImageView)findViewById(R.id.cafe_map);
													cafe_map.setImageResource(R.drawable.map_tom);
													cafe_map.setScaleY(1);
												}
											
											});	
									 		
									 		ImageView cafe_map = (ImageView)findViewById(R.id.cafe_map);
											cafe_map.setOnClickListener(new Button.OnClickListener() 
											{
												public void onClick(View v) 
												{
													ImageView cafe_map= (ImageView)findViewById(R.id.cafe_map);
													//cafe_map.setImageResource(0);		
													cafe_map.setScaleY((float)0.001);
												}
											});	
											
											Button btn_open= (Button)findViewById(R.id.open_button);
											btn_open.setBackgroundResource(R.drawable.cafe_close);
										
									 		btn_open.setOnClickListener(new Button.OnClickListener() 
											{
												public void onClick(View v) 
												{
													Button btn_open= (Button)findViewById(R.id.open_button);
													btn_open.setBackgroundResource(R.drawable.open_button);
													
													ImageView cafe = (ImageView)findViewById(R.id.cafe);
													cafe.setScaleY((float)0.001);
													
													ImageView map = (ImageView)findViewById(R.id.map);
													map.setScaleY((float)0.001);
													
													ImageView cafe_map= (ImageView)findViewById(R.id.cafe_map);
													cafe_map.setScaleY((float)0.001);
												}
											
											});											
										}
									});
								}
							}
		  	    	  });
		  	   
		  	       }
				 
				 else
				 {
					 ImageView oncafe = (ImageView)findViewById(R.id.oncafe);
					 oncafe.setImageResource(0);
					 
					 ImageView cafe1 = (ImageView)findViewById(R.id.cafelist1);
					 cafe1.setImageResource(0);
					 
					 ImageView cafe2 = (ImageView)findViewById(R.id.cafelist2);
					 cafe2.setImageResource(0);
					 
					 ImageView cafe3 = (ImageView)findViewById(R.id.cafelist3);
					 cafe3.setImageResource(0);
					 
					 ImageView cafe4 = (ImageView)findViewById(R.id.cafelist4);
					 cafe4.setImageResource(0);
					 
					 ImageView cafe5 = (ImageView)findViewById(R.id.cafelist5);
					 cafe5.setImageResource(0);
					 
					 ScrollView cafe = (ScrollView)findViewById(R.id.scrollView1);
					 cafe.setScaleY((float)0.001);
					 
					 ImageView map = (ImageView)findViewById(R.id.map);
					 map.setScaleY((float)0.001);
					
					ImageView cafe_map= (ImageView)findViewById(R.id.cafe_map);
					cafe_map.setScaleY((float)0.001);
				 }			
			} 
		});
		
		//프로필 버튼
		btn_profile.setOnClickListener(new Button.OnClickListener() 
		{
			public void onClick(View v) 
			{
				Intent intent_add = new Intent(CafeScreen.this, ProfileScreen.class);
				startActivity(intent_add);
				finish();
			}
		});
		
		//편지함 버튼
		btn_mail.setOnClickListener(new Button.OnClickListener() 
		{
			public void onClick(View v) 
			{
				Intent intent_add = new Intent(CafeScreen.this, MailScreen.class);
				startActivity(intent_add);
				finish();
			}
		});
		
		//친구목록 버튼
		btn_friend.setOnClickListener(new Button.OnClickListener() 
		{
			public void onClick(View v) 
			{
				Intent intent_add = new Intent(CafeScreen.this, FriendScreen.class);
				startActivity(intent_add);
				finish();
			}
		});
		
		//환경설정 버튼
		btn_setting.setOnClickListener(new Button.OnClickListener() 
		{
			public void onClick(View v) 
			{
				Intent intent_add = new Intent(CafeScreen.this, SettingScreen.class);
				startActivity(intent_add);
				finish();
			}
		});
		
	}
	
//	@Override 
//    public boolean onKeyDown(int keyCode, KeyEvent event) 
//	{ 
//        
//        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0)
//        { 
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
//                    onDestroy();
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
//    public void onDestroy() 
//    { 
//        super.onDestroy(); 
//       clearApplicationCache(null); 
//       android.os.Process.killProcess(android.os.Process.myPid() ); 
//    } 
//    
//    public void clearApplicationCache(java.io.File dir)
//    {  //종료시 모든 캐쉬 삭제 
//        if(dir==null) dir = getCacheDir(); 
//        if(dir==null) return; 
//        java.io.File[] children = dir.listFiles(); 
//        
//        try
//        { 
//            CookieManager cookieManager = CookieManager.getInstance(); 
//            cookieManager.removeSessionCookie(); 
//            
//            for(int i=0;i<children.length;i++) 
//                if(children[i].isDirectory()) 
//                    clearApplicationCache(children[i]); 
//                else children[i].delete(); 
//        } 
//        
//        catch(Exception e){} 
//    }
	
	
}
