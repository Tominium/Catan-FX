package com.example.catanfx.GamePieces.Structures;

import com.example.catanfx.GamePieces.Structures.Structure;

import java.awt.*;

public class Road extends Structure {

    private int orientation;

    public Road(String type, String color, Point pos, int orientation) {
        super(type, color, pos);
        this.orientation = orientation;
        image = resize(image, (int) ((int)image.getWidth()/2.75), (int)((int)image.getHeight()/2.75));
        image = crop(image);
    }

    public int getOrientation() {
        return orientation;
    }
}
