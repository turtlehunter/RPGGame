package me.urielsalis.RPGGame.base.level;

import me.urielsalis.RPGGame.base.engine.GameObject;
import me.urielsalis.RPGGame.base.gameobject.item.Wall;

import java.util.ArrayList;

public class TestLevel {

    public static int WallWidth = 1;
    public static int RoomLength = 300;
    public static int DoorSizeSides = 100;
    public static int HallwayLength = 200;
    public static int DrawStart = 200;
    public static int Room1XStart = DrawStart;
    public static int Room1YStart = DrawStart;
    public static int Room2XStart = DrawStart;
    public static int Room2YStart = Room1YStart+RoomLength+HallwayLength;
    public static int Room3XStart = Room1XStart+RoomLength+HallwayLength;
    public static int Room3YStart = DrawStart;
    public static int Room4XStart = Room1XStart-HallwayLength-RoomLength;
    public static int Room4YStart = DrawStart;
    public static int Room5XStart = DrawStart;
    public static int Room5YStart = Room1YStart-RoomLength-HallwayLength;
    public static int Room6XStart = Room2XStart+RoomLength+HallwayLength;
    public static int Room6YStart = Room2YStart;



    public static ArrayList<GameObject> generate() {
        ArrayList<GameObject> objects = new ArrayList<>();

        //Room 1(center)
        objects.add(new Wall(Room1XStart, Room1YStart, WallWidth, DoorSizeSides)); //left wall first half
        objects.add(new Wall(Room1XStart, Room1YStart+RoomLength-DoorSizeSides, WallWidth, DoorSizeSides)); //left wall second half
        objects.add(new Wall(Room1XStart+RoomLength, Room1YStart, WallWidth, DoorSizeSides)); //hole in right first half
        objects.add(new Wall(Room1XStart+RoomLength, Room1YStart+RoomLength-DoorSizeSides, WallWidth, DoorSizeSides)); //hole in right second half
        objects.add(new Wall(Room1XStart, Room1YStart, DoorSizeSides, WallWidth)); //bottom wall first half
        objects.add(new Wall(RoomLength+DoorSizeSides, Room1YStart, DoorSizeSides, WallWidth)); //bottom wall second half
        objects.add(new Wall(Room1XStart, Room1YStart+RoomLength, DoorSizeSides, WallWidth)); //hole in top first half
        objects.add(new Wall(RoomLength+DoorSizeSides, Room1YStart+RoomLength, DoorSizeSides, WallWidth)); //hole in top second half

        //Hallway 1(top)
        objects.add(new Wall(Room1XStart+DoorSizeSides, Room1YStart+RoomLength, WallWidth, HallwayLength));
        objects.add(new Wall(Room1XStart+RoomLength-DoorSizeSides, Room1YStart+RoomLength, WallWidth, HallwayLength)); //last arg = length of halway up

        //Room 2(top)
        objects.add(new Wall(Room2XStart+HallwayLength, Room2YStart, DoorSizeSides, WallWidth)); //y = previousY + length(500 + 200) //first half of room opened in the bottom RoomLength*2 because we are drawing the size of this room too
        objects.add(new Wall(Room2XStart, Room2YStart, DoorSizeSides, WallWidth)); //first half of wall opened in the bottom
        objects.add(new Wall(Room2XStart, Room2YStart, WallWidth, RoomLength)); //left wall
        objects.add(new Wall(Room2XStart+RoomLength, Room2YStart, WallWidth, RoomLength)); //right wall
        objects.add(new Wall(DrawStart, Room2YStart+RoomLength, RoomLength, WallWidth)); //top wall

        //Hallway 2(right)
        objects.add(new Wall(Room1XStart+RoomLength, Room1YStart+RoomLength-DoorSizeSides, HallwayLength, WallWidth)); //top wall 100 so shorter halfway than 200
        objects.add(new Wall(Room1XStart+RoomLength, Room1YStart+DoorSizeSides, HallwayLength, WallWidth)); //top wall

        //Room 3(right)
        objects.add(new Wall(Room3XStart, Room3YStart, WallWidth, DoorSizeSides)); //hole in left first half
        objects.add(new Wall(Room3XStart, Room3YStart+RoomLength-DoorSizeSides, WallWidth, DoorSizeSides)); //hole in left second half
        objects.add(new Wall(Room3XStart, Room3YStart, RoomLength, WallWidth)); //bottom wall
        objects.add(new Wall(Room3XStart, Room3YStart+RoomLength, RoomLength, WallWidth)); //top wall
        objects.add(new Wall(Room3XStart+RoomLength, Room3YStart, WallWidth, RoomLength)); //right wall

        //Hallway 3(left)
        objects.add(new Wall(Room1XStart-HallwayLength, Room1YStart+RoomLength-DoorSizeSides, HallwayLength, WallWidth)); //top wall 100 so shorter halfway than 200
        objects.add(new Wall(Room1XStart-HallwayLength, Room1YStart+DoorSizeSides, HallwayLength, WallWidth)); //top wall

        //Room 4(left)
        objects.add(new Wall(Room4XStart, Room4YStart, WallWidth, RoomLength)); //left wall hole first half
        objects.add(new Wall(Room4XStart, Room4YStart, RoomLength, WallWidth)); //bottom wall
        objects.add(new Wall(Room4XStart, Room4YStart+RoomLength, RoomLength, WallWidth)); //top wall
        objects.add(new Wall(Room4XStart+RoomLength, Room4YStart, WallWidth, DoorSizeSides)); //right wall
        objects.add(new Wall(Room4XStart+RoomLength, Room4YStart+RoomLength-DoorSizeSides, WallWidth, DoorSizeSides)); //right wall

        //Hallway 4(bottom)
        objects.add(new Wall(Room1XStart+DoorSizeSides, Room1YStart-HallwayLength, WallWidth, HallwayLength));
        objects.add(new Wall(Room1XStart+RoomLength-DoorSizeSides, Room1YStart-HallwayLength, WallWidth, HallwayLength));

        //Room 5(bottom)
        objects.add(new Wall(Room5XStart, Room5YStart, RoomLength, WallWidth)); //bottom wall
        objects.add(new Wall(Room5XStart, Room5YStart, WallWidth, RoomLength)); //left wall
        objects.add(new Wall(Room5XStart+RoomLength, Room5YStart, WallWidth, RoomLength)); //right wall
        objects.add(new Wall(Room5XStart, Room5YStart+RoomLength, DoorSizeSides, WallWidth)); //top wall hole first half
        objects.add(new Wall(Room5XStart+RoomLength-DoorSizeSides, Room5YStart+RoomLength, DoorSizeSides, WallWidth)); //top wall hole second half

        //Room 6(no cuts)
        objects.add(new Wall(Room6XStart, Room6YStart, RoomLength, WallWidth)); //bottom wall
        objects.add(new Wall(Room6XStart, Room6YStart, WallWidth, RoomLength)); //left wall
        objects.add(new Wall(Room6XStart+RoomLength, Room6YStart, WallWidth, RoomLength)); //right wall
        objects.add(new Wall(Room6XStart, Room6YStart+RoomLength, RoomLength, WallWidth)); //top wall hole first half

        return objects;
    }
}
