package Modal;


import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

import Modal.Artifact.Armor;
import Modal.Artifact.Artifacts;
import Modal.Artifact.Helm;
import Modal.Artifact.Weapon;
import Modal.Points;

public class Play {

    private static Play instance = null;

    private Hero hero;
    private Points heroCoord;
    private int mapSize;
    private boolean[][] map;

    private Play() {
    }
    //
    public static Play getInstance() {
        if (instance == null) {
            instance = new Play();
        }
        return instance;
    }
//
    public void initGame(Hero hero) {
        this.hero = hero;
        generateMap();
        generateVillains();
        putHero();
    }
//
    private void generateMap() {
        int level = hero.getLevel();
        mapSize = (level - 1) * 5 + 10 - (level % 2);
        map = new boolean[mapSize][mapSize];
    }
//
    private void generateVillains() {
        int rand;
        int level = hero.getLevel();

        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                rand = ThreadLocalRandom.current().nextInt(0, 101);
                if ((level + 1) * 10 >= rand)
                    map[i][j] = true;
            }
        }
    }
//
    public Villians generateVillain() {
        int attack = ThreadLocalRandom.current().nextInt(hero.getAttack() - 20, hero.getAttack() + 2 + hero.getLevel());
        int defense = ThreadLocalRandom.current().nextInt(hero.getDefense() - 20, hero.getDefense() + 2 + hero.getLevel());
        int hitPoints = ThreadLocalRandom.current().nextInt(hero.getHitPoints() - 50, hero.getHitPoints() + 20 + hero.getLevel());

        attack = attack < 0 ? -attack : attack;
        defense = defense < 0 ? -defense : defense;
        hitPoints = hitPoints < 0 ? -hitPoints : hitPoints;
        Artifacts artifacts = generateArtifact();

        return new Villians("Villain", attack, defense, hitPoints, artifacts);
    }

    private Artifacts generateArtifact() {
        int rand = ThreadLocalRandom.current().nextInt(0, 10);

        Artifacts artifacts = null;
        if (rand == 0)
            artifacts = new Weapon("Sword", ThreadLocalRandom.current().nextInt(1, 5 * (hero.getLevel() + 1)));
        else if (rand == 1)
            artifacts = new Helm("Pot", ThreadLocalRandom.current().nextInt(1, 3 * (hero.getLevel() + 1)));
        else if (rand == 2)
            artifacts = new Armor("Shield", ThreadLocalRandom.current().nextInt(1, 4 * (hero.getLevel() + 1)));
        return artifacts;
    }
//
    public int fightResult(Villians villains) {
        int xp = villains.getAttack() + villains.getDefense() + villains.getHitPoints();
        int rand = ThreadLocalRandom.current().nextInt(0, 101);

        if (rand < 3)
            return xp;
        else if (rand > 98)
            return -1;

        return hero.fight(villains) ? xp : -1;
    }
//
    private void putHero() {
        heroCoord = new Points(mapSize / 2, mapSize / 2);
        map[heroCoord.getY()][heroCoord.getX()] = false;
    }

    public int getMapSize() {
        return mapSize;
    }

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Points getHeroCoord() {
        return heroCoord;
    }

    public void setHeroCoord(Points heroCoord) {
        this.heroCoord = heroCoord;
    }

    public boolean[][] getMap() {
        return map;
    }

    public void setMap(boolean[][] map) {
        this.map = map;
    }
}
