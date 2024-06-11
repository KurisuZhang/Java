public class ReverseSentence {
    
    public static void main(String[] args) {
        String s = "i love programming very much";
        String output = reverseSentence(s);
        System.out.println(output);
    }

    public static String reverseSentence(String s) {
        String[] strArray = s.split(" ");
        StringBuilder sb = new StringBuilder();
        
        for (int i = strArray.length - 1; i >= 0; i--) {
            sb.append(strArray[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}