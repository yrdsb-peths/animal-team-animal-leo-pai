import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TiTitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TiTitleScreen extends World
{
    Label titleLabel = new Label("The Elephant", 70);
    /**
     * Constructor for objects of class TiTitleScreen.
     * 
     */
    public TiTitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        GreenfootImage bg = new GreenfootImage("resized.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        addObject(titleLabel, 220, 80);
        prepare();
    }

    /**
     * The main world act loop
     */
    public void act()
    {
        //Start the game if user presses the space bar
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Elephant elephant = new Elephant();
        addObject(elephant,495,130);
        Label label = new Label("Press  <space> to Start", 40);
        addObject(label,312,310);
        Label label2 = new Label("Use \u2190 and \u2192 to Move", 40);
        addObject(label2,309,240);
    }
}
