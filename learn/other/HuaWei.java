package other;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;

public class HuaWei {
    public static int[][] readFromFile(String filePath) throws IOException {
        File file = new File(filePath);
        //作废，行数不完全等于数值
//        int lines = 0;
//        if(file.isFile() && file.exists()){
//            long fileLength = file.length();
//            LineNumberReader lineNumberReader =new LineNumberReader(new FileReader(file));
//            lineNumberReader.skip(fileLength);
//            lines=lineNumberReader.getLineNumber();
//            lineNumberReader.close();
//        }
//        if(lines == 0){
//            return null;
//        }
//        System.out.println(lines);
//        int[][] result = new int[lines][lines];
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        bufferedReader.mark(1);
        int lines = 0;
        String text = null;
        LinkedList<String> fileTextByLine = new LinkedList<>();
        while((text = bufferedReader.readLine()) != null) {
            fileTextByLine.add(text);
            String[] split = text.split(",");
            lines = Integer.parseInt(split[0]) > Integer.parseInt(split[1]) ?
                    Math.max(lines, Integer.parseInt(split[0])) :
                    Math.max(lines, Integer.parseInt(split[1]));
        }

        int[][] result = new int[lines + 1][lines + 1];
        for(String line : fileTextByLine){
            String[] split = line.split(",");
            int from = Integer.parseInt(split[0]);
            int to = Integer.parseInt(split[1]);
            result[from][to] = 1;
        }
        return result;
    }
}
