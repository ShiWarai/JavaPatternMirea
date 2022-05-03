package ru.mirea.task12;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class FileWorker {

    @Value("${input:file.in}")
    private String input;
    @Value("${output:file.out}")
    private String output;

    private File fileInput, fileOutput;

    public FileWorker() {}

    public void start(String input, String output) {
        this.input = input;
        this.output = output;
        init();
        hash();
    }

    @PostConstruct
    private void init() {
        fileInput = new File(input);
        fileOutput = new File(output);
    }

    @PreDestroy
    private void finish() {
        fileInput.delete();
    }

    public void hash() {
        if (fileInput.exists()) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutput));
                String content = new String(Files.readAllBytes(Paths.get(input)));
                writer.write(DigestUtils.md5DigestAsHex(content.getBytes()));
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutput));
                writer.write("null");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
