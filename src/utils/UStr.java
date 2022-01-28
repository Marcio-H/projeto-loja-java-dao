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
    
    public static UStr create(String str){
        UStr create = new UStr();
        
        create.setStr(str);
        return create;
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

    private void setStr(String str) {
        this.str = str;
    }
}
