package com.workspace.fileHandling;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileHandlingApplicationTests {

	@Test
	public void contextLoads() {
	}

    public static class zipTest {
        public static void main(String[] args) throws IOException {
            BufferedReader br= new BufferedReader( new InputStreamReader(System.in));
            System.out.println("Enter the information to be zipped (Enter 0 to stop):");
            String str="";
            String readline, end="0";
            while(!(readline=br.readLine()).equals(end)){
                readline+="\r\n";
                str+=readline;
            }
            Zipper zp= new Zipper();
            File zpFile= zp.zip(str, "DummyFile");
        }
    }
}
