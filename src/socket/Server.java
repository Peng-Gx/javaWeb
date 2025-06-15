package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(8080);
        while(true){
            System.out.println("waiting connection...");
            Socket socket=server.accept();
            Thread t=new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(socket.getInetAddress().getHostAddress());
                    try {
                        InputStreamReader reader=new InputStreamReader(socket.getInputStream());

                        while(true){
                            int i=reader.read();
                            if(i==-1) break;
                            System.out.print((char) i);
                        }

                        socket.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            t.start();
        }
    }
}
