package Modal;

public abstract class HeroFactory {

    //Creating a new hero
    //switch case or if statements herofactory
    public static Hero newHero(String name, String heroClass) {
        switch (heroClass.toUpperCase()) {
            case "WARRIOR":
                return HeroManager.createWarrior(name);
            case "SHAMAN":
                return HeroManager.createShaman(name);
            case "PRIEST":
                return HeroManager.createPriest(name);
            case "PALADIN":
                return HeroManager.createPaladin(name);
            case "MAGE":
                return HeroManager.createMage(name);
            case "HUNTER":
                return HeroManager.createHunter(name);
            default:
                throw new IllegalArgumentException("Invalid hero class: " + heroClass);
        }
    }

}
