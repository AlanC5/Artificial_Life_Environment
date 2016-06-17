/**
 * Created by Alan on 4/24/16.
 */
public interface Hunter extends HuntState
{
    void hunt(Agent[][] earth, int i, int j);
}
