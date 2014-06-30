package com.example.drawpaper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class DrawActivity extends Activity 
{
	private Paint mPaint;
	private Path mPath;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_draw);
		  
	    Button back_btn = (Button) findViewById(R.id.back_btn);      
	     
      	//뒤로가기 버튼
	    back_btn.setOnClickListener(new Button.OnClickListener() 
		{
			public void onClick(View v) 
			{
				Intent intent_add = new Intent(DrawActivity.this, MainActivity.class);
				startActivity(intent_add);
			}
		});
  }
	@Override

	protected void onResume() 
	{
		// TODO Auto-generated method stub

		super.onResume();
	
		setContentView(new MyView(this));
		mPaint = new Paint();
		mPaint.setAntiAlias(true);
		mPaint.setDither(true);
		mPaint.setColor(0xFFFFFF00);
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setStrokeJoin(Paint.Join.ROUND);
		mPaint.setStrokeCap(Paint.Cap.ROUND);
		mPaint.setStrokeWidth(8);
	}
	
	public class drawPoint 
	{
		private float x;
		private float y;
		private boolean draw;

		public drawPoint(float x, float y, boolean d) 
		{
			this.x = x;
			this.y = y;
			draw = d;
		}
		
		public boolean getDraw() 
		{
			return draw;
		}

		public void setDraw(boolean _draw) 
		{
			draw = _draw;
		}
		
		public float getX() 
		{
		   return x;
		}

		public float getY() 
		{
			return y;
		}
	}
	
	public class MyView extends View
	{
		private static final float MINP = 0.25f;
		private static final float MAXP = 0.75f;
		private Bitmap mBitmap;
		Bitmap bm;
		private Canvas mCanvas;

		// private Path mPath;
		private Paint mBitmapPaint;
		public MyView(Context context) 
		{
			super(context);
			bm = BitmapFactory.decodeResource(getResources(), // 배경 비트맵
			R.drawable.ic_launcher);
	
			DisplayMetrics metrics = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(metrics);
	
			mBitmap = Bitmap.createBitmap(metrics.widthPixels,
			metrics.heightPixels, Bitmap.Config.ARGB_8888);
	
			mCanvas = new Canvas(mBitmap);
	
			mPath = new Path();
			mBitmapPaint = new Paint(Paint.DITHER_FLAG);
	
			// Matrix matrix;
			// mCanvas.setBitmap(bm);
			// mCanvas.drawBitmap(bm, matrix, 0xFFFFFFFF);
			mCanvas.drawColor(0xFFFFFFFF); // backgroundcolor
		}




		protected void onDraw(Canvas canvas) 
		{
			// canvas.drawColor(0x00000000);
			canvas.drawBitmap(bm, 0, 0, mBitmapPaint); // 배경바꾸기
			canvas.drawPath(mPath, mPaint);
		}
		
		private float mX, mY;
		private static final float TOUCH_TOLERANCE = 4;
		
		private void touch_start(float x, float y) 
		{
			// mPath.reset();
			mPath.moveTo(x, y);
			mX = x;
			mY = y;
		}

		private void touch_move(float x, float y) 
		{
			float dx = Math.abs(x - mX);
			float dy = Math.abs(y - mY);
			if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) 
			{
				mPath.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2);
				mX = x;
				mY = y;
			}
		}

		private void touch_up() 
		{
			mPath.lineTo(mX, mY);
			mCanvas.drawPath(mPath, mPaint);
			// mPath.reset();
		}

		public boolean onTouchEvent(MotionEvent event) 
		{
			int action = event.getAction();
			float x = event.getX();
			float y = event.getY();	
			drawPoint p = new drawPoint(x, y, false);	
			switch (action) 
			{
				case MotionEvent.ACTION_DOWN:	
				touch_start(x, y);	
				break;
		
				case MotionEvent.ACTION_MOVE:	
				touch_move(x, y);	
				break;
		
				case MotionEvent.ACTION_UP:		
				touch_up();		
				break;
			}
			
			invalidate();	
			return true;
		}
	}
		@Override
		public boolean onOptionsItemSelected(MenuItem item) 
		{
			// TODO Auto-generated method stub
			super.onOptionsItemSelected(item);

			switch (item.getItemId()) 
			{
				case 1:	
				mPath.reset();	
				onResume();
			}
			return true;

		}
}
