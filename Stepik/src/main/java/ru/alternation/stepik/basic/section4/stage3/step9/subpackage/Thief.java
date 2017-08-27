package ru.alternation.stepik.basic.section4.stage3.step9.subpackage;

/**
 3) Thief – вор, который ворует самые ценные посылки и игнорирует все остальное. Вор принимает в конструкторе
 переменную int – минимальную стоимость посылки, которую он будет воровать. Также, в данном классе должен
 присутствовать метод getStolenValue, который возвращает суммарную стоимость всех посылок, которые он своровал.
 Воровство происходит следующим образом: вместо посылки, которая пришла вору, он отдает новую, такую же,
 только с нулевой ценностью и содержимым посылки "stones instead of {content}". */
public class Thief implements MailService{
    private int minPrice;
    private int totalStolen;

    public Thief(int minPrice) {
        this.minPrice = minPrice;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (!(mail instanceof MailPackage)) {  // чтобы не подсвечивалось, что код сдублирован
            return mail;
        }
        ru.alternation.stepik.basic.section4.stage3.step9.subpackage.Package aPackage = ((MailPackage) mail).getContent();
        if (aPackage.getPrice() >= minPrice){
            totalStolen+=aPackage.getPrice();
            return new MailPackage(mail.getFrom(), mail.getTo(), new ru.alternation.stepik.basic.section4.stage3.step9.subpackage.Package("stones instead of " + aPackage.getContent(), 0));
        }
        return mail;
    }

    public int getStolenValue(){
        return totalStolen;
    }

}
