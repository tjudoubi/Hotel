package Hotel;

import java.util.ArrayList;

public class Room {
	public String num;////1-5�� 0 �ͣ�6-10��1�ͣ�11-14��2�ͣ�15-19��3�ͣ�20��4��
	public int level;
	public float price;
	public int up;
	public ArrayList<Inform> list = new ArrayList<Inform>();
	public Room(){
		num = "";
		list = new ArrayList<Inform>();
	}
}
