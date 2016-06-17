/**
 * Created by Alan on 4/22/16.
 */
public class Carnivore extends Agent
{
    private String name = "CARNIVORE";


    public Carnivore(int x, int y) {
        super(x, y,
                new Movable()
                {
                    public void move(Agent[][] earth, int i, int j) {
                        // Directions are clockwise, 1 is north and 4 is west
                        int direction = (int )(Math.random() * 4 + 1);

                        switch (direction)
                        {
                            case 1:
                                if (i-1 >= 0 && earth[i-1][j] == null)
                                {
                                    earth[i-1][j] = earth[i][j];
                                    earth[i][j] = null;

                                }
                                break;

                            case 2:
                               if (j+1 < 3 && earth[i][j+1] == null)
                                {
                                    earth[i][j+1] = earth[i][j];
                                    earth[i][j] = null;
                                }
                                break;

                            case 3:
                                if (i+1 < 3 && earth[i+1][j] == null)
                                {
                                    earth[i+1][j] = earth[i][j];
                                    earth[i][j] = null;
                                }
                                break;

                            case 4:
                                if (j-1 >= 0 && earth[i][j-1] == null)
                                {
                                    earth[i][j-1] = earth[i][j];
                                    earth[i][j] = null;
                                }
                                break;

                            default:
                                break;
                        }
                    }
                },
                new Hunter() {
                    // Hunting herbivores within 1 square
                    public void hunt(Agent[][] earth, int i, int j)
                    {
                        // Directions are clockwise, 1 is north and 4 is west
                        int direction = (int )(Math.random() * 4 + 1);

                        switch (direction)
                        {
                            case 1:
                                if (i-1 >= 0 && earth[i-1][j] instanceof Herbivore)
                                {
                                    earth[i-1][j] = null;
                                }
                                break;

                            case 2:
                                if (j+1 < 3 && earth[i][j+1] instanceof Herbivore)
                                {
                                    earth[i][j+1] = null;
                                }
                                break;

                            case 3:
                                if (i+1 < 3 && earth[i+1][j] instanceof Herbivore)
                                {
                                    earth[i+1][j] = null;
                                }
                                break;

                            case 4:
                                if (j-1 >= 0 && earth[i][j-1] instanceof Herbivore)
                                {
                                    earth[i][j-1] = null;
                                }
                                break;

                            default:
                                break;
                        }
                    }
                }
        );
    }

    public String getName() {return name;}
}
