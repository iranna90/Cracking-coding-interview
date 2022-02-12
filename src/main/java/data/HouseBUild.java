package data;

import java.util.List;

public class HouseBUild {

    // 1. Duration
    // 2. Number of rooms -- Bedroom, bathroom, Kitechen
    // 3. Acrchitecture.

    private class HouseService {
        public House createHouse(List<Kitchen> kitchens, List<Bathroom> bathrooms) {
            House house = new House();
            house.kitchens = kitchens;
            Bathroom bathroom = bathrooms.get(0);
            bathroom.openDoor();
            return house;
        }
    }

    private class RoomService {
        public Room createHouse() {
            return null;
        }
    }

    private class House {
        private List<Kitchen> kitchens;
        private List<Bathroom> bathrooms;
        private List<Room> rooms;
    }

    private class Kitchen {
        private int floor;
        private String sink;
        private String dinningTable;

    }

    private class Bathroom {
        private String door;
        private String numberTaps;
        private String typeOfTaps;
        private String mirrorType;
        private String tioletType;
        private int floor;

        public void openDoor() {
            System.out.println("Door opend");
        }
    }

    private class Room {
        private String door;
        private int size;
        private String light;
    }
}
