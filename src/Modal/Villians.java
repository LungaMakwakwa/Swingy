package Modal;

import Modal.Artifact.Artifacts;

public class Villians extends HeroAttributes{

    private Artifacts artifacts;

    public Villians(String name, int attack, int defense, int hitPoints, Artifacts artifacts)
    {
        super(name, attack, defense, hitPoints);
        this.artifacts = artifacts;
    }

    public Artifacts getArtifact() {
        return artifacts;
    }
}
