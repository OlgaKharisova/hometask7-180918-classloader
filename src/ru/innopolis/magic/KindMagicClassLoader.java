package ru.innopolis.magic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class KindMagicClassLoader extends ClassLoader {
    public KindMagicClassLoader(ClassLoader parent) {
        super(parent);
    }

/*    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (name.equals("ru.innopolis.magic.Human")) {
            String dest = "/magic.class";
            byte[] classData = null;
            try (InputStream inputStream = new URL(dest).openConnection().getInputStream())){
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

                int data = inputStream.read();
                while (data != -1) {
                    ByteArrayOutputStream.write(data);
                    data = inputStream.read();
                }
                classData = byteArrayOutputStream.toByteArray();
            }
        } return

    }*/
}
