package com.example.inucampusmap;

import java.util.*;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class UseInfoActivityImage extends Activity{
	public static int infoNumber = 0;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_useinfo_info0);
        InfoView infoView = new InfoView(this, infoNumber);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//상단 타이틀 삭제
        setContentView(infoView);
    }
}

class InfoView extends View{
	int number;
	public InfoView(Context context, int number){
		super(context);
		this.number = number;
	}
	
	public void onDraw(Canvas canvas){
		canvas.drawColor(Color.LTGRAY);
		Paint pnt = new Paint();
		Bitmap bitmap = null;
		switch(number){
			case 0 :
				bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.i0);break;
			case 1 :
				bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.i1);break;
			case 2 :
				bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.i2);break;
			case 3 :
				bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.i3);break;
			case 4 :
				bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.i4);break;
			case 5 :
				bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.i5);break;
			case 6 :
				bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.i6);break;
			case 7 :
				bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.i7);break;
			case 8 :
				bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.i8);break;
			case 9 :
				bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.i9);break;
			case 10:
				bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.i10);break;
			case 11:
				bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.i11);break;
			case 12:
				bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.i12);break;
			case 13:
				bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.i13);break;
			case 14:
				bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.i14);break;
			case 15:
				bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.i15);break;
			case 16:
				bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.i16);break;
			case 17:
				bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.i17);break;
			case 18:
				bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.i18);break;
			case 19:
				bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.i19);break;
			case 20:
				bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.i20);break;
			case 21:
				bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.i21);break;
			case 22:
				bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.i22);break;
			case 23:
				bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.i23);break;
			case 24:
				bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.i24);break;
			case 25:
				bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.i25);break;
			case 26:
				bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.i26);break;	
		}
		
		
		Rect rtDest = new Rect(40,10,1000,800);
		
		canvas.drawBitmap(bitmap, null, rtDest,null);
	}
}