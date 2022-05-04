package com.example.catanfx.GamePieces;

import com.example.catanfx.GamePieces.Structures.City;
import com.example.catanfx.GamePieces.Structures.Settlement;
import com.example.catanfx.GamePieces.Structures.Structure;
import javafx.scene.image.ImageView;

import javax.sound.sampled.Port;

public class Intersection {

    private Tile one, two, three;
    private Structure structure;
    private Port port;

    public Intersection(Tile one, Tile two, Tile three) {
        this.one = one;
        this.two = two;
        this.three = three;

        structure = null;
        port = null;
    }

    public void buildSettlement() {
        structure = new Settlement("settlement",GameState.players.get(GameState.turnNumber).getColor(), getStructureImage());
    }

    public void buildCity() {
        structure = new City("city", GameState.players.get(GameState.turnNumber).getColor(), getStructureImage());
    }

    public ImageView getStructureImage() {
        for(int i = 0; i < one.getVertices().size(); i++) {
            if(two.getVertices().contains(one.getVertices().get(i))&&three.getVertices().contains(one.getVertices().get(i)))
                return one.getVertices().get(i).getImage();
        }
        return null;
    }
}
