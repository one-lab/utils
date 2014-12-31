package org.onelab.utils.net;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by chunliangh on 14-12-16.
 */
public class NioDemo {
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(80);
        serverSocket.accept();
    }
}
