package edu.sdccd.cisc191.template;

import java.io.*;
import java.net.Socket;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * Runs with ServerSocket2.java via terminal (java ClientSocket2.java).
 * This connects to a server socket and can send file(s) sent to the
 * server. This encloses smaller file sizes of the file(s) sent.
 */

// credits: https://heptadecane.medium.com/file-transfer-via-java-sockets-e8d4f30703a5

public class ClientSocket2 {
    private static DataOutputStream dataOutputStream = null;
    private static DataInputStream dataInputStream = null;

    // opens a socket to connect to the declared host name and port #
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost",5000)) {
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());

            /*
               gives the file path of ColorGame.java without having to
               explicitly declare the file path as seen from my device.
               To change file, edit file path.

               credits: https://stackoverflow.com/questions/4871051/
             */
            Path path = FileSystems.getDefault().getPath("ColorGame.java");
            sendFile(String.valueOf(path));

            dataInputStream.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // creates a new file with the given file path and allows input stream.
    private static void sendFile(String path) throws Exception{
        int bytes;

        File file = new File(path);
        FileInputStream fileInputStream = new FileInputStream(file);

        // send file size
        dataOutputStream.writeLong(file.length());

        // break file into smaller size
        byte[] buffer = new byte[4*1024];

        while ((bytes=fileInputStream.read(buffer))!=-1){
            dataOutputStream.write(buffer,0,bytes);
            dataOutputStream.flush();
        }

        fileInputStream.close();
    }
}