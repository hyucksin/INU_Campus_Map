package com.example.inucampusmap;

import android.app.*;
import android.os.*;
import android.view.*;

public class SplashActivity extends Activity {
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//상단 타이틀 삭제
        setContentView(R.layout.activity_splash);
        
        //splash
        Handler handler = new Handler(){
        	public void handleMessage(Message msg){
        		finish();
        	}
        };
        handler.sendEmptyMessageDelayed(0, 2000);//2초
    }
}

