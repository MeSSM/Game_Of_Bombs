import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fire here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Fire extends Actor
{
    private int FireDisappear;
    public void act()
    {
      if(++FireDisappear == 10*1.5)
      {
        getWorld().removeObject(this);
      }
    }
}
