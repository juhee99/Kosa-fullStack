package day9.tv;

public class RentalTV extends TV implements Rentable {
	private int price;
	
	public RentalTV() {}
	
	public RentalTV(int price, String model, int size, int channel) {
		super(model, size, channel);
		setPrice(price);
	}
	
	public void play() {
		System.out.printf("대여 TV 채널 %d번의 프로를 플레이 합니다.\n", getChannel());
	}
	

	public void rent() {
		System.out.printf("%s 모델의 상품을 대여합니다. %,d 을 지불해 주세요.\n", getModel(), getPrice());
	}
	
	public String toString() {
		return String.format("대여상품정보 : 모델명(%s), 가격(%,d), 크기(%d)", getModel(), getPrice(), getSize());
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
		if(price < 0) this.price = 0;
	}
}
