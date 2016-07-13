package Zip;

import java.io.BufferedOutputStream;  
import java.io.BufferedReader;  
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.util.zip.GZIPInputStream;  
import java.util.zip.GZIPOutputStream; 

/** 
 * @�ļ�ѹ�� 
 * @���ļ�ѹ����GZIP ��һ�������� �����ǻ�������� 
 * @GZIPOutputStream��GZIPInputStream��ʹ�� 
 * @author jkd 
 *  
 */  
  
public class Uzip_Zip {  
    public static void main(String[] args) throws IOException {  
        //��׼��ѹ��һ���ַ��ļ���ע��������ַ��ļ�Ҫ��GBK���뷽ʽ��  
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(  
                "source.txt"), "GBK"));  
        //ʹ��GZIPOutputStream��װOutputStream����ʹ�����ѹ�����ԣ���������test.txt.gzѹ����  
        //����������һ����Ϊtest.txt���ļ�  
        BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(  
                new FileOutputStream("test.txt.gz")));
        
        
        System.out.println("��ʼдѹ���ļ�...");  
        int c;  
        while ((c = in.read()) != -1) {  
  
            /*  
             * ע��������ѹ��һ���ַ��ļ���ǰ�������ַ��������ģ�����ֱ�Ӵ���c����Ϊc����Unicode 
             * �룬�����ᶪ����Ϣ�ģ���Ȼ��������ʽ�Ͳ��ԣ�����������Ҫ��GBK������ٴ��롣 
             */  
            out.write(String.valueOf((char) c).getBytes("GBK"));  
        }  
        in.close();  
        out.close();  
        
        
        System.out.println("��ʼ��ѹ���ļ�...");  
        //ʹ��GZIPInputStream��װInputStream����ʹ����н�ѹ����  
        BufferedReader in2 = new BufferedReader(new InputStreamReader(  
                new GZIPInputStream(new FileInputStream("test.txt.gz")), "GBK"));  
        String s;  
        //��ȡѹ���ļ��������  
        while ((s = in2.readLine()) != null) {  
            System.out.println(s);  
        }  
        in2.close();  
    }  
}  