package com.example.inucampusmap;

import java.util.*;

import android.app.*;
import android.content.*;
import android.content.DialogInterface.OnClickListener;
import android.os.*;
import android.view.*;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.model.*;

public class MapActivity extends Activity {

	private GoogleMap mMap;
	private Marker marker;
	private Context mContext;
	private ArrayList<CampusMap> mapInfoList;

	LatLng loc = new LatLng(37.37556, 126.63279); // 위치 좌표 설정 
	CameraPosition cp = new CameraPosition.Builder().target((loc)).zoom(17).build(); //좌표 설정한 부분으로 FOCUS맞춰서 보여주기.    
	
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
		addMapInfoList();

		//각각 원하는 곳에 Marker표시 이때, ArrayList에 저장했던 정보들을 이요해서 한다.//
		addMapMarker();
	}
	
	//건물 정보를 CampusMap 클래스에 있는 ArrayList를 사용하여 정보를 저장 //
		void addMapInfoList(){
			
					mapInfoList = new ArrayList<CampusMap>();
					mapInfoList.add(new CampusMap("37.37691,126.63442","대학본부",(R.drawable.buildingnum1)));
					mapInfoList.add(new CampusMap("37.37763,126.63373","교수회관",(R.drawable.buildingnum2)));
					mapInfoList.add(new CampusMap("37.37706,126.63414","홍보관",(R.drawable.buildingnum3)));
					mapInfoList.add(new CampusMap("37.37653,126.63537","정보전산원",(R.drawable.buildingnum4)));
					mapInfoList.add(new CampusMap("37.37581,126.63469","자연과학대",(R.drawable.buildingnum5)));
					mapInfoList.add(new CampusMap("37.37513,126.63404","학산도서관",(R.drawable.buildingnum6)));
					mapInfoList.add(new CampusMap("37.37449,126.63349","정보기술대학",(R.drawable.buildingnum7)));
					mapInfoList.add(new CampusMap("37.37339,126.63200","공과대학",(R.drawable.buildingnum8)));
					mapInfoList.add(new CampusMap("37.37284,126.63376","공동실험실습관",(R.drawable.buildingnum9)));
					mapInfoList.add(new CampusMap("37.37288,126.63158","게스트하우스",(R.drawable.buildingnum10)));
					mapInfoList.add(new CampusMap("37.37467,126.63198","복지회관",(R.drawable.buildingnum11)));
					mapInfoList.add(new CampusMap("37.37544,126.63279","컨벤션센터",(R.drawable.buildingnum12)));
					mapInfoList.add(new CampusMap("37.37621,126.63344","사회과학대,법과대학",(R.drawable.buildingnum13)));
					mapInfoList.add(new CampusMap("37.37688,126.63306","동북아대,경영대학",(R.drawable.buildingnum14)));
					mapInfoList.add(new CampusMap("37.37578,126.63218","인문대학 어학원",(R.drawable.buildingnum15)));
					mapInfoList.add(new CampusMap("37.37500,126.63139","예체능대학",(R.drawable.buildingnum16)));
					mapInfoList.add(new CampusMap("37.37426,126.63084","학생회관",(R.drawable.buildingnum17)));
					mapInfoList.add(new CampusMap("37.37376,126.63022","생활원",(R.drawable.buildingnum18)));
					mapInfoList.add(new CampusMap("37.37466,126.63027","인천한국어학당",(R.drawable.buildingnum19)));
					mapInfoList.add(new CampusMap("37.37505,126.62970","스포츠센터",(R.drawable.buildingnum20)));
					mapInfoList.add(new CampusMap("37.37572,126.63029","체육관",(R.drawable.buildingnum21)));
					mapInfoList.add(new CampusMap("37.37599,126.63090","학군단",(R.drawable.buildingnum22)));
					mapInfoList.add(new CampusMap("37.37785,126.63260","강단 공연장",(R.drawable.buildingnum23)));
					mapInfoList.add(new CampusMap("37.37593,126.63561","전망타워",(R.drawable.buildingnum24)));
					mapInfoList.add(new CampusMap("37.37526,126.63620","어린이집",(R.drawable.buildingnum25)));
		}
		
		//마커와 마커 리스너를 추가한다.
		void addMapMarker(){
			for (int i = 0; i < mapInfoList.size(); i++) {
				marker = mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(mapInfoList.get(i).getPlace_img())).position(mapInfoList.get(i).getPlace_location()));
			}
			
			//각 마커를 눌렀을 떄, 나오는 화면을 보여주기 위한 구현//
			mMap.setOnMarkerClickListener(new OnMarkerClickListener() {
				@Override
				public boolean onMarkerClick(Marker marker) {
					int img = 0;
					String dialogtitle = "";

					for (int i = 0; i < mapInfoList.size(); i++) {
						//각 마커에대해서 경도,위도가 같은지에 대해서 알아보고 마커 적용
						if(Math.floor(marker.getPosition().latitude*100000d)/100000d==mapInfoList.get(i).getPlace_location().latitude
								&&Math.floor(marker.getPosition().longitude*100000d)/100000d==mapInfoList.get(i).getPlace_location().longitude){
							dialogtitle = mapInfoList.get(i).getPlace_name();
							if(i==6)
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
							else if(i==7)
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
							else if(i==10)
							{
								//마커 클릭하면, 정보 읽어오면서 동시에 다이얼로그 창 보여주기.상세정보 버튼 누르면//
								//BuildingActivity11.Class와 연동//
								img = R.drawable.b11;
								AlertDialog.Builder builder = new AlertDialog.Builder(MapActivity.this);
								builder.setIcon(img).setTitle(dialogtitle).setPositiveButton
								("상세정보", new OnClickListener(){
									public void onClick(DialogInterface dialog,int which)
									{
										Intent intent=new Intent(MapActivity.this,BuildingInfoActivity11.class);
										startActivity(intent);
									}
								}).show();
							}
							else if(i==16)
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