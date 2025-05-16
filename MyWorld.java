import greenfoot.*;

public class MyWorld extends World {
    public int score = 0;
    Label scoreLabel;
    int level = 1;
    boolean gameOver = false;
    Elephant elephant;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        GreenfootImage bg = new GreenfootImage("PrideLands.jpg");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        
        //Create the elephant object
        elephant = new Elephant();
        addObject(elephant, 300, 300);
        
        //Create a label
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
        
        createApple();
    }
    
    /**
     * End the game and draw 'GameOver'
     */
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
    
    /**
     * Inscrease score
     */
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        
        if(score % 5 == 0)
        {
            level += 1;
        }
         if(score == 10)
        {
            DarkWorld darkWorld = new DarkWorld(score, getElephant());
            Greenfoot.setWorld(darkWorld);
        }
    }
    /**
     * Create a new apple at random location at top of screen
     */
    public void createApple()
    {
        Apple apple = new Apple();
        apple.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);
    }
    
    public Elephant getElephant(){
        return elephant;
    }
}
