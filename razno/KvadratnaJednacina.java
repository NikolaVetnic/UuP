class KvadratnaJednacina {
  public static void main(String[] args) {
    Svetovid.out.print("Unesite koeficijente kvadratne jednacine: ");
    double a = Svetovid.in.readDouble(),
           b = Svetovid.in.readDouble(),
           c = Svetovid.in.readDouble();
    
    double x1, x2, y1, y2;
    double d = b * b - 4 * a * c;
    
    if (a > 0) {
      if (d > 0) {
        x1 = (-b + Math.sqrt(d)) / (2 * a);
        x2 = (-b - Math.sqrt(d)) / (2 * a);
        Svetovid.out.println("Resenja su realna i razlicita:");
        Svetovid.out.println("x1 = " + x1 + "; x2 = " + x2 + ". ");
      }
      else if (d == 0) {
        x1 = -b / (2 * a);
        Svetovid.out.println("Dvostruko realno resenje:");
        Svetovid.out.println("x1/2 = " + x1 + ". ");
      }
      else {
        x1 = -b / (2 * a);
        y1 = Math.sqrt(-d) / (2 * a);
        x2 = x1;
        y2 = -y1;
        Svetovid.out.println("Kompleksni koreni su:");
        Svetovid.out.println("(" + String.format("%.2f", x1) + ", " + String.format("%.2f", y1) + ")"); 
        Svetovid.out.println("(" + String.format("%.2f", x2) + ", " + String.format("%.2f", y2) + ")");
      }
    }
    else if (a == 0) {
      x1 = -b / c;
      Svetovid.out.println("Jednacina je linearna sa resenjem: x = " + String.format("%.2f", x1));
    }
    else if (a == 0 && b == 0) {
      Svetovid.out.println("Resenje ne postoji.");
    }
    
    
  }
}