package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.AVLTree;
import models.NodeAVL;

public class WindowTree extends JFrame{

	private static final long serialVersionUID = 1L;
	private NodeAVL root;
	private AVLTree tree;
	private JPanel panel;
	private JLabel jlMetod;

	public WindowTree(ActionListener listener) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);

		panel = new JPanel();
		panel.setLayout(new GridLayout(1,3));
		
		JButton btnAdd = new JButton("Agregar");
		btnAdd.addActionListener(listener);
		btnAdd.setActionCommand("ADD");
		
		JButton btnBalance = new JButton("Balance");
		btnBalance.addActionListener(listener);
		btnBalance.setActionCommand("BAL");
		
				
		jlMetod = new JLabel();
		jlMetod.setBorder(BorderFactory.createTitledBorder("Metodo de Balanceo Utilizado: "));
		
		panel.add(btnBalance);
		panel.add(btnAdd);
		panel.add(jlMetod);
		
		add(panel,BorderLayout.PAGE_END);
		
		setVisible(true);
	}
	
	public void setLabel(String metod) {
		jlMetod.setText(metod);
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
			g.setColor(Color.RED);
			g.drawString(String.valueOf(node.getTam()), x + width , height);
			g.setColor(Color.BLACK);
			addNode(node.getLeft(), x + width, -1 * (Math.abs(width) / 2), height + 100, g);
			addNode(node.getRight(), x + width, (Math.abs(width) / 2), height + 100, g);
		}
	}
}