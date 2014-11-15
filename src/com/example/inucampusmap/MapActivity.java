package com.example.inucampusmap;

import java.util.*;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class MapActivity extends Activity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //activity_building의 레이아웃으로 화면을 설정
        setContentView(R.layout.activity_campus_map);
    }
}
