package pack1;

public class GameLogic {

    public int birdVelocity(int birdA, int birdV) {

        birdV += birdA;

        return birdV;
    }

    public int birdAceleration(int birdA) {

        int birdI = 1;
        birdA += birdI;

        return birdA;
    }


    public void wallXCoordinate(int[] wallX) {

        int wallXVelocity = 5;
        wallX[0] -= wallXVelocity;
        wallX[1] -= wallXVelocity;

    }
}
