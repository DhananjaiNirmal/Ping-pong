import java.awt.*;

public class HumanPaddle implements Paddle {
    double y,yVEl;
    boolean upAccel,downAccel;
    int x,player;
    final double GRAVITY=0.94;

    public HumanPaddle(int player) {
        this.player = player;
        upAccel=false;
        downAccel=false;
        yVEl=0;
        y=210;

        if(player == 1)
        {
            x=20;
        }
        else{
            x=660;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.cyan);
        g.fillRect(x,(int)y,20,80);

    }

    public void move() {
        if(upAccel)
        {
            yVEl -= 2;
        }
        else if(downAccel)
        {
            yVEl += 2;
        }
        else if(!upAccel && !downAccel)
        {
            yVEl *= GRAVITY;
        }
        if(yVEl>=5)
        {
            yVEl=5;
        }
        else if(yVEl<=-5)
        {
            yVEl=-5;
        }
        y +=yVEl;
        if(y<=0)
        {
            y=0;
        }
        else if(y>=420)
        {
            y=420;
        }

    }

    public void setUpAccel(boolean input)
    {
        upAccel=input;
    }

    public void setDownAccel(boolean input)
    {
        downAccel=input;
    }

    public int getY() {
        return (int)y;
    }
}
