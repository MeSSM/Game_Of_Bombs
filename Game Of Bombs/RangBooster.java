    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    import java.util.List;
    /**
     * Write a description of class RangBooster here.
     * 
     * @author (your name) 
     * @version (a version number or a date)
     */
    public class RangBooster extends Powers
    {
       
        public void act() 
        {
        Actor pow1 = getOneObjectAtOffset(0, 0,Player1.class);
        Actor pow2 = getOneObjectAtOffset(0, 0,Player2.class);
         if (pow1 != null){
            getWorld().removeObject(this);
            Bomb1.Range++;
        }
         else if (pow2 != null){
             getWorld().removeObject(this);
            Bomb2.Range++;
            }
        }
         
        
        
           

          
        
}
