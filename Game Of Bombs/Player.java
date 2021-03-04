import greenfoot.*;
import java.util.List;

abstract public class Player extends Actor
{
    protected int Lives;
    protected int BombsCanPlace;
    protected boolean AlreadyTouchedBomb = true ;


    //Simple movements of the player
    public void checkMovements(String UpKey,String DownKey,String RightKey,String LeftKey)
    {
      int x=getX();
      int y=getY();
      if(Greenfoot.isKeyDown(UpKey))
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
      else if(Greenfoot.isKeyDown(DownKey))
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
      else if(Greenfoot.isKeyDown(RightKey))
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
      else if(Greenfoot.isKeyDown(LeftKey))
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

    abstract public void placeBombs();

    //method for checking collisions with fire and reducing player's live by one
    public void checkCollisionWithFire()
    {
      if(checkCollisions(0,0,Fire.class) && AlreadyTouchedBomb)
      {
        if(Lives != 0)
        {
          Lives--;
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
      if(Lives == 0)
      {
        MainWorld NewWorld = new MainWorld();
        Greenfoot.setWorld(NewWorld);
        Greenfoot.stop();
      }
    }
}
