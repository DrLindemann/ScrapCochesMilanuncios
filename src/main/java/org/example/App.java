package org.example;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class App
{
    public static void main( String[] args ) {

        //URL de la web donde realizaremos el raspado de datos
        String url = "https://www.milanuncios.com/motor/?hasta=7000&demanda=n&vendedor=part&latitude=38.3459963&longitude=-0.4906855&distance=30000&geoProvinceId=3&geolocationTerm=Alicante%20%28Alacant%29%2C%20Alicante&orden=relevance&fromSearch=1&hitOrigin=listing";

        try {
            //haremos la peticion GET a la url
            Document doc = Jsoup.connect(url).get();

            //Crearemos una array de los elementos que encuentre con esa etiqueta
            Elements cars = doc.select(".ma-AdCardV2");

            //recorremos esa array
            for (Element car : cars){
                //Busca el contenido de la etiqueta css y le da valor a los strings
                String title = car.select(".ma-AdCardV2-title").text();
                String price = car.select(".ma-AdMultiplePrice-priceBlock").text();
                String description = car.select(".ma-AdCardV2-description").text();
                String attributes = car.select(".ma-AdTagList").text();

                //Impresion por consola de los datos obtenidos de cada elemento de la array cars
                System.out.println(title);
                System.out.println("Caracteristicas: " + attributes);
                System.out.println("Descripcion: " + description);
                System.out.println("Precio: " + price);
                System.out.println("----------------------");

            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
