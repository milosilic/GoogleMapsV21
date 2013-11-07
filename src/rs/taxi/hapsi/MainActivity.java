package rs.taxi.hapsi;


import com.google.android.gms.maps.GoogleMap;

import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;  
import com.google.android.gms.maps.SupportMapFragment; 

import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;



public class MainActivity extends FragmentActivity {
	 
    // Google Map
    private GoogleMap googleMap;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 
        try {
            // Loading map
            initilizeMap();
            LocationManager locationManager = (LocationManager) 
            		getSystemService(Context.LOCATION_SERVICE);
 
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }
 
    /**
     * function to load map. If map is not created it will create it for you
     * */
    private void initilizeMap() {
        if (googleMap == null) {
            googleMap = ((SupportMapFragment)  getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
            //SupportMapFragment fm = (SupportMapFragment)  getSupportFragmentManager().findFragmentById(R.id.map);
            // check if map is created successfully or not
            if (googleMap == null) {
                Toast.makeText(getApplicationContext(),
                        "Sorry unable to create maps", Toast.LENGTH_SHORT)
                        .show();
            }
            
            googleMap.setMyLocationEnabled( true );
        }
    }
 
    @Override
    protected void onResume() {
        super.onResume();
        initilizeMap();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.more_tab_menu, menu);


       return true;//return true so to menu pop up is opens

    }
 
}


