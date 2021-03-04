import greenfoot.*;
import java.util.List;

public class Player1 extends Player
{
    public Player1()
    {
      Lives=3;
      BombsCanPlace=1;
    }
    public void act()
    {
      List BombsInWorld = getWorld().getObjects(Bomb1.class);
      checkMovements("up","down","right","left");
      if(BombsInWorld.size() != BombsCanPlace)
      {
        placeBombs();
      }
      checkCollisionWithFire();
      dead();
    }
    public void placeBombs()
    {
      if(Greenfoot.isKeyDown("l"))
      {
        getWorld().addObject(new Bomb1(),this.getX(),this.getY());
      }
    }
}
