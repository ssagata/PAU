package pkp_1;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.*;

public class TrainStation implements Comparator<TrainStation> {
    //3
    private String stationName;
    private int maxCapacity;
    List<Train> trainList = new ArrayList<Train>(maxCapacity);

    public TrainStation(String stationName, int maxCapacity) {
        this.stationName = stationName;
        this.maxCapacity = maxCapacity;
    }
    public String getName(){ return stationName; }
    public int getMaxCapacity(){ return maxCapacity; }

    //3a


    void addTrain(Train t1) {
        String stationName,start,finish,arrival,departure;
        int numberOfPlaces, duration;

        Scanner scanner = new Scanner(System.in);

       /* System.out.println("Station name:");
        stationName=scanner.nextLine();

        System.out.println("Number of seats:");
        numberOfPlaces = scanner.nextInt();
        System.out.println("Duration:");
        duration = scanner.nextInt();

        System.out.println("Starting station:");
        start = scanner.nextLine();

        System.out.println("Final station:");
        finish = scanner.nextLine();

        System.out.println("Arrival time:");
        arrival = scanner.nextLine();

        System.out.println("Departure time:");
        departure = scanner.nextLine();

        TrainStatus status = TrainStatus.ONTIME;

       // Train newTrain= new Train(stationName,start,finish,numberOfPlaces,LocalTime.parse(arrival),LocalTime.parse(departure),status, duration);
*/

        if(trainList.size()<maxCapacity) {
            trainList.add(t1);
        }else{

            System.err.println("Trainstation is full");
        }


    }
    //3b
    void errors(Train train){
        if(train.status ==TrainStatus.DELAYED){
            trainList.remove(train);
            System.out.println("Add train with different time: ");
            addTrain(train);
        }else if(train.status == TrainStatus.CHANGED){
            trainList.remove(train);
        }
    }

    //3c

    void delete(Train train){
        trainList.remove(train);
    }

    //3d

    @Override
    public int  compare(TrainStation o, TrainStation t){
        return o.getName().compareTo(t.getName());
    }

    //3e

    void matching(){
            String partOfName;
        System.out.println("Train: ");
        Scanner scanner = new Scanner(System.in);
        partOfName = scanner.nextLine();

        for (int  i = 0; i<trainList.size(); i++){
            if (trainList.get(i).getName().contains(partOfName)){
                trainList.get(i).print();
            }
        }
    }

    //3f

    int products(TrainStatus status){
        int couter = 0;
        for (Train train: trainList){
            if(train.getStatus().equals(status)){
                couter ++;
            }
        }
        return couter;

    }

    //3g
    public void print() {
        System.out.println("------Information about Trainstation------");
        System.out.println("Name: " + this.stationName);
        System.out.println("max Capasity: "+ this.maxCapacity);

        for(int i = 0; i<trainList.size();i++){
            trainList.get(i).print();
        }
    }

    //3h

    public void sortByNames(){
        Collections.sort(trainList);
        for (Train train : trainList){
            System.out.println(train.getName());
        }
    }

    //3i
        public void sortByNumberOfPlaces(){
            Collections.sort(trainList, new Comparator<Train>() {
                @Override
                public int compare(Train o1, Train o2) {
                    return Integer.compare(o1.getNumberOfPlaces(), o2.getNumberOfPlaces());
                }
            });
            Collections.reverse(trainList);
        }
        //3j
    //tu trzeba dodac prace na zmiennych czasowych albo dodac localdate na zwyklego inta

    public Train maxTime(){
        Train max = Collections.max(trainList, ((o1, o2) -> Integer.compare(o1.getDuration(),o2.getDuration()))
        );
        return max;
    }


}




