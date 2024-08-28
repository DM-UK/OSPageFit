package dm.ospagefit;

import dm.pagefit.PageFit;
import dm.pagefit.clustering.PageCluster;
import dm.pagefit.io.CoordinateFile;
import dm.pagefit.io.FileIO;
import dm.pagefit.map.Coordinate;
import dm.pagefit.map.PageSize;

import java.util.ArrayList;
import java.util.List;

public class OSPageFit extends PageFit
{
    public final static String ROUTE_FILENAME = "resources/route3.txt";
    public final static PageSize PAGE_SIZE = new OSPageSize.A3MapSize(25000);
    public final static String OS_LINKS_FILENAME = "resources/urls_route3.txt";

    /**
     * Loads coordinates from a file.
     *
     * @return A list of coordinates loaded from the file.
     */
    public List<Coordinate> loadCoordinates()
    {
        return CoordinateFile.loadCoordinates(ROUTE_FILENAME);
    }

    public void saveClusters(List<PageCluster> clusters)
    {
        List<String[]> strings = new ArrayList();

        int i = 1;

        for (PageCluster cluster: clusters)
        {
            String orientation = !cluster.getPageSize().getOrientation() ? "Portrait" : "Landscape";

            String[] strArr = new String[]{
                    "Map " +i
                    +":\n"+ OSLinkGenerator.createMapCentreLink(cluster.getClusterCentre())
                    +"\nOrientation: " + orientation
                    +" @ Scale: " + (int) cluster.getPageSize().getScale()
                    +"\n"
            };

            strings.add(strArr);
            i++;
        }

        FileIO.writeFileLines(OS_LINKS_FILENAME, ",", strings);
    }

    public static void main(String[] args)
    {
        new OSPageFit();
    }
}
