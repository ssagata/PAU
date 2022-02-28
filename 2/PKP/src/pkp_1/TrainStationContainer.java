package pkp_1;

import java.time.LocalTime;
import java.util.*;

public class TrainStationContainer {
    private Map<String,TrainStation> stations = new TreeMap<>();

    public Map<String, TrainStation> getStation() { return stations; }

    //4a
    void addStation(){
        int capacity;
        String name;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Station name: ");
        name = scanner.nextLine();
        System.out.println("Max Capacity: ");
        capacity = scanner.nextInt();

    }

    //4b
    void delete(String name){
        stations.remove(name);
    }
    //4c

    void emptyStations(){
        List<TrainStation> emptyStation = new ArrayList<>();
        TrainStation station;
        for(int i = 0; i< stations.size(); i++){
            if(stations.get(i).trainList.isEmpty()){
                System.out.println("Empty stations: " +stations.get(i).getName());
            }
        }
    }

    //4d

    public void print(){
        for(String station :stations.keySet()){

            System.out.println("Station: " +stations.get(station).getName());
            int i =0;
            System.out.println("Capacity: " + stations.get(i).trainList.size());
            i++;

        }

    }





}
