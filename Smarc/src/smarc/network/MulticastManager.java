package network;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastManager {
    private MulticastSocket socket;
    private InetAddress group;
    private int port;

    public MulticastManager(String address, int port) throws Exception {
        this.group = InetAddress.getByName(address);
        this.port = port;
        this.socket = new MulticastSocket(port);
        this.socket.joinGroup(group);
    }

    public void sendMessage(byte[] data) throws Exception {
        DatagramPacket packet = new DatagramPacket(data, data.length, group, port);
        socket.send(packet);
    }

    public byte[] receiveMessage() throws Exception {
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);
        return packet.getData();
    }

    public void close() throws Exception {
        socket.leaveGroup(group);
        socket.close();
    }
}
