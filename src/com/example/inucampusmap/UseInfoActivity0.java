 package com.example.inucampusmap;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.*;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.*;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.*;

public class UseInfoActivity0 extends FragmentActivity{
	public static int infoNumber = 0;
	private GoogleMap mMap;
	private ImageView civ;
	private ArrayList<UseInfoData> map_info_list;
	private UseInfoData map_info;
	private Marker marker;
	
	ImageView mImageView;
	LatLng loc;
	CameraPosition cp;
	Bitmap bitmap = null;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_useinfo_info0);
        mImageView = (ImageView)findViewById(R.id.useInfoImageView);
        
        add_info_list();
    	show_map();
	}
    
	public void add_info_list(){
		map_info_list = new ArrayList<UseInfoData>();
        map_info_list.add(new UseInfoData("37.37372,126.63265","공과대학 매점"));//0
        map_info_list.add(new UseInfoData("37.37751,126.63379","교직원 식당"));//1
    	map_info_list.add(new UseInfoData("37.37751,126.63379","교직원 카페"));//2
    	map_info_list.add(new UseInfoData("37.37289,126.63159","놀부보쌈"));//3
    	map_info_list.add(new UseInfoData("37.37448,126.63175","농협중앙회"));//4
    	map_info_list.add(new UseInfoData("37.37516,126.63396","도서관 매점"));//5
    	map_info_list.add(new UseInfoData("37.37448,126.63175","모닝글로리(문구점)"));//6
    	map_info_list.add(new UseInfoData("37.37448,126.63175","헤어비토(미용실)"));//7
    	map_info_list.add(new UseInfoData("37.37448,126.63175","복지회관 복사점"));//8
    	map_info_list.add(new UseInfoData("37.37516,126.63396","도서관 복사점"));//9
    	map_info_list.add(new UseInfoData("37.37448,126.63175","복지회관 매점"));//10
    	map_info_list.add(new UseInfoData("37.37448,126.63175","사진관"));//11
    	map_info_list.add(new UseInfoData("37.37392,126.62984","생활관 식당"));//12
    	map_info_list.add(new UseInfoData("37.37448,126.63175","서점"));//13
    	map_info_list.add(new UseInfoData("37.37604,126.63239","토스트 매점"));//14
    	map_info_list.add(new UseInfoData("37.374831,126.629754","스포츠센터"));//15
    	map_info_list.add(new UseInfoData("37.375164,126.631749","인문대매점"));//16
    	map_info_list.add(new UseInfoData("37.375547,126.635150","자연대매점"));//17
    	map_info_list.add(new UseInfoData("37.374226,126.630719","그라지에 제과점"));//18
    	map_info_list.add(new UseInfoData("37.375539,126.633230","주차장 관리실"));//19
    	map_info_list.add(new UseInfoData("37.373944,126.631621","학생식당"));//20
	}
	public void show_map(){
		//이부분 내껄로 맞춰서 focus까지         
      	mMap=((MapFragment)getFragmentManager().findFragmentById(R.id.location_map)).getMap();
      	
        switch(infoNumber)
        {
	        case 0 ://공대매점      	
	        	bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.i0);
	        	bitmap = Bitmap.createScaledBitmap(bitmap, 450, 300, true);
	        	loc = map_info_list.get(0).getPlace_location();
	          	cp = new CameraPosition.Builder().target((loc)).zoom(17).build();
	          	mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
	          	marker = mMap.addMarker(new MarkerOptions().position(map_info_list.get(0).getPlace_location()));
	          	break;
			case 1 ://교직원식당
				bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.i1);
	        	bitmap = Bitmap.createScaledBitmap(bitmap, 450, 300, true);
	        	loc = map_info_list.get(1).getPlace_location();
	          	cp = new CameraPosition.Builder().target((loc)).zoom(17).build();
	          	mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
	          	marker = mMap.addMarker(new MarkerOptions().position(map_info_list.get(1).getPlace_location()));
	          	break;
			case 2 ://교직원카페
				bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.i2);
	        	bitmap = Bitmap.createScaledBitmap(bitmap, 450, 300, true);
	        	loc = map_info_list.get(2).getPlace_location();
	          	cp = new CameraPosition.Builder().target((loc)).zoom(17).build();
	          	mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
	          	marker = mMap.addMarker(new MarkerOptions().position(map_info_list.get(2).getPlace_location()));
	          	break;
			case 3 ://놀부보삼
				bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.i3);
	        	bitmap = Bitmap.createScaledBitmap(bitmap, 450, 300, true);
	        	loc = map_info_list.get(3).getPlace_location();
	          	cp = new CameraPosition.Builder().target((loc)).zoom(17).build();
	          	mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
	          	marker = mMap.addMarker(new MarkerOptions().position(map_info_list.get(3).getPlace_location()));
	          	break;
			case 4 ://농협중앙회
				bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.i4);
	        	bitmap = Bitmap.createScaledBitmap(bitmap, 450, 300, true);
	        	loc = map_info_list.get(4).getPlace_location();
	          	cp = new CameraPosition.Builder().target((loc)).zoom(17).build();
	          	mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
	          	marker = mMap.addMarker(new MarkerOptions().position(map_info_list.get(4).getPlace_location()));
	          	break;
			case 5 ://도서관매점
				bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.i5);
	        	bitmap = Bitmap.createScaledBitmap(bitmap, 450, 300, true);
	        	loc = map_info_list.get(5).getPlace_location();
	          	cp = new CameraPosition.Builder().target((loc)).zoom(17).build();
	          	mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
	          	marker = mMap.addMarker(new MarkerOptions().position(map_info_list.get(5).getPlace_location()));
	          	break;
			case 6 ://모닝글로리
				bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.i6);
	        	bitmap = Bitmap.createScaledBitmap(bitmap, 450, 300, true);
	        	loc = map_info_list.get(6).getPlace_location();
	          	cp = new CameraPosition.Builder().target((loc)).zoom(17).build();
	          	mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
	          	marker = mMap.addMarker(new MarkerOptions().position(map_info_list.get(6).getPlace_location()));
	          	break;
			case 7 ://헤어비토
				bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.i7);
	        	bitmap = Bitmap.createScaledBitmap(bitmap, 450, 300, true);
	        	loc = map_info_list.get(7).getPlace_location();
	          	cp = new CameraPosition.Builder().target((loc)).zoom(17).build();
	          	mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
	          	marker = mMap.addMarker(new MarkerOptions().position(map_info_list.get(7).getPlace_location()));
	          	break;
			case 8 ://복지회관 복사점
				bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.i8);
	        	bitmap = Bitmap.createScaledBitmap(bitmap, 450, 300, true);
	        	loc = map_info_list.get(8).getPlace_location();
	          	cp = new CameraPosition.Builder().target((loc)).zoom(17).build();
	          	mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
	          	marker = mMap.addMarker(new MarkerOptions().position(map_info_list.get(8).getPlace_location()));
	          	break;
			case 9 ://도서관 복사점
				bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.i9);
	        	bitmap = Bitmap.createScaledBitmap(bitmap, 450, 300, true);
	        	loc = map_info_list.get(9).getPlace_location();
	          	cp = new CameraPosition.Builder().target((loc)).zoom(17).build();
	          	mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
	          	marker = mMap.addMarker(new MarkerOptions().position(map_info_list.get(9).getPlace_location()));
	          	break;
			case 10://복지회관 매점
				bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.i10);
	        	bitmap = Bitmap.createScaledBitmap(bitmap, 450, 300, true);
	        	loc = map_info_list.get(10).getPlace_location();
	          	cp = new CameraPosition.Builder().target((loc)).zoom(17).build();
	          	mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
	          	marker = mMap.addMarker(new MarkerOptions().position(map_info_list.get(10).getPlace_location()));
	          	break;
			case 11://사진관
				bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.i11);
	        	bitmap = Bitmap.createScaledBitmap(bitmap, 450, 300, true);
	        	loc = map_info_list.get(11).getPlace_location();
	          	cp = new CameraPosition.Builder().target((loc)).zoom(17).build();
	          	mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
	          	marker = mMap.addMarker(new MarkerOptions().position(map_info_list.get(11).getPlace_location()));
	          	break;
			case 12://생활관 식당
				bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.i12);
	        	bitmap = Bitmap.createScaledBitmap(bitmap, 450, 300, true);
	        	loc = map_info_list.get(12).getPlace_location();
	          	cp = new CameraPosition.Builder().target((loc)).zoom(17).build();
	          	mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
	          	marker = mMap.addMarker(new MarkerOptions().position(map_info_list.get(12).getPlace_location()));
	          	break;
			case 13://서점
				bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.i13);
	        	bitmap = Bitmap.createScaledBitmap(bitmap, 450, 300, true);
	        	loc = map_info_list.get(13).getPlace_location();
	          	cp = new CameraPosition.Builder().target((loc)).zoom(17).build();
	          	mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
	          	marker = mMap.addMarker(new MarkerOptions().position(map_info_list.get(13).getPlace_location()));
	          	break;
			case 14://토스트매점
				bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.i14);
	        	bitmap = Bitmap.createScaledBitmap(bitmap, 450, 300, true);
	        	loc = map_info_list.get(14).getPlace_location();
	          	cp = new CameraPosition.Builder().target((loc)).zoom(17).build();
	          	mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
	          	marker = mMap.addMarker(new MarkerOptions().position(map_info_list.get(14).getPlace_location()));
	          	break;
			case 15://스포츠센터
				bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.i15);
	        	bitmap = Bitmap.createScaledBitmap(bitmap, 450, 300, true);
	        	loc = map_info_list.get(15).getPlace_location();
	          	cp = new CameraPosition.Builder().target((loc)).zoom(17).build();
	          	mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
	          	marker = mMap.addMarker(new MarkerOptions().position(map_info_list.get(15).getPlace_location()));
	          	break;
			case 16://안경점
				bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.i16);
	        	bitmap = Bitmap.createScaledBitmap(bitmap, 450, 300, true);
	        	loc = map_info_list.get(6).getPlace_location();
	          	cp = new CameraPosition.Builder().target((loc)).zoom(17).build();
	          	mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
	          	marker = mMap.addMarker(new MarkerOptions().position(map_info_list.get(6).getPlace_location()));
	          	break;
			case 17://여행사유학원
				bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.i17);
	        	bitmap = Bitmap.createScaledBitmap(bitmap, 450, 300, true);
	        	loc = map_info_list.get(6).getPlace_location();
	          	cp = new CameraPosition.Builder().target((loc)).zoom(17).build();
	          	mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
	          	marker = mMap.addMarker(new MarkerOptions().position(map_info_list.get(6).getPlace_location()));
	          	break;
			case 18://우체국
				bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.i18);
	        	bitmap = Bitmap.createScaledBitmap(bitmap, 450, 300, true);
	        	loc = map_info_list.get(6).getPlace_location();
	          	cp = new CameraPosition.Builder().target((loc)).zoom(17).build();
	          	mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
	          	marker = mMap.addMarker(new MarkerOptions().position(map_info_list.get(6).getPlace_location()));
	          	break;
			case 19://이동통신사
				bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.i19);
	        	bitmap = Bitmap.createScaledBitmap(bitmap, 450, 300, true);
	        	loc = map_info_list.get(6).getPlace_location();
	          	cp = new CameraPosition.Builder().target((loc)).zoom(17).build();
	          	mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
	          	marker = mMap.addMarker(new MarkerOptions().position(map_info_list.get(6).getPlace_location()));
	          	break;
			case 20://인문대매점
				bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.i20);
	        	bitmap = Bitmap.createScaledBitmap(bitmap, 450, 300, true);
	        	loc = map_info_list.get(16).getPlace_location();
	          	cp = new CameraPosition.Builder().target((loc)).zoom(17).build();
	          	mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
	          	marker = mMap.addMarker(new MarkerOptions().position(map_info_list.get(16).getPlace_location()));
	          	break;
			case 21://자연대매점
				bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.i21);
	        	bitmap = Bitmap.createScaledBitmap(bitmap, 450, 300, true);
	        	loc = map_info_list.get(17).getPlace_location();
	          	cp = new CameraPosition.Builder().target((loc)).zoom(17).build();
	          	mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
	          	marker = mMap.addMarker(new MarkerOptions().position(map_info_list.get(17).getPlace_location()));
	          	break;
			case 22://그라지에 제과점
				bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.i22);
	        	bitmap = Bitmap.createScaledBitmap(bitmap, 450, 300, true);
	        	loc = map_info_list.get(18).getPlace_location();
	          	cp = new CameraPosition.Builder().target((loc)).zoom(17).build();
	          	mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
	          	marker = mMap.addMarker(new MarkerOptions().position(map_info_list.get(18).getPlace_location()));
	          	break;
			case 23://주차장 관리실
				bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.i23);
	        	bitmap = Bitmap.createScaledBitmap(bitmap, 450, 300, true);
	        	loc = map_info_list.get(19).getPlace_location();
	          	cp = new CameraPosition.Builder().target((loc)).zoom(17).build();
	          	mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
	          	marker = mMap.addMarker(new MarkerOptions().position(map_info_list.get(19).getPlace_location()));
	          	break;
			case 24://피자리아
				bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.i24);
	        	bitmap = Bitmap.createScaledBitmap(bitmap, 450, 300, true);
	        	loc = map_info_list.get(18).getPlace_location();
	          	cp = new CameraPosition.Builder().target((loc)).zoom(17).build();
	          	mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
	          	marker = mMap.addMarker(new MarkerOptions().position(map_info_list.get(18).getPlace_location()));
	          	break;
			case 25://학생식당
				bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.i25);
	        	bitmap = Bitmap.createScaledBitmap(bitmap, 450, 300, true);
	        	loc = map_info_list.get(20).getPlace_location();
	          	cp = new CameraPosition.Builder().target((loc)).zoom(17).build();
	          	mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
	          	marker = mMap.addMarker(new MarkerOptions().position(map_info_list.get(20).getPlace_location()));
	          	break;
			case 26://한솥도시락
				bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.i26);
	        	bitmap = Bitmap.createScaledBitmap(bitmap, 450, 300, true);
	        	loc = map_info_list.get(18).getPlace_location();
	          	cp = new CameraPosition.Builder().target((loc)).zoom(17).build();
	          	mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
	          	marker = mMap.addMarker(new MarkerOptions().position(map_info_list.get(18).getPlace_location()));
	          	break;
        }
        mImageView.setImageBitmap(bitmap);
        mImageView.setScaleType(ImageView.ScaleType.FIT_START);
	}
	
}
