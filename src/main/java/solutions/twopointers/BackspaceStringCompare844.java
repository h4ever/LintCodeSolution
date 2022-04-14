package solutions.twopointers;

public class BackspaceStringCompare844 {
    public static boolean backspaceCompare(String S, String T) {
        return typedIntoEditor(S).equals(typedIntoEditor(T));
    }

    public static  String typedIntoEditor(String S){
        StringBuilder textS = new StringBuilder();
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='#'){
                if(textS.length()>0) textS.deleteCharAt(textS.length()-1);
            }else{
                textS.append(S.charAt(i));
            }
        }
        return textS.toString();
    }

    public static  String typedIntoEditorBack(String S){
        StringBuilder textS = new StringBuilder();
        int i=S.length()-1, back = 0;
        while(i>=0){
            while (i >= 0 && (back > 0 || S.charAt(i) == '#')) {
                back += S.charAt(i)  == '#' ? 1 : -1;
                i--;
            }
            textS.insert(0,S.charAt(i--));
        }

        return textS.toString();
    }

    public static void main(String[] args) {
        System.out.println(typedIntoEditorBack("bxj##tw"));
        System.out.println(typedIntoEditorBack("bxo#j##tw"));
    }
}
