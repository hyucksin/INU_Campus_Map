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
import android.view.Window;
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
		requestWindowFeature(Window.FEATURE_NO_TITLE);//상단 타이틀 삭제
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
			bitmap = Bitmap.createScaledBitmap(bitmap, 600, 600, true);
			mImageView.setImageBitmap(bitmap);
			mImageView.setScaleType(ImageView.ScaleType.FIT_START);
			break;
		case F_TWO:
			mImage.setVisibility(LinearLayout.VISIBLE);
			mText.setVisibility(LinearLayout.INVISIBLE);
			bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.bf_7_2);
			bitmap = Bitmap.createScaledBitmap(bitmap, 600, 600, true);
			mImageView.setImageBitmap(bitmap);
			mImageView.setScaleType(ImageView.ScaleType.FIT_START);
			break;
		case F_THREE:
			mImage.setVisibility(LinearLayout.VISIBLE);
			mText.setVisibility(LinearLayout.INVISIBLE);
			bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.bf_7_3);
			bitmap = Bitmap.createScaledBitmap(bitmap, 600, 600, true);
			mImageView.setImageBitmap(bitmap);
			mImageView.setScaleType(ImageView.ScaleType.FIT_START);
			break;
		case F_FOUR:
			mImage.setVisibility(LinearLayout.VISIBLE);
			mText.setVisibility(LinearLayout.INVISIBLE);
			bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.bf_7_4);
			bitmap = Bitmap.createScaledBitmap(bitmap, 600, 600, true);
			mImageView.setImageBitmap(bitmap);
			mImageView.setScaleType(ImageView.ScaleType.FIT_START);
			break;
		case F_FIVE:
			mImage.setVisibility(LinearLayout.VISIBLE);
			mText.setVisibility(LinearLayout.INVISIBLE);
			bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.bf_7_5);
			bitmap = Bitmap.createScaledBitmap(bitmap, 600, 600, true);
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

class TextRoom7 {
	ArrayList<String> textArray;
	TextRoom7(){
		addRoomText();
	}
	
	void addRoomText(){
		textArray = new ArrayList<String>();
		textArray.add("101 : 디지털실험실\n" +
				"102 : 기초정보공학실험실\n" +
				"103 : 단과대학생회실\n" +
				"104 : 강의실(중)-1\n" +
				"105 : 정보시스템실험실\n" +
				"106 : PC검색실\n" +
				"107 : 정보통신실험실\n" +
				"108 : 학과학생회실\n" +
				"109 : 경비실\n" +
				"110 : 집중구내통신실\n" +
				"111 : 컴퓨터실험실-1\n" +
				"112 : 여학생휴게실\n" +
				"113 : 샤워실(여)\n" +
				"114 : 탈의실(여)\n" +
				"115 : 샤워실(남)\n" +
				"116 : 탈의실(남)");
		textArray.add("201 : HCI연구실\n" +
				"202 : 분산네트워크연구실\n" +
				"203 : 무선정보연구실\n" +
				"204 : 강사대기실\n" +
				"205 : 정보처리실험실\n" +
				"206 : 정보공학실험실\n" +
				"209 : 학과사무실\n" +
				"210 : 실험준비실-2\n" +
				"211 : 컴퓨터실험실-2\n" +
				"212 : 실험준비실-1\n" +
				"213 : 임베디드영상신호처리실험실\n" +
				"214 : 교수실험실\n" +
				"215 : 전파공학전파환경연구실\n" +
				"216 : 통신망및보안연구실\n" +
				"217 : 유비쿼터스네트워크연구실\n" +
				"218 : 교수연구실\n" +
				"219 : 교수연구실\n" +
				"220 : 교수연구실\n" +
				"221 : 교수연구실\n" +
				"222 : 교수연구실\n" +
				"223 : 교수연구실\n" +
				"224 : 교수연구실\n" +
				"225 : 교수연구실\n" +
				"226 : 교수연구실\n" +
				"227 : 교수연구실\n" +
				"228 : 교수연구실\n" +
				"229 : 교수연구실\n");
		textArray.add("301 지능로봇시스템실험실\n"+
				"302 캡스턴디자인실습실\n"+
				"303 학과학생회실-2\n"+
				"304 강희실(대)-계단식\n"+
				"305 프로그래밍실습실\n"+
				"306 임베디드SW실습실\n"+
				"309 학과사무실\n"+
				"310 실험준비실\n"+
				"311 입베디드시스템실험실\n"+
				"312 임베디드네트워크시스템 설계연구실\n"+
				"313 강의실(중)-2\n"+
				"314 강의실(소)-1\n"+
				"315 ABEEK자료실\n"+
				"316 창의설계실험실\n"+
				"317 임베디드HW실습실\n"+
				"318 임베디드SW설계실험실\n"+
				"319 모바일앱실험실\n"+
				"320 교학실\n"+
				"321 교수회의실\n"+
				"322 학장실\n"+
				"323~328 교수연구실\n"+
				"329 임베디드시스템구조실험실\n"+
				"330 무선통신실험실\n");
		textArray.add("401 모바일컴퓨팅연구실\n"+
				"402 무선정보네트워크연구실\n"+
				"403 세미나실\n"+
				"404 기자재실\n"+
				"405 정보통신대학원학생회실\n"+
				"406 강의실(소)-2\n"+
				"407 강의실 (중)-3\n"+
				"408 컴퓨터실습실-1\n"+
				"409 실습준비실\n"+
				"410 학부사무실\n"+
				"413 멀티미디어가상현실연구실\n"+
				"414 인터넷소프트웨어연구실\n"+
				"415 컴퓨터실습실-2\n"+
				"416 세미나실(대)\n"+
				"417 강의실(소)-3\n"+
				"418 첨단SW연구센터\n"+
				"419 컴퓨터공학부 학생회실(주)\n"+
				"420 프로젝트실습실\n"+
				"421 엔터테인먼트컴퓨팅연구실\n"+
				"422 컴퓨터그래픽스연구실\n"+
				"423 분산시스템연구실\n"+
				"424 Enion연구실\n"+
				"425~434 교수연구실\n"+
				"435 데이터베이스연구실\n"+
				"436 지능소프트웨어연구실\n");
		textArray.add("501 컴퓨터실습실3\n"+
				"502 HW실습실\n"+
				"503 컴퓨터실\n"+
				"504 강의실(중)-1\n"+
				"505 강의실(중)-2\n"+
				"506 IMPRESS연구실\n"+
				"509 교수연구실\n"+
				"509-1 교수연구실\n"+
				"510 학부학생회실\n"+
				"511 컴퓨터실습실-4\n"+
				"512서버실\n"+
				"513 컴퓨터공학과학생회실(야)\n"+
				"514 프로젝트실습실-2\n"+
				"515 단과대학학생회실\n"+
				"516 연구실\n"+
				"517 학과사무실\n"+
				"517-1 학과학생회실\n"+
				"518 초빙교수실\n"+
				"519~524 공동교수실\n"+
				"525~527 교수연구실\n"+
				"528 시스템스프트웨어연구실\n");
	}
}