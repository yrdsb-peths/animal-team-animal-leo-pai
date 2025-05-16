import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

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
    Elephant elephant;
    Label scoreLabel;
    boolean gameOver = false;
    boolean havePApple = false;
    
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
        createPoisonousapple();
    }
    
    public void increaseScore(){
        score++;
        scoreLabel.setValue(score);
        
        if(score % 5 == 0)
        {
            level += 1;
        }
    }
    
    public void decreaseScore()
    {
        score--;
        scoreLabel.setValue(score);
        
        if(score % 5 == 0)
        {
            level -= 1;
        }
        if(score < 10)
        {
            List<Apple> apples = getObjects(Apple.class);
            for (Apple a : apples)
            {
                removeObject(a);
            }
            MyWorld myWorld = new MyWorld();
            Greenfoot.setWorld(myWorld);
        }
    }
    
    public void createApple()
    {
        Apple apple = new Apple();
        apple.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);
    }
    
    public void createPoisonousapple()
    {
        Poisonousapple poisonousapple = new Poisonousapple();
        poisonousapple.setSpee(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(poisonousapple, x, y);
    }
    
    public void gameOver()
    {
        gameOver = true;
        Label gameOverLabel = new Label("Game Over", 100);
        Label gameOverLabel1 = new Label("Press < space > restart game", 40);
        addObject(gameOverLabel, 300, 200);
        addObject(gameOverLabel1, 300, 300);
    }
    
    public void act()
    {
        if (gameOver)
        {
            if (Greenfoot.isKeyDown("space")) 
            {
                TiTitleScreen titleScreen = new TiTitleScreen(); 
                Greenfoot.setWorld(titleScreen);
            }
        }
    }
    
    public Elephant getElephant(){
        return elephant;
    }
    
    public int getScore()
    {
        return score;
    }
    
    public boolean isGameOver() {
        return gameOver;
    }
}
