package factory;

import model.Geolocation;

public class GeolocationFactory {
    private static final double LATITUDE = 40.7143528d;
    private static final double LONGITUDE = -74.0059731d;

    public static Geolocation createGeolocation() {
        return new Geolocation(LATITUDE, LONGITUDE);
    }
}
