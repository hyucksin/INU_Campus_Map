package com.example.inucampusmap;

import java.util.*;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.drawable.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class BuildingInfoActivity0 extends Activity{
	ImageView mImageView;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building_info0);
        mImageView = (ImageView)findViewById(R.id.buildingImageView);
    }
	
	
	//선택한 버튼에 따라 해당 Activity로 이동
    public void onClick(View v) {
    	Resources res;
    	BitmapDrawable bitmap;
    	switch(v.getId()){
    	
    	//누른 버튼에 따라 이미지를 다르게 띄움
    	case R.id.f1Button :
    		res = getResources();
    		bitmap = (BitmapDrawable) res.getDrawable(R.drawable.b7_1);
    		mImageView.setImageDrawable(bitmap);
    		break;
    	case R.id.f2Button :
    		res = getResources();
    		bitmap = (BitmapDrawable) res.getDrawable(R.drawable.b7_2);
    		mImageView.setImageDrawable(bitmap);
    		break;
    	case R.id.locationButton :      		
    		res = getResources();
    		bitmap = (BitmapDrawable) res.getDrawable(R.drawable.b7_3);
    		mImageView.setImageDrawable(bitmap);
    		break;
    	}
    }
}
