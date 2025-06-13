package socket;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("localhost",8080);
//        InputStream stream=socket.getInputStream();
//        InputStreamReader reader=new InputStreamReader(stream);
//
//        char[] buffer=new char[10];
//        reader.read(buffer,0,10);
//        System.out.println(buffer);
        OutputStreamWriter writer=new OutputStreamWriter(socket.getOutputStream());

        Scanner scanner=new Scanner(System.in);
        while (true){
            String text=scanner.nextLine();
            if(text.length()==0) break;
            writer.write(text+'\n');
            writer.flush();
        }
        socket.close();
    }
}
