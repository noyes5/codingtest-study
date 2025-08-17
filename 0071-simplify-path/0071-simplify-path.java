class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        String[] token = path.split("/");

        for (int i = 0; i < token.length; i++) {
            String now = token[i];

            if (now.equals("") || now.equals(".")) {
                continue;
            } else if (now.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(now);
            } 
        }

        String result = "/";
        List<String> stl = new ArrayList<>(stack);
        // Collections.reverse(stl);

        result = result + String.join("/", stl);

        return result;
    }
} 