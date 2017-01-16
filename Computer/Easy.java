package Computer;
import main.Main;
public class Easy {
	private Main father;
	private final int min = 1;
	private final int max = 3;
	public Easy(Main father) {
		this.father = father;
	}
	private String Computer() {
		java.util.Random random = new java.util.Random();
		final int number = random.nextInt(max)%(max-min+1)+min;
		switch(number) {
		case 1:return "forfex";
		case 2:return "stone";
		case 3:return "cloth";
		default:return null;
		}
	}
	public void setcomputer() {
		String computer = this.Computer(); 
		father.data.setComputer(computer);
	}
}