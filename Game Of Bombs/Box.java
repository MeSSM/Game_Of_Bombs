import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Box here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Box extends Solid
{
  public boolean checkCollisions(int x,int y,Class cls)
    {
      Actor actor = getOneObjectAtOffset(x,y,cls);
      return actor != null; //return true if actor!=null (when using it in a condition write if(checkCollisions(x,y,cls))
    }
    public void act()
    {
      if(checkCollisions(0,0,Fire.class))
      {
        getWorld().removeObject(this);
      }
    }
}
