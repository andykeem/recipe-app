package com.example.demorecipe.helper;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class Image {

    public byte[] getBytesByPaty(String path) {
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(path));
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            int size = in.available();
            byte[] b = new byte[size];
            int len;
            while ((len = in.read(b)) != -1) {
                out.write(b, 0, len);
            }
            return out.toByteArray();
        } catch (FileNotFoundException fne) {
            log.error(fne.getMessage(), fne);
        } catch (IOException ioe) {
            log.error(ioe.getMessage(), ioe);
        }
        return null;
    }
}