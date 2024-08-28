package dm.ospagefit;

import dm.pagefit.map.Coordinate;

import java.awt.*;

public class OSLinkGenerator
{
    private final static String PRINT_URL = "https://explore.osmaps.com/print?";

    /**
     * Creates a URL that points to a map centered on the specified coordinates that can be used to generate a print map on the OS Maps website.
     *
     * @param eastingNorthingMapCentre The center of the map in Easting/Northing coordinates.
     * @return A URL string that can be used to generate a print map on the OS Maps website.
     */
    public static String createMapCentreLink(Coordinate eastingNorthingMapCentre)
    {
        /* OS website printing generates prints from centre of the viewable area.
           Unfortunately this area is reduced and skewed by the printing menu when printing.
           So https://explore.osmaps.com/print?lat=53.401456&lon=-1.880410 doesn't center at the targeted lat/lon.
           To counteract this an offset is added to the target coordinates (1150M East / 165M North)
           This is only true at a zoom level of 13.0000 and on a screen resolution of 1920x1080
         */

        // Get the screen size as a Dimension object
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        if (screenSize.width != 1920 || screenSize.height!= 1080)
            System.err.println("Possible incompatible resolution, set to 1920x1080 when opening url");

        Coordinate adjustedCoordinate = new Coordinate(eastingNorthingMapCentre.getX() - 1150, eastingNorthingMapCentre.getY() + 165);
        Coordinate longLatMapCentre = CoordinateConversion.fromEastingNorthing(adjustedCoordinate);

        return  PRINT_URL +
                "lat="+longLatMapCentre.getY()+
                "&lon="+longLatMapCentre.getX()+
                "&zoom=13.0000&style=Leisure&type=2d";
    }
}
