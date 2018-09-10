package Hotel;

public class Floor {
	public Room[] room;
	public Floor(){
		room = new Room[20];
		for(int i = 0;i < room.length;i++){
			room[i] = new Room();
//			System.out.println(room[i].list.size());
		}
		for(int i = 1;i <= 20;i++){
			String s = "";
			if(i < 10){
				s = s+"0"+i;
			}else{
				s = s + i;
			}
			room[i-1].num = s;
			if(i <= 5){
				room[i-1].level = 0;
				room[i-1].up = 1;
				room[i-1].price = 100;
			}else if(i <= 10){
				room[i-1].level = 1;
				room[i-1].up = 2;
				room[i-1].price = 180;
			}else if(i <= 14){
				room[i-1].level = 2;
				room[i-1].up = 1;
				room[i-1].price = 120;
			}else if(i <= 19){
				room[i-1].level = 3;
				room[i-1].up = 2;
				room[i-1].price = 220;
			}else{
				room[i-1].level = 4;
				room[i-1].up = 3;
				room[i-1].price = 240;
			}
		}
	}
}
