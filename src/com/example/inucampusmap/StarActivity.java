package com.example.inucampusmap;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class StarActivity extends Activity
{
	private GoogleMap mMap;
	private View v;
	private TextView ctv;
	private ImageView civ;
	private Marker marker;
	private Context mContext;
	private ArrayList<MapBean> map_info_list;
	private MapBean map_info;

	LatLng loc = new LatLng(37.37556, 126.63279); // 위치 좌표 설정 
	CameraPosition cp = new CameraPosition.Builder().target((loc)).zoom(16).build();       


	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_star_map);
		mContext = StarActivity.this;

		//이부분 내껄로 맞춰서 focus까지         
		mMap=((MapFragment)getFragmentManager().findFragmentById(R.id.star_map)).getMap();
		mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));

		map_info_list = new ArrayList<MapBean>();   
		map_info_list.add(new MapBean("37.37478,126.63442","촬영장 1 학산도서관",(R.drawable.rlatngus)));//학산도서관
		map_info_list.add(new MapBean("37.37449,126.63349","촬영장 2 정보기술대",(R.drawable.classroom1)));//정보기술대
		map_info_list.add(new MapBean("37.37426,126.63071","촬영장 3 복지회관",(R.drawable.cjsthddl)));//복지회관

		for (int i = 0; i < map_info_list.size(); i++) 
		{
			//map_info_list.get(i).getPlace_img()
			marker = mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(map_info_list.get(i).getPlace_img())).position(map_info_list.get(i).getPlace_location()));
		}

		mMap.setOnMarkerClickListener(new OnMarkerClickListener() {

			@Override
			public boolean onMarkerClick(Marker marker) {
				int img = 0;
				String dialogtitle = "";

				for (int i = 0; i < map_info_list.size(); i++) {
					//각 마커에대해서 경도,위도가 같은지에 대해서 알아보고 마커 적용
					if(Math.floor(marker.getPosition().latitude*100000d)/100000d==map_info_list.get(i).getPlace_location().latitude
							&&Math.floor(marker.getPosition().longitude*100000d)/100000d==map_info_list.get(i).getPlace_location().longitude){
						dialogtitle = map_info_list.get(i).getPlace_name();
						//각각 Diaglog창을 다르게 해주기 위해서 .
						if(i==0)
						{
							img = map_info_list.get(i).getPlace_img();
							AlertDialog.Builder builder = new AlertDialog.Builder(StarActivity.this);
							builder.setIcon(img).setTitle(dialogtitle).setPositiveButton
							(map_info_list.get(i).getPlace_name(), new OnClickListener(){
								public void onClick(DialogInterface dialog,int which)
								{
									dialog.dismiss();
								}
							}).show();
						}
						else if(i==1)
						{
							img = map_info_list.get(i).getPlace_img();
							AlertDialog.Builder builder = new AlertDialog.Builder(StarActivity.this);
							builder.setIcon(img).setTitle(dialogtitle).setPositiveButton
							("상세정보", new OnClickListener(){
								public void onClick(DialogInterface dialog,int which)
								{
									//dialog.dismiss();
									startActivity(new Intent(StarActivity.this,BuildingInfoActivity7.class));
								}
							}).show();

						}
						else
						{
							img = map_info_list.get(i).getPlace_img();
							AlertDialog.Builder builder = new AlertDialog.Builder(StarActivity.this);
							builder.setIcon(img).setTitle(dialogtitle).setPositiveButton
							(map_info_list.get(i).getPlace_name(), new OnClickListener(){
								public void onClick(DialogInterface dialog,int which)
								{
									dialog.dismiss();
								}
							}).show();
						}
					}

				}
				return false;
			}
		});
	}
}