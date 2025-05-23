import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Apple here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Apple extends Actor
{
    int speed = 1;
    
    public Apple()
    {
        GreenfootImage image = new GreenfootImage("apple.png");
        image.scale(40, 40);
        setImage(image);
    }
    
    /**
     * Act - do whatever the Apple wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Apple falls downwards.
        int x = getX();
        int y = getY() + speed;
        setLocation(x, y);
        World world = getWorld();
        int currentScore = 0;
        if ((world instanceof MyWorld && ((MyWorld) world).isGameOver()) || (world instanceof DarkWorld && ((DarkWorld) world).isGameOver())) {
            return;
        }
        
        Poisonousapple p = (Poisonousapple) getOneIntersectingObject(Poisonousapple.class);
        if (p != null){
            getWorld().removeObject(this);
            return;
        }
        
        if(world instanceof MyWorld) {
            currentScore = ((MyWorld) world).getScore();
        } else if(world instanceof DarkWorld) {
            currentScore = ((DarkWorld) world).getScore();
        }
        // Remove apple and draw game over when apple gets to bottom
        if(getY() >= world.getHeight()-1)
        {
            if (currentScore < 10)
            {
                ((MyWorld) world).gameOver();
            }
            else
            {
                ((DarkWorld) world).gameOver();
            }
            world.removeObject(this);
        }
        
    }
    
    public void setSpeed(int spd)
    {
        speed = spd;
    }

}
