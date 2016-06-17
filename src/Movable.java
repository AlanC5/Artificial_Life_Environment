/**
 * Created by Alan on 4/22/16.
 */
public interface Movable extends MoveState
{
    void move(Agent[][] earth, int i, int j);
}
