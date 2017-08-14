package ru.alternation.stepik.basic.section5.stage4.step8;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;

/**
 Дан сериализуемый класс Animal:
 см. код

 Реализуйте метод, который из переданного массива байт восстановит массив объектов Animal.
 Массив байт устроен следующим образом:
 - Сначала идет число типа int, записанное при помощи ObjectOutputStream.writeInt(size).
 - Далее подряд записано указанное количество объектов типа Animal, сериализованных при
 помощи ObjectOutputStream.writeObject(animal).

 Если вдруг массив байт не является корректным представлением массива экземпляров Animal,
 то метод должен бросить исключение java.lang.IllegalArgumentException.

 Причины некорректности могут быть разные. Попробуйте подать на вход методу разные некорректные данные и посмотрите,
 какие исключения будут возникать. Вот их-то и нужно превратить в IllegalArgumentException и выбросить.
 Если что-то забудете, то проверяющая система подскажет. Главное не глотать никаких исключений,
 т.е. не оставлять нигде пустой catch.


 https://stepik.org/media/attachments/lesson/12782/module5.pdf
 */
public class Main {

    public static Animal[] deserializeAnimalArray(byte[] data) {
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) { // IOException
            int count = ois.readInt(); // IOException
            Animal[] animals = new Animal[count];
            for (int i = 0; i < count; i++) {
                animals[i] = (Animal)ois.readObject(); // IOException | ClassNotFoundException |
                                                       // ClassCastException - т.к. без instanceOf
//________________________________________________________________________________________________
//                Object o = ois.readObject();  // IOException | ClassNotFoundException
//                if (o instanceof Animal){     // ClassCastException не будет
//                    animals[i] = (Animal)o;
//                } else {
//                    throw new IllegalArgumentException();
//                }
            }
            return animals;

        } catch (IOException | ClassNotFoundException | ArrayIndexOutOfBoundsException | ClassCastException e){
            throw new IllegalArgumentException(e);
        }
    }




    public static void main(String[] args) {
        test();
    }

    private static void test(){
        int size = 5;
        Animal[] animals = new Animal[size];
        for (int i = 0; i < size; i++) {
            animals[i] = new Animal("Animal " + (i+1));
        }

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try(ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream)) {
            outputStream.writeInt(size);
            for (Animal a : animals){
                outputStream.writeObject(a);
            }
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Animal[] animals2;
        animals2 = deserializeAnimalArray(byteArrayOutputStream.toByteArray());
        for (Animal animal : animals2){
            System.out.println(animal);
        }
    }
}


class Animal implements Serializable {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            return Objects.equals(name, ((Animal) obj).name);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}