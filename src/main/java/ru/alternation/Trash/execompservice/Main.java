package ru.alternation.Trash.execompservice;



import org.apache.commons.io.IOUtils;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 http://www.nurkiewicz.com/2013/02/executorcompletionservice-in-practice.html
 http://www.nurkiewicz.com/2013/02/javautilconcurrentfuture-basics.html
 */
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final List<String> topSites = Arrays.asList(
                "www.google.com", "www.youtube.com", "www.yahoo.com", "www.msn.com",
                "www.wikipedia.org", "www.baidu.com", "www.microsoft.com", "www.qq.com",
                "www.bing.com", "www.ask.com", "www.adobe.com", "www.taobao.com",
                "www.youku.com", "www.soso.com", "www.wordpress.com", "www.sohu.com",
                "www.windows.com", "www.163.com", "www.tudou.com", "www.amazon.com"
        );

//        final ExecutorService pool = Executors.newFixedThreadPool(5);
//        List<Future<String>> contentsFutures = new ArrayList<>(topSites.size());
//        for (final String site : topSites) {
//            final Future<String> contentFuture = pool.submit(new Callable<String>() {
//                @Override
//                public String call() throws Exception {
//                    return IOUtils.toString(new URL("http://" + site), StandardCharsets.UTF_8); //  (IOUtils.toString() comes from Apache Commons IO):
//                }
//            });
//            contentsFutures.add(contentFuture);
//        }
//
//        for (Future<String> contentFuture : contentsFutures) {
//            final String content = contentFuture.get(); //  throws ExecutionException, InterruptedException
//            //...process contents
//        }



// good
        final ExecutorService pool = Executors.newFixedThreadPool(5);
        final ExecutorCompletionService<String> completionService = new ExecutorCompletionService<>(pool);
        for (final String site : topSites) {
            completionService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return IOUtils.toString(new URL("http://" + site), StandardCharsets.UTF_8);
                }
            });
        }

        for(int i = 0; i < topSites.size(); ++i) {
            final Future<String> future = completionService.take(); // !!!
            try {
                final String content = future.get();
                //...process contents
            } catch (ExecutionException e) {
                //log.warn("Error while downloading", e.getCause());
            }
        }


    }

}
