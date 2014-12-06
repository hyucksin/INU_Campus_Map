package com.example.inucampusmap;

import java.util.ArrayList;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class BuildingInfoActivity7 extends Activity{
	GoogleMap mMap;
	Marker marker;
	LatLng loc ; // 위치 좌표 설정 
	CameraPosition cp;    

	ImageView mImageView;
	Bitmap bitmap = null;
	TextView textView = null;
	TextRoom textRoom = new TextRoom();
	ArrayList<String> textArray = new TextRoom().textArray;

	private LinearLayout mImage;
	private LinearLayout mText;

	final int F_ONE = 0;
	final int F_TWO = 1;
	final int F_THREE = 2;
	final int F_FOUR = 3;
	final int F_FIVE = 4;

	final int R_ONE = 5;
	final int R_TWO = 6;
	final int R_THREE = 7;
	final int R_FOUR = 8;
	final int R_FIVE = 9;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_building_info0);
		
		
		textView = (TextView)findViewById(R.id.textRoomList);

		Button mapButton = (Button)findViewById(R.id.floorMapButton);
		Button roomButton = (Button)findViewById(R.id.floorRoomButton);

		registerForContextMenu(mapButton);
		registerForContextMenu(roomButton);
		mImage = (LinearLayout)findViewById(R.id.frameLayoutImage);
		mText = (LinearLayout)findViewById(R.id.frameLayoutText);

	}
	//선택한 버튼에 따라 해당 Activity로 이동 //location버튼을 누르면 지도가 나오게 하는 것.
	public void onClick(View v) {
		Resources res;
		Bitmap bitmap;
		switch(v.getId()){
		case R.id.locationButton :
			setContentView(R.layout.activity_building_mapshow);
			bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.b7);
        	bitmap = Bitmap.createScaledBitmap(bitmap, 450, 300, true);
        	mImageView = (ImageView)findViewById(R.id.buildingImageView);
        	mImageView.setImageBitmap(bitmap);
            mImageView.setScaleType(ImageView.ScaleType.FIT_START);
			loc = new LatLng(37.374494, 126.633517);
          	cp = new CameraPosition.Builder().target((loc)).zoom(17).build();
			mMap=((MapFragment)getFragmentManager().findFragmentById(R.id.campus_mapshow)).getMap();
			mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));   
			marker = mMap.addMarker(new MarkerOptions().position(loc));
			break;
		case R.id.floorMapButton :
			this.openContextMenu(v);
			break;
		case R.id.floorRoomButton :
			this.openContextMenu(v);
			break;
		}
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {

		if(v.getId() == R.id.floorMapButton) {
			menu.setHeaderIcon(android.R.drawable.btn_star);
			menu.setHeaderTitle("층별 구조도 보기");
			menu.add(Menu.NONE, F_ONE, Menu.NONE, "1층");
			menu.add(Menu.NONE, F_TWO, Menu.NONE, "2층");
			menu.add(Menu.NONE,F_THREE, Menu.NONE, "3층");
			menu.add(Menu.NONE, F_FOUR, Menu.NONE, "4층");
			menu.add(Menu.NONE,F_FIVE, Menu.NONE, "5층");
		} 
		else if(v.getId() == R.id.floorRoomButton){				
			menu.setHeaderIcon(android.R.drawable.btn_star);
			menu.setHeaderTitle("층별 방 목록 보기");
			menu.add(Menu.NONE, R_ONE, Menu.NONE, "1층");
			menu.add(Menu.NONE, R_TWO, Menu.NONE, "2층");
			menu.add(Menu.NONE, R_THREE, Menu.NONE, "3층");
			menu.add(Menu.NONE, R_FOUR, Menu.NONE, "4층");
			menu.add(Menu.NONE,R_FIVE, Menu.NONE, "5층");
		}

		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		mImageView = (ImageView)findViewById(R.id.buildingImageView);
		switch (item.getItemId()) {
		case F_ONE:
			mImage.setVisibility(LinearLayout.VISIBLE);
			mText.setVisibility(LinearLayout.INVISIBLE);
			bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.bf_7_1);
			bitmap = Bitmap.createScaledBitmap(bitmap, 450, 600, true);
			mImageView.setImageBitmap(bitmap);
			mImageView.setScaleType(ImageView.ScaleType.FIT_START);
			break;
		case F_TWO:
			mImage.setVisibility(LinearLayout.VISIBLE);
			mText.setVisibility(LinearLayout.INVISIBLE);
			bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.bf_7_2);
			bitmap = Bitmap.createScaledBitmap(bitmap, 450, 600, true);
			mImageView.setImageBitmap(bitmap);
			mImageView.setScaleType(ImageView.ScaleType.FIT_START);
			break;
		case F_THREE:
			mImage.setVisibility(LinearLayout.VISIBLE);
			mText.setVisibility(LinearLayout.INVISIBLE);
			bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.bf_7_3);
			bitmap = Bitmap.createScaledBitmap(bitmap, 450, 600, true);
			mImageView.setImageBitmap(bitmap);
			mImageView.setScaleType(ImageView.ScaleType.FIT_START);
			break;
		case F_FOUR:
			mImage.setVisibility(LinearLayout.VISIBLE);
			mText.setVisibility(LinearLayout.INVISIBLE);
			bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.bf_7_4);
			bitmap = Bitmap.createScaledBitmap(bitmap, 450, 600, true);
			mImageView.setImageBitmap(bitmap);
			mImageView.setScaleType(ImageView.ScaleType.FIT_START);
			break;
		case F_FIVE:
			mImage.setVisibility(LinearLayout.VISIBLE);
			mText.setVisibility(LinearLayout.INVISIBLE);
			bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.bf_7_5);
			bitmap = Bitmap.createScaledBitmap(bitmap, 450, 600, true);
			mImageView.setImageBitmap(bitmap);
			mImageView.setScaleType(ImageView.ScaleType.FIT_START);
			break;

		case R_ONE:
			mImage.setVisibility(LinearLayout.INVISIBLE);
			mText.setVisibility(LinearLayout.VISIBLE);
			textView.setText(textArray.get(0));
			break;
		case R_TWO:
			mImage.setVisibility(LinearLayout.INVISIBLE);
			mText.setVisibility(LinearLayout.VISIBLE);
			textView.setText(textArray.get(1));
			break;
		case R_THREE:
			mImage.setVisibility(LinearLayout.INVISIBLE);
			mText.setVisibility(LinearLayout.VISIBLE);
			textView.setText(textArray.get(2));
			break;
		case R_FOUR:
			mImage.setVisibility(LinearLayout.INVISIBLE);
			mText.setVisibility(LinearLayout.VISIBLE);
			textView.setText(textArray.get(3));
			break;
		case R_FIVE:
			mImage.setVisibility(LinearLayout.INVISIBLE);
			mText.setVisibility(LinearLayout.VISIBLE);
			textView.setText(textArray.get(4));
			break;

		default:
			break;
		}

		return super.onContextItemSelected(item);
	}
}
