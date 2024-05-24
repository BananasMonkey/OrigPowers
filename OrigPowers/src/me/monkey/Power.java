package me.monkey;

public class Power implements PowerInterface {
	private String powerName;

	public Power(Object ob) {
	}

	public void setName(String name) {
		powerName = name;
	}

	@Override
	public String getName() {
		return powerName;
	}

	@Override
	public void setSwapHandAction() {
		
	}

}
