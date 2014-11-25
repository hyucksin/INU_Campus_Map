package com.example.inucampusmap;

import java.util.*;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class UseInfoActivity extends Activity {
	ListView mListMember;
	ArrayList<String> mUseInfoArray;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //activity_building의 레이아웃으로 화면을 설정
        setContentView(R.layout.activity_useinfo);
        initListView();
    }

    //화면 구성 
	public void initListView(){
		//리스트에 추가 할 목록들
		String[] strTextList = {
				"공과대학 매점",
				"교직원식당",
				"교직원카페",
				"놀부보쌈",
				"농협중앙회",
				"도서관 매점",
				"모닝글로리(문구점)",
				"헤어비토(미용실)",
				"복지회관 복사점",
				"도서관 복사점",
				"복지회관 매점",
				"사진관",
				"생활관 식당",
				"서점",
				"토스트 매점",
				"스포츠센터",
				"안경점",
				"여행사 유학원",
				"우체국",
				"이동 통신사",
				"인문대 매점",
				"자연대 매점",
				"그라지에 제과점",
				"주차장 관리실",
				"피자리아(피자&파스타)",
				"학생식당",
				"한솥도시락"};
		
		//mBuildingArray에 목록을 추가
		mUseInfoArray = new ArrayList<String>();
		for(int i = 0; i < strTextList.length; i++)
			mUseInfoArray.add(strTextList[i]);
		
		//ListView와 연동하기 위해 adapter를 이용하여 등록
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, mUseInfoArray);
		mListMember = (ListView)findViewById(R.id.useInfoList);
		mListMember.setAdapter(adapter);
		
		//리스너를 등록한다.
		AdapterView.OnItemClickListener mItemClickListener = 
				new AdapterView.OnItemClickListener() {
					public void onItemClick(AdapterView parent, View view, int position, long id){
						//선택한 이용정보의 액티비티 이동
						UseInfoActivityImage a = new UseInfoActivityImage();
						a.infoNumber = position;
						startActivity(new Intent(UseInfoActivity.this,UseInfoActivityImage.class));
					}
				};
		mListMember.setOnItemClickListener(mItemClickListener);
	}
}
