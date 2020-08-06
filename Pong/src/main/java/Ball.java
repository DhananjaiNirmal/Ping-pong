import java.awt.*;

public class Ball {
    double x,y,yVel,xVel;

    public Ball() {
        xVel=getRandomDirection()*getRandomSpeed();
        yVel=getRandomDirection()*getRandomSpeed();
        x=350;
        y=250;
    }

    public double getRandomSpeed()
    {
        return (Math.random()*3+2);
    }
    public int getRandomDirection()
    {
         int rand =(int)(Math.random()*2);
         if(rand==1) {
             return 1;
         }
         else{
             return -1;
         }
    }

    public void move()
    {
        x+=xVel;
        y+=yVel;
        if(y<10)
        {
            yVel=-yVel;
        }

        if(y>490)
        {
            yVel=-yVel;
        }
    }

    public void checkPaddlePosition(Paddle p1,Paddle p2)
    {
        if(x<50)
        {
            if(y> p1.getY() && y<p1.getY()+80)
            {
              xVel=-xVel;
            }

        }
        else if(x>650)
        {
            if(y> p2.getY() && y<p2.getY()+80)
            {
                xVel = -xVel;
            }
        }
    }

    public void draw(Graphics g)
    {
        g.setColor(Color.white);
        g.fillOval((int)x-10,(int)y-10,20,20);
    }

    public int getX()
    {
        return (int)x;
    }
    public int getY()
    {
        return (int)y;
    }
}
