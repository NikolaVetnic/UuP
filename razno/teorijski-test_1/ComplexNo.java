class ComplexNoTest {
  public static void main(String[] args) {
    ComplexNo c1 = new ComplexNo();
    c1.name = "c1";
    c1.re   = 1;
    c1.im   = 1;
    ComplexNo.println(c1);
    
    ComplexNo c2 = new ComplexNo("c2", 2, 2);
    ComplexNo.println(c2);
    
    ComplexNo c3 = ComplexNo.input();
    ComplexNo c3Con = ComplexNo.conjugate(c3);
    
    ComplexNo c4 = ComplexNo.multiply("c4", c1, c2);
    ComplexNo c5 = ComplexNo.add("c5", c2, c3);
  }
}

class ComplexNo {
  // class fields
  double re, im;
  String name;
  
  public ComplexNo() {
    // constructor, no parameters
  }
  
  public ComplexNo(String name, double re, double im) {
    // constructor, with parameters
    this.name = name;
    this.re = re;
    this.im = im;
  }
  
  static ComplexNo input() {
    // complex number creation by inputting parameters
    String name = Svetovid.in.readLine("Name: ");
    double re   = Svetovid.in.readInt("Real: ");
    double im   = Svetovid.in.readInt("Imag: ");
    ComplexNo c = new ComplexNo(name, re, im);
    ComplexNo.println(c);
    return c;
  }
  
  static void print(ComplexNo c) {
    // complex number printout
    System.out.print(c.name + " = " + c.re + " + " + c.im + "i");
  }
  
  static void println(ComplexNo c) {
    // complex number printout with new line
    System.out.println(c.name + " = " + c.re + " + " + c.im + "i");
  }
  
  static ComplexNo add(String name, ComplexNo c1, ComplexNo c2) {
    // complex number addition
    ComplexNo cRes = new ComplexNo();
    cRes.name = name;
    cRes.re   = c1.re + c2.re;
    cRes.im   = c1.im + c2.im;
    System.out.println(cRes.name + " = (" + c1.re   + " + " + c1.im   + "i) + (" 
                                          + c2.re   + " + " + c2.im   + "i) = " 
                                          + cRes.re + " + " + cRes.im + "i");
    return cRes;
  }
  
  static ComplexNo multiply(String name, ComplexNo c1, ComplexNo c2) {
    // complex number multiplication
    ComplexNo cRes = new ComplexNo();
    cRes.name = name;
    cRes.re   = c1.re * c2.re;
    cRes.im   = c1.im * c2.im;
    System.out.println(cRes.name + " = (" + c1.re   + " + " + c1.im   + "i) * (" 
                                          + c2.re   + " + " + c2.im   + "i) = " 
                                          + cRes.re + " + " + cRes.im + "i");
    return cRes;
  }
  
  static ComplexNo conjugate(ComplexNo c) {
    ComplexNo cRes = new ComplexNo(c.name + ".conjugate", c.re, -c.im);
    ComplexNo.println(cRes);
    return cRes;
  }
}