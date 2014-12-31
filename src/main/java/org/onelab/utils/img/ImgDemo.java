package org.onelab.utils.img;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.*;
import java.util.List;

/**
 * Created by chunliangh on 14-12-24.
 */
public class ImgDemo {
    public static void main(String args[]){
        List<Map<String,String>> rs = getImgFile(5,2000,"/Users/daojian/Desktop/","jpg");
        System.out.println(rs);
    }

    public static List<Map<String,String>> getImgFile(int len,int step,String folder,String type){
        List<Map<String,String>> rs = new LinkedList<Map<String,String>>();
        for (int i=1;i<=len;i++){
            BufferedImage image = new BufferedImage(step*i,1000,BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = image.createGraphics();
            graphics2D.setColor(Color.BLUE);
            graphics2D.fillRect(0,0,step*i,1000);
            graphics2D.dispose();
            String file = folder+"pic"+i+"."+type;
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(file);
                ImageIO.write(image, type, fos);
            } catch (Exception e) {
                e.printStackTrace();
            }
            File f = new File(file);
            Map<String,String> row = new HashMap<String, String>();
            row.put("file",file);
            row.put("size",(f.length()/1000)+"KB");
            rs.add(row);
        }
        return rs;
    }
}
