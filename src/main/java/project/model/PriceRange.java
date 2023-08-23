package project.model;

public class PriceRange {
	private int id;
	private String priceRange;
	private int min;
	private int max;
	public PriceRange() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PriceRange(int id, String priceRange, int min, int max) {
		super();
		this.id = id;
		this.priceRange = priceRange;
		this.min = min;
		this.max = max;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPriceRange() {
		return priceRange;
	}
	public void setPriceRange(String priceRange) {
		this.priceRange = priceRange;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
}
