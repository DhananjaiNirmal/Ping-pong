import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Pong extends Applet implements Runnable, KeyListener {
    final int WIDTH=700,HIEGHT=500;
    Thread thread;
    HumanPaddle p1;
    AiPaddle p2;
    Ball b;
    boolean gameStarted;
    Graphics gfx;
    Image img;

    @Override
    public void init() {
        this.resize(WIDTH,HIEGHT);
        addKeyListener(this);

        img=createImage(WIDTH,HIEGHT);
        gfx=img.getGraphics();
        gameStarted=false;
        p1=new HumanPaddle(1);
        b= new Ball();
        p2=new AiPaddle(2,b);
        Thread thread =new Thread((this));
        thread.start();
    }

    @Override
    public void paint(Graphics g) {
        gfx.setColor(Color.black);
        gfx.fillRect(0,0,WIDTH,HIEGHT);
        if(b.getX()<-10 || b.getX()>710)
        {
            gfx.setColor(Color.red);
            gfx.drawString("GAME OVER",350,250);
        }
        else {
            p1.draw(gfx);
            b.draw(gfx);
            p2.draw(gfx);
        }
        if(!gameStarted)
        {
            gfx.setColor(Color.white);
            gfx.drawString("Ping-Pong",330,100);
            gfx.drawString("Press Enter to Start...",330,130);
        }
        g.drawImage(img,0,0,this);
    }

    public void update(Graphics g)
    {
        paint(g);
    }

    public void run() {
        for(;;)
        {
            if(gameStarted) {
                p1.move();
                b.move();
                p2.move();
                b.checkPaddlePosition(p1, p2);
                repaint();
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode()==KeyEvent.VK_UP)
        {
            p1.setUpAccel(true);

        }
        else if (e.getKeyCode()==KeyEvent.VK_DOWN)
        {
            p1.setDownAccel(true);
        }
        else if(e.getKeyCode()==KeyEvent.VK_ENTER)
        {
            gameStarted=true;
        }

    }

    public void keyReleased(KeyEvent e) {


        if(e.getKeyCode()==KeyEvent.VK_UP)
        {
           p1.setUpAccel(false);
        }
        else if (e.getKeyCode()==KeyEvent.VK_DOWN)
        {
            p1.setDownAccel(false);
        }

    }
}
