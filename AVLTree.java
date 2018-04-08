package models;

public class AVLTree {

	private NodeAVL root;

	public void add(NodeAVL node) {
		if (root != null) {
			add(root, node);
		} else {
			root = node;
		}
	}

	private void add(NodeAVL base, NodeAVL newNode) {
		if (newNode.getInfo() < base.getInfo()) {
			if (base.getLeft() != null) {
				add(base.getLeft(), newNode);
				base.setTam(1 + base.getTam());
			} else {
				base.setLeft(newNode);
				base.setTam(1 + base.getTam());
			}
		} else {
			if (base.getRight() != null) {
				add(base.getRight(), newNode);
				base.setTam(1 + base.getTam());
			} else {
				base.setRight(newNode);
				base.setTam(1 + base.getTam());
			}
		}
	}

	public void balance() {
		int tamValue = height(root.getLeft()) - height(root.getRight());
		System.out.println("Tamaño: " + tamValue);
		if (height(root.getLeft()) - height(root.getRight()) == 2
				|| height(root.getLeft()) - height(root.getRight()) == -2) {
			if (root.getLeft() != null) {
				System.out.println("Izquierda");
				NodeAVL aux = root.getLeft();
				root.setLeft(aux.getLeft());
				aux.setRight(root);
				root = aux;
				root.setRight(aux.getRight());

			} else {
				System.out.println("Derecha");
				NodeAVL aux = root.getRight();
				root.setRight(aux.getRight());
				aux.setLeft(root);
				root = aux;
				root.setLeft(aux.getLeft());
			}
			{

			}
		}
	}

	private int height(NodeAVL node) {
		return (node == null) ? -1 : node.getTam();
	}
	//
	// private int max(int heightLeft, int heightRight) {
	// return heightLeft > heightRight ? heightLeft : heightRight;
	// }

	public NodeAVL getRoot() {
		return root;
	}

}
