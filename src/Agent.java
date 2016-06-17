/**
 * Created by Alan on 4/22/16.
 */
public abstract class Agent {
    // Coordinates on a "map" (two dimensional array)
    private int x;
    private int y;
    private int age;
    private int maximumAge;
    private int energy = 100;


    // Can the agent move or not
    private MoveState moveState;
    // Can the agent hunt or not
    private HuntState huntState;

    public Agent(int x, int y, MoveState moveState, HuntState huntState) {
        this.x = x;
        this.y = y;
        this.moveState = moveState;
        this.huntState = huntState;

        // Randomize age and maximumAge and ensure maximumAge is greater than age
        int maximumAge = (int )(Math.random() * 50 + 1);
        int age;
        do {
            age = (int )(Math.random() * 50 + 1);
        } while (maximumAge < age);

        this.age = age;
        this.maximumAge = maximumAge;
    }

    // Getters
    public int getX() {return x;}
    public int getY() {return y;}
    private int getAge() {return age;}
    private int getMaximumAge() {return maximumAge;}
    public MoveState getMoveState() {return moveState;}
    public HuntState getHuntState() {return huntState;}

    // Increase age and check for death, true if age >= maximumAge
    public boolean incrementAge()
    {
        age++;
        if (age >= maximumAge)
        {
            return true;
        }
        return false;
    }

    public void reproduce(Agent[][] earth, int i, int j) {
        if (earth[i][j].getAge() > 20)
        {

            // Directions are clockwise, 1 is north and 4 is west
            int direction = (int) (Math.random() * 4 + 1);

            switch (direction) {
                case 1:
                    if (i - 1 >= 0 && earth[i - 1][j] == null) {
                        earth[i - 1][j] = earth[i][j];

                    }
                    break;

                case 2:
                    if (j + 1 < 3 && earth[i][j + 1] == null) {
                        earth[i][j + 1] = earth[i][j];
                    }
                    break;

                case 3:
                    if (i + 1 < 3 && earth[i + 1][j] == null) {
                        earth[i + 1][j] = earth[i][j];
                    }
                    break;

                case 4:
                    if (j - 1 >= 0 && earth[i][j - 1] == null) {
                        earth[i][j - 1] = earth[i][j];
                    }
                    break;

                default:
                    break;
            }
        }
    }

    // Check if there is enough energy to reproduce, hunt, or move
    public boolean enoughEnergy()
    {
        int minEnergy = 1;
        int maxEnergy = 9;
        energy = energy - (int)(Math.random()*(maxEnergy-minEnergy+1)+minEnergy);

        if (energy >= 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
