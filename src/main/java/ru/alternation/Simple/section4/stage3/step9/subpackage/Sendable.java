package ru.alternation.Simple.section4.stage3.step9.subpackage;

/**
 * Интерфейс: сущность, которую можно отправить по почте.
 * У такой сущности можно получить от кого и кому направляется письмо.
 */
public interface Sendable {
    String getFrom();

    String getTo();
}
