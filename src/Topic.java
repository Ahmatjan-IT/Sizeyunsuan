
public class Topic {
	private int result;
	private String topic;
	public Topic(String topic,int result){
		this.topic=topic;
		this.result=result;
	}
	int getResult(){
		return result;
	}
	String getTopic(){
		return topic;
	}
}
