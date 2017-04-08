package ru.alternation.Simple.section4.stage3.step9.subpackage;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 2) Spy – шпион, который логгирует о всей почтовой переписке, которая проходит через его руки. Объект конструируется
 от экземпляра Logger, с помощью которого шпион будет сообщать о всех действиях. Он следит только за объектами класса
 MailMessage и пишет в логгер следующие сообщения (в выражениях нужно заменить части в фигурных скобках на
 значения полей почты):
 2.1) Если в качестве отправителя или получателя указан "Austin Powers", то нужно написать в лог сообщение с
 уровнем WARN: Detected target mail correspondence: from {from} to {to} "{message}"
 2.2) Иначе, необходимо написать в лог сообщение с уровнем INFO: Usual correspondence: from {from} to {to}
 */
public class Spy implements MailService {

    private Logger logger;

    public Spy(Logger logger) {
        this.logger = logger;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        final String AUSTIN_POWERS = "Austin Powers";

        if (mail instanceof MailMessage) {
            if (AUSTIN_POWERS.equals(mail.getFrom()) || AUSTIN_POWERS.equals(mail.getTo())) {
                logger.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"",
                        new String[]{
                                mail.getFrom(),
                                mail.getTo(),
                                ((MailMessage) mail).getMessage()
                        });
            } else {
                logger.info("Usual correspondence: from " + mail.getFrom() + " to " + mail.getTo());
            }
        }

        return mail;
    }
}
