package pkp_1;

import java.sql.Time;
import java.time.Instant;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Main {

    public static void main(String[] args)throws Exception {
       //Train train = new Train("name", "start", "finish", 100, LocalTime.parse("12:30:11"), LocalTime.parse("12:32:11"), TrainStatus.ONTIME, 2);
       //System.out.println(train);


        Train train1 = new Train("Matejko", "Krakow", "Brzeg", 12, LocalTime.parse("12:30:11"), LocalTime.parse("12:32:11"), TrainStatus.ONTIME, 2);
        Train train2 = new Train("Kossak", "Krakow", "Wroclaw", 20, LocalTime.parse("14:30:11"), LocalTime.parse("14:32:11"), TrainStatus.DELAYED, 3);
        Train train3 = new Train("Matejko", "Wladek", "Hel", 30, LocalTime.parse("18:30:11"), LocalTime.parse("18:32:11"), TrainStatus.ONTIME, 1);

        TrainStation station1 = new TrainStation("Krakow", 3);
        TrainStation station2 = new TrainStation("Wroclaw", 10);

        train1.print();
        train2.print();
        train3.print();

        //station1.compare(station1,station2);
        //porownanie nazw stacji - K
        System.out.println(station1.compare(station1,station2));


        station1.addTrain(train1);
        //for(Train train: station1.trainList){
           //train.print();
        //}
        station1.addTrain(train2);
        for(Train train: station1.trainList){
            train.print();
        }
    station1.sortByNames();

        for(Train train: station1.trainList){
            train.print();
        }


    }

}
