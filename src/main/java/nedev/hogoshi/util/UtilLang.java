package nedev.hogoshi.util;

public class UtilLang {

    public static String pluralRu(int count, String form1, String form2, String form3) {
        count = Math.abs(count) % 100;
        int count1 = count % 10;
        return count > 10 && count < 20 ? form3 : (count1 > 1 && count1 < 5 ? form2 : (count1 == 1 ? form1 : form3));
    }

    public static String pluralRu(double d, String form1, String form2, String form3) {
        return UtilLang.pluralRu((int)d, form1, form2, form3);
    }

}
