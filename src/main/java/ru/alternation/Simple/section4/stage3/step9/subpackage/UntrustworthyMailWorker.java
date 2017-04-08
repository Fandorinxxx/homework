package ru.alternation.Simple.section4.stage3.step9.subpackage;

/**
 1) UntrustworthyMailWorker – класс, моделирующий ненадежного работника почты, который вместо того, чтобы передать
 почтовый объект непосредственно в сервис почты, последовательно передает этот объект набору третьих лиц, а затем,
 в конце концов, передает получившийся объект непосредственно экземпляру RealMailService. У UntrustworthyMailWorker
 должен быть конструктор от массива MailService ( результат вызова processMail первого элемента массива передается
 на вход processMail второго элемента, и т. д.) и метод getRealMailService, который возвращает ссылку на внутренний
 экземпляр RealMailService.

 */
public class UntrustworthyMailWorker implements MailService{

    private MailService[] mailServices;
    private RealMailService realMailService = new RealMailService();

    public UntrustworthyMailWorker(MailService[] mailServices) {
        this.mailServices = mailServices;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        for (MailService m : mailServices) {
            mail = m.processMail(mail);
        }
        return getRealMailService().processMail(mail);
    }
    public RealMailService getRealMailService(){
        return realMailService;
    }
}
