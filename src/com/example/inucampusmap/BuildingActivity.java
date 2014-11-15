package com.example.inucampusmap;

import java.util.*;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class BuildingActivity extends Activity {
	ListView mListMember;
	ArrayList<String> mBuildingArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //activity_building.xml의 레이아웃으로 화면을 설정
        setContentView(R.layout.activity_building);
        initListView();
    }

    //화면 구성 
	public void initListView(){
		//리스트에 추가 할 목록들
		String[] strTextList = {"7호관 정보기술대학", "복지회관"};
		
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
								startActivity(new Intent(BuildingActivity.this,BuildingInfoActivity0.class));
							break;
						}
					}
				};
		mListMember.setOnItemClickListener(mItemClickListener);
	}
}