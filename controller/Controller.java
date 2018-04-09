package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import models.AVLTree;
import models.NodeAVL;
import views.WindowTree;

public class Controller implements ActionListener {

	private AVLTree tree;
	private WindowTree window;

	public Controller() {
		tree = new AVLTree();
		tree.add(new NodeAVL(10));
//		tree.add(new NodeAVL(7));
//		tree.add(new NodeAVL(5));
//		tree.add(new NodeAVL(1));
		tree.add(new NodeAVL(100));
		tree.add(new NodeAVL(200));
//		tree.add(new NodeAVL(90));

		window = new WindowTree(this);
		window.paintTree(tree.getRoot());
	}

	public static void main(String[] args) {
		new Controller();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("ADD")) {
			tree.add(new NodeAVL(Integer.valueOf(JOptionPane.showInputDialog("id"))));
		}else {
			System.out.println("Balance");
			tree.balance();
		}
		window.paintTree(tree.getRoot());
	}
}