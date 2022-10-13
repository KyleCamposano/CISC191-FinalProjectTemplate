package edu.sdccd.cisc191.template;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Runs with ClientSocket2.java via terminal (java ServerSocket2.java).
 * This connects to a client socket and can receive file(s) sent by
 * the client. This reads smaller file size of the file(s) sent.
 */

// credits: https://heptadecane.medium.com/file-transfer-via-java-sockets-e8d4f30703a5

public class ServerSocket2 {
    private static DataOutputStream dataOutputStream = null;
    private static DataInputStream dataInputStream = null;

    // opens a listening socket for a client to connect with port # 5000
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(5000)){
            System.out.println("listening to port:5000");
            Socket clientSocket = serverSocket.accept();
            System.out.println(clientSocket + " connected.");
            dataInputStream = new DataInputStream(clientSocket.getInputStream());
            dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());

            /*
               receives the file to name it as ColorGameRequest and
               saves it in the current directory. To change name of
               received file, edit fileName.
             */
            receiveFile("ColorGameRequest");

            dataInputStream.close();
            dataOutputStream.close();
            clientSocket.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // reads the new file into output stream.
    private static void receiveFile(String fileName) throws Exception{
        int bytes;
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);

        // read file size
        long size = dataInputStream.readLong();
        byte[] buffer = new byte[4*1024];

        // read up to file size
        while (size > 0 && (bytes = dataInputStream.read(buffer, 0,
                (int)Math.min(buffer.length, size))) != -1) {
            fileOutputStream.write(buffer,0,bytes);
            size -= bytes;
        }

        fileOutputStream.close();
    }
}