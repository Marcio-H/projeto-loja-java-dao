package utils;

public class UStr {
    
    private String str;
    
    public static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
    
    public static String removePackageFromName(String name) {
        int lastPoint = name.lastIndexOf(".");
        
        return name.substring(lastPoint + 1);
    }
    
    public static String toLower(String str) {
        return str.toLowerCase();
    }
    
    public static UStr create(String str){
        UStr create = new UStr();
        
        create.setStr(str);
        return create;
    }
    
    public UStr toLower() {
        str = toLower(str);
        return this;
    }
    
    public UStr capitalize() {
        str = capitalize(str);
        return this;
    }
    
    public UStr removePackageFromName() {
        str = removePackageFromName(str);
        return this;
    }

    public String get() {
        return str;
    }

    public static StringBuilder convertCameoCase(String str) {
        StringBuilder strBuilder = new StringBuilder();
        boolean novaPalavra = false;

        for (char letter : str.toCharArray()) {
            if (Character.isUpperCase(letter) && novaPalavra) {
                strBuilder.append("_");
                novaPalavra = false;
            } else {
                novaPalavra = true;
            }
            strBuilder.append(Character.toLowerCase(letter));
        }
        return strBuilder;
    }

    private void setStr(String str) {
        this.str = str;
    }
}
