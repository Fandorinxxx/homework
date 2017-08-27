package ru.alternation.examples.jul;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class LogAndFinalize {

        static private int numberOfMain = 0;
        static private final Logger logger = Logger.getLogger(LogAndFinalize.class.getName());
        static {
            logger.setUseParentHandlers(false); // Иначе корневой еще будет выводить
            for(Handler h : Logger.getLogger("").getHandlers()){
                System.out.println(h);  // java.util.logging.ConsoleHandler@45ee12a7
            }


            logger.setLevel(Level.ALL);
            Handler handler = new ConsoleHandler();
            handler.setLevel(Level.ALL);
            logger.addHandler(handler);
            handler.setFormatter(new SimpleFormatter(){
                @Override
                public synchronized String format(LogRecord record) {
                    return "\n__________" + record.getLevel() + " "  +record.getMessage() + "____________\n\n";
                }
            });
        }


        public static void main(String[] args) {
            LogAndFinalize m1 =  new LogAndFinalize();
            LogAndFinalize m2 =  new LogAndFinalize();
            LogAndFinalize m3 =  new LogAndFinalize();
            new LogAndFinalize();
            m1 = null;
            m2 = null;
            m3 = null;
            Runtime.getRuntime().gc();

//            for (int i = 0; i < Integer.MAX_VALUE/10; i++) {
//
//                if (i % 100_000_000 == 0){
//                    System.out.println(i);
//                }
//            }
//            System.err.println("____________");
        }


        @Override
        protected void finalize() throws Throwable {
            numberOfMain++;
            //logger.fine("finalize    " + numberOfMain);
            logger.warning("finalize " + numberOfMain);
            //System.err.println("qqqq");
            super.finalize();
        }
    }