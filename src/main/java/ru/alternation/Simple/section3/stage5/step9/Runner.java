package ru.alternation.Simple.section3.stage5.step9;

import java.util.Arrays;

/**
 Пришло время попробовать реализовать иерархию классов определенного вида и решить конкретную задачу.

 Представим, вы делаете систему фильтрации комментариев на каком-то веб-портале, будь то новости, видео-хостинг,
 а может даже для системы онлайн-обучения :)

 Вы хотите фильтровать комментарии по разным критериям, уметь легко добавлять новые фильтры и модифицировать старые.

 Допустим, мы будем фильтровать спам, комментарии с негативным содержанием и слишком длинные комментарии.
 Спам будем фильтровать по наличию указанных ключевых слов в тексте.
 Негативное содержание будем определять по наличию одного из трех смайликов – :( =( :|
 Слишком длинные комментарии будем определять исходя из данного числа – максимальной длины комментария.

 Вы решили абстрагировать фильтр в виде следующего интерфейса:

 interface TextAnalyzer {
 Label processText(String text);
 }

 Label – тип-перечисление, которые содержит метки, которыми будем помечать текст:
 enum Label {
 SPAM, NEGATIVE_TEXT, TOO_LONG, OK
 }

 Дальше, вам необходимо реализовать три класса, которые реализуют данный интерфейс:
 SpamAnalyzer, NegativeTextAnalyzer и TooLongTextAnalyzer.
 1. SpamAnalyzer должен конструироваться от массива строк с ключевыми словами.
 Объект этого класса должен сохранять в своем состоянии этот массив строк в приватном поле keywords.
 2. NegativeTextAnalyzer должен конструироваться конструктором по-умолчанию.
 3. TooLongTextAnalyzer должен конструироваться от int'а с максимальной допустимой длиной комментария.
 Объект этого класса должен сохранять в своем состоянии это число в приватном поле maxLength.

 Наверняка вы уже заметили, что SpamAnalyzer и NegativeTextAnalyzer во многом похожи – они оба проверяют текст
 на наличие каких-либо ключевых слов (в случае спама мы получаем их из конструктора, в случае негативного текста
 мы заранее знаем набор грустных смайликов) и в случае нахождения одного из ключевых слов возвращают
 Label (SPAM и NEGATIVE_TEXT соответственно), а если ничего не нашлось – возвращают OK.
 Давайте эту логику абстрагируем в абстрактный класс KeywordAnalyzer следующим образом:
 1. Выделим два абстрактных метода getKeywords и getLabel, один из которых будет возвращать набор ключевых слов,
 а второй метку, которой необходимо пометить положительные срабатывания. Нам незачем показывать эти методы
 потребителям классов, поэтому оставим доступ к ним только для наследников.
 2. Реализуем processText таким образом, чтобы он зависел только от getKeywords и getLabel.
 3. Сделаем SpamAnalyzer и NegativeTextAnalyzer наследниками KeywordAnalyzer и реализуем абстрактные методы.

 Последний штрих – написать метод checkLabels, который будет возвращать метку для комментария по набору
 анализаторов текста. checkLabels должен возвращать первую не-OK метку в порядке данного набора анализаторов,
 и OK, если все анализаторы вернули OK.
 Используйте, пожалуйста, модификатор доступа по-умолчанию для всех классов.
 В итоге, реализуйте классы KeywordAnalyzer, SpamAnalyzer, NegativeTextAnalyzer и TooLongTextAnalyzer и метод checkLabels.
 TextAnalyzer и Label уже подключены, лишние импорты вам не потребуются.

 */

public class Runner {

    interface TextAnalyzer {
        Label processText(String text);
    }

    enum Label {
        SPAM, NEGATIVE_TEXT, TOO_LONG, OK
    }

    //=====================================================================VVVV
    abstract class KeywordAnalyzer implements TextAnalyzer{
        abstract protected String[] getKeywords();
        abstract protected Label getLabel();

        @Override
        public Label processText(String text) {

            for (String s : getKeywords()){
                if (text.contains(s)){
                    return getLabel();
                }
            }
            return Label.OK;
        }
    }

    class SpamAnalyzer extends KeywordAnalyzer{
        private String[] keywords;
        public SpamAnalyzer(String... strings) {
            //this.keywords = strings;
            this.keywords = Arrays.copyOf(strings, strings.length); // полноценная копия, а не доп. ссылка на массив
        }

        @Override
        protected String[] getKeywords() {
            return keywords;
        }

        @Override
        protected Label getLabel() {
            return Label.SPAM;
        }
    }
    class NegativeTextAnalyzer extends KeywordAnalyzer{
        private String[] keywords =  {":(", "=(", ":|"};

        public NegativeTextAnalyzer() {}

        @Override
        protected String[] getKeywords() {
            return keywords;
        }

        @Override
        protected Label getLabel() {
            return Label.NEGATIVE_TEXT;
        }
    }
    class TooLongTextAnalyzer implements TextAnalyzer{
        private int maxLength;
        public TooLongTextAnalyzer(int maxLength) {
            this.maxLength = maxLength;
        }

        @Override
        public Label processText(String text) {
            return (text.length() > maxLength)
                    ? Label.TOO_LONG
                    : Label.OK;
        }
    }


    public Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer ta : analyzers) {
            Label label = ta.processText(text);
            if (label != Label.OK)
                return label;
        }
        return Label.OK;
    }

    //=====================================================================^^^^



    public static void main(String[] args) {

        Runner runner = new  Runner();

        String[] texts = {
                "qwerty",
                "qqq :(",
                "you are noob",
                "hell o",
                "100_000_                  _000 is so long",
                ":| noob",
                "the end"
        };
        String[] spamWords = {
                "zalupa",
                "kek",
                "noob"
        };

        TextAnalyzer[] tA = {
                runner.new TooLongTextAnalyzer(15),
                runner.new NegativeTextAnalyzer(),
                runner.new SpamAnalyzer(spamWords)
        };

        for (String text : texts){
            System.out.println(runner.checkLabels(tA, text));
        }

    }
}
