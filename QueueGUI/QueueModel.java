package Model;
import javax.swing.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
public class QueueModel {
    private Queue<Integer> queue;

    public QueueModel(){
        this.queue = new LinkedList<>();
        try {
            File contents = new File("contents.txt");
            contents.createNewFile();
            } catch (IOException e){
                e.printStackTrace();
        }
    }

    public Queue<Integer> getQueue() {
        return queue;
    }

    public static void save(Queue<Integer> queue) {
        try (Writer w = new FileWriter("contents.txt")) {
            for (int value : queue) {
                w.write(String.valueOf(value));
                w.write("\n");
            }
            w.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Queue<Integer> load() {
        Queue<Integer> queue = new LinkedList<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader("contents.txt"))) {
            while ((line = reader.readLine()) != null) {
                queue.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return queue;
    }

    public boolean isEmpty(){
        if(queue.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public void enqueue(Object toAdd){
        if (toAdd instanceof Integer) {
            String dumbString = toAdd.toString();
            queue.add(Integer.parseInt(dumbString));
        }else{
            System.out.println("Please enter an int");
        }
    }

    public void dequeue(){
        queue.poll();
    }

    public int peek(){
        return queue.peek();
    }

    public void clear(){
        queue.clear();
    }

}
