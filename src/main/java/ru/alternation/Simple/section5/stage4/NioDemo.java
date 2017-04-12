package ru.alternation.Simple.section5.stage4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class NioDemo {

    public static void main(String[] args) throws IOException, URISyntaxException {
        //Path path = Paths.get("src/org/stepik/java/io/NioDemo.java");
        Path path = Paths.get("src\\main\\java\\ru\\alternation\\Simple\\section5\\stage4\\NioDemo.java");



        try (ReadableByteChannel in = FileChannel.open(path); // throws IOException
             WritableByteChannel out = Channels.newChannel(System.out)) {

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (in.read(buffer) >= 0 || buffer.position() != 0) {
                buffer.flip();
                out.write(buffer);
                buffer.compact();
            }
        }

//        try (InputStream in = Files.newInputStream(path);
//                OutputStream out = System.out) {
//            byte[] buffer = new byte[1024];
//            int byteRead;
//            while ((byteRead = in.read(buffer)) > 0){
//                out.write(buffer, 0, byteRead);
//            }
//        }
    }
}
