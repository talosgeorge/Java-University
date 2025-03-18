package isp.lab8.airways;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Exercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RouteManager routeManager = new RouteManager();

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Create a route");
            System.out.println("2. Delete a route");
            System.out.println("3. List all routes");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the name of the route:");
                    scanner.nextLine(); // consume newline character
                    String routeName = scanner.nextLine();
                    routeManager.createRoute(routeName);
                    System.out.println("Route created.");
                    break;

                case 2:
                    System.out.println("Enter the name of the route to delete:");
                    scanner.nextLine(); // consume newline character
                    String routeToDelete = scanner.nextLine();
                    Route route = routeManager.getRouteByName(routeToDelete);
                    if (route != null) {
                        routeManager.deleteRoute(route);
                        System.out.println("Route deleted.");
                    } else {
                        System.out.println("Route not found.");
                    }
                    break;

                case 3:
                    System.out.println("List of available routes:");
                    routeManager.listAllRoutes();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

