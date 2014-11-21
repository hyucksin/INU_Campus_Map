package com.example.inucampusmap;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;



public class StarActivity extends Activity {
	
	private GoogleMap mMap;
	//private GoogleMap mMap2;
	//private GoogleMap mMap3;
	//private GoogleMap inMap; //일단
	 LatLng loc = new LatLng(37.37556, 126.63279); // 위치 좌표 설정 
	 CameraPosition cp = new CameraPosition.Builder().target((loc)).zoom(16).build();  
	 MarkerOptions marker = new MarkerOptions().position(loc); // 구글맵에 기본마커 표시  
	// AlertDialog.Builder alter2=new AlertDialog.Builder(this);
	 
	 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_star_map);
        //방법2

        
        //방법1
        mMap=((MapFragment)getFragmentManager().findFragmentById(R.id.star_map)).getMap();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
        mMap.addMarker(marker);
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.classroom1)).position(new LatLng(37.37449,126.63349)));
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.rlatngus1)).position(new LatLng(37.37478,126.63442)));
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.wjswlgus1)).position(new LatLng(37.37426,126.63071)));
                


 
    }
   
}
//map marker생성해주는 객체 
// TODO Auto-generated method stub
/** Called when the activity is first created. */
// 타이틀바 없애기
//각 마커에대해서 경도,위도가 같은지에 대해서 알아보고 마커 적용
// 내용
// 사진
// 커스텀 다이얼로그를 띄우세요.
/*public class StarActivity extends Activity {
	
	private GoogleMap mMap;
	//private GoogleMap mMap2;
	//private GoogleMap mMap3;
	//private GoogleMap inMap; //일단
	 LatLng loc = new LatLng(37.37556, 126.63279); // 위치 좌표 설정 
	 CameraPosition cp = new CameraPosition.Builder().target((loc)).zoom(16).build();  
	 MarkerOptions marker = new MarkerOptions().position(loc); // 구글맵에 기본마커 표시  
	// AlertDialog.Builder alter2=new AlertDialog.Builder(this);
	 
	 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_star_map);
        //방법22

        
        //방법1
        mMap=((MapFragment)getFragmentManager().findFragmentById(R.id.star_map)).getMap();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
        mMap.addMarker(marker);
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.classroom1)).position(new LatLng(37.37449,126.63349)));
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.rlatngus1)).position(new LatLng(37.37478,126.63442)));
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.wjswlgus1)).position(new LatLng(37.37426,126.63071)));
                
        mMap.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {
        	 
            public void onInfoWindowClick(Marker arg0) {
                AlertDialog alert2 = new AlertDialog.Builder(StarActivity.this)
                        .setTitle("등촌칼국수")
                        .setMessage("주소:복정동 694-1 tel:031-752-3414")
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
 
                                    @Override
                                    public void onClick(DialogInterface dialog,
                                            int which) {
                                        dialog.dismiss();
                                    }
                                }).show();
            };
        });

 
    }
   
}*/

















