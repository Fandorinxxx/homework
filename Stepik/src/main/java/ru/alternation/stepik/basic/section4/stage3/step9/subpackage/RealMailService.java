package ru.alternation.stepik.basic.section4.stage3.step9.subpackage;

/**
 Класс, в котором скрыта логика настоящей почты
 */
public class RealMailService implements MailService {

    @Override
    public Sendable processMail(Sendable mail) {
        // Здесь описан код настоящей системы отправки почты.
        return mail;
    }
}
