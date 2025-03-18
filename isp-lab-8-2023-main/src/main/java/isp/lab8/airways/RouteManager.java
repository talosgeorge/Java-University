package isp.lab8.airways;

import com.fasterxml.jackson.databind.ObjectMapper;
import examples.files.FilesAndFoldersUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class RouteManager {
    private List<Route> routes;

    public RouteManager() {
        this.routes = new ArrayList<>();
    }

    public void createRoute(String name) {
        Route route = new Route(name);
        this.routes.add(route);
    }

    public void deleteRoute(Route route) {
        this.routes.remove(route);
    }
    public Route getRouteByName(String name) {
        for (Route route : routes) {
            if (Objects.equals(route.getName(), name)) {
                return route;
            }
        }
        return null;
    }

    public void addWaypoint(Route route, Waypoint waypoint) {
        route.addWaypoint(waypoint);
    }

    public void removeWaypoint(Route route, Waypoint waypoint) {
        route.removeWaypoint(waypoint);
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void saveRoutes() throws IOException {
        String workingFolder = "C:\\Users\\talos\\OneDrive\\Desktop\\Scoala\\An II\\ISP\\Airways";
        ObjectMapper objectMapper = new ObjectMapper();
        for (Route route : routes) {
            FilesAndFoldersUtil.createFolder(workingFolder + "\\" + route.getName());
            for (Waypoint waypoint : route.getWaypoints()) {
                objectMapper.writeValue(new FileWriter(workingFolder + "\\" + route.getName() + "\\" + waypoint.getName() + ".json"), waypoint);
            }
        }
    }

    public List<Waypoint> loadWaypoints(File routesDir) throws IOException {
        List<Waypoint> wps = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        File[] waypoints = routesDir.listFiles();
        for (File wp : waypoints) {
            Waypoint waypoint = objectMapper.readValue(wp, Waypoint.class);
            wps.add(waypoint);
        }
        return wps;
    }
    public void listAllRoutes() {
        for (Route route : routes) {
            System.out.println(route.getName());
        }
    }
}

