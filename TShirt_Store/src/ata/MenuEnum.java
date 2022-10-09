package ata;

public enum MenuEnum {

	EXIT(0),
	LIST(1),
	BUY(2),
	FIND(3),
	CART(4),
	COUT(5);
	
	public final int label;
	
	private MenuEnum(int label) {
		this.label = label;
	}
}
