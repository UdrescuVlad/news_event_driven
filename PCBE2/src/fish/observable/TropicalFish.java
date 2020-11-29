package fish.observable;

import java.util.Observable;
import java.util.Observer;

public class TropicalFish implements Observer {

    private String name;
    @Override
    public void update(Observable theObservable, Object message) {

        if(!(message.equals(null)) && message instanceof FishFeederMessage) {
            FishFeederMessage fishFeederMessage = (FishFeederMessage) message;
            System.out.printf("%s was just fed with %d pieces of food.\n",
                    getName(), fishFeederMessage.quantityOfFood);
        }
//        System.out.printf("%s was just fed.\n", getName());

    }

    public TropicalFish(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TropicalFish{" +
                "name='" + name + '\'' +
                '}';
    }
}
