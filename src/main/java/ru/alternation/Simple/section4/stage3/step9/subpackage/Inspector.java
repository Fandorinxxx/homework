package ru.alternation.Simple.section4.stage3.step9.subpackage;

/**
 4) Inspector – Инспектор, который следит за запрещенными и украденными посылками и бьет тревогу в виде исключения,
 если была обнаружена подобная посылка. Если он заметил запрещенную посылку с одним из запрещенных содержимым
 ("weapons" и "banned substance"), то он бросает IllegalPackageException. Если он находит посылку, состоящую из камней
 (содержит слово "stones"), то тревога прозвучит в виде StolenPackageException.
 Оба исключения вы должны объявить самостоятельно в виде непроверяемых исключений. */
public  class Inspector implements MailService {
    private final String WEAPONS = "weapons";
    private final String BANNED_SUBSTANCE = "banned substance";

    @Override
    public Sendable processMail(Sendable mail) {

        if (mail instanceof MailPackage){
            Package aPackage = ((MailPackage) mail).getContent();
            if (aPackage.getContent().contains(WEAPONS) || aPackage.getContent().contains(BANNED_SUBSTANCE)){
                throw new IllegalPackageException();
            } else if (aPackage.getContent().contains("stones"))
                throw new StolenPackageException(); // удалил {}, чтобы код не подсвечивался как дублирующийся
        }
        return mail;
    }
}

