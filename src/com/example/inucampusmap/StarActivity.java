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
	//private GoogleMap inMap; //�ϴ�
	 LatLng loc = new LatLng(37.37556, 126.63279); // ��ġ ��ǥ ���� 
	 CameraPosition cp = new CameraPosition.Builder().target((loc)).zoom(16).build();  
	 MarkerOptions marker = new MarkerOptions().position(loc); // ���۸ʿ� �⺻��Ŀ ǥ��  
	// AlertDialog.Builder alter2=new AlertDialog.Builder(this);
	 
	 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_star_map);
        //���2

        
        //���1
        mMap=((MapFragment)getFragmentManager().findFragmentById(R.id.star_map)).getMap();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
        mMap.addMarker(marker);
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.classroom1)).position(new LatLng(37.37449,126.63349)));
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.rlatngus1)).position(new LatLng(37.37478,126.63442)));
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.wjswlgus1)).position(new LatLng(37.37426,126.63071)));
                


 
    }
   
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
   
}*/

















