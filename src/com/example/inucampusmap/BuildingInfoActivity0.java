package com.example.inucampusmap;

import java.io.*;
import java.util.*;

import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;

import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.os.*;
import android.view.*;
import android.view.ContextMenu.ContextMenuInfo;
import android.webkit.*;
import android.widget.*;

public class BuildingInfoActivity0 extends Activity{
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
        
        mImageView = (ImageView)findViewById(R.id.buildingImageView);
        textView = (TextView)findViewById(R.id.textRoomList);
        		
        Button mapButton = (Button)findViewById(R.id.floorMapButton);
        Button roomButton = (Button)findViewById(R.id.floorRoomButton);
        
        registerForContextMenu(mapButton);
        registerForContextMenu(roomButton);
        
        mImage = (LinearLayout)findViewById(R.id.frameLayoutImage);
    	mText = (LinearLayout)findViewById(R.id.frameLayoutText);
        
	}
	//선택한 버튼에 따라 해당 Activity로 이동
    public void onClick(View v) {
    	Resources res;
    	Bitmap bitmap;
    	switch(v.getId()){
    	case R.id.locationButton :      		
    		res = getResources();
    		bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.b7_1);
        	bitmap = Bitmap.createScaledBitmap(bitmap, 450, 600, true);
        	mImageView.setImageBitmap(bitmap);
            mImageView.setScaleType(ImageView.ScaleType.FIT_START);
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
				menu.add(Menu.NONE, F_THREE, Menu.NONE, "3층");
				menu.add(Menu.NONE, F_FOUR, Menu.NONE, "4층");
				menu.add(Menu.NONE, F_FIVE, Menu.NONE, "5층");
			} 
			else if(v.getId() == R.id.floorRoomButton){				
				menu.setHeaderIcon(android.R.drawable.btn_star);
				menu.setHeaderTitle("층별 방 목록 보기");
				menu.add(Menu.NONE, R_ONE, Menu.NONE, "1층");
				menu.add(Menu.NONE, R_TWO, Menu.NONE, "2층");
				menu.add(Menu.NONE, R_THREE, Menu.NONE, "3층");
				menu.add(Menu.NONE, R_FOUR, Menu.NONE, "4층");
				menu.add(Menu.NONE, R_FIVE, Menu.NONE, "5층");
			}
		
		super.onCreateContextMenu(menu, v, menuInfo);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		
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
			break;
		case R_FOUR:
			mImage.setVisibility(LinearLayout.INVISIBLE);
            mText.setVisibility(LinearLayout.VISIBLE);
			break;
			
		case R_FIVE:
			mImage.setVisibility(LinearLayout.INVISIBLE);
            mText.setVisibility(LinearLayout.VISIBLE);
			break;

		default:
			break;
		}
		
		return super.onContextItemSelected(item);
	}
}

class TextRoom {
	ArrayList<String> textArray;
	TextRoom(){
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

	}
}