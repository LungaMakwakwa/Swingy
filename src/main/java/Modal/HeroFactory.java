package Modal;

public abstract class HeroFactory {

    //Creating a new hero
    //switch case or if statements herofactory
    public static Hero newHero(String name, String heroClass) {
        switch (heroClass.toUpperCase()) {
            case "KNIGHT":
                return HeroManager.createKnight(name);
            case "ELF":
                return HeroManager.createElf(name);
            case "PRIEST":
                return HeroManager.createPriest(name);
            default:
                throw new IllegalArgumentException("Invalid hero class: " + heroClass);
        }
    }

}
