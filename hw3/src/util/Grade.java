package util;

public enum Grade {
    /*
    Bu enum tipi, bir öğrencinin notunu temsil eder ve A, B, C, D, F notlarını içerir.
    Aşağıdaki sabitler kullanılacak: Grade.A, Grade.B, Grade.C, Grade.D, Grade.F
    Grade sınıfı, stringValue ve numericValue adında iki instance alanı içermelidir.
    stringValue, harf notunun bir String temsilini içermelidir, örneğin "C", "A".
    numericValue, harf notuna karşılık gelen sayısal notu içermelidir ve A, B, C, D ve F için sırasıyla 4, 3, 2, 1 ve 0 olmalıdır.
    Bu sınıf için toString() metodu uygulanmalıdır. Örneğin, Grade.F için şöyle yazdırılmalıdır: "Grade F, sayısal notu 0'a karşılık gelir."
    Şartlarını sağlayacak şekilde "Grade" isimli Enum class oluşturulmuştur.
     */
    A("A", 4), B("B", 3), C("C", 2), D("D", 1), F("F", 0);

    private String stringValue;
    private int numericValue;

    private Grade(String stringValue, int numericValue) {
        this.stringValue = stringValue;
        this.numericValue = numericValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public int getNumericValue() {
        return numericValue;
    }

    @Override
    public String toString() {
        return "Grade " + stringValue + " corresponds to numeric grade " + numericValue;
    }
}

