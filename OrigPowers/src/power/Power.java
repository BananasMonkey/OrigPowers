package power;

public class Power implements PowerInterface {
	private String powerName;
	private static PowerMethodsInterface pm;
	public Power(Object ob) {
		pm = (PowerMethodsInterface) ob;
	}

	public void setName(String name) {
		powerName = name;
	}

	@Override
	public String getName() {
		return powerName;
	}
	
	public PowerMethodsInterface getPowerObject() {
		return pm;
	}

}
