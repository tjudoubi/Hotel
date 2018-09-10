package Hotel;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JPanel;


public class manage {
	public static float[] money = {100,180,120,220,240};
	static Scanner scan=new Scanner(System.in);
	private static  Floor[] flloor = new Floor[5];
	private static  User user = new User();
	
	public static void main(String[] args) throws ParseException {
		init();
		int i = 1;
		while(i!= 1000){
			
//			Scann(user);
			Rand(user);
			match_rooms(user);
			
			print();
			
			i++;
			System.out.println();
		}
		
		
		int a = 0;
		float total = 0;
		for(int i2 = 0; i2 < flloor.length;i2++){
			for(int j = 0;j < flloor[i2].room.length;j++){
				a += flloor[i2].room[j].list.size();
				for(int k = 0; k < flloor[i2].room[j].list.size();k++){
					Inform mm = flloor[i2].room[j].list.get(k);
					total += count_total(mm);
				}
			}
		}
		System.out.println(a);
		System.out.println(" total: "+total);
		
		for(int month = 8;month < 9;month++){
			for(int day = 1;day < 31;day++){
				String s = "2018-";
				if(month < 10){
					s = s+"0"+month+"-";
				}else{
					s = s+month+"-";
				}
				if(day < 10){
					s = s+"0"+day;
				}else{
					s = s+day;
				}
				System.out.println(s);
				statistics(s);
				System.out.println();
				
			}
		}
	
	}
	
	private static float count_total(Inform inform) throws ParseException{
		 SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
		String begin = inform.begin_date;
		String end = inform.end_date;
		long m = sdf.parse(end).getTime() - sdf.parse(begin).getTime();
		long days =  m / (1000 * 60 * 60 * 24);
		return days*inform.money;
	}
	
	private static void statistics(String s) {
		// TODO Auto-generated method stub
		for(int i = 0;i < flloor.length;i++){
			Floor floor = flloor[i];
			for(int j = 0;j < floor.room.length;j++){
				Room room = floor.room[j];
				int a = check(room,s);
				if(a == 1){
					System.out.println(""+(i+1)+room.num+":空房");
				}else if(a == 2){
					System.out.println(""+(i+1)+room.num+":住人");
				}else if(a == 3){
					System.out.println(""+(i+1)+room.num+":脏房");
				}
			}
		}
	}

	private static int check(Room room, String s) {
		// TODO Auto-generated method stub
		for(int i = 0;i < room.list.size();i++){
			Inform inform = room.list.get(i);
			if(inform.end_date.equals(s)&&(inform.stay_in == 0||inform.stay_in == 3)){
				return 3;
			}else if((inform.begin_date.compareTo(s)<=0&&inform.end_date.compareTo(s)>=0)||
					(inform.end_date.equals(s)&&(inform.stay_in == 1||inform.stay_in == 2))){
				return 2;
			}
		}
		return 1;
	}


	
	private static void Rand(User u) {
		// TODO Auto-generated method stub
		Random random = new Random();
		u.level = random.nextInt(5);
		

		u.floor = random.nextInt(5);
		

		u.sex = random.nextInt(2);
		

		u.vip = random.nextInt(2);

		if(u.level == 0||u.level == 2){
			u.number = 1;
		}else if(u.level == 1||u.level == 3){
			u.number = random.nextInt(2)+1;
		}else if(u.level == 4){
			u.number = random.nextInt(3)+1;
		}
		

		if(u.number == 1){
			u.together = random.nextInt(2);
		}else{
			u.together = 0;
		}
		
		String in = "2018-0";
		int a = random.nextInt(2)+8;
		in = in+a+"-";
		int b = random.nextInt(30)+1;
		if(b < 10){
			in = in+"0"+b;
		}else{
			in = in + b;
		}
		u.in = in;
		
		
		String out = "2018-";
		int a_1 = 0;
		while(a_1 < a){
			a_1 = random.nextInt(2)+8;
		}
		if(a_1 < 10){
			out  = out+"0"+a_1+"-";
		}else{
			out = out+a_1+"-";
		}
		int b_l = 0;
		if(a_1 == a&&b!=30){
			while(b_l <= b){
				b_l = random.nextInt(30)+1;
			}
		}else{
			
			b_l = random.nextInt(30)+1;
		}
		if(b_l < 10){
			out = out+"0"+b_l;
		}else{
			out = out + b_l;
		}
		u.out = out;
		//System.out.println(u.in + " " + u.out);
	}

	private static void init() {
		// TODO Auto-generated method stub
		for(int i = 0;i < flloor.length;i++){
			flloor[i] = new Floor();
		}
	}

	private static void Scann(User u) {
		System.out.print("level:");
		u.level = scan.nextInt();
		
		System.out.print("Floor:");
		u.floor = scan.nextInt();
		u.floor -= 1;
		
		System.out.print("sex:");
		u.sex = scan.nextInt();
		
		System.out.print("vip:");
		u.vip = scan.nextInt();
		
		System.out.print("in:");
		u.in = scan.next();
		
		System.out.print("out:");
		u.out = scan.next();
		
		System.out.print("together:");
		u.together = scan.nextInt();
		
		System.out.print("number:");
		u.number = scan.nextInt();
		// TODO Auto-generated method stub
		
	}
	
	public static void print() {
		// TODO Auto-generated method stub
		for(int i = 0;i < flloor.length;i++){
			for(int j = 0;j < flloor[i].room.length;j++){
				System.out.println(""+(i+1)+flloor[i].room[j].num+":");
				for(int k = 0;k < flloor[i].room[j].list.size();k++){
					Inform in = flloor[i].room[j].list.get(k);
					System.out.println("begin_date:" + in.begin_date + " end_date:"+in.end_date+ " status:"+in.status+" stay_in:"+in.stay_in+" money:"+in.money+ " sex:"+in.sex+" people_num:"+in.people_num);
				}
				System.out.println();
			}
		}
	}
	
	private static void add_in(User u, int f, int index_2, Inform inform,int rem) {
		//flloor[f].room[index_2].list.remove(rem);
		Float price = flloor[f].room[index_2].price;
		String o_bdate = inform.begin_date;
		String o_edate = inform.end_date;
		String bdate = u.in;
		String edate = u.out;
		Inform inform_2 = new Inform();
		inform_2.begin_date = bdate;
		inform_2.end_date = edate;
		inform_2.sex = u.sex;
		inform_2.people_num = inform.people_num+1;
		inform_2.status = u.together;
		if(u.vip == 1){
			inform_2.money = (float) (price*0.8);
		}else{
			inform_2.money = price;
		}
		if(o_bdate.equals(bdate)&&o_edate.equals(edate)){
			inform_2.stay_in = 3;
			flloor[f].room[index_2].list.remove(rem);
			flloor[f].room[index_2].list.add(inform_2);
		}else if(o_bdate.compareTo(bdate)<0&&o_edate.compareTo(edate)>0){
			Inform inform_temp = new Inform();
			copy(inform_temp,flloor[f].room[index_2].list.get(rem));
			flloor[f].room[index_2].list.get(rem).end_date = bdate;
			flloor[f].room[index_2].list.get(rem).stay_in = 2;
			inform_temp.begin_date = edate;
			inform_2.stay_in = 1;
			flloor[f].room[index_2].list.add(inform_2);
			flloor[f].room[index_2].list.add(inform_temp);
		}else if(o_bdate.compareTo(bdate)<0&&o_edate.equals(edate)){
			inform_2.stay_in = 3;
			flloor[f].room[index_2].list.get(rem).end_date = bdate;
			flloor[f].room[index_2].list.get(rem).stay_in = 2;
			flloor[f].room[index_2].list.add(inform_2);
		}else if(o_bdate.equals(bdate)&&o_edate.compareTo(edate)>0){
			inform_2.stay_in = 1;
			flloor[f].room[index_2].list.get(rem).begin_date = bdate;
			flloor[f].room[index_2].list.get(rem).stay_in = 0;
			flloor[f].room[index_2].list.add(inform_2);
		}
		
		
	}
	
	
	private static void copy(Inform inform,Inform copy) {
		// TODO Auto-generated method stub
		inform.begin_date = copy.begin_date;
		inform.end_date = copy.end_date;
		inform.status = copy.status;
		inform.stay_in = copy.stay_in;
		inform.money = copy.money;
		inform.sex = copy.sex;
		inform.people_num = copy.people_num;
	}

	private static void match_rooms(User u) {
		// TODO Auto-generated method stub
		int f = u.floor;int flag = 0;
		int index = 0;
		for(int i = 0; i < 20;i++){
			
//			System.out.println("x"+i+":"+flloor[f].room[i].list.size());
			Room r = flloor[f].room[i];
			if(r.level == u.level){
				flag = 1;
				for(int j = 0;j < r.list.size();j++){
					Inform inform = r.list.get(j);
					
					if(!(u.in.compareTo(inform.end_date)>0||u.out.compareTo(inform.begin_date)<0)){
						flag = 0;
						break;
					}
					if(j+1 == r.list.size()){
						index = i;
//						System.out.println("o_index:"+index);
						break;
					}
				}
			}
			if(flag == 1){
				index = i;
				break;
			}
		}
		
		
		
		if(flag == 1){
			//System.out.println("index:"+index);
			Inform inform_2 = new Inform();
			inform_2.begin_date = u.in;
			inform_2.end_date = u.out;
			inform_2.people_num = u.number;
			inform_2.sex = u.sex;
			inform_2.status = u.together;
			inform_2.stay_in = 0;
			if(u.vip == 1){
				inform_2.money = (float) (money[u.level]*0.8);
			}else{
				inform_2.money = (float) (money[u.level]);
			}
			flloor[f].room[index].list.add(inform_2);
		}else{
			if(u.together == 1&&u.number == 1){
				//System.out.println("together");
				int index_2;flag = 2;
				for(index_2 = 0; index_2 < 20;index_2++){
					Room r = flloor[f].room[index_2];
					if(r.level == u.level){
						flag = 1;
						for(int j = 0;j < r.list.size();j++){
							Inform inform = r.list.get(j);
							if(u.in.compareTo(inform.begin_date)>=0&&u.out.compareTo(inform.end_date)<=0&&
									inform.sex == u.sex && inform.status == 1 &&inform.stay_in < r.up){
								//System.out.println("ok");
								flag = 0;
								add_in(u,f,index_2,inform,j);
								break;
							}
						}/////for j
						if(flag == 0){
							break;
						}
						
					}/////if(r.level == u.level).
				}//////for index
			}
			
			
		}////else
		
	}

}
