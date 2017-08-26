package ru.alternation.stepik.contest_java.generics;


import java.lang.reflect.Array;
import java.util.Arrays;

/**
 # 3.26 Generic Arrays

 https://en.wikipedia.org/wiki/Photocopier
 Remember all these good old photocopiers? Let's try to implement something similar with time-proven Java arrays
 in dangerous mix with up to date Java generics.

 Your task is to create Multiplicator that receives Folders with anything that can be copied
 (i.e. implementing Copy interface) any creates array of Folders with copies of the original Folder content.
 Mix of generics and arrays is not desirable, but sometimes we need to work in such a way (e.g. when interacting with
 legacy code) and it worth to spend time to learn how to deal with it.

 Class hierarchy is illustrated by the code snippet:

 ...

 Note the following:
 - It's ok to create new Folder instances
 - Objects inside newly created Folders should be copies of the original
 - Original Folder object should left intact (all array entries are copies of the original object)

 */

public class Main26 {

    interface Copy<T> {
        T copy();
    }

    static class File implements Copy<File> {
        private String string;

        public File(String string) {
            this.string = string;
        }

        @Override
        public File copy() {
            return new File(string);
        }
    }

    static class Folder<T> {
        private T item;

        public void put(T item) {
            this.item = item;
        }

        public T get() {
            return this.item;
        }
    }

    /**
     * Class to work with
     */
    static class Multiplicator { // добавил static
        /**
         * Multiply folders and put copies of original folder argument content in each.
         *
         * @param folder folder which content should be multiplicated
         * @param arraySize size of array to return.
         *     Each array element should have Folder with copy of the original content inside
         * @return array of Folder<T>[] objects
         */
        public static <T extends Copy<T>> Folder<T>[] multiply(Folder<T> folder, int arraySize) {

            // создавать дженерик массивы нельзя, так что создаем роу тайповый
            Folder<T>[] folders = new Folder[arraySize];   // (Folder<T>[]) Array.newInstance(Folder.class, arraySize)
            for (int i = 0; i < arraySize; i++) {
                folders[i] = new Folder<>();
                folders[i].put(folder.get().copy());
            }

            return folders;
        }

    }


    public static void main(String[] args) {

        Folder<File> folder = new Folder<>();
        folder.put(new File("Q"));

        Folder<File>[] folders = Multiplicator.multiply(folder, 3);
        System.out.println(Arrays.toString(folders));

    }
}
