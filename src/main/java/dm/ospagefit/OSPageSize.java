package dm.ospagefit;

import dm.pagefit.map.PageSize;

public class OSPageSize
{

    /**
     * Concrete subclass representing the size of an A4 map.
     */
    public static class A4MapSize extends PageSize {

        /**
         * Constructs an A4MapSize object with the given scale and default portrait orientation.
         *
         * @param scale the scale factor to be applied to the map dimensions
         */
        public A4MapSize(double scale) {
            super(0.190244, 0.277245, scale, false, "A4");
        }
    }

    /**
     * Concrete subclass representing the size of an A3 map.
     */
    public static class A3MapSize extends PageSize {

        /**
         * Constructs an A3MapSize object with the given scale and default portrait orientation.
         *
         * @param scale the scale factor to be applied to the map dimensions
         */
        public A3MapSize(double scale) {
            super(0.277245, 0.400246, scale, false, "A3");
        }
    }
}
