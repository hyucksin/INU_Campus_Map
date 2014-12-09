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
	CameraPosition cp = new CameraPosition.Builder().target((loc)).zoom(16).build(); //좌표 설정한 부분으로 FOCUS맞춰서 보여주기.    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//activity_building
		requestWindowFeature(Window.FEATURE_NO_TITLE);//상단 타이틀 삭제
		setContentView(R.layout.activity_campus_map);
		mContext = MapActivity.this;

		//이부분 내껄로 맞춰서 focus까지         
		mMap=((MapFragment)getFragmentManager().findFragmentById(R.id.campus_map)).getMap();
		mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
		
		//건물 정보를 CampusMap 클래스에 있는 ArrayList를 사용하여 정보를 저장 //
		map_info_list = new ArrayList<CampusMap>();   
		map_info_list.add(new CampusMap("37.37449,126.63349","정보기술대학",(R.drawable.buildingnum7)));//정보기술대
		map_info_list.add(new CampusMap("37.37361,126.63270","공과대학",(R.drawable.buildingnum8)));//공대
		map_info_list.add(new CampusMap("37.37426,126.63072","학생회관",(R.drawable.buildingnum17)));//복지회관

		//각각 원하는 곳에 Marker표시 이때, ArrayList에 저장했던 정보들을 이요해서 한다.//
		for (int i = 0; i < map_info_list.size(); i++) 
		{
			marker = mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(map_info_list.get(i).getPlace_img())).position(map_info_list.get(i).getPlace_location()));
		}
		
		//각 마커를 눌렀을 떄, 나오는 화면을 보여주기 위한 구현//
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
							//마커 클릭하면, 정보 읽어오면서 동시에 다이얼로그 창 보여주기.상세정보 버튼 누르면//
							//BuildingActivity7.Class와 연동//
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
							//마커 클릭하면, 정보 읽어오면서 동시에 다이얼로그 창 보여주기.상세정보 버튼 누르면//
							//BuildingActivity8.Class와 연동//
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
							//마커 클릭하면, 정보 읽어오면서 동시에 다이얼로그 창 보여주기.상세정보 버튼 누르면//
							//BuildingActivity0.Class와 연동//
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