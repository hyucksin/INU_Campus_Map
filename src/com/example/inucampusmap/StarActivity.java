package com.example.inucampusmap;

<<<<<<< HEAD
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
=======
import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
    mMap=((MapFragment)getFragmentManager().findFragmentById(R.id.star_map)).getMap();
    mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
   
    mMap.setOnMapClickListener((OnMapClickListener) this);
    
    MarkerOptions m1 = new MarkerOptions(); 
	m1.position(new LatLng(37.37449,126.63349));// 위도 • 경도 
	m1.title("63빌딩"); // 제목 미리보기 
    m1.snippet("이곳은 63빌딩입니다."); 
    mMap.addMarker(m1).showInfoWindow(); 
    
    //mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.classroom1)).position(new LatLng(37.37449,126.63349)));
   // mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.rlatngus1)).position(new LatLng(37.37478,126.63442)));
    //mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.wjswlgus1)).position(new LatLng(37.37426,126.63071)));
            
    mMap.setOnMarkerClickListener(new OnMarkerClickListener() {
    	 
        public boolean onMarkerClick(Marker marker) {
            String text = "[마커 클릭 이벤트] latitude ="
                                + marker.getPosition().latitude + ", longitude ="
                    + marker.getPosition().longitude;
            Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG)
                    .show();
            return false;
        }
    });
 
    // 클릭이벤트
    mMap.setOnMapClickListener(new OnMapClickListener() {
 
        public void onMapClick(LatLng point) {
            String text = "[단시간 클릭시 이벤트] latitude ="
                                + point.latitude + ", longitude ="
                    + point.longitude;
            Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG)
                    .show();
        }
    });



}
}*/




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
  /* public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
        Intro.gubunView = 1;
        Intent i = new Intent(getApplicationContext(), Tab.class);
        startActivity(i);
        finish();
    }*/
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀바 없애기
        //setContentView(R.layout.StarActivity); //try to do it.
        setContentView(R.layout.activity_star_map);
        //TextView tv = (TextView) findViewById(R.id.intro_campus_textview);
        //tv.setText("별그대 촬영장 지도");
       
        mContext = StarActivity.this;
        
        //이부분 내껄로 맞춰서 focus까지         
        mMap=((MapFragment)getFragmentManager().findFragmentById(R.id.star_map)).getMap();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
        //gmap = ((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
        //LatLng loc = new LatLng(위도, 경도);

        //CameraPosition cp = new CameraPosition.Builder().target((loc)).zoom(17).build();
        //gmap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));

        map_info_list = new ArrayList<MapBean>();
        
        map_info_list.add(new MapBean("37.37449,126.63349","촬영장 1",(R.drawable.classroom1)));
        map_info_list.add(new MapBean("37.37478,126.63442","촬영장 2",(R.drawable.rlatngus1)));
        map_info_list.add(new MapBean("37.37426,126.63071","촬영장 3",(R.drawable.wjswlgus1)));
   
        for (int i = 0; i < map_info_list.size(); i++) {
        	//map_info_list.get(i).getPlace_img()
            marker = mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(map_info_list.get(i).getPlace_img())).position(map_info_list.get(i).getPlace_location()));
            //여기에 이미지 추가 시키기. 
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
                         img = map_info_list.get(i).getPlace_img();
                    	AlertDialog.Builder builder = new AlertDialog.Builder(StarActivity.this);
                    	builder.setIcon(img).setTitle(dialogtitle).setPositiveButton
                    			("상세정보", new OnClickListener(){
                    				public void onClick(DialogInterface dialog,int which)
                    				{
                    					dialog.dismiss();
                    				}
                    			}).show();
                    	
                       
                        
                    }
                    
                }
				return false;
                
                //이부분이 뭔지 모르겠다.//
               // v = View.inflate(mContext, R.layout.activity_star_map, null);
               // ctv = (TextView)v.findViewById(R.id.star_map_dialog_tv); //내용
               // civ = (ImageView)v.findViewById(R.id.star_map_dialog_iv); // 사진
               // if(img != 0)
                 //   civ.setImageResource(img);

                // 커스텀 다이얼로그를 띄우세요.
                //AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                
               // builder.setNeutralButton("닫기", null);
              //  builder.setTitle(dialogtitle);
               // builder.setView(v);
               // builder.show();
               // return false;
            }
        });
        
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
>>>>>>> 45d4489fbb3f2a69349c9c99668eca4a426a2da5
	
	private GoogleMap mMap;
	//private GoogleMap mMap2;
	//private GoogleMap mMap3;
<<<<<<< HEAD
	//private GoogleMap inMap; //�ϴ�
	 LatLng loc = new LatLng(37.37556, 126.63279); // ��ġ ��ǥ ���� 
	 CameraPosition cp = new CameraPosition.Builder().target((loc)).zoom(16).build();  
	 MarkerOptions marker = new MarkerOptions().position(loc); // ���۸ʿ� �⺻��Ŀ ǥ��  
=======
	//private GoogleMap inMap; //일단
	 LatLng loc = new LatLng(37.37556, 126.63279); // 위치 좌표 설정 
	 CameraPosition cp = new CameraPosition.Builder().target((loc)).zoom(16).build();  
	 MarkerOptions marker = new MarkerOptions().position(loc); // 구글맵에 기본마커 표시  
>>>>>>> 45d4489fbb3f2a69349c9c99668eca4a426a2da5
	// AlertDialog.Builder alter2=new AlertDialog.Builder(this);
	 
	 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_star_map);
<<<<<<< HEAD
        //���2

        
        //���1
=======
        //방법22

        
        //방법1
>>>>>>> 45d4489fbb3f2a69349c9c99668eca4a426a2da5
        mMap=((MapFragment)getFragmentManager().findFragmentById(R.id.star_map)).getMap();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
        mMap.addMarker(marker);
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.classroom1)).position(new LatLng(37.37449,126.63349)));
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.rlatngus1)).position(new LatLng(37.37478,126.63442)));
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.wjswlgus1)).position(new LatLng(37.37426,126.63071)));
                
<<<<<<< HEAD

=======
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
>>>>>>> 45d4489fbb3f2a69349c9c99668eca4a426a2da5

 
    }
   
<<<<<<< HEAD
}
//map marker�������ִ� ��ü 
// TODO Auto-generated method stub
/** Called when the activity is first created. */
// Ÿ��Ʋ�� ���ֱ�
//�� ��Ŀ�����ؼ� �浵,������ �������� ���ؼ� �˾ƺ��� ��Ŀ ����
// ����
// ����
// Ŀ���� ���̾�α׸� ��켼��.
/*public class StarActivity extends Activity {
	
	private GoogleMap mMap;
	//private GoogleMap mMap2;
	//private GoogleMap mMap3;
	//private GoogleMap inMap; //�ϴ�
	 LatLng loc = new LatLng(37.37556, 126.63279); // ��ġ ��ǥ ���� 
	 CameraPosition cp = new CameraPosition.Builder().target((loc)).zoom(16).build();  
	 MarkerOptions marker = new MarkerOptions().position(loc); // ���۸ʿ� �⺻��Ŀ ǥ��  
	// AlertDialog.Builder alter2=new AlertDialog.Builder(this);
	 
	 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_star_map);
        //���22

        
        //���1
        mMap=((MapFragment)getFragmentManager().findFragmentById(R.id.star_map)).getMap();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
        mMap.addMarker(marker);
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.classroom1)).position(new LatLng(37.37449,126.63349)));
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.rlatngus1)).position(new LatLng(37.37478,126.63442)));
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.wjswlgus1)).position(new LatLng(37.37426,126.63071)));
                
        mMap.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {
        	 
            public void onInfoWindowClick(Marker arg0) {
                AlertDialog alert2 = new AlertDialog.Builder(StarActivity.this)
                        .setTitle("����Į����")
                        .setMessage("�ּ�:������ 694-1 tel:031-752-3414")
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
   
=======
>>>>>>> 45d4489fbb3f2a69349c9c99668eca4a426a2da5
}*/

















