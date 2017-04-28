package ru.alternation.Other.stepik_contest_java.functionals;

import java.util.Date;
import java.util.stream.Collectors;

/**
 2.32 Almost like a SQL: click count

 There is a LogEntry class for monitoring user activity on your site. The class have three fields:
    created: Date - the date of creating log entry
    login: String - an user login
    url: String - an url that the user clicked
 The class have getters for all fields with the corresponding names (getCreated(), getLogin(), getUrl()).

 TASK: Write a collector that calculates how often was clicked each url by users. The collector will be applied to
 a stream of log entries for creating a map: url -> click frequency.

 The class LogEntry will be available during testing. You can create your own classes for local testing.

 You should write only the collector in any valid formats but without ; on the end.
 It will be passed as the argument to the collect() method of the stream.

 Examples of the valid solution formats: Collectors.reducing(...) or reducing(...).

 */
public class Main32 {
    public static void main(String[] args) {

        Collectors.groupingBy(LogEntry::getUrl, Collectors.counting());
    }

    static class LogEntry{

        private Date created;
        private String login;
        private String url;

        public Date getCreated() {
            return created;
        }

        public String getLogin() {
            return login;
        }

        public String getUrl() {
            return url;
        }
    }
}
