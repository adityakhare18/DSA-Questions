class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peekLast() > ch) {
                stack.pollLast();
                k--;
            }
            stack.offerLast(ch);
        }

        //edge case like remove those ele which can't be removed due to stack containing numbers in scending order like 123456 then in below loop removing 456
        while (k-- > 0 && !stack.isEmpty()) {
            stack.pollLast();
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }

        // remove leading 0 from ans
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
