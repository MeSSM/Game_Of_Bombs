import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Point;

/**
 * Write a description of class Bomb here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bomb extends Block
{
  private int ExplodeTime;
  public boolean checkCollisions(int x,int y,Class cls)
  {
    Actor actor = getOneObjectAtOffset(x,y,cls);
    return actor != null; //return true if actor!=null (when using it in a condition write if(checkCollisions(x,y,cls))
  }
  public void act()
  {
    if(++ExplodeTime == 10*1.5)
    {
      getWorld().addObject(new Fire(),this.getX(),this.getY());
      for(int i=1;i<3;i++)
      {
        if(checkCollisions(i,0,Wall.class))
        {
          break;
        }
        else if(checkCollisions(i,0,Box.class))
        {
          Fire rightCornerPart = new Fire();
          rightCornerPart.setImage("right.png");
          getWorld().addObject(rightCornerPart,this.getX()+i,this.getY());
          break;
        }
        else
        {
          Fire rightMiddlePart = new Fire();
          if(checkCollisions(i+1,0,Wall.class) || i == 2)
          {
            rightMiddlePart.setImage("right.png");
          }
          else
          {
            rightMiddlePart.setImage("sides_h.png");
          }
          getWorld().addObject(rightMiddlePart,this.getX()+i,this.getY());
        }
      }
      for(int i=1;i<3;i++)
      {
        if(checkCollisions(-i,0,Wall.class))
        {
          break;
        }
        else if(checkCollisions(-i,0,Box.class))
        {
          Fire leftCornerPart = new Fire();
          leftCornerPart.setImage("left.png");
          getWorld().addObject(leftCornerPart,this.getX()-i,this.getY());
          break;
        }
        else
        {
          Fire leftMiddlePart = new Fire();
          if(checkCollisions(-(i+1),0,Wall.class) || i == 2)
          {
            leftMiddlePart.setImage("left.png");
          }
          else
          {
            leftMiddlePart.setImage("sides_h.png");
          }
          getWorld().addObject(leftMiddlePart,this.getX()-i,this.getY());
        }
      }
      for(int i=1;i<3;i++)
      {
        if(checkCollisions(0,i,Wall.class))
        {
          break;
        }
        else if(checkCollisions(0,i,Box.class))
        {
          Fire downCornerPart = new Fire();
          downCornerPart.setImage("down.png");
          getWorld().addObject(downCornerPart,this.getX(),this.getY()+i);
          break;
        }
        else
        {
          Fire downMiddlePart = new Fire();
          if(checkCollisions(0,i+1,Wall.class) || i == 2)
          {
            downMiddlePart.setImage("down.png");
          }
          else
          {
            downMiddlePart.setImage("sides_v.png");
          }
          getWorld().addObject(downMiddlePart,this.getX(),this.getY()+i);
        }
      }
      for(int i=1;i<3;i++)
      {
        if(checkCollisions(0,-i,Wall.class))
        {
          break;
        }
        else if(checkCollisions(0,-i,Box.class))
        {
          Fire upCornerPart = new Fire();
          upCornerPart.setImage("up.png");
          getWorld().addObject(upCornerPart,this.getX(),this.getY()-i);
          break;
        }
        else
        {
          Fire upMiddlePart = new Fire();
          if(checkCollisions(0,-(i+1),Wall.class) || i == 2)
          {
            upMiddlePart.setImage("up.png");
          }
          else
          {
            upMiddlePart.setImage("sides_v.png");
          }
          getWorld().addObject(upMiddlePart,this.getX(),this.getY()-i);
        }
      }
      getWorld().removeObject(this);
    }
  }
}
