public class ComplexityAnalyzer {

    public static String analyze(String code){

        int loops = 0;

        if(code.contains("for(") || code.contains("for ("))
            loops++;

        if(code.contains("while(") || code.contains("while ("))
            loops++;

        if(code.indexOf("for") != code.lastIndexOf("for"))
            loops++;

        if(loops == 0)
            return "O(1)";

        if(loops == 1)
            return "O(n)";

        if(loops == 2)
            return "O(n^2)";

        return "O(n^3)";
    }
}