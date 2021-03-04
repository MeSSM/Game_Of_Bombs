import greenfoot.*;
import java.util.List;

public class Player2 extends Player
{
    public Player2()
    {
      Lives=3;
      BombsCanPlace=1;
    }
    public void act()
    {
      List BombsInWorld = getWorld().getObjects(Bomb2.class);
      checkMovements("w","s","d","a");
      if(BombsInWorld.size() != BombsCanPlace)
      {
        placeBombs();
      }
      checkCollisionWithFire();
      dead();
    }
    public void placeBombs()
    {
      if(Greenfoot.isKeyDown("space"))
      {
        getWorld().addObject(new Bomb2(),this.getX(),this.getY());
      }
    }
}
