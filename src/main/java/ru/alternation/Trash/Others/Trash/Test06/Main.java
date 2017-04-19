package ru.alternation.Trash.Others.Trash.Test06;


import java.io.BufferedOutputStream;
import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main implements Externalizable {
    public static void main(String[] args) throws IOException {


        List<String> list3 = new ArrayList<String>(){{
            add("111 hello");
            add("222 bye");
            add("lol");
            add("lololfff");
            add("lololfff");
        }};
//      list3.removeIf(s -> s.equals("lol"));
        for (Iterator<String> i = list3.iterator(); i.hasNext();){
            String s = i.next();
            if (s.equals("lol")){
                i.remove();
            }
        }

// NOOOOOOOOOOOOOOOO
//        for (String s : list3){
//            if (s.equals("lol")){
//                list3.remove(s);
//            }
//        }






        Path path = Paths.get("input.txt");

        System.out.println(path.getFileSystem().getSeparator());

        BufferedOutputStream b = new BufferedOutputStream(Files.newOutputStream(path));

        b.write("dfgdfgdfg".getBytes());
        b.flush();
        b.close();

        List<String> list = new ArrayList<String>(){{
            add("111 hello");
            add("222 bye");
        }};
        String s ="hello123 123";

        try(OutputStream os = new FileOutputStream("out.txt");
            ObjectOutputStream oos = new ObjectOutputStream(os)) {
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> list2 = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("out.txt"))){
            list2 = (List<String>) ois.readObject();


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        list.forEach(System.out::println);

    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }
}
