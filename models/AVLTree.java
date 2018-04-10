package models;

public class AVLTree {

	private NodeAVL root;
	private String metod;

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
		if (height(root.getLeft()) - height(root.getRight()) == 2) {
			if (root.getLeft() != null) {
				if (root.getLeft().getLeft() != null) {
					rotationDoubleLeft();
					
					

				} else {
					rotationSimpleLeft();
				}

			}
		} else if (height(root.getLeft()) - height(root.getRight()) == -2) {
			if (root.getRight() != null) {
				if (root.getRight().getRight() != null) {
					rotationDoubleRight();

				} else {
					rotationSimpleRight();
				}
			}
		}
	}

	private void rotationDoubleRight() {
		System.out.println("Derecha");
		NodeAVL aux = root.getRight();
		root.setRight(aux.getRight());
		aux.setLeft(root);
		root = aux;
		root.getLeft().setRight(null);
		setMetod("Rotacion Doble ala Izquierda");
		root.getLeft().setTam(0);
		root.setTam(0);
	}

	private void rotationSimpleLeft() {
		NodeAVL aux = root.getLeft().getRight();
		root.getLeft().setRight(null);
		aux.setRight(root);
		aux.setLeft(root.getLeft());
		root = aux;
		root.getRight().setLeft(null);
		setMetod("Rotacion Derecha -Izquierda");
		root.getLeft().setTam(0);
		root.getRight().setTam(0);
	}

	private void rotationSimpleRight() {
		NodeAVL aux = root.getRight().getLeft();
		root.getRight().setLeft(null);
		aux.setLeft(root);
		aux.setRight(root.getRight());
		root = aux;
		root.getLeft().setRight(null);
		setMetod("Rotacion Izquierda - Derecha");
		root.getLeft().setTam(0);
		root.getRight().setTam(0);
	}

	private void rotationDoubleLeft() {
		System.out.println("Izquierda");
		NodeAVL aux = root.getLeft();
		root.setLeft(aux.getLeft());
		aux.setRight(root);
		root = aux;
		root.getRight().setLeft(null);
		setMetod("Rotacion Doble a la Derecha");
		root.setTam(0);
		root.getRight().setTam(0);
	}

	private int height(NodeAVL node) {
		return (node == null) ? -1 : node.getTam();
	}

	public String getMetod() {
		return metod;
	}

	public void setMetod(String metod) {
		this.metod = metod;
	}

	public NodeAVL getRoot() {
		return root;
	}

}
