package com.example.inucampusmap;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class UseInfoActivity0 extends Activity{
	public static int infoNumber = 0;
	private GoogleMap mMap;
	private View v;
	private TextView ctv;
	private ImageView civ;
	private Marker marker;
	private Context mContext;
	
	ImageView mImageView;
	ImageView mImageView2;
	BitmapDrawable dr;
	LatLng loc = new LatLng(37.37556, 126.63279); // 위치 좌표 설정 
	CameraPosition cp = new CameraPosition.Builder().target((loc)).zoom(16).build(); 
	//정보를 저장할 곳
	private ArrayList<UseInfoData> map_info_list;
	private UseInfoData map_info;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_useinfo_info0);
        //setContentView(R.layout.activity_building_mapshow);
        mImageView = (ImageView)findViewById(R.id.buildingImageView);
       
       // mImageView = (ImageView)findViewById(R.id.useInfoImageView);
        mImageView2 = (ImageView)findViewById(R.id.useInfoMapImage);
     
        //Bitmap bitmap = null;
        //Bitmap bitmap2 = null;
        map_info_list.add(new UseInfoData("37.37372,126.63265","공과대학 매점",(R.drawable.i0)));
        map_info_list.add(new UseInfoData("37.37751,126.63379","교직원 식당",(R.drawable.i1)));
    	map_info_list.add(new UseInfoData("37.37751,126.63379","교직원 카페",(R.drawable.i2)));
    	map_info_list.add(new UseInfoData("37.37289,126.63159","놀부보쌈",(R.drawable.i3)));
    	map_info_list.add(new UseInfoData("37.37448,126.63175","농협중앙회",(R.drawable.i4)));
    	map_info_list.add(new UseInfoData("37.37516,126.63396","도서관 매점",(R.drawable.i5)));
    	map_info_list.add(new UseInfoData("37.37448,126.63175","모닝글로리(문구점)",(R.drawable.i6)));
    	map_info_list.add(new UseInfoData("37.37448,126.63175","헤어비토(미용실)",(R.drawable.i7)));
    	map_info_list.add(new UseInfoData("37.37448,126.63175","복지회관 복사점",(R.drawable.i8)));
    	map_info_list.add(new UseInfoData("37.37516,126.63396","도서관 복사점",(R.drawable.i9)));
    	map_info_list.add(new UseInfoData("37.37448,126.63175","복지회관 매점",(R.drawable.i10)));
    	map_info_list.add(new UseInfoData("37.37448,126.63175","사진관",(R.drawable.i11)));
    	map_info_list.add(new UseInfoData("37.37392,126.62984","생활관 식당",(R.drawable.i12)));
    	map_info_list.add(new UseInfoData("37.37448,126.63175","서점",(R.drawable.i13)));
    	map_info_list.add(new UseInfoData("37.37604,126.63239","토스트 매점",(R.drawable.i14)));
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
        switch(infoNumber)
        {
	        case 0 :
	        	//bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i0);
	        	//bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im0);break;
	        	/*bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.i0);
	        	bitmap = Bitmap.createScaledBitmap(bitmap, 450, 300, true);
	        	bitmap2 = BitmapFactory.decodeResource(getResources(),R.drawable.im0);
	        	bitmap2 = Bitmap.createScaledBitmap(bitmap2, 450, 300, true);*/
	        	//map_info_list.add(new UseInfoData("37.37372,126.63265","공과대학 매점",(R.drawable.i0)));
	        	mImageView.setImageResource(map_info_list.get(0).getPlace_img());
				mMap=((MapFragment)getFragmentManager().findFragmentById(R.id.campus_mapshow)).getMap();
				//mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp)); 				
	        	//marker = mMap.addMarker(new MarkerOptions().position(map_info_list.get(0).getPlace_location()));
	        	//startActivity(new Intent(UseInfoActivity0.this,ShowLocation.class));
			case 1 :
				//bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i1);
				//bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im1);break;
				//map_info_list.add(new UseInfoData("37.37751,126.63379","교직원 식당",(R.drawable.i1)));
			case 2 :
				//bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i2);
				//bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im2);break;
				//map_info_list.add(new UseInfoData("37.37751,126.63379","교직원 카페",(R.drawable.i2)));
			case 3 :
				//bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i3);
				//bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im3);break;
				//map_info_list.add(new UseInfoData("37.37289,126.63159","놀부보쌈",(R.drawable.i3)));
			case 4 :
				//bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i4);
				//bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im4);break;
				//map_info_list.add(new UseInfoData("37.37448,126.63175","농협중앙회",(R.drawable.i4)));
			case 5 :
				//bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i5);
				//bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im5);break;
				//map_info_list.add(new UseInfoData("37.37516,126.63396","도서관 매점",(R.drawable.i5)));
			case 6 :
				//bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i6);
				//bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im6);break;
				//map_info_list.add(new UseInfoData("37.37448,126.63175","모닝글로리(문구점)",(R.drawable.i6)));
			case 7 :
				//bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i7);
				//bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im7);break;
				//map_info_list.add(new UseInfoData("37.37448,126.63175","헤어비토(미용실)",(R.drawable.i7)));
			case 8 :
				//bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i8);
				//bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im8);break;
				//map_info_list.add(new UseInfoData("37.37448,126.63175","복지회관 복사점",(R.drawable.i8)));
			case 9 :
				//bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i9);
				//bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im9);break;
				//map_info_list.add(new UseInfoData("37.37516,126.63396","도서관 복사점",(R.drawable.i9)));
			case 10:
				//bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i10);
				//bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im10);break;
				//map_info_list.add(new UseInfoData("37.37448,126.63175","복지회관 매점",(R.drawable.i10)));
			case 11:
				//bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i11);
				//bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im11);break;
				//map_info_list.add(new UseInfoData("37.37448,126.63175","사진관",(R.drawable.i11)));
			case 12:
				//bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i12);
				//bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im12);break;
				//map_info_list.add(new UseInfoData("37.37392,126.62984","생활관 식당",(R.drawable.i12)));
			case 13:
				//bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i13);
				//bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im13);break;
				//map_info_list.add(new UseInfoData("37.37448,126.63175","서점",(R.drawable.i13)));
			case 14:
				//bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i14);
				//bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im14);break;
				//map_info_list.add(new UseInfoData("37.37604,126.63239","토스트 매점",(R.drawable.i14)));
			case 15:
				//bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i15);
				//bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im15);break;
				//map_info_list.add(new UseInfoData("37.37491,126.62976","스포츠 센터",(R.drawable.i15)));
			case 16:
				//bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i16);
				//bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im16);break;
				//map_info_list.add(new UseInfoData("37.37448,126.63175","안경점",(R.drawable.i16)));
			case 17:
				//bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i17);
				//bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im17);break;
				//map_info_list.add(new UseInfoData("37.37448,126.63175","여행사 유학원",(R.drawable.i17)));
			case 18:
				//bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i18);
				//bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im18);break;
				//map_info_list.add(new UseInfoData("37.37448,126.63175","우체국",(R.drawable.i18)));
			case 19:
				//bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i19);
				//bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im19);break;
				//map_info_list.add(new UseInfoData("37.37448,126.63175","이동 통신사",(R.drawable.i19)));
			case 20:
				//bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i20);
				//bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im20);break;
				//map_info_list.add(new UseInfoData("37.37519,126.63169","인문대 매점",(R.drawable.i20)));
			case 21:
				//bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i21);
				//bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im21);break;
				//map_info_list.add(new UseInfoData("37.37576,126.63517","자연대 매점",(R.drawable.i21)));
			case 22:
				//bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i22);
				//bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im22);break;
				//map_info_list.add(new UseInfoData("37.37430,126.63087","그라지에 제과점",(R.drawable.i22)));
			case 23:
				//bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i23);
				//bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im23);break;
				//map_info_list.add(new UseInfoData("37.37372,126.63265","공과대학매점",(R.drawable.i23)));
			case 24:
				//bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i24);
				//bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im24);break;
				//map_info_list.add(new UseInfoData("37.37435,126.63075","피자리아(피자&파스타)",(R.drawable.i24)));
			case 25:
				//bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i25);
				//bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im25);break;
				//map_info_list.add(new UseInfoData("37.37448,126.63175","학생식당",(R.drawable.i25)));
			case 26:
				//bitmap = (BitmapDrawable)res.getDrawable(R.drawable.i26);
				//bitmap2 = (BitmapDrawable)res.getDrawable(R.drawable.im26);break;
				//map_info_list.add(new UseInfoData("37.37415,126.63068","한솥도시락",(R.drawable.i26)));
        }
        //mImageView.setImageDrawable(bitmap);
        //mImageView2.setImageDrawable(bitmap2);
      //  mImageView.setImageBitmap(bitmap);
      //  mImageView.setScaleType(ImageView.ScaleType.FIT_START);
       // mImageView2.setImageBitmap(bitmap2);
       // mImageView2.setScaleType(ImageView.ScaleType.FIT_START);
        
    }
}
