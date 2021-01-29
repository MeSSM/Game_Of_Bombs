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
  public void act()
  {
    if(++ExplodeTime == 10*1.5)
    {
      getWorld().addObject(new Fire(),this.getX(),this.getY());
      getWorld().removeObject(this);
    }
  }
}
