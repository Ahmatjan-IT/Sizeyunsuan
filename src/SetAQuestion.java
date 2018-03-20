import java.util.ArrayList;
import java.util.Random;
public class SetAQuestion {
	int n;
	int next,time;
	String topic;
	ArrayList<Topic> al;
	Topic question;
	ArithmeticResult ar;
	Random random;
	public SetAQuestion(int n,String path,String schoolNumber){
		this.n=n;
		init();
		setQuestion();
		new WriteToFile(path, al, n,schoolNumber);
	}
	
	
	public void init(){
		al=new ArrayList<Topic>();
		ar=new ArithmeticResult();
		random=new Random();
	}
	
	public void setQuestion(){
		//出题的数量
		int[] questionTopic;;
		int[] questionOprator;
		for(int i=0;i<n;i++){
			//出题的长度
			time=Time();
			questionTopic=new int[time];
			questionOprator=new int[time-1];
			for(int t=0;t<time;t++){
				questionTopic[t]=randomDigit();
				if(t<time-1){
					questionOprator[t]=oprator();
				}
			}
			topic="";
			for(int t=0;t<time;t++){
				topic=topic+questionTopic[t];
				if(t<time-1){
					topic=topic+getType(questionOprator[t]);
				}
			}
			topic=topic+"=";
			double a=ar.Result(topic);
			if(a<0||a%1!=0){
				i--;
				continue;
			}
			question=new Topic(topic,(int)a);
			al.add(question);
		}
	}
	
	String getType(int type){
		if(type==1){
			return "+";
		}else if(type==2){
			return "-";
		}else if(type==3){
			return "*";
		}else{
			return "/";
		}
	}
	
	boolean PQ(){
		int PQ=probabilityQuestion();
		if(PQ>=90 && PQ<=120){
			return true;
		}else{
			return false;
		}
	}
	
	//判断减法和乘法
	boolean judge(int type,int a,int b){
		if(type==2){
			if(a-b>0){
				return true;
			}else{
				return false;
			}
		}else{
			if(b!=0){
				if(a%b==0){
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		}

	}
	
	int oprator(){
		return random.nextInt(4)+1;
	}
	
	//3~5的随机数
	int Time(){
		return random.nextInt(3)+3;
	}
	
	//0~100 随机数
	int randomDigit(){
		return random.nextInt(100);
	}
	
	//产生随机数，让其20概率
	int probabilityQuestion(){
		return random.nextInt(200);
	}
	
}
