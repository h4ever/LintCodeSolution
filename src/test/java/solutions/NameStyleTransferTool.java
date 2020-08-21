package test.java.solutions;

import java.io.*;

public class NameStyleTransferTool {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("C:\\oaoOrder.columns.txt");
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = new FileWriter("C:\\oaoOrder.columns.result.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        String line;
        while((line = br.readLine())!=null){
            bw.write(uptotf(line));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
        fr.close();
    }

    public static String uptotf(String key){
        String newKey = key.toLowerCase();
        String[] temp= newKey.split("_");

        int i = temp.length;
        StringBuilder plpBuffer = new StringBuilder(temp[0]);
        for (int w = 1; w < i; w++) {
            plpBuffer.append(temp[w].substring(0, 1).toUpperCase()).append(temp[w].substring(1));
        }
        return plpBuffer.toString();
    }
}
