package Practice.Practice_19_20;

import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test {

     public void Client () {
        Scanner in=new Scanner(System.in);
        System.out.println("Your nickname : ");
        String name=in.nextLine();
        String message;
        while (true)
        {
            message = in.nextLine();
            try {
                this.sendMessage(name+" "+ message, "255.255.255.255", 14888);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMessage(String message, String address, int port) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        byte[] data = message.getBytes();
        DatagramPacket packet = new DatagramPacket(
                data, 0, data.length, InetAddress.getByName(address), port);
        socket.send(packet);

    }
    public void Server() throws IOException {
        DatagramSocket socket = new DatagramSocket(14888);
        byte[] buffer = new byte[2048];
        FileWriter writer = new FileWriter("history.txt",true);
        try {
            writer.write( "Conversation 1488\n" );
        } catch (IOException e) {
            System.out.println("Problems writing to file");
        } finally {
            writer.close();
        }
        DatagramPacket packet = new DatagramPacket(
                buffer, 0,
                buffer.length);
        while (true) {
            socket.receive(packet);

            String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
            String message = new String(buffer, 0, packet.getLength());
            System.out.println(date + " " + message);
            writer = new FileWriter("history.txt",true);
            try {
                writer.write(date + " " + message + "\n");
            } catch (IOException e) {
                System.out.println("Problems writing to file");
            } finally {
                writer.close();
            }
        }
    }
}
