package com.example.inucampusmap;

import java.util.*;
import android.app.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.os.*;
import android.widget.*;

public class UseInfoActivity0 extends Activity{
	public static int infoNumber = 0;
	ImageView mImageView;
	ImageView mImageView2;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_useinfo_info0);
        mImageView = (ImageView)findViewById(R.id.useInfoImageView);
        mImageView2 = (ImageView)findViewById(R.id.useInfoMapImage);
        
        Resources res = getResources();
        BitmapDrawable bitmap = null;
        BitmapDrawable bitmap2 = null;
        
        
        
        
        switch(infoNumber)
        {
	        case 0 :
	        	bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i0);
	        	bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im0);break;
			case 1 :
				bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i1);
				bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im1);break;
			case 2 :
				bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i2);
				bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im2);break;
			case 3 :
				bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i3);
				bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im3);break;
			case 4 :
				bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i4);
				bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im4);break;
			case 5 :
				bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i5);
				bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im5);break;
			case 6 :
				bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i6);
				bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im6);break;
			case 7 :
				bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i7);
				bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im7);break;
			case 8 :
				bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i8);
				bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im8);break;
			case 9 :
				bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i9);
				bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im9);break;
			case 10:
				bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i10);
				bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im10);break;
			case 11:
				bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i11);
				bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im11);break;
			case 12:
				bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i12);
				bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im12);break;
			case 13:
				bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i13);
				bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im13);break;
			case 14:
				bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i14);
				bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im14);break;
			case 15:
				bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i15);
				bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im15);break;
			case 16:
				bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i16);
				bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im16);break;
			case 17:
				bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i17);
				bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im17);break;
			case 18:
				bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i18);
				bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im18);break;
			case 19:
				bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i19);
				bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im19);break;
			case 20:
				bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i20);
				bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im20);break;
			case 21:
				bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i21);
				bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im21);break;
			case 22:
				bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i22);
				bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im22);break;
			case 23:
				bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i23);
				bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im23);break;
			case 24:
				bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i24);
				bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im24);break;
			case 25:
				bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i25);
				bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im25);break;
			case 26:
				bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i26);
				bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im26);break;
        }
        mImageView.setImageDrawable(bitmap);
        mImageView2.setImageDrawable(bitmap2);
    }
}
