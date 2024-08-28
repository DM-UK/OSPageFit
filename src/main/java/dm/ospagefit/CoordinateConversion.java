package dm.ospagefit;

import dm.pagefit.map.Coordinate;
import uk.gov.dstl.geo.osgb.Constants;
import uk.gov.dstl.geo.osgb.EastingNorthingConversion;
import uk.gov.dstl.geo.osgb.OSGB36;

public class CoordinateConversion
{
    public static Coordinate fromLatLon(double latitude, double longitude)
    {
        double[] latlongDatumShift  = OSGB36.fromWGS84(latitude, longitude);
        double[] eastNorthOSGB38 = EastingNorthingConversion.fromLatLon(
                latlongDatumShift,
                Constants.ELLIPSOID_AIRY1830_MAJORAXIS,
                Constants.ELLIPSOID_AIRY1830_MINORAXIS,
                Constants.NATIONALGRID_N0,
                Constants.NATIONALGRID_E0,
                Constants.NATIONALGRID_F0,
                Constants.NATIONALGRID_LAT0,
                Constants.NATIONALGRID_LON0);

        return new Coordinate(eastNorthOSGB38[0], eastNorthOSGB38[1]);
    }

    public static Coordinate fromEastingNorthing(Coordinate eastingNorthing)
    {
        //Convert from Easting and Northing into Cartesian Coordinates (LatLon)
        double[] latlonOSGB38 = EastingNorthingConversion.toLatLon(
                new double[]{eastingNorthing.getX(), eastingNorthing.getY()},
                Constants.ELLIPSOID_AIRY1830_MAJORAXIS,
                Constants.ELLIPSOID_AIRY1830_MINORAXIS,
                Constants.NATIONALGRID_N0,
                Constants.NATIONALGRID_E0,
                Constants.NATIONALGRID_F0,
                Constants.NATIONALGRID_LAT0,
                Constants.NATIONALGRID_LON0);

        //Convert from LatLon (OSGB) to WGS84
        double[] latlonWGS84 = OSGB36.toWGS84(latlonOSGB38[0], latlonOSGB38[1]);
        return new Coordinate(latlonWGS84[1], latlonWGS84[0]);
    }
}
