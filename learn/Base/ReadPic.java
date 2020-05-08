package Base;

import java.io.*;

public class ReadPic {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bi = new BufferedInputStream(new FileInputStream(new File("E:\\djy.png")));
        byte[] ch = new byte[1024];
        BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(new File("E:\\new.png")));
        while(bi.read(ch)!=-1){
            bo.write(ch);
            bo.flush();
        }
    }
}
