package Modal;

public class HeroManager {

    private static HeroCreation buildNew(String name) {
        HeroCreation builder = new HeroCreation();
        builder.setName(name);
        builder.setLevel(0);
        builder.setExperience(0);
        return builder;
    }

    public static Hero createKnight(String name) {
        HeroCreation builder = buildNew(name);
        builder.setAttack(40);
        builder.setDefense(20);
        builder.setHitPoints(100);
        builder.setHeroClass("Knight");
        return builder.getHero();
    }

    public static Hero createElf(String name) {
        HeroCreation builder = buildNew(name);
        builder.setAttack(30);
        builder.setDefense(15);
        builder.setHitPoints(90);
        builder.setHeroClass("Elf");
        return builder.getHero();
    }

    public static Hero createPriest(String name) {
        HeroCreation builder = buildNew(name);
        builder.setAttack(25);
        builder.setDefense(25);
        builder.setHitPoints(90);
        builder.setHeroClass("Priest");
        return builder.getHero();
    }

}
