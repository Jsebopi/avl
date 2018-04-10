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
		window = new WindowTree(this);

	}

	public static void main(String[] args) {
		new Controller();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("ADD")) {
			tree.add(new NodeAVL(Integer.valueOf(JOptionPane.showInputDialog("id"))));
		}else {
			tree.balance();
			window.setLabel(tree.getMetod());
		}
		window.paintTree(tree.getRoot());
	}
}