package isp.lab8.airways;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AirwaysTest {
    @Test
    public void testCalculateDistance() {
        Waypoint LRCL = new Waypoint("LRCL", 46.7852, 23.6862, 415);
        Waypoint TASOD = new Waypoint("TASOD", 47.0548, 23.9212, 10460);
        Waypoint SOPAV = new Waypoint("SOPAV", 46.9804, 24.7365, 10900);
        Waypoint BIRGU = new Waypoint("BIRGU", 45.9467, 26.0217, 10200);
        Waypoint LROP = new Waypoint("LROP", 44.5711, 26.0858, 106);

        RouteManager routeManager = new RouteManager();
        Route LRCL_LROP = new Route("LRCL-LROP");
        routeManager.createRoute(LRCL_LROP.getName());
        routeManager.addWaypoint(LRCL_LROP, LRCL);
        routeManager.addWaypoint(LRCL_LROP, TASOD);
        routeManager.addWaypoint(LRCL_LROP, SOPAV);
        routeManager.addWaypoint(LRCL_LROP, BIRGU);
        routeManager.addWaypoint(LRCL_LROP, LROP);

        double expectedDistance = 401.6;

        double actualDistance = LRCL_LROP.calculateDistance();

        assertEquals(expectedDistance, actualDistance, 0.1);
    }
}
