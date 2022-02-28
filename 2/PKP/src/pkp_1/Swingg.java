package pkp_1;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Swingg extends JFrame{

    static DefaultTableModel model;
    private static DefaultTableModel model2;
    static List<TrainStation> listOfTrainStations;
    JComboBox<String> listOfTrains;

    public static void trainTable(int rowCount, String stationName){
        model2 = new DefaultTableModel();
        TrainStation current = null;

        for(TrainStation train : listOfTrainStations){
            if(train.getName().equals(stationName))
                current = train;
        }
        //OKNO Z LISTA POCIAGOW
        JFrame frame = new JFrame();
        frame.setSize(500, 350);
        frame.setVisible(true);

        JButton btnAdd = new JButton("Dodaj pociag");
        btnAdd.setBounds(10, 320, 150, 30);

        JButton btnRemove = new JButton("Usun pociag ");
        btnRemove.setBounds(170, 320, 150, 30);

        JButton btnChangeInfo = new JButton("Zmien parametry");
        btnChangeInfo.setBounds(330, 320, 150, 25);

        JTable table = new JTable();
        Object[] columns = {"Nazwa pociagu", "Stacja poczatkowa", "Stacja koncowa", "Ilosc miejsc", "Czas przejazdu"};
        model2.setColumnIdentifiers(columns);
        table.setModel(model2);

        assert current != null;
        for(Train train : current.getTrainList()){
            Object[] row = {train.getName(), train.getStart(), train.getFinish(), /*train.getStatus(),*/ train.getNumberOfPlaces() , train.getDuration()};
            model2.addRow(row);
        }
        //BIALA PRZESTRZEN
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0,0,500,300);

        frame.setLayout(null);
        frame.add(btnAdd);
        frame.add(btnRemove);
        frame.add(btnChangeInfo);
        frame.add(pane);

        TrainStation finalCurrent = current;

        //przycisk DODAWANIE POCIAGU
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int currentCapacity = Integer.parseInt(String.valueOf(model.getValueAt(rowCount, 2)));
                int maxCapacity = Integer.parseInt(String.valueOf(model.getValueAt(rowCount, 1)));
                if(currentCapacity == maxCapacity){
                    JOptionPane.showMessageDialog(null, "Brak miejsca na stacji!");
                    return;
                }
                Object[] row = new Object[5];
                row[0] = JOptionPane.showInputDialog("Wprowadź nazwę pociągu");
                row[1] = JOptionPane.showInputDialog("Wprowadź stacje poczatkowa");
                row[2] = JOptionPane.showInputDialog("Wprowadź stacje koncowa");
                row[3]  = JOptionPane.showInputDialog("Wprowadź ilosc miejsc w pociagu");
                //row[4]  = JOptionPane.showInputDialog("Wprowadź stan pociagu (DELAYED,NEW,ONTIME,FULL,CHANGED)");
                row[4]  = JOptionPane.showInputDialog("Wprowadź czas trwania przejazdu");

                String name = String.valueOf(row[0]);
                String start = String.valueOf(row[1]);
                String finish = String.valueOf((row[2]));
                // TrainStatus stan = TrainStatus.valueOf(String.valueOf(row[3]));
                int capasity = Integer.parseInt(String.valueOf(row[3]));
                int duration = Integer.parseInt(String.valueOf(row[4]));

                finalCurrent.addTrain(new Train(name, start, finish, capasity, duration));

                currentCapacity++;
                model.setValueAt(currentCapacity,rowCount,2);
                model2.addRow(row);

            }
        });
        //PRZYCISK USUWANIA POCIAGU
        TrainStation finalCurrent1 = current;
        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = table.getSelectedRow();
                if(i >= 0){
                    int currentCapacity = Integer.parseInt(String.valueOf(model.getValueAt(rowCount, 2)));
                    for(Train t : finalCurrent1.getTrainList()){
                        if(t.getName().equals(String.valueOf(model2.getValueAt(i,0))));
                        finalCurrent1.delete(t);
                        break;
                    }
                    currentCapacity--;
                    model.setValueAt(currentCapacity,rowCount,2);
                    model2.removeRow(i);

                }else{
                    JOptionPane.showMessageDialog(null,"Najpierw wybierz pociag");
                }
            }
        });
        //przycisk zmieniania danych
        TrainStation finalCurrent2 = current;
        btnChangeInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = table.getSelectedRow();
                if(i >= 0){
                    String start = String.valueOf(JOptionPane.showInputDialog("Nowa stacja poczatkowa: "));
                    String finish = String.valueOf(JOptionPane.showInputDialog("Nowa stacja koncowa: "));
                    int duration = Integer.parseInt(JOptionPane.showInputDialog("Nowy czas przejazdu "));
                    int nrOfPlaces = Integer.parseInt(JOptionPane.showInputDialog("Wpisz ilośc miejsc"));

                    model2.setValueAt(start,i, 2);
                    model2.setValueAt(finish,i, 3);
                    model2.setValueAt(nrOfPlaces,i,3);
                    model2.setValueAt(duration,i,4);

                    for(Train t : finalCurrent2.getTrainList()){
                        if(t.getName().equals(String.valueOf(model2.getValueAt(i, 0)))){
                            t.setStart(start);
                            t.setFinish(finish);
                            t.setNumberOfPlaces(nrOfPlaces);
                            t.setDuration(duration);
                        }
                    }

                }else{
                    JOptionPane.showMessageDialog(null,"Najpierw zaznacz pociag!");
                }
            }
        });
    }
    public Swingg() {

        listOfTrainStations = new ArrayList<>();
        model = new DefaultTableModel();

        JFrame frame = new JFrame();
        frame.setSize(500, 350);
        frame.setVisible(true);


        JTable table = new JTable();
        Object[] columns = new Object[]{"Nazwa stacji", "Maksymalna pojemność", "Obecna pojemność"};
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table.setModel(model);


        JButton btnAdd = new JButton("Dodaj stacje ");
        JButton btnRemove = new JButton("Usun stacje ");
        JButton btnSortStations = new JButton("Sortuj stacje");
        JButton btnShowTrainStations = new JButton("Pokaz stacje");

        listOfTrains = new JComboBox<>();
        btnAdd.setBackground(Color.PINK);
        btnRemove.setBackground(Color.BLUE);
        btnSortStations.setBackground(Color.gray);

        btnAdd.setBounds(10, 320, 150, 25);
        btnRemove.setBounds(170, 320, 150, 25);
        btnSortStations.setBounds(320, 320,150,25);
        listOfTrains.setBounds(170, 360, 150, 25);
        btnShowTrainStations.setBounds(320, 360, 150, 25);

        for(int i = 0; i < listOfTrainStations.size(); i++){
            listOfTrains.addItem(listOfTrainStations.get(i).getName());
        }

        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0,0, 500,200);

        frame.add(btnAdd);
        frame.add(btnRemove);
        frame.add(btnSortStations);
        frame.add(listOfTrains);
        frame.add(btnShowTrainStations);

        frame.add(pane);

        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.getHSBColor((float) 0.72, (float) 0.2, (float) 0.3));
        frame.setBounds(0,1,500,500);

        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] row = new Object[3];
                row[0] = JOptionPane.showInputDialog("Wpisz nazwę stacji");
                row[1] = JOptionPane.showInputDialog("Wpisz maksymalną pojemność");
                row[2] = 0;

                if(row[0].equals("") || row[1].equals("")) {
                    JOptionPane.showMessageDialog(null, "Wpisanie wartosci jest obowiazakowe");
                }else {
                    String name = String.valueOf(row[0]);
                    int max = Integer.parseInt(String.valueOf(row[1]));
                    listOfTrainStations.add(new TrainStation(name,max));
                    model.addRow(row);
                    listOfTrains.addItem(name);
                }
            }
        });
        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = table.getSelectedRow();
                if(i >= 0){
                    model.removeRow(i);
                }
                else{
                    System.out.println("Niepoprawna operacja");
                }
            }
        });
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = table.getSelectedRow();
                if(i >= 0){
                    trainTable(i, String.valueOf(model.getValueAt(i,0)));
                }
            }
        });

        btnSortStations.addActionListener(new ActionListener() {
                                              @Override
                                              public void actionPerformed(ActionEvent e) {
                                                  Comparator<TrainStation> compareByName = (TrainStation t1, TrainStation t2) -> CharSequence.compare(t1.getName(), t2.getName());

                                                  listOfTrainStations.sort(compareByName);
                                                  for(TrainStation t : listOfTrainStations){
                                                      model.removeRow(0);
                                                      Object[] row = {t.getName(), t.getMaxCapacity(), t.getTrainList().size()};
                                                      model.addRow(row);
                                                  }
                                              }
                                          }
        );


        btnShowTrainStations.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Object o = listOfTrains.getSelectedItem();
               // trainTable();
                /*for( int i = 0; i < listOfTrainStations.size(); i++){
                    if(listOfTrainStations.get(i).getName().equals(o)){
                        trainTable(i, String.valueOf(o));
                    };
                }

                 */

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


    }

    public static void main(String[] args) {
        Swingg swing = new Swingg();
    }
}


