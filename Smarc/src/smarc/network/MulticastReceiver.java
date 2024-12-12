package network;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastReceiver implements Runnable {
    private MulticastSocket socket;
    private InetAddress group;
    private int port;

    public MulticastReceiver(String address, int port) throws Exception {
        this.group = InetAddress.getByName(address);
        this.port = port;
        this.socket = new MulticastSocket(port);
        this.socket.joinGroup(group);
    }

    @Override
    public void run() {
        try {
            while (true) {
                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Mensagem recebida: " + message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() throws Exception {
        socket.leaveGroup(group);
        socket.close();
    }
}
