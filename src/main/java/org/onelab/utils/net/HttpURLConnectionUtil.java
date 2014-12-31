package org.onelab.utils.net;

import org.apache.commons.io.IOUtils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.UUID;

/**
 * Created by chunliangh on 14-12-9.
 */
public class HttpURLConnectionUtil {
    private static String split = "\r\n";
    private static Charset utf8 = Charset.forName("utf-8");

    public static String updatePic(String hostUrl,Map<String,String> params,byte[] bytes) throws IOException{
        String json = null;
        String boundary = UUID.randomUUID().toString().toLowerCase().replaceAll("-", "").substring(12);
        String boundaryStart = "--" + boundary + split;
        String boundaryEnd = "--" + boundary + "--" + split;

        StringBuilder paramStr = new StringBuilder();
        for (Map.Entry<String,String> entry:params.entrySet()){
            paramStr.append(boundaryStart);
            paramStr.append("Content-Disposition: form-data; name=\"").append(entry.getKey()).append("\"")
                    .append(split+split).append(entry.getValue()).append(split);
        }

        HttpURLConnection urlConnection = null;
        OutputStream os = null;
        DataOutputStream dos = null;
        try {
            urlConnection = (HttpURLConnection) new URL(hostUrl).openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Connection", "close");
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            urlConnection.setConnectTimeout(10000);
            urlConnection.setReadTimeout(10000);
            urlConnection.setUseCaches(false);
            if (bytes!=null){
                urlConnection.setRequestProperty("Content-type", "multipart/form-data;boundary=" + boundary);
                os = urlConnection.getOutputStream();
                dos = new DataOutputStream(os);
                dos.writeBytes(paramStr.toString());
                //图片信息
                dos.writeBytes(boundaryStart);
                dos.writeBytes("Content-Disposition:form-data;name=\"imagefile\";filename=\"imagefile\"" + split + split);
                dos.write(bytes);
                dos.writeBytes(split + split);
                dos.writeBytes(boundaryEnd);
                dos.flush();
            }else{
                os = urlConnection.getOutputStream();
                dos = new DataOutputStream(os);
                dos.writeBytes(paramStr.toString());
                dos.flush();
            }
            if (urlConnection.getResponseCode() == 200) {
                json = IOUtils.toString(urlConnection.getInputStream(), utf8);
            }
        } finally {
            if (dos != null) {
                dos.close();
            }
            if (os != null) {
                os.close();
            }
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        return json;
    }
}
