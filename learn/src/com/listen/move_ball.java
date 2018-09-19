package com.listen;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/*控制小球在屏幕运动*/
public class move_ball extends JFrame{

	
	MPanel mp = null;
	public move_ball() {
		// TODO Auto-generated constructor stub
		mp = new MPanel();
		this.addKeyListener(mp);
		this.add(mp);
		this.addKeyListener(mp);
		
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		move_ball mb = new move_ball();
	}

}
class MPanel extends JPanel implements KeyListener{
	int x = 10,y = 10;
	public void paint(Graphics g) {
		super.paint(g);
		g.fillOval(x, y, 10, 10);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode() == KeyEvent.VK_DOWN) {
			y++;
			repaint();
		}
			
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
