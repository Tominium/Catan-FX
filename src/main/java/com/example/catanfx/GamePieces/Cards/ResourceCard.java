package com.example.catanfx.GamePieces.Cards;

import javafx.scene.image.ImageView;
import java.util.Objects;

public class ResourceCard {
    private String rc;
    private ImageView rcFront;
    private ImageView rcBack;

    public ResourceCard(String rcName) {
        rc = rcName;
        rcFront = new ImageView(ResourceCard.class.getClassLoader().getResource("Assets/Resource_Cards/"+rc+".png").toExternalForm());
        rcBack = new ImageView(ResourceCard.class.getClassLoader().getResource("Assets/Resource_Cards/back.png").toExternalForm());
    }

    public ImageView getFront(){
        return rcFront;
    }
    public ImageView getBack(){
        return rcBack;
    }

    public String getType(){
        return rc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourceCard that = (ResourceCard) o;
        return that.getType().toLowerCase().equals(getType().toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(rc, rcFront, rcBack);
    }
}
