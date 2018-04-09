package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import models.NodeAVL;

public class WindowTree extends JFrame{

	private static final long serialVersionUID = 1L;
	private NodeAVL root;

	public WindowTree(ActionListener listener) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		
		JButton btnAdd = new JButton("+");
		btnAdd.addActionListener(listener);
		btnAdd.setActionCommand("ADD");
		add(btnAdd, BorderLayout.PAGE_START);
		
		JButton btnBalance = new JButton("Balance");
		btnBalance.addActionListener(listener);
		btnBalance.setActionCommand("BAL");
		add(btnBalance, BorderLayout.PAGE_END);
		
		setVisible(true);
	}

	public void paintTree(NodeAVL root) {
		this.root = root;
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (root != null) {
			addNode(root, 0, getContentPane().getWidth() / 2, 50, g);
		}
	}

	public void addNode(NodeAVL node, int x, int width, int height, Graphics g) {
		if (node != null) {
			g.fillOval(x + width, height, 50, 50);
			g.setColor(Color.WHITE);
			g.drawString(node.toString(), x + width + 20, height + 30);
			g.setColor(Color.BLACK);
			addNode(node.getLeft(), x + width, -1 * (Math.abs(width) / 2), height + 100, g);
			addNode(node.getRight(), x + width, (Math.abs(width) / 2), height + 100, g);
		}
	}
}