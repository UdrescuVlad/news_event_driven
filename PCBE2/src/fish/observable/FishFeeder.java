package fish.observable;

import java.util.Observable;

public class FishFeeder extends Observable {

    public void feedFish(int quantityOfFood){
        FishFeederMessage fishFeederMessage = new FishFeederMessage();
        fishFeederMessage.quantityOfFood = quantityOfFood;

        setChanged();
        notifyObservers(fishFeederMessage);
    }

}
