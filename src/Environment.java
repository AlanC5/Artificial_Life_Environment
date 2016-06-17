/**
 * Singleton Class
 *
 * Created by Alan on 4/22/16.
 */
public class Environment
{
    private static final char CARNIVORE = 'C';
    private static final char HERBIVORE = '@';
    private static final char PLANT = '*';

    // Two dimensional array contains all the agents
    private Agent[][] earth;
    public static Environment instance;

    // Private constructor, prevents constructor from being called outside
    private Environment()
    {
        earth = new Agent[30][30];
        initEarth();
    }

    // Randomly initialize the Earth with agents
    private void initEarth()
    {
        for (int i = 0; i < 30; i++)
        {
            for (int j = 0; j < 30; j++)
            {

                if (Math.random() < 0.20)
                {
                    earth[i][j] = new Plant(i, j);
                }

                else if (Math.random() < 0.10)
                {
                    earth[i][j] = new Herbivore(i, j);
                }

                else if (Math.random() < 0.05)
                {
                    earth[i][j] = new Carnivore(i, j);
                }
            }
        }
    }

    // Singleton if no instance Environment, it creates it otherwise it returns the already created instance
    // Impossible to create a new environment because constructor is private as well
    public static Environment getInstance()
    {
        if (instance == null)
        {
            instance = new Environment();
        }

        return instance;
    }

    // Move the movable agents inside Earth a number of times
    public void startEarth(int numItr)
    {
        for (int itr = 0; itr < numItr; itr++)
        {
            for (int i = 0; i < 30; i++)
            {
                for (int j = 0; j < 30; j++)
                {
                    // Check if cell contains an agent, increment age and reproduce
                    if (earth[i][j] != null)
                    {
                        // Age and check for death
                        if (earth[i][j].incrementAge())
                        {
                            earth[i][j] = null;
                        }

                        else {


                            // Check if there is anything to eat
                            if (earth[i][j].getHuntState() instanceof Hunter)
                            {
                                if (earth[i][j].enoughEnergy()) {
                                    ((Hunter) earth[i][j].getHuntState()).hunt(earth, i, j);
                                }
                            }

                            // Reproduce
                            if (earth[i][j].enoughEnergy()) {
                                earth[i][j].reproduce(earth, i, j);
                            }

                            // Check if cell contains a movable agent
                            if (earth[i][j].getMoveState() instanceof Movable)
                            {
                                if (earth[i][j].enoughEnergy()) {
                                    ((Movable) earth[i][j].getMoveState()).move(earth, i, j);
                                }
                            }

                        }

                    }

                }
            }

            printEarth();
            System.out.println();
            System.out.println();
            System.out.println();

            try
            {
                Thread.sleep(500);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    private void printEarth()
    {
        for (int i = 0; i < 30; i++)
        {
            for (int j = 0; j < 30; j++)
            {
                if (earth[i][j] instanceof Carnivore)
                {
                    System.out.print(CARNIVORE);
                }
                else if (earth[i][j] instanceof Herbivore)
                {
                    System.out.print(HERBIVORE);
                }
                else if (earth[i][j] instanceof Plant)
                {
                    System.out.print(PLANT);
                }
                else {
                    System.out.print(' ');
                }
            }
            System.out.println(' ');

        }
    }

    public Agent[][] getData() {return earth;}

}
