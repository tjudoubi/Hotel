package Hotel;

import java.util.ArrayList;

public class Room {
	public String num;////1-5是 0 型，6-10是1型，11-14是2型，15-19是3型，20是4型
	public int level;
	public float price;
	public int up;
	public ArrayList<Inform> list = new ArrayList<Inform>();
	public Room(){
		num = "";
		list = new ArrayList<Inform>();
	}
}
