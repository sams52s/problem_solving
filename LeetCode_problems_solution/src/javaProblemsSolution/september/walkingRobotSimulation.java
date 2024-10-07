package javaProblemsSolution.september;

import java.util.HashSet;
import java.util.Set;

class walkingRobotSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obstacleSet = new HashSet<>();
        for(int[] obstacle : obstacles){
           obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        int[][] directionVectors = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int currentDirection = 0;

        int x = 0, y = 0;
        int maxDistanceSquared = 0;
        
        for (int command : commands) {
            if(command == -2){
                currentDirection = (currentDirection + 3) % 4;
            }
            else if(command == -1){
                currentDirection = (currentDirection + 1) % 4;
            }
            else{
                for (int i = 0; i < command; i++) {
                    int nextX = x + directionVectors[currentDirection][0];
                    int nextY = y + directionVectors[currentDirection][1];
                    if (!obstacleSet.contains(nextX + "," + nextY)) {
                        x = nextX;
                        y = nextY;
                        maxDistanceSquared = Math.max(maxDistanceSquared, x * x + y * y);
                    } else {
                        break;
                    }
                }
            }
        }   
        return maxDistanceSquared ;
    }
}
