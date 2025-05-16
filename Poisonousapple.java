import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Poisonousapple here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Poisonousapple extends Actor
{
    int speed = 1;
    
    public Poisonousapple()
    {
        GreenfootImage image = new GreenfootImage("apple.png");
        image.scale(40, 40);
        setImage(image);
    }
    
    public void act()
    {
        int x = getX();
        int y = getY() + speed;
        setLocation(x, y);
        
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight())
        {
            world.gameOver();
            world.removeObject(this);
        }
    }
    
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
