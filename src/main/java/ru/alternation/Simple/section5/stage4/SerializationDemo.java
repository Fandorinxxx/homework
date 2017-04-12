package ru.alternation.Simple.section5.stage4;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

public class SerializationDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Client originalClient = new Client();
        originalClient.setId(1);
        originalClient.setName("Chuck Norris");
        originalClient.setBirthDate(LocalDate.of(1940, 3, 10));

        Path path = Paths.get("object.bin");
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) { // IOException
            oos.writeObject(originalClient);
        }

        Client deserializedClient;
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            deserializedClient = (Client) ois.readObject(); // ClassNotFoundException
        }

        System.out.println(deserializedClient.getId());
        System.out.println(deserializedClient.getName());
        System.out.println(deserializedClient.getBirthDate());
        System.out.println(deserializedClient.getAgeInYears());

    }


    public static class Client implements Serializable{
        private long id;
        private String name;
        private LocalDate birthDate;
        private transient int ageInYears;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public LocalDate getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
        }

        public int getAgeInYears() {
            if (ageInYears == 0){
                ageInYears = birthDate.until(LocalDate.now()).getYears();
            }
            return ageInYears;
        }
    }
}
