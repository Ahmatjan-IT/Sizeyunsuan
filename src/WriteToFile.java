import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class WriteToFile {
	public WriteToFile(String path,ArrayList<Topic> al,int n,String schoolNumber){
		try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            bw.write(schoolNumber+"\n");
            bw.write(n+"\n");
            for(int i=0;i<al.size();i++){
            	al.get(i);
            	bw.write(al.get(i).getTopic()+al.get(i).getResult());
            	bw.write("\n");
            }
              
            bw.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
	}
}
