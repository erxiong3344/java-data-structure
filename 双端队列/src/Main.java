import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Deque<Integer> queue = new Deque<>();

        queue.enQueueFront(11);
        queue.enQueueFront(22);
        queue.enQueueRear(33);
        queue.enQueueRear(44);
        while(!queue.isEmpty())
        {
            System.out.println(queue.deQueueRear());
        }



    }
}
