
public class GenPage {

    static int counter = 1;

    public static void create_root(String q, String a) {

        System.out.println("<div data-comment=\"root\">");

        System.out.println("<button class=\"accordion\" data-comment=\"question\">");
        System.out.println((counter++) + ") " + q.trim());
        System.out.println("</button>");
        System.out.println("<div class=\"panel\">");
        System.out.println("<hr>");
        System.out.println("<p data-comment=\"answer\">");
        System.out.println(a);
        System.out.println("</p>");

        System.out.println("</div>");
        System.out.println("</div>");
    }
}
