package org.onelab.utils.net;

import java.net.InetAddress;

/**
 * Created by chunliangh on 14-12-22.
 */
public class IPAdress {
    public static void main(String[] args) {
        try {
            InetAddress[] address = InetAddress.getAllByName("manage.int.jumei.com");
            for (int i = 0; i < address.length; i++) {
                System.out.println(address[i].getHostAddress());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            System.exit(1);
        }
    }
}
