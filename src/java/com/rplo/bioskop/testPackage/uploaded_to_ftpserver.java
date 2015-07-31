/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rplo.bioskop.testPackage;

/**
 *
 * @author NOVITA
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Path;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class uploaded_to_ftpserver {

    public static void main(String args[]) {
        String hostName = "127.0.0.1";
        String username = "operator";
        String password = "14147";
        String location = "C:\\Users\\NOVITA\\Pictures\\2.JPG";
       
        FTPClient ftp = null;

        InputStream in = null;

        try {
            ftp = new FTPClient();
            ftp.connect(hostName);
            ftp.login(username, password);

            ftp.setFileType(FTP.BINARY_FILE_TYPE);

            //ftp.changeWorkingDirectory("D:/baru minta fi");

            int reply = ftp.getReplyCode();
            System.out.println("Received Reply from FTP Connection:" + reply);

            if (FTPReply.isPositiveCompletion(reply)) {
                System.out.println("Connected Success");
            }

            File f1 = new File(location);
            in = new FileInputStream(f1);

            ftp.storeFile("2.JPG", in);

            System.out.println("SUCCESS");

            ftp.logout();
            ftp.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}