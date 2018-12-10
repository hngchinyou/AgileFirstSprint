/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery;

import com.sun.jmx.remote.util.OrderClassLoaders;
import java.sql.Timestamp;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import entity.Order;
import entity.OrderList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * @author Chin You
 */
public class ViewOrderListV3 {

    /**
     * @param args the command line arguments
     */
    public static void Deliverymain(List<OrderList> orderList) {
        // TODO code application logic here
        char result;
        Scanner sc = new Scanner(System.in);

        List<Order> orderItem = new ArrayList<>();
        List<Order> orderItem2 = new ArrayList<>();
        List<OrderList> orderList1 = viewOrderList(true, orderList);

        do {
            System.out.println("Please select your option"
                    + "\n1) View Order of today"
                    + "\n2) Indicate specific order"
                    + "\n3) View route"
                    + "\n4) Exit");
            result = sc.next().charAt(0);
            if (result == '1') {
                viewOrderList(false, orderList);
            } else if (result == '2') {
                indicateOrder(orderList);
            } else if (result == '3') {
                sortRoute(orderList);
            }
        } while (result != '4');
    }

    public static List<OrderList> viewOrderList(boolean valid, List<OrderList> orderList) {

        // List<OrderList> orderList = new ArrayList<>();
        try {

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date date = sdf.parse("9/12/2018");
            Date pickUpDate = sdf.parse("9/12/2018");
            Date todayDate = new Date();
            int count = 0;

            todayDate = sdf.parse(sdf.format(new Date()));

            //    addOrder(orderItem, todayDate, orderItem2, orderList, pickUpDate);
            if (!valid) {
                System.out.println("Displaying order list of the day");

                int a = 0;

                for (OrderList ol : orderList)//displaying order list of today
                {
                    if (ol.getPickUpDate().compareTo(todayDate) == 0 && ol.getCollectMethod().equals("Delivery")) {
                        System.out.println(ol.toString(++a));
                    } else {
                        count++;
                    }
                }
            }
            if (count == orderList.size() && !valid)//displaying message if no order list today
            {
                System.out.println("There are no available order list today");
            }

        } catch (ParseException ex) {
            Logger.getLogger(ViewOrderListV3.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderList;
    }//end of retrieving

    private static void addOrder(List<Order> orderItem, Date todayDate, List<Order> orderItem2, List<OrderList> orderList, Date pickUpDate) {
//        orderItem.add(new Order("1", 3, todayDate, 12.34));
//        orderItem.add(new Order("2", 1, todayDate, 54.32));
//        orderItem.add(new Order("3", 6, todayDate, 22.34));
//        orderItem2.add(new Order("4", 6, todayDate, 22.34));
//        orderItem2.add(new Order("5", 6, todayDate, 22.34));
//        orderItem2.add(new Order("6", 6, todayDate, 22.34));
//
//        orderList.add(new OrderList(orderItem, "Or0001", todayDate, "Delivery", "setapak", "Pv13", "Cn0001", "Processing"));//hardcoding order list 1
//        orderList.add(new OrderList(orderItem, "Or0002", todayDate, "Delivery", "setapak", "Pv13", "Cr0001", "Processing"));//hardcoding order list 1
//        orderList.add(new OrderList(orderItem, "Or0003", pickUpDate, "Delivery", "cheras", "Pv13", "Cr0001", "Processing"));//hardcoding order list 1
//        orderList.add(new OrderList(orderItem, "Or0003", todayDate, "Delivery", "gombak", "Pv13", "Cr0001", "Processing"));//hardcoding order list 1
//        orderList.add(new OrderList(orderItem, "Or0003", pickUpDate, "Delivery", "subang", "Pv13", "Cr0001", "Processing"));//hardcoding order list 1
//        orderList.add(new OrderList(orderItem, "Or0003", todayDate, "Delivery", "gombak", "Pv13", "Cr0001", "Processing"));//hardcoding order list 1
    }

    public static void indicateOrder(List<OrderList> orderList) {
        Date date = new Date();
        long time = date.getTime();
        List<OrderList> orderProcessingList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int reply;
        int count = 0;
        double pay;
        String exit = "";
        double change;
        String cusId;

        Timestamp ts = new Timestamp(time);
        int a = 0;
        do {

            System.out.println("Which customer's order do you want to indicate? Please enter ID: ");
            cusId = sc.next();

            customerOrder(orderList, orderProcessingList, cusId, count, a);

            if (orderProcessingList.isEmpty()) {
                System.out.println("This id is invalid or it does not has processing order");
            }

        } while (orderProcessingList.isEmpty());

        do {
            // System.out.println(count);//ask user to choose order to indicate
            System.out.print("Which order do you want to indicate? \nOrder ");//ask user to choose order to indicate

            while (!sc.hasNextInt()) {
                sc.next();
                System.out.println("Please enter number only: ");
            }
            reply = sc.nextInt() - 1;

            if (!(reply >= orderProcessingList.size()) && !(reply < 0)) {
                if (!(orderProcessingList.get(reply).getStatus().equals("Processing"))) {
                    System.out.println("The order is not exist");
//                    sc.next();
                } else {
//                    count++;
                }
            } else {
                System.out.println("The order is not exist");
//                sc.next();0
            }
        } while ((reply + 1) > orderProcessingList.size());
//          for (int i = 0; i < orderList.size(); i++)//find order requested by user
//         {
//        if (orderList.get(reply).getOrderList().get(reply)) {

        System.out.println("\n" + orderProcessingList.get(reply).getOrderList());
        System.out.println("\nThe price is RM " + String.format("%.2f", orderProcessingList.get(reply).calcTotalPrice(orderProcessingList.get(reply).getOrderList())) + ".\n");
        if (orderProcessingList.get(reply).getCustId().substring(0, 2).toLowerCase().equals("cn")) {
            System.out.print("Please enter your payment amount: RM "
                    + ""
                    + "");
            while (!sc.hasNextInt() && !sc.hasNextDouble()) {
                sc.next();
                System.out.println("Please enter number only: ");
            }
            pay = sc.nextDouble();

            while (pay < orderProcessingList.get(reply).calcTotalPrice(orderProcessingList.get(reply).getOrderList())) {
                System.out.println("Insufficient money, please reenter!");
                while (!sc.hasNextInt() && !sc.hasNextDouble()) {
                    sc.next();
                    System.out.println("Please enter number only: ");
                }
                pay = sc.nextDouble();
            }

            change = pay - orderProcessingList.get(reply).calcTotalPrice(orderProcessingList.get(reply).getOrderList());

            for (OrderList aa : orderList) {
                if (aa.getId().equals(orderProcessingList.get(reply).getId())) {
                    aa.setStatus("Completed");
                    aa.setPickUpDate(ts);
                }
            }
            System.out.println("\nYour change is RM " + String.format("%.2f", change) + ". Thank you for coming!\n==============================================");
        } else {
            for (OrderList aa : orderList) {
                if (aa.getId().equals(orderProcessingList.get(reply).getId())) {
                    aa.setStatus("Completed");
                    aa.setPickUpDate(ts);
                    System.out.println("Thank you for coming!\n==============================================");
                }
            }
        }
        int b = 0;
        System.out.println(orderList.get(reply).getOrderList());
        System.out.println("Order status= " + orderList.get(reply).getStatus());
        System.out.println("Collected time= " + orderList.get(reply).getPickUpDate());
        //  }
        //  }
//        indicateOrder(orderList, orderItem);

    }//end of indicating

    public static List customerOrder(List<OrderList> orderList, List<OrderList> orderProcessingList, String cusId, int count, int a) {

        for (OrderList aa : orderList) {
            if (aa.getCustId().toLowerCase().equals(cusId.toLowerCase()) && aa.getStatus().equals("Processing")) {

                //alltotal+=aa.getAllTotal();
                ++a;
                System.out.print(aa.toString(a));
                count++;
                orderProcessingList.add(aa);
                //alltotal += aa.calcAllOrder(orderList, "Cr0001", arrOrder);
            }
        }
        return orderProcessingList;
    }

    public static void sortRoute(List<OrderList> orderList) {
        try {
            int vertices = 4;
            Graph graph = new Graph(vertices);
            int setapak = 0, cheras = 0, gombak = 0, subang = 0;
            int sc = 0, sg = 0;
            int cs = 0, cg = 0;
            int gs = 0, gc = 0;
            String input;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Queue routeQueue = new ArrayBlockingQueue<>(100);
            Date date = new Date();
            date = sdf.parse(sdf.format(new Date()));
            for (OrderList ol : orderList) {
               
                if (ol.getArea().toLowerCase().equals("setapak")
                        && ol.getStatus().equals("Processing") && ol.getCollectMethod().equals("Delivery")
                        && ol.getPickUpDate().compareTo(date) == 0) {
                    setapak++;

                } else if (ol.getArea().toLowerCase().equals("gombak") && ol.getStatus().equals("Processing")
                        && ol.getCollectMethod().equals("Delivery")
                        && ol.getPickUpDate().compareTo(date) == 0) {
                    gombak++;

                } else if (ol.getArea().toLowerCase().equals("cheras") && ol.getStatus().equals("Processing")
                        && ol.getCollectMethod().equals("Delivery")
                        && ol.getPickUpDate().compareTo(date) == 0) {
                    cheras++;

                } else if (ol.getArea().toLowerCase().equals("subang") && ol.getStatus().equals("Processing")
                        && ol.getCollectMethod().equals("Delivery")
                        && ol.getPickUpDate().compareTo(date) == 0) {
                    subang++;

                }
            }
//        setapakRoute(setapak, routeQueue, cheras, graph, gombak, subang);
//        gombakRoute(gombak, routeQueue, cheras, graph, subang, setapak);
//        cherasRoute(cheras, routeQueue, subang, graph, setapak, gombak);
//        subangRoute(subang, routeQueue, setapak, graph, cheras, gombak);
        
            System.out.print("There are ");
            if (setapak != 0 || gombak != 0 || cheras != 0 || subang != 0) {
                if (setapak != 0) {
                    System.out.print("\n" + setapak + " order(s) from Setapak \n");
                }
                if (gombak != 0) {
                    System.out.print("\n" + gombak + " order(s) from Gombak \n");
                }
                if (cheras != 0) {
                    System.out.print("\n" + cheras + " order(s) from Cheras \n");
                }
                if (subang != 0) {
                    System.out.print("\n" + subang + " order(s) from Subang\n");
                }
            } else {
                System.out.print("no order today\n");
            }
            if (setapak != 0) {
                getSetapakOrder(orderList);
            }
            if (cheras != 0) {
                getCherasOrder(orderList);
                if (gombak != 0) {
                    getGombakOrder(orderList);
                    if (subang != 0) {
                        getSubangOrder(orderList);
                    }
                } else {
                    getSubangOrder(orderList);
                }
            } else if (gombak != 0) {
                getGombakOrder(orderList);
                if (subang != 0) {
                    getSubangOrder(orderList);
                }
            } else if (subang != 0) {
                getSubangOrder(orderList);
            }
        } catch (ParseException ex) {
            Logger.getLogger(ViewOrderListV3.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void getSetapakOrder(List<OrderList> orderList) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            date = sdf.parse(sdf.format(new Date()));
            System.out.println("======================\nSetapak");
            for (OrderList ol : orderList) {
                if (ol.getArea().toLowerCase().equals("setapak") && ol.getStatus().equals("Processing")
                        && ol.getCollectMethod().equals("Delivery") && ol.getPickUpDate().compareTo(date)==0) {
                    
                    System.out.println(ol.getCustId());
                    System.out.println(sdf.format(ol.getPickUpDate()));
                    System.out.println(String.format("RM %.2f", ol.calcTotalPrice(ol.getOrderList())));
                }
            }
            System.out.println("======================\n");
        } catch (ParseException ex) {
            Logger.getLogger(ViewOrderListV3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void getGombakOrder(List<OrderList> orderList) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            date = sdf.parse(sdf.format(new Date()));
            System.out.println("======================\nGombak");
            for (OrderList ol : orderList) {
                if (ol.getArea().toLowerCase().equals("gombak") && ol.getStatus().equals("Processing")
                        && ol.getCollectMethod().equals("Delivery") && ol.getPickUpDate().compareTo(date)==0) {
                    
                    System.out.println(ol.getCustId());
                    System.out.println(sdf.format(ol.getPickUpDate()));
                    System.out.println(String.format("RM %.2f", ol.calcTotalPrice(ol.getOrderList())));
                }
            }
            System.out.println("======================\n");
        } catch (ParseException ex) {
            Logger.getLogger(ViewOrderListV3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void getSubangOrder(List<OrderList> orderList) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            
            date = sdf.parse(sdf.format(new Date()));
            System.out.println("======================\nSubang");
            for (OrderList ol : orderList) {
                if (ol.getArea().toLowerCase().equals("subang") && ol.getStatus().equals("Processing")
                        && ol.getCollectMethod().equals("Delivery") && ol.getPickUpDate().compareTo(date)==0) {
                    
                    System.out.println(ol.getCustId());
                    System.out.println(sdf.format(ol.getPickUpDate()));
                    System.out.println(String.format("RM %.2f", ol.calcTotalPrice(ol.getOrderList())));
                }
            }
            System.out.println("======================\n");
        } catch (ParseException ex) {
            Logger.getLogger(ViewOrderListV3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void getCherasOrder(List<OrderList> orderList) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            date = sdf.parse(sdf.format(new Date()));
            System.out.println("======================\nCheras");
            for (OrderList ol : orderList) {
                if (ol.getArea().toLowerCase().equals("cheras") && ol.getStatus().equals("Processing")
                        && ol.getCollectMethod().equals("Delivery") && ol.getPickUpDate().compareTo(date)==0) {
                    
                    System.out.println(ol.getCustId());
                    System.out.println(sdf.format(ol.getPickUpDate()));
                    System.out.println(String.format("RM %.2f", ol.calcTotalPrice(ol.getOrderList())));
                }
            }
            System.out.println("======================\n");
        } catch (ParseException ex) {
            Logger.getLogger(ViewOrderListV3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    
//    private static void subangRoute(int subang, Queue routeQueue, int setapak, Graph graph, int cheras, int gombak) {
//        if (subang != 0) {
//            int setapakWeight = 0, cherasWeight = 0, subangWeight = 0, gombakWeight = 0;
//            String destination = "";
//            if (setapak != 0) {
//                graph.addEdge(3, 0, 6);
//                setapakWeight = 6;
//            }
//            if (cheras != 0) {
//                graph.addEdge(3, 2, 2);
//                cherasWeight = 2;
//            }
//            if (gombak != 0) {
//                graph.addEdge(3, 1, 3);
//                gombakWeight = 3;
//            }
//
//            if((calcEfficientRoute(setapakWeight, cherasWeight, gombakWeight, subangWeight) == 2))
//            {
//                destination = "Cheras";
//            }
//            else if(calcEfficientRoute(setapakWeight, cherasWeight, gombakWeight, subangWeight) == 3)
//            {
//                destination = "Gombak";
//            }
//            else if(calcEfficientRoute(setapakWeight, cherasWeight, gombakWeight, subangWeight) == 6)
//            {
//                destination = "Setapak";
//            }
//            System.out.println("Most efficient route from Subang: " + destination);
//        }
//    }
//
//    private static void cherasRoute(int cheras, Queue routeQueue, int subang, Graph graph, int setapak, int gombak) {
//        if (cheras != 0) {
//            int setapakWeight = 0, cherasWeight = 0, subangWeight = 0, gombakWeight = 0;
//            String destination = "";
//            if (subang != 0) {
//                graph.addEdge(2, 3, 2);
//                subangWeight = 2;
//            }
//            if (setapak != 0) {
//                graph.addEdge(2, 0, 3);
//                setapakWeight = 3;
//            }
//            if (gombak != 0) {
//                graph.addEdge(2, 1, 5);
//                gombakWeight = 5;
//            }
//            
//            if(calcEfficientRoute(setapakWeight, cherasWeight, gombakWeight, subangWeight) == 3)
//            {
//                destination = "Gombak";
//            }
//            else if(calcEfficientRoute(setapakWeight, cherasWeight, gombakWeight, subangWeight) == 2)
//            {
//                destination = "Subang";
//            }
//            else if(calcEfficientRoute(setapakWeight, cherasWeight, gombakWeight, subangWeight) == 6)
//            {
//                destination = "Setapak";
//            }
//            System.out.println("Most efficient route from Cheras: " + destination);
//
//        }
//    }
//
//    private static void gombakRoute(int gombak, Queue routeQueue, int cheras, Graph graph, int subang, int setapak) {
//        if (gombak != 0) {
//            int setapakWeight = 0, cherasWeight = 0, subangWeight = 0, gombakWeight = 0;
//            String destination = "";
//            if (cheras != 0) {
//                graph.addEdge(1, 2, 5);
//                cherasWeight = 5;
//            }
//            if (subang != 0) {
//                graph.addEdge(1, 3, 3);
//                subangWeight = 3;
//            }
//            if (setapak != 0) {
//                graph.addEdge(1, 0, 4);
//                setapakWeight = 4;
//            }
//            
//            if(calcEfficientRoute(setapakWeight, cherasWeight, gombakWeight, subangWeight) == 3)
//            {
//                destination = "Subang";
//            }
//            else if(calcEfficientRoute(setapakWeight, cherasWeight, gombakWeight, subangWeight) == 4)
//            {
//                destination = "Setapak";
//            }
//            else if(calcEfficientRoute(setapakWeight, cherasWeight, gombakWeight, subangWeight) == 5)
//            {
//                destination = "Cheras";
//            }
//            System.out.println("Most efficient route from Gombak: " + destination);
//        }
//    }
//
//    private static void setapakRoute(int setapak, Queue routeQueue, int cheras, Graph graph, int gombak, int subang) {
//        if (setapak != 0) {
//            int setapakWeight = 0, cherasWeight = 0, subangWeight = 0, gombakWeight = 0;
//            String destination = "";
//            if (cheras != 0) {
//                graph.addEdge(0, 2, 3);
//                cherasWeight = 3;
//            }
//            if (gombak != 0) {
//                graph.addEdge(0, 1, 4);
//                gombakWeight = 4;
//            }
//            if (subang != 0) {
//                graph.addEdge(0, 3, 6);
//                subangWeight = 6;
//            }
//            if(calcEfficientRoute(setapakWeight, cherasWeight, gombakWeight, subangWeight) == 3)
//            {
//                destination = "Cheras";
//            }
//            else if(calcEfficientRoute(setapakWeight, cherasWeight, gombakWeight, subangWeight) == 4)
//            {
//                destination = "Gombak";
//            }
//            else if(calcEfficientRoute(setapakWeight, cherasWeight, gombakWeight, subangWeight) == 6)
//            {
//                destination = "Subang";
//            }
//            System.out.println("Most efficient route from Setapak: " + destination);
//        }
//    }
//
//    private static void isVisited(String destination, Queue routeQueue)
//    {
//        if (routeQueue == null) {
//            routeQueue.add(destination);
//        }
//
//        int size = routeQueue.size();
//
//        for (int i = 0; i < size; i++) {
//            if (routeQueue.remove().equals(destination)) {
//                routeQueue.add(routeQueue.remove());
//            } else {
//                
//                routeQueue.add(destination);
//            }
//        }
//    }
    static class Edge {

        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {

        int vertices;
        LinkedList<Edge>[] adjacencylist;

        Graph(int vertices) {
            this.vertices = vertices;
            adjacencylist = new LinkedList[vertices];
            //initialize adjacency lists for all the vertices
            for (int i = 0; i < vertices; i++) {
                adjacencylist[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            adjacencylist[source].addFirst(edge); //for directed graph
        }

        public int getWeight(int source, int destination) {
            int weight = 0;
            for (Edge e : adjacencylist[source]) {
                if (e.destination == destination) {
                    weight = e.weight;
                }
            }
            return weight;
        }

//        public void printGraph(Queue q1) {
//            String[] address = new String[]{"Setapak", "Gombak", "Cheras", "Subang"};
//                    System.out.println("The most efficient route is ");
//            for (int i = 0; i < vertices; i++) {
//                LinkedList<Edge> list = adjacencylist[i];
//                for (int j = 0; j < q1.size(); j++) {
//                    System.out.println(address[(int)q1.remove()]);
//                }
//            }
//        }
        public void printGraph() {
            for (int i = 0; i < vertices; i++) {
                LinkedList<Edge> list = adjacencylist[i];
                for (int j = 0; j < list.size(); j++) {
                    System.out.println("vertex-" + i + " is connected to "
                            + list.get(j).destination + " with weight " + list.get(j).weight);
                }
            }
        }

    }

    public static int calcEfficientRoute(int setapakRoute, int cherasRoute, int gombakRoute, int subangRoute) {
        int efficientRoute = 0;
        Integer[] allWeights = new Integer[]{setapakRoute, cherasRoute, gombakRoute, subangRoute};
        Arrays.sort(allWeights, Collections.reverseOrder());
        for (int i = 0; i < allWeights.length; i++) {
            if (allWeights[i] != 0) {
                efficientRoute = allWeights[i];
            }
        }
        return efficientRoute;
    }
}
