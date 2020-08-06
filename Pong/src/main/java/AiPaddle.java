import java.awt.*;

public class AiPaddle implements Paddle {
    double y,yVEl;
    boolean upAccel,downAccel;
    int x,player;
    final double GRAVITY=0.94;
    Ball b;

    public AiPaddle(int player,Ball B) {
        this.player = player;
        upAccel=false;
        downAccel=false;
        b=B;
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
        y=b.getY()-40;

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



    public int getY() {
        return (int)y;
    }
}

