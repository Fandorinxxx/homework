package ru.alternation.stepik.basic.section4.stage3.step9.subpackage;

/**
 * Интерфейс, который задает класс, который может каким-либо образом обработать почтовый объект.
 */
public interface MailService {
    Sendable processMail(Sendable mail);
}
