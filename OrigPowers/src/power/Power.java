package power;

public class Power implements PowerInterface {
	private String powerName;
	private int cooldown;
	private static PowerMethodsInterface pm;
	public Power(Object ob, int Cooldown) {
		pm = (PowerMethodsInterface) ob;
		cooldown = Cooldown;
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

	@Override
	public int getCooldown() {
		// TODO Auto-generated method stub
		return cooldown;
	}

}
