import java.util.*;

public class 햄버거_만들기 {
    public int solution(int[] ingredient) {
        int[] order = {1, 3, 2, 1};
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ingredient.length; i++) {
            stack.push(ingredient[i]);
            
            if (stack.size() >= 4) {
                boolean flag = true;
                for (int j = 0; j < 4; j++) {
                    if (stack.get(stack.size() - 1 - j) != order[j]) {
                        flag = false;
                        break;
                    }
                }
                
                if (flag) {
                    answer++;
                    for (int j = 0; j < 4; j++) {
                        stack.pop();
                    }
                }
            }
        }
        
        return answer;
    }
}
