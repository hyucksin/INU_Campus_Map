package com.example.inucampusmap;
import com.google.android.gms.maps.model.LatLng;

public class MapBean 
{
	private LatLng place_location;
	private String place_name;
	private int place_img;

	public MapBean(String place_location_get,String place_name_get,int place_img_get) {
		
		String[] loc_string = place_location_get.split(",");
		double[] loc_array = new double[2];

		for (int k = 0; k < loc_string.length; k++) {
			loc_array[k] = Double.valueOf(loc_string[k]);
		}

		place_location = new LatLng(loc_array[0], loc_array[1]);
		place_name = place_name_get;
		place_img = place_img_get;

	}

	public LatLng getPlace_location() {
		return place_location;
	}

	public String getPlace_name() {
		return place_name;
	}

	public int getPlace_img() {
		return place_img;
	}
}