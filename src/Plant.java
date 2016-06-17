/**
 * Created by Alan on 4/22/16.
 */
public class Plant extends Agent
{
    private String name = "PLANT";

    public Plant(int x, int y) {
        super(x, y, new Immovable() {}, new NonHunter() {});
    }


    public String getName() {return name;}

}
