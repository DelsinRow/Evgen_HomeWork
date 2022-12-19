package some_code_from_meeting;

class Class1 {
    public void fooClass1(){};
    public int val1;
}

public class OuterClass {

    public void fooOuterClass(){};
    public void setValOuter(int value) {
        this.valOuter = value;
    }
    public int valOuter = 0;

    class Class2 extends Class1 {

        private OuterClass outerClass;

        public Class2() {
            outerClass = OuterClass.this;
        }

        public void fooClass2(int newInt) {
            outerClass.valOuter = newInt;
//            outerClass.setValOuter(newInt);
//            setValOuter(newInt);
        }
    }

//    Class2 class2 = new Class2();


    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        System.out.println(outerClass.valOuter);

        OuterClass.Class2 class2 = outerClass.new Class2();
        class2.fooClass2(123);

        System.out.println(outerClass.valOuter);
    }

}


