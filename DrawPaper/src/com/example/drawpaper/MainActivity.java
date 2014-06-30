package com.example.drawpaper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity 
{

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        Button draw_btn = (Button) findViewById(R.id.draw_btn);
        Button end_btn = (Button) findViewById(R.id.end_btn);      
    
      	//그리기 버튼
        draw_btn.setOnClickListener(new Button.OnClickListener() 
		{
			public void onClick(View v) 
			{
				Intent intent_add = new Intent(MainActivity.this, DrawActivity.class);
				startActivity(intent_add);
			}
		});
        
      //끝내기 버튼
        end_btn.setOnClickListener(new Button.OnClickListener() 
		{
			public void onClick(View v) 
			{
				finish();
			}
		});
    }
}
