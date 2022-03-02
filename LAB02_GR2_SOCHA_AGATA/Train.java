package pkp_1;
import java.sql.SQLOutput;
import java.sql.Time;
import java.time.Instant;
import java.time.LocalTime;


//zad2
public class Train implements Comparable<Train>{

    private String name;
    private String start;
    private String finish;
    private int  numberOfPlaces;
    LocalTime arrival;
    LocalTime departure;
    TrainStatus status;
    private int duration;

    //2.a konstruktor

    public Train(String name,String start, String finish, int numberOfPlaces, LocalTime arrival, LocalTime departure,  TrainStatus status,int duration){
        this.name = name;
        this.start = start;
        this.finish = finish;
        this.numberOfPlaces = numberOfPlaces;
        this.arrival = arrival;
        this.departure = departure;
        this.status = status;
        this.duration = duration;
    }

    public String getName(){ return name; }
    public String getStart(){ return start; }
    public String getFinish() { return finish; }
    public int getNumberOfPlaces() { return numberOfPlaces; }
    public LocalTime getArrival(){return arrival;}
    public LocalTime getDeparture(){return departure;}
    public TrainStatus getStatus() { return status; }

    public int getDuration() {
        return duration;
    }
    /*
    @Override
    public String toString() {
        return "Train{" +
                "name='" + name + '\'' +
                ", start='" + start + '\'' +
                ", finish='" + finish + '\'' +
                ", numberOfPlaces=" + numberOfPlaces +
                ", arrival=" + arrival +
                ", status=" + status +
                '}';
    }
 */

    //2.b
    public void print() {
        System.out.println("------Information about Train------");
        System.out.println("Name: " + this.name);
        System.out.println("Departure station: " + this.start);
        System.out.println("Destination station: "+ this.finish);
        System.out.println("Acount of places: "+ this.numberOfPlaces);
        System.out.println("Arrival Time: "+ this.arrival);
        System.out.println("Departure Time: "+ this.departure);
        System.out.println("Status"+ this.status);
    }

    //2c
    //hierarchia ilosci znakow
    @Override
    public int compareTo(Train o) {
        return this.name.compareTo(o.name);
    }
}
