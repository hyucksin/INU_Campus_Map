package com.example.inucampusmap;

import android.app.*;
import android.content.*;
import android.os.*;
import android.util.*;
import android.view.*;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    //선택한 버튼에 따라 해당 Activity로 이동
    public void onClick(View v) {
    	switch(v.getId()){
    	case R.id.buildingButton :  
    		Intent intent = new Intent(this,BuildingActivity.class);
    		startActivity(intent);
    		break;
    	case R.id.useButton :  
    		Intent intent1 = new Intent(this,UseInfoActivity.class);
    		startActivity(intent1);
    		break;
    	case R.id.mapButton :  
    		Intent intent2 = new Intent(this,MapActivity.class);
    		startActivity(intent2);
    		break;
    	case R.id.starButton :  
    		Intent intent3 = new Intent(this,StarActivity.class);
    		startActivity(intent3);
    		break;
    	}
    }
}
