package com.example.inucampusmap;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BuildingActivity extends Activity {
	ListView mListMember;
	ArrayList<String> mBuildingArray;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BuildingActivity.setBackgroundColor(Color.BLUE);
        //activity_building.xml의 레이아웃으로 화면을 설정
        requestWindowFeature(Window.FEATURE_NO_TITLE);//상단 타이틀 삭제
        setContentView(R.layout.activity_building);
        initListView();
    }

    private static void setBackgroundColor(int blue) {
		// TODO Auto-generated method stub
		
	}

	//화면 구성 
	public void initListView(){
		//리스트에 추가 할 목록들
		String[] strTextList = {"7호관 정보기술대학", "8호관 공과대학", "11호관 복지회관"};
		
		//mBuildingArray에 목록을 추가
		mBuildingArray = new ArrayList<String>();
		for(int i = 0; i < strTextList.length; i++)
			mBuildingArray.add(strTextList[i]);
		
		//ListView와 연동하기 위해 adapter를 이용하여 등록
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, mBuildingArray);
		mListMember = (ListView)findViewById(R.id.buildingList);
		mListMember.setAdapter(adapter);
		
		//리스너를 등록한다.
		AdapterView.OnItemClickListener mItemClickListener = 
				new AdapterView.OnItemClickListener() {
					public void onItemClick(AdapterView parent, View view, int position, long id){
						
						//선택된 건물의 액티비티 이동
						switch(position){
							case 0 :
								startActivity(new Intent(BuildingActivity.this,BuildingInfoActivity7.class));
							break;
							case 1 :
								startActivity(new Intent(BuildingActivity.this,BuildingInfoActivity8.class));
							break;
							case 2 :
								startActivity(new Intent(BuildingActivity.this,BuildingInfoActivity11.class));
							break;
						}
					}
				};
		mListMember.setOnItemClickListener(mItemClickListener);
	}
}
