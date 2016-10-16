package dvimer;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//На любом языке напишите функцию, которая заменит ip 192.168.1.10 на  ip 192.168.1.100 во всех файлах и всех поддиректориях
// (базовая директория подается на вход как параметр)
public class ChangeIp {
    public static final String LEGENDARY_IP = "192.168.1.10";
    public static final String REPLACE_IP = "192.168.1.100";

    public static void main(String[] args) {
        changeIp(new File("E:\\Test"));
    }

    public static void changeIp(File directory) {
        if (directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                if (file.isDirectory()) {
                    changeIp(file);
                } else {
                    replaceIP(file);
                }
            }
        }
    }

    public static void replaceIP(File file) {
        Charset charset = StandardCharsets.UTF_8;
        Path path = Paths.get(file.getPath());
        try {
            Files.write(path,
                    new String(Files.readAllBytes(path), charset).replace(LEGENDARY_IP, REPLACE_IP)
                            .getBytes(charset));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


