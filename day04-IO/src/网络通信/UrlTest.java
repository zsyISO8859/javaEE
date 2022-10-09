package 网络通信;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class UrlTest {
    public static void main(String[] args) throws Exception{
        URL url = new URL("https://www.bilibili.com/video/BV1Kb411W75N?p=630&vd_source=b7176735eaffa89e5822b39b6f218638");
        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
        urlConnection.connect();
        InputStream inputStream = urlConnection.getInputStream();
        FileOutputStream fos = new FileOutputStream("day01-IO\\1.txt");
        int len;
        byte[] bytes = new byte[1024];
        while((len = inputStream.read(bytes))!=-1){
            fos.write(bytes,0,len);
        }
        fos.close();
        inputStream.close();
    }
}
