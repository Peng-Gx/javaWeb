package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(8080);
        while(true){
            Socket socket=server.accept();
            System.out.println(socket.getInetAddress());
//        OutputStream stream=socket.getOutputStream();
//        OutputStreamWriter writer=new OutputStreamWriter(stream);
//        writer.write("hello world!");
//        writer.flush();
            InputStream stream=socket.getInputStream();
            InputStreamReader reader=new InputStreamReader(stream);

            while(true){
                int i=reader.read();
                if(i==-1) break;
                System.out.print((char) i);
            }
            socket.close();
        }
    }
}
