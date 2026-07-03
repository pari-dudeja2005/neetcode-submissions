

class MinStack {

    Stack<Long> st;
    long min;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int val) {
        if (st.isEmpty()) {
            st.push((long) val);
            min = val;
        } else if (val >= min) {
            st.push((long) val);
        } else {
            st.push(2L * val - min);   // encoded value
            min = val;
        }
    }

    public void pop() {
        long top = st.pop();

        if (top < min) {
            min = (int) (2L * min - top);      // restore previous minimum
        }
    }

    public int top() {
        long top = st.peek();

        if (top < min)
            return (int) min;               // encoded value means actual top is min

        return (int) top;
    }

    public int getMin() {
        return (int) min;
    }
}