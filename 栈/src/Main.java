//栈的应用:通过两个栈实现浏览器的前进和后退功能
//1.一个栈X,一个栈Y
//2.将新刷新的界面压入栈X中,清空栈Y;点击后退按钮，弹出栈X
//栈顶元素,压入栈Y;点击前进按钮,弹出栈Y栈顶元素,压入栈X
public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(11);
        stack.push(22);
        stack.push(33);
        stack.push(44);
        while(!stack.isEmpty())
        {
            System.out.println(stack.pop());
        }
    }
}



