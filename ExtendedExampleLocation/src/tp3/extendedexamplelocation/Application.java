package tp3.extendedexamplelocation;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Application extends Activity implements ObserverLocation {

	private TextView latitudeText, longitudeText; 
	private LocationManager locationManager;
	private User user;
	private LocationListenerCollaborator locationListenerCol; 
	
    public TextView getLatitudeText() {
		return latitudeText;
	}

	public void setLatitudeText(TextView latitudeText) {
		this.latitudeText = latitudeText;
	}

	public TextView getLongitudeText() {
		return longitudeText;
	}

	public void setLongitudeText(TextView longitudeText) {
		this.longitudeText = longitudeText;
	}

	public LocationManager getLocationManager() {
		return locationManager;
	}

	public void setLocationManager(LocationManager locationManager) {
		this.locationManager = locationManager;
	}
	
	public LocationListenerCollaborator getLocationListenerCol() {
		return locationListenerCol;
	}
	
	public void setLocationListenerCol(
			LocationListenerCollaborator locationListenerCol) {
		this.locationListenerCol = locationListenerCol;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);
        this.setUser(new User());
        this.setLocationListenerCol(new LocationListenerCollaborator());
        getLocationListenerCol().addObserver(this);
        
        setLatitudeText((TextView) findViewById(R.id.textView2));
        setLongitudeText((TextView) findViewById(R.id.textView4));
        
        setLocationManager((LocationManager) getSystemService(Context.LOCATION_SERVICE));
    }
    
    @Override
	protected void onResume() {
		super.onResume();
		getLocationManager().requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, this.locationListenerCol);
	}


	@Override
	protected void onPause() {
		super.onPause();
		getLocationManager().removeUpdates(this.locationListenerCol);
	}
    
    @Override
	public void notifyLocationUpdated(Location location) {
		// ACá actualiza valor de contexto del usuario y cambia los valores de los textview
		this.user.setPositionContextValue(location);
		getLatitudeText().setText(String.valueOf(location.getLatitude()));
		getLongitudeText().setText(String.valueOf(location.getLongitude()));		
	}
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.application, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_application, container, false);
            return rootView;
        }
    }


}
