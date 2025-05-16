import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DarkWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DarkWorld extends World
{
    private int score;
    private int level = 1;
    private Elephant elephant;
    Label scoreLabel;
    /**
     * Constructor for objects of class DarkWorld.
     * 
     */
    public DarkWorld(int score, Elephant elephant)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        this.score = score;
        this.elephant = elephant;
        
        GreenfootImage bg = new GreenfootImage("darkworld.jpg");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        
        addObject(elephant, 300, 300);
        
        scoreLabel = new Label(score, 80);
        addObject(scoreLabel, 50, 50);
        
        Label newLabel = new Label("Next Level", 40);
        addObject(newLabel, 300, 50);
        
        createApple();
    }
    
    public void increaseScore(){
        score++;
        scoreLabel.setValue(score);
    }
    
    public void createApple()
    {
        Apple apple = new Apple();
        apple.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);
    }
}
