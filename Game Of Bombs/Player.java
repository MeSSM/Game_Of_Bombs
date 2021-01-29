import greenfoot.*;
import java.util.List;

public class Player extends Actor
{
    private int lives = 3 ;
    private int BombsCanPlace = 1;
    private boolean AlreadyTouchedBomb = true ;
    public void act()
    {
      List BombsInWorld = getWorld().getObjects(Bomb.class);
      checkMovements();
      if(BombsInWorld.size() != BombsCanPlace)
      {
        placeBombs();
      }
      checkCollisionWithFire();
      dead();
    }

    //Simple movements of the player
    public void checkMovements()
    {
      int x=getX();
      int y=getY();
      if(Greenfoot.isKeyDown("up"))
      {
        setImage("Gback.png");
        if(checkCollisions(0,-1,Solid.class))//check collisions with world's border
        {
          move(0);
        }
        else
        {
          setLocation(x,y-1);
          
        }
      }
      else if(Greenfoot.isKeyDown("down"))
      {
          setImage("Gfront.png");
        if(checkCollisions(0,1,Solid.class))
        {
          move(0);
        }
        else
        {
          setLocation(x,y+1);
        }
      }
      else if(Greenfoot.isKeyDown("right"))
      {
        setImage("Gright.png");
        if(checkCollisions(1,0,Solid.class))
        {
          move(0);
        }
        else
        {
          setLocation(x+1,y);
        }
      }
      else if(Greenfoot.isKeyDown("left"))
      {
        setImage("Gleft.png");
        if(checkCollisions(-1,0,Solid.class))
        {
          move(0);
        }
        else
        {
          setLocation(x-1,y);
        }
      }
    }

    //check collision with other objects of any class
    public boolean checkCollisions(int x,int y,Class cls)
    {
      Actor actor = getOneObjectAtOffset(x,y,cls);
      return actor != null; //return true if actor!=null (when using it in a condition write if(checkCollisions(x,y,cls))
    }

    public void placeBombs()
    {
      if(Greenfoot.isKeyDown("space"))
      {
        getWorld().addObject(new Bomb(),this.getX(),this.getY());
      }
    }

    //method for checking collisions with fire and reducing player's live by one
    public void checkCollisionWithFire()
    {
      if(checkCollisions(0,0,Fire.class) && AlreadyTouchedBomb)
      {
        if(lives != 0)
        {
          lives--;
        }
        AlreadyTouchedBomb = false;
      }
      else if(!checkCollisions(0,0,Fire.class))
      {
        AlreadyTouchedBomb = true ;
      }
    }

    //method called when player lives reached zero and die
    public void dead()
    {
      if(lives == 0)
      {
        MainWorld NewWorld = new MainWorld();
        Greenfoot.setWorld(NewWorld);
        Greenfoot.stop();
      }
    }
}
