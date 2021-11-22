package pack1;

public class GameLogic implements Score{

    private int score;

    public int birdGravity(int birdA, int birdG) {

        birdG += birdA;

        return birdG;
    }

    public int birdAceleration(int birdA, int gravity) {

        birdA += gravity;

        return birdA;
    }

    public void wallXCoordinate(int[] wallX) {

        int wallXVelocity = 5;
        wallX[0] -= wallXVelocity;
        wallX[1] -= wallXVelocity;
    }

    public static boolean gameStatus(int[] wallX, int wallwidth, int birdHeight, int birdV, int[] gap, int height, int width){

        for (int i=0; i<2; i++){
            if (wallX[i] < 100 && wallX[i] + wallwidth >= 100 || wallX[i] <= 75 && wallX[i] + wallwidth >= 75)
                if (birdHeight + birdV <= gap[i] || birdHeight + birdV + 25 >= gap[i] + 150){
                    return true;
                }

            if (birdHeight + birdV <= 0 || birdHeight + birdV + 25 >= height){
                return true;
            }

            if (wallX[i] + wallwidth <= 0) {
                wallX[i] = width;
                gap[i] = (int) (Math.random() * (height - 150));
            }

        }

        return false;
    }


    @Override
    public void printScoreInConsole() {

    }

    @Override
    public void addScore(){
            score++;
    }

    @Override
    public void resetScore() {

    }
}

