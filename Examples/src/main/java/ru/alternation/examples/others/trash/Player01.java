package ru.alternation.examples.others.trash;


import java.util.*;


//https://www.codingame.com/ide/puzzle/coders-strike-back
// todo: переписать не плохо бы

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
public class Player01 {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        CheckPointHolder checkPointHolder = new CheckPointHolder();
        boolean isBoostUsed = false;

        // game loop
        while (true) {

            int x = in.nextInt();
            int y = in.nextInt();
            int nextCheckpointX = in.nextInt(); // x position of the next check point
            int nextCheckpointY = in.nextInt(); // y position of the next check point
            int nextCheckpointDist = in.nextInt(); // distance to the next checkpoint // не заметил
            int nextCheckpointAngle = in.nextInt(); // angle between your pod orientation and the direction of the next checkpoint
            int opponentX = in.nextInt();
            int opponentY = in.nextInt();

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");


            // You have to output the target position
            // followed by the power (0 <= thrust <= 100)
            // i.e.: "x y thrust"


            if(!checkPointHolder.isFull()){
                checkPointHolder.add(nextCheckpointX, nextCheckpointY);
                checkPointHolder.print();
            }
            else {
                if(checkPointHolder.get(nextCheckpointX,nextCheckpointY).getDistanceToNext() == checkPointHolder.getMaxDistance()) {
                    //useBoots();
                    if(!isBoostUsed && (nextCheckpointAngle < 25 && nextCheckpointAngle > -25)){
                        System.out.println(nextCheckpointX + " " + nextCheckpointY + " BOOST");
                        isBoostUsed = true;
                        continue;
                    }
                }
                else{
                    isBoostUsed = false;
                }
            }




            int thrust;
            if(nextCheckpointAngle > 90 || nextCheckpointAngle < -90){
                thrust = 0;
            }
            else{
                thrust = 100;
            }


            System.out.println(nextCheckpointX + " " + nextCheckpointY + " " + thrust);
        }
    }


    private static class CheckPoint{
        int x, y;
        int distanceToNext;

        public int getDistanceToNext() {
            return distanceToNext;
        }

        public void setDistanceToNext(int distanceToNext) {
            this.distanceToNext = distanceToNext;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CheckPoint that = (CheckPoint) o;
            return x == that.x &&
                    y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        CheckPoint(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static class CheckPointHolder{
        private List<CheckPoint> checkPoints  = new ArrayList<>();
        private boolean isFull = false;
        int maxDistance = 0;
        int x = -1 , y = -1;

        public int getMaxDistance() {
            return maxDistance;
        }

        void print(){
            for (CheckPoint ch : checkPoints){
                System.err.println(ch.x +" "+ ch.y);
            }
        }

        boolean isFull(){
            return isFull;
        }

        void add(int nextCheckpointX, int nextCheckpointY){

            if (x != nextCheckpointX && y != nextCheckpointY){
                if (checkPoints.contains(new CheckPoint(nextCheckpointX, nextCheckpointY))) {
                    isFull = true;
                    resolveDistance();
                    maxDistance = findMaxDistance();
                    return;
                }
                checkPoints.add(new CheckPoint(nextCheckpointX, nextCheckpointY));
                x = nextCheckpointX;
                y = nextCheckpointY;
            }
        }

        void resolveDistance(){
            for (int i = 0; i < checkPoints.size()-1; i++) {
                CheckPoint first = checkPoints.get(i);
                CheckPoint second = checkPoints.get(i+1);
                int dist = (int)Math.sqrt(Math.pow(Math.abs(second.x - first.x), 2) + Math.pow(Math.abs(second.y - first.y),2));
                second.setDistanceToNext(dist);
                System.err.println("dist "+ dist);
                System.err.println(first.x  +" "+  first.y);
                System.err.println(second.x  +" "+  second.y);
            }
            CheckPoint first = checkPoints.get(checkPoints.size()-1);
            CheckPoint second = checkPoints.get(0);
            int dist = (int)Math.sqrt(Math.pow(Math.abs(second.x - first.x), 2) + Math.pow(Math.abs(second.y - first.y),2));
            second.setDistanceToNext(dist);
            System.err.println("dist "+ dist);
            System.err.println(first.x +" "+ first.y);
            System.err.println(second.x  +" "+  second.y);

        }

        int findMaxDistance(){
            int max =0;
            for (CheckPoint checkPoint : checkPoints){
                if (checkPoint.getDistanceToNext()> max)
                    max = checkPoint.getDistanceToNext();
            }
            return max;
        }

        CheckPoint get(int x, int y){
            int i = checkPoints.indexOf(new CheckPoint(x,y));
            System.err.println(checkPoints.size());
            System.err.println("_" + x +" "+ y);

            return checkPoints.get(i);
        }
    }
}


