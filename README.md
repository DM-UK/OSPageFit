### OSPageFit ###
This Java project is a practical implementation of [PageFit](https://github.com/DM-UK/PageFit) for generating URL's to Ordnance Survey's print service. 

![](https://github.com/DM-UK/OSPageFit/blob/master/map.png)

___

## Usage ##
Entry point is [OSPageFit](https://github.com/DM-UK/OSPageFit/blob/master/src/main/java/dm/ospagefit/OSPageFit.java).main()

[Coordinates](https://github.com/DM-UK/OSPageFit/blob/master/src/main/java/dm/pagefit/map/Coordinate.java) must consist of an Easting/Northing  in OSGB36 format.

___
## Example output ##
```
Map 1:
https://explore.osmaps.com/print?lat=52.54559331188692&lon=1.2435133072764932&zoom=13.0000&style=Leisure&type=2d
Orientation: Portrait @ Scale: 25000

Map 2:
https://explore.osmaps.com/print?lat=52.46477415668778&lon=1.1873703402776228&zoom=13.0000&style=Leisure&type=2d
Orientation: Portrait @ Scale: 25000

Map 3:
https://explore.osmaps.com/print?lat=52.39748590528539&lon=1.10636540645313&zoom=13.0000&style=Leisure&type=2d
Orientation: Landscape @ Scale: 25000

Map 4:
https://explore.osmaps.com/print?lat=52.37254186367083&lon=0.970480350768266&zoom=13.0000&style=Leisure&type=2d
Orientation: Landscape @ Scale: 25000

Map 5:
https://explore.osmaps.com/print?lat=52.40738356938143&lon=0.847961652790244&zoom=13.0000&style=Leisure&type=2d
Orientation: Portrait @ Scale: 25000
```
