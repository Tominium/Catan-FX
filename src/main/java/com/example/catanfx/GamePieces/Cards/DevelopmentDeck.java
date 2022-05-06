package com.example.catanfx.GamePieces.Cards;

import java.util.*;

public class DevelopmentDeck {

    private static Deque<DevelopmentCard> deck;

    public DevelopmentDeck() {
        deck = new ArrayDeque<DevelopmentCard>();

        fill("knight", 14);
        fill("roadbuilding", 2);
        fill("yearofplenty", 2);
        fill("monopoly", 2);
        fill("victorypoint", 5);
        shuffle();


    }

    public void fill(String type, int num) {
        for(int i = 0; i < num; i++) {
            deck.offer(new DevelopmentCard(type));
        }
    }

    public void fillVP(String type, int num) {
        for(int i = 0; i < num; i++) {
            deck.offer(new DevelopmentCard(type, 1));
        }
    }

    public void shuffle() {
        ArrayList<Integer> used = new ArrayList<>();
        ArrayDeque<DevelopmentCard> shuffled = new ArrayDeque<>();
        for(int i = 0; i < 25; i++){
            int random = (int)(Math.random() * 25) + 1;
            if(used.indexOf(random) == -1){
                if(random < 14){
                    shuffled.offer(new DevelopmentCard("knight"));
                }
                else if(random < 16){
                    shuffled.offer(new DevelopmentCard("roadbuilding"));
                }
                else if(random < 18){
                    shuffled.offer(new DevelopmentCard("yearofplenty"));
                }
                else if(random < 20){
                    shuffled.offer(new DevelopmentCard(("monopoly")));
                }
                else{
                    shuffled.offer(new DevelopmentCard("victorypoint"));
                }
            }
            else{
                i--;
            }
        }
        deck = shuffled;
    }

    public static DevelopmentCard getCard() {
        return deck.pop();
    }
}
