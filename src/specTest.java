import java.util.Stack;

public class specTest {

    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.get(stack.size()-1));
    }
}
