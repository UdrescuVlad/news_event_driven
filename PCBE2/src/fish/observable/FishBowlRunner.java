package fish.observable;

import java.util.ArrayList;
import java.util.List;

public class  FishBowlRunner {
    public static void main(String[] args) {
        List<TropicalFish> fishies = new ArrayList<>();

        fishies.add(new TropicalFish("A"));
        fishies.add(new TropicalFish("B"));
        fishies.add(new TropicalFish("C"));

        FishFeeder fishFeeder = new FishFeeder();

        for(TropicalFish tropicalFish : fishies){
            fishFeeder.addObserver(tropicalFish);
        }

        System.out.println("We are feeding the fish.");
        fishFeeder.feedFish(5);

    }
}
