import java.util.*;

public class 택배_배달과_수거하기 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        Stack<Integer> dStack = new Stack<>();
        Stack<Integer> pStack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (deliveries[i] != 0) dStack.push(i);
            if (pickups[i] != 0) pStack.push(i);
        }
        
        while (!dStack.isEmpty() && !pStack.isEmpty()) {
            answer += (Math.max(dStack.peek(), pStack.peek()) + 1) * 2;
            
            int box = 0;
            while (!dStack.isEmpty() && box < cap) {
                if (box + deliveries[dStack.peek()] <= cap) {
                    box += deliveries[dStack.pop()];
                } else {
                    deliveries[dStack.peek()] -= (cap - box);
                    break;
                }
            }
            
            box = 0;
            while (!pStack.isEmpty() && box < cap) {
                if (box + pickups[pStack.peek()] <= cap) {
                    box += pickups[pStack.pop()];
                } else {
                    pickups[pStack.peek()] -= (cap - box);
                    break;
                }
            }
        }
        
        while (!dStack.isEmpty()) {
            answer += (dStack.peek() + 1) * 2;
            
            int box = 0;
            while (!dStack.isEmpty() && box < cap) {
                if (box + deliveries[dStack.peek()] <= cap) {
                    box += deliveries[dStack.pop()];
                } else {
                    deliveries[dStack.peek()] -= (cap - box);
                    break;
                }
            }
        }
        
        while (!pStack.isEmpty()) {
            answer += (pStack.peek() + 1) * 2;
            
            int box = 0;
            while (!pStack.isEmpty() && box < cap) {
                if (box + pickups[pStack.peek()] <= cap) {
                    box += pickups[pStack.pop()];
                } else {
                    pickups[pStack.peek()] -= (cap - box);
                    break;
                }
            }
        } 

        return answer;
    }
}
