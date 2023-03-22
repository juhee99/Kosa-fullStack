package day9.tv;

public class TV {
	private String model;
	private int size;
	private int channel;
	
	public TV() {}
	
	public TV(String model, int size, int channel) {
		this.model = model;
		setSize(size);
		setChannel(channel);
	}
	
	public void channelUp() {
		if(channel > 10) 
			setChannel(1);
		else channel++; 
	}
	
	public void channelDown() {
		if(channel < 1) 
			setChannel(10);
		else channel--;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
		if(size < 0)  this.size=0;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
		if(channel < 0 ) this.channel = 0;
	}

}
