package models;

public class NodeAVL {
	private NodeAVL left;
	private NodeAVL right;
	private int info;
	private int tam;

	public NodeAVL(int info) {
		this.info = info;
		tam = 0;
	}

	public NodeAVL getLeft() {
		return left;
	}

	public void setLeft(NodeAVL left) {
		this.left = left;
	}

	public NodeAVL getRight() {
		return right;
	}

	public void setRight(NodeAVL right) {
		this.right = right;
	}

	public int getInfo() {
		return info;
	}

	public void setInfo(int info) {
		this.info = info;
	}

	public int getTam() {
		return tam;
	}

	public void setTam(int tam) {
		this.tam = tam;
	}

	@Override
	public String toString() {
		return String.valueOf(info);
	}

}
