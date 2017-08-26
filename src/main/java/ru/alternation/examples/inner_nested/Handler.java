package ru.alternation.examples.inner_nested;

import java.util.ArrayList;
import java.util.List;

/**
 http://www.quizful.net/post/inner-classes-java

 Локальный класс (local inner class)
 */

public class Handler {
    public void handle(String requestPath) {
        class Path {
            List<String> parts = new ArrayList<>();
            String path = "/";
            Path(String path) {
                if (path == null) return;
                this.path = path;
                for (String s : path.split("/"))
                    if (s.trim().length() > 0) this.parts.add(s);
            }
            int size() { return parts.size(); }
            String get(int i) { return i > this.parts.size() - 1 ? null : this.parts.get(i); }
            boolean startsWith(String s) { return path.startsWith(s); }
        }

        Path path = new Path(requestPath);

        if (path.startsWith("/page")) {
            String pageId = path.get(1);
            //...
        }
        if (path.startsWith("/post")) {
            String categoryId = path.get(1);
            String postId = path.get(2);
            //...
        }
        //...
    }
}
