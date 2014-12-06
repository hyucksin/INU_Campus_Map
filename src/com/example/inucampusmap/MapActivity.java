package com.example.inucampusmap;

import java.util.*;

import android.app.*;
import android.content.*;
import android.content.DialogInterface.OnClickListener;
import android.os.*;
import android.view.*;
import android.widget.*;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends Activity {

	private GoogleMap mMap;
	private Marker marker;
	private Context mContext;
	private ArrayList<CampusMap> map_info_list;
	private MapBean map_info;

	LatLng loc = new LatLng(37.37556, 126.63279); // 위치 좌표 설정 
	CameraPosition cp = new CameraPosition.Builder().target((loc)).zoom(16).build();     
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//activity_building
		setContentView(R.layout.activity_campus_map);
		mContext = MapActivity.this;

		//이부분 내껄로 맞춰서 focus까지         
		mMap=((MapFragment)getFragmentManager().findFragmentById(R.id.campus_map)).getMap();
		mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));

		map_info_list = new ArrayList<CampusMap>();   
		map_info_list.add(new CampusMap("37.37449,126.63349","정보기술대학",(R.drawable.buildingnum7)));//정보기술대
		map_info_list.add(new CampusMap("37.37361,126.63270","공과대학",(R.drawable.buildingnum8)));//공대
		map_info_list.add(new CampusMap("37.37426,126.63072","학생회관",(R.drawable.buildingnum17)));//복지회관


		for (int i = 0; i < map_info_list.size(); i++) 
		{
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
						if(i==0)
						{
							img = R.drawable.b7;
							AlertDialog.Builder builder = new AlertDialog.Builder(MapActivity.this);
							builder.setIcon(img).setTitle(dialogtitle).setPositiveButton
							("상세정보", new OnClickListener(){
								public void onClick(DialogInterface dialog,int which)
								{
									Intent intent=new Intent(MapActivity.this,BuildingInfoActivity7.class);
									startActivity(intent);
								}
							}).show();
						}
						else if(i==1)
						{
							img = R.drawable.b8;
							AlertDialog.Builder builder = new AlertDialog.Builder(MapActivity.this);
							builder.setIcon(img).setTitle(dialogtitle).setPositiveButton
							("상세정보", new OnClickListener(){
								public void onClick(DialogInterface dialog,int which)
								{
									Intent intent=new Intent(MapActivity.this,BuildingInfoActivity8.class);
									startActivity(intent);
								}
							}).show();
						}
						else if(i==2)
						{
							img = R.drawable.b17;
							AlertDialog.Builder builder = new AlertDialog.Builder(MapActivity.this);
							builder.setIcon(img).setTitle(dialogtitle).setPositiveButton
							("상세정보", new OnClickListener(){
								public void onClick(DialogInterface dialog,int which)
								{
									Intent intent=new Intent(MapActivity.this,MainActivity.class);
									startActivity(intent);
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