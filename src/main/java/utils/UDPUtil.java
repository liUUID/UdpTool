package utils;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPUtil {

    /**
     * 发送消息
     * @param ip ip
     * @param port 端口
     * @param payload 消息内容
     * @throws SocketException
     */
    public static void send(String ip, Integer port, String payload) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        byte[] buf = payload.getBytes();
        //将数据打包
        DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName(ip), port);
        socket.send(packet);
        socket.close();
    }
}
