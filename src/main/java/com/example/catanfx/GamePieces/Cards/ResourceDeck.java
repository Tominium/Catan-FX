package com.example.catanfx.GamePieces.Cards;

import java.util.ArrayDeque;
import java.util.Deque;

public class ResourceDeck {
    // instance variables
    private Deque lumberDeck, brickDeck, woolDeck, grainDeck, oreDeck;

    // constructor
    public ResourceDeck() {
        lumberDeck = new ArrayDeque<>();
        brickDeck = new ArrayDeque<>() ;
        woolDeck = new ArrayDeque<>();
        grainDeck = new ArrayDeque<>();
        oreDeck = new ArrayDeque<>();
        fill("lumber");
        fill("brick");
        fill("wool");
        fill("grain");
        fill("ore");
    }

    public ResourceCard drawLumber() {
        // draw a card from the lumber deck
        return (ResourceCard) lumberDeck.removeFirst();
    }

    public ResourceCard drawBrick() {
        // draw a card from the brick deck
        return (ResourceCard) brickDeck.removeFirst();
    }

    public ResourceCard drawWool() {
        // draw a card from the wool deck
        return (ResourceCard) woolDeck.removeFirst();
    }

    public ResourceCard drawGrain() {
        // draw a card from the grain deck
        return (ResourceCard) grainDeck.removeFirst();
    }

    public ResourceCard drawOre() {
        // draw a card from the ore deck
        return (ResourceCard) oreDeck.removeFirst();
    }

    public void addLumber(ResourceCard card) {
        // add a card to the lumber deck
        lumberDeck.add(card);
    }

    public void addBrick(ResourceCard card) {
        // add a card to the brick deck
        brickDeck.add(card);
    }

    public void addWool(ResourceCard card) {
        // add a card to the wool deck
        woolDeck.add(card);
    }

    public void addGrain(ResourceCard card) {
        // add a card to the grain deck
        grainDeck.add(card);
    }

    public void addOre(ResourceCard card) {
        // add a card to the ore deck
        oreDeck.add(card);
    }

 public void fill(String resource) {
        // fill the deck with the specified resource
        if (resource.equals("lumber")) {
            for (int i = 0; i < 19; i++) {
                lumberDeck.add(new ResourceCard(resource));
            }
        } else if (resource.equals("brick")) {
            for (int i = 0; i < 19; i++) {
                brickDeck.add(new ResourceCard(resource));
            }
        } else if (resource.equals("wool")) {
            for (int i = 0; i < 19; i++) {
                woolDeck.add(new ResourceCard(resource));
            }
        } else if (resource.equals("grain")) {
            for (int i = 0; i < 19; i++) {
                grainDeck.add(new ResourceCard(resource));
            }
        } else if (resource.equals("ore")) {
            for (int i = 0; i < 19; i++) {
                oreDeck.add(new ResourceCard(resource));
            }
        }
    }
 }


