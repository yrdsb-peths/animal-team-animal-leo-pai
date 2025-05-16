import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Poisonousapple here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Poisonousapple extends Actor
{
    int spee = 2;
    
    public Poisonousapple()
    {
        GreenfootImage image = new GreenfootImage("Poisonousapple.png");
        image.scale(40, 40);
        setImage(image);
    }
    
    public void act()
    {
        int x = getX();
        int y = getY() + spee;
        setLocation(x, y);
        
        World world = getWorld();
        if ((world instanceof MyWorld && ((MyWorld) world).isGameOver()) || (world instanceof DarkWorld && ((DarkWorld) world).isGameOver())) {
            return;
        }
        if(getY() >= world.getHeight()-1)
        {
            world.removeObject(this);
            if(world instanceof DarkWorld)
            {
                ((DarkWorld) world).createPoisonousapple();
            }
        }
    }
    
    public void setSpee(int spdd)
    {
        spee = 2 * spdd;
    }
}
