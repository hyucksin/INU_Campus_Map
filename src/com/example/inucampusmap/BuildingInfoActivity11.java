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

public class BuildingInfoActivity11 extends Activity{
	GoogleMap mMap;
	Marker marker;
	LatLng loc ; // 위치 좌표 설정 
	CameraPosition cp;    

	ImageView mImageView;
	Bitmap bitmap = null;
	TextView textView = null;
	TextRoom11 textRoom = new TextRoom11();
	ArrayList<String> textArray = new TextRoom11().textArray;

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
			bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.b11);
			bitmap = Bitmap.createScaledBitmap(bitmap, 600, 500, true);
			mImageView = (ImageView)findViewById(R.id.buildingImageView);
			mImageView.setImageBitmap(bitmap);
			mImageView.setScaleType(ImageView.ScaleType.FIT_START);
			loc = new LatLng(37.37461,126.63195);
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
			bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.bf_8_1);
			bitmap = Bitmap.createScaledBitmap(bitmap, 600, 600, true);
			mImageView.setImageBitmap(bitmap);
			mImageView.setScaleType(ImageView.ScaleType.FIT_START);
			break;
		case F_TWO:
			mImage.setVisibility(LinearLayout.VISIBLE);
			mText.setVisibility(LinearLayout.INVISIBLE);
			bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.bf_8_2);
			bitmap = Bitmap.createScaledBitmap(bitmap, 600, 600, true);
			mImageView.setImageBitmap(bitmap);
			mImageView.setScaleType(ImageView.ScaleType.FIT_START);
			break;
		case F_THREE:
			mImage.setVisibility(LinearLayout.VISIBLE);
			mText.setVisibility(LinearLayout.INVISIBLE);
			bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.bf_8_3);
			bitmap = Bitmap.createScaledBitmap(bitmap, 600, 600, true);
			mImageView.setImageBitmap(bitmap);
			mImageView.setScaleType(ImageView.ScaleType.FIT_START);
			break;
		case F_FOUR:
			mImage.setVisibility(LinearLayout.VISIBLE);
			mText.setVisibility(LinearLayout.INVISIBLE);
			bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.bf_8_4);
			bitmap = Bitmap.createScaledBitmap(bitmap, 600, 600, true);
			mImageView.setImageBitmap(bitmap);
			mImageView.setScaleType(ImageView.ScaleType.FIT_START);
			break;
		case F_FIVE:
			mImage.setVisibility(LinearLayout.VISIBLE);
			mText.setVisibility(LinearLayout.INVISIBLE);
			bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.bf_8_5);
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

class TextRoom11 {
	ArrayList<String> textArray;
	TextRoom11(){
		textArray = new ArrayList<String>();
		textArray.add("101 기계제도실\n"+
				"102 재료 실험실\n"+
				"103 기자재실\n"+
				"104 학부학생회실\n"+
				"105 초정밀기계가공실\n"+
				"106 파괴역학실험실\n"+
				"107 창고-1\n"+
				"109 응용제어공학실험실-2\n"+
				"110 응용제어공학실험실-1\n"+
				"111 유체역학실험실\n"+
				"112 과세미나실-1\n"+
				"113 학과학생회실-2\n"+
				"114 경비실\n"+
				"115 창고-2\n"+
				"117 세미나실\n"+
				"119 환경수리실험실\n");
		textArray.add("201 신소재기초실험실\n"+
				"202 분석준비실\n"+
				"203 실험준비실\n"+
				"204 학부사무실\n"+
				"205 세미나실-1\n"+
				"206 스크롤압축실험실\n"+
				"207 생산공학실험실\n"+
				"208 연료전지실험실\n"+
				"209 전기화학에너지/디바이스연구실\n"+
				"211 기초전기실험실\n"+
				"212 전기기계실험실\n"+
				"213 디지털 실험실\n"+
				"214 SEM실험실\n"+
				"215 전기기자개실\n"+
				"216 과사무실\n"+
				"217 회의실\n"+
				"218 시스템제어실험실\n"+
				"219 전자전력실험실\n"+
				"220 교강사 휴계실\n"+
				"221 학부사무실\n"+
				"222 세미나실(소)-1\n"+
				"223 공학기술연구소\n"+
				"224 전기설계실험실\n"+
				"225 화학안전실험실\n"+
				"226 전산실습실\n"+
				"227 학부학생회실-2\n"+
				"228 전기안전실험실\n"+
				"229 구조실험실\n"+
				"231~234 교수연구실\n"+
				"235 측량 및 GIS 연구실\n"+
				"236 지반공학연구실\n"+
				"237 환경오염제어실험실\n"+
				"238 구조진동연구실\n"+
				"239~246 교수연구실\n"+
				"247 마이크로컴퓨터및센서어레이실험실\n"+
				"248 전기재료실험실\n"+
				"249 전력및에너지시스템연구실\n"+
				"250 전기공해환경환경실험실\n"+
				"251~258 교수연구실\n"+
				"259 CFD실험실\n"+
				"260 에너지환경시스템연구실\n"+
				"261 기계진동실험실\n"+
				"262 구조해석실험실\n"+
				"263 공동교수실\n"+
				"264~266 교수연구실\n"+
				"268 PC실습실\n"+
				"269 신소재분석실험실\n"+
				"270 신소재설계실습실\n"+
				"271 학부학생회실-1\n"+
				"272 강의실");
		textArray.add("301 전자세라믹스실험실\n"+
				"302 박막전자재료실험실\n"+
				"303 세라믹실험실\n"+
				"304 정밀기자재실\n"+
				"305 과사무실-1\n"+
				"306 과세미나실-1\n"+
				"307 후막적층재료실험실\n"+
				"308 광전재료실험실\n"+
				"309 나노소재실험실\n"+
				"310 에너지변환실험실\n"+
				"311 복합재료실험실\n"+
				"312 태양전지실험실\n"+
				"313 SDT연구실험실\n"+
				"315 학과사무실-2\n"+
				"316 기초전자회로실험실\n"+
				"317 전자회로실험실\n"+
				"318 멀티미디어실험실\n"+
				"319 탈의실(남)\n"+
				"320 샤워실(남)\n"+
				"321 강의실(소)-2\n"+
				"322 강의실(중)-3\n"+
				"323 학과학생회실-2\n"+
				"324 실험준비실\n"+
				"325 디지털회로실험실\n"+
				"326 컴퓨터실험실\n"+
				"327 디지털미디어실습실\n"+
				"328 과세미나실\n"+
				"329 반도체소자연구실험실\n"+
				"330 부호이론및통신방식연구실험실\n"+
				"331 폐자원연구실\n"+
				"332 전기응용연구실\n"+
				"333 세미나실\n"+
				"334 학과사무실-3\n"+
				"335 안전공학멀티미디어실\n"+
				"336 작업환경실험실\n"+
				"337 강의실(중)-2\n"+
				"338 강의실(소)-3\n"+
				"339 학과학생회실-3\n"+
				"340 열유체가시화실험실\n"+
				"341 소방방재연구실\n"+
				"343 토질연구실\n"+
				"344~346 교수연구실\n"+
				"347 안전관리실험실\n"+
				"348 정밀측정실험실\n"+
				"349 폐수처리연구실\n"+
				"350 구조안전실험실\n"+
				"351~358 교수연구실\n"+
				"359 통신신호처리연구실험실\n"+
				"360 광전자연구실험실\n"+
				"361 무선및마이크로파통신연구실험실\n"+
				"362 컴퓨터시각시스템연구실험실\n"+
				"363~370 교수연구실\n"+
				"371 전략소재및재자원화실험실\n"+
				"372 반도체재료실험실\n"+
				"373 자성정보저장재료실험실\n"+
				"374 신소재기기공작실\n"+
				"375~378 교수연구실\n"+
				"380 스핀전자재료실험실\n"+
				"381 전자패키지실험실\n"+
				"382 기능소재실험실\n"+
				"383 전산실습실\n"+
				"384 학과학생회실-1\n"+
				"385 강의실(소)-1\n"+
				"386 강의실(중)-1");
		textArray.add("401 컴퓨터실습실\n"+
				"402 멀티미디어실\n"+
				"403 학과사무실\n"+
				"404 세미나실\n"+
				"405 물류시스템연구실\n"+
				"406 산업정보화연구실\n"+
				"407 노동과학연구실\n"+
				"408 서비스사이언스연구실\n"+
				"410 마이크로전자트랙실험실2\n"+
				"411 마이크로전자트랙실험실1\n"+
				"412 전자응용 및 컴퓨터트랙실습실1\n"+
				"413 전자응용 및 컴퓨터트랙실습실2\n"+
				"414 단과대학생회실\n"+
				"415 컴퓨터실-3\n"+
				"416 강의실(소)-5\n"+
				"417 학과학생회실-2\n"+
				"418 인터넷실습실\n"+
				"419 캠스턴디자인실습실1\n"+
				"420 통신트랙실습실1\n"+
				"421 통신트랙실습실2\n"+
				"422 안전보건연구원\n"+
				"423 경제성평가연구실\n"+
				"424 공간조형설계연구실\n"+
				"425 친환경건축설비연구실\n"+
				"426 디지털건축연구실\n"+
				"427 학부사무실\n"+
				"428 건축세미나실1\n"+
				"429 4학년설계실-2\n"+
				"430 4학년설계실-1\n"+
				"431 3학년설계실-2\n"+
				"432 3학년설계실-1\n"+
				"433 강의실(중)-5\n"+
				"434 강의실(중)-6\n"+
				"435 학부학생회실-3\n"+
				"436 2학년설계실-1\n"+
				"437 2학년설계실-2\n"+
				"438 1힉년설계실\n"+
				"439 건축세미나실2\n"+
				"441~444 교수연구실\n"+
				"445 강구조연구실\n"+
				"446 건축구조연구실\n"+
				"447 건설경영및관리연구실\n"+
				"448 건축학/도시설계 전공사무실\n"+
				"449~456 교수연구실\n"+
				"457 WIT연구실험실\n"+
				"458 플라즈마연구실험실\n"+
				"459 집적회로설계연구실험실\n"+
				"460 지능제어연구실험실\n"+
				"461~468 교수연구실\n"+
				"469 품질경엉연구실\n"+
				"470 VMS연구실\n"+
				"471 생산혁신연구실\n"+
				"472 IT서비스연구실\n"+
				"473~476 교수연구실\n"+
				"478 비즈니스 솔루션 실습실\n"+
				"479 VMS실험실\n"+
				"480 물류실험실\n"+
				"481 학과학생회실(주간)\n"+
				"482 강의실(소)-4\n"+
				"483 강의실(중)-4");
		textArray.add("501 학과학생회실(야간)\n"+
				"502 강의실(소)-7\n"+
				"503 강의실(중)-6\n"+
				"504 연소공학실험실\n"+
				"505 열공학실험실\n"+
				"506 학과사무실\n"+
				"506-1 학과학생회실\n"+
				"507 세미나실(소)-4\n"+
				"508 에너지변환및저장실험실\n"+
				"509 수리환경연구실\n"+
				"510 대기환경&교통연구실\n"+
				"511 전공학회실\n"+
				"511-1 전공사무실\n"+
				"513 강사대기실-2\n"+
				"514 강사대기실-1\n"+
				"515 세미나실(대)\n"+
				"516 캠스턴디자인실습실2\n"+
				"517 캠스턴디자인실습실3\n"+
				"518 강의실(대)-계단식\n"+
				"519 창고\n"+
				"520 기초설계실습실\n"+
				"521 교학실\n"+
				"522 학장실\n"+
				"523 교수회의실\n"+
				"524 공동교수실\n"+
				"525 학과학생회실\n"+
				"525-1 연구원실\n"+
				"526 강사대기실\n"+
				"526-1 학과사무실\n"+
				"527 학장실\n"+
				"528 교학실\n"+
				"529 세미나실(소)-6\n"+
				"530 에너지화공심화실험실\n"+
				"531 5학년설계실2\n"+
				"532 5학년설계실1\n"+
				"533 모형제작실\n"+
				"534 강의실(중)-7\n"+
				"535 강의실(소)-8\n"+
				"536 여학생휴게실\n"+
				"537 탈의실(여)\n"+
				"538 샤워실(여)\n"+
				"539 디지털건축실습실\n"+
				"540 서버실\n"+
				"541 암실\n"+
				"542 자료실\n"+
				"543 강의실\n"+
				"545 세미나실(소)-8\n"+
				"546 공동교수실\n"+
				"547 공동교수실\n"+
				"548 유-무기혼성나노물질연구실\n"+
				"549 유기광전자연구실\n"+
				"550 공학교육혁신센터\n"+
				"551 공학교육혁신센터\n"+
				"552 공학교육혁신센터장살\n"+
				"553 공동교수실\n"+
				"554 공동교수실\n"+
				"555 전공사무실\n"+
				"556 전공사무실\n"+
				"557 공동교수실\n"+
				"558 전공사무실\n"+
				"559 전공사무실\n"+
				"560 나노바이오실험실1\n"+
				"561 나노바이오공용실습실\n"+
				"562 나노재료연구실\n"+
				"563 나노바이오실험실2\n"+
				"564~568 교수연구실\n"+
				"569 교수연구실(교학과장실)\n"+
				"570 교수연구실\n"+
				"571 교수연구실\n"+
				"572 에너지화공기초실험실\n"+
				"574 나노생화학실험실\n"+
				"575 나노세포배양실\n"+
				"576 공동교수실\n"+
				"577 공동교수실\n"+
				"578 세미나실(소)-7\n"+
				"580 생산혁신실험실\n"+
				"581 품질혁신실험실\n"+
				"582 서버실\n"+
				"583 인간공학실험실");
	}
}