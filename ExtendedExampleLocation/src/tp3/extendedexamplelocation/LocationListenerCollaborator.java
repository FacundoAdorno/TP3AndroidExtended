package tp3.extendedexamplelocation;

import java.util.Vector;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

public class LocationListenerCollaborator implements LocationListener {

	private Vector<ObserverLocation> observers = new Vector<ObserverLocation>();
	
	
	@Override
	public void onLocationChanged(Location location) {
		// Avisar a los que se registraron como observadores que ocurrió un cambio.
		if (location != null) {
			for (int i = 0; i < observers.size(); i++) {
				((ObserverLocation) observers.elementAt(i)).notifyLocationUpdated(location);
			}
		}
	}
	
	public void addObserver(ObserverLocation observer) {
		if (observer != null & !observers.contains(observer)) {
			observers.addElement(observer);
		}
	}

	public void removeObserver(ObserverLocation observer) {
		if (observer != null) {
			observers.removeElement(observer);
		}
	}

	@Override
	public void onProviderDisabled(String arg0) {
	}

	@Override
	public void onProviderEnabled(String arg0) {
	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
	}

}
