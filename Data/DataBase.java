package Data;
public class DataBase {
	private String player = null;
	private String computer = null;
	public String setPlayer(String player) {
		this.player = player;
		return this.judgment();
	}
	public void setComputer(String computer) {
		this.computer = computer;
	}
	private String judgment() {
		if(player.equals("forfex")&&computer.equals("cloth")
				||player.equals("stone")&&computer.equals("forfex")
				||player.equals("cloth")&&computer.equals("stone"))
			return "Äú";
		else if(player.equals("forfex")&&computer.equals("stone")
				||player.equals("stone")&&computer.equals("cloth")
				||player.equals("cloth")&&computer.equals("forfex"))
			return "µçÄÔ";
		else return "Æ½¾Ö";
	}
}