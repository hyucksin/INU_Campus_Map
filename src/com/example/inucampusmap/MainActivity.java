package kr.co.company.mapexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends Activity {

	private GoogleMap mMap;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setUpMapIfNeeded();
	}

	private void setUpMapIfNeeded()
	{
		if(mMap==null)
		{
			mMap=((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();
			if(mMap!=null)
			{
				setUpMap();
			}
		}
	}
	
	private void setUpMap()
	{
		MarkerOptions marker=new MarkerOptions();
		marker.position(new LatLng(37.555,126.970));
		marker.title("marker");
		marker.draggable(true);
		marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.restaurant));
		mMap.addMarker(marker);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onResume()
	{
		super.onResume();
		mMap.setMyLocationEnabled(true);
	}
	
	public void onPause()
	{
		super.onPause();
		mMap.setBuildingsEnabled(false);
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
}
