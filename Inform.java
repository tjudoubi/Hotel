package Hotel;

public class Inform {
	public String begin_date;
	public String end_date;
	public int status;///是否合住，合住为1
	public int stay_in;/////0为单人住，1为合住中，2为期间有人合住，3为一起合住到结束
	public float money;
	public int sex;
	public int people_num;
	public Inform(){
		begin_date = "";
		end_date = "";
	}
}
