
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        List<Integer> listaElem = new LinkedList<>();

        System.out.print("Entre numero de elementos: ");
        int n = entrada.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Entre el elmento " + i + ": ");
            int elem = entrada.nextInt();
            listaElem.add(elem);
        }
        Collections.sort(listaElem);
        Collections.reverse(listaElem);
        //System.out.println(listaElem);

        int nroViajes = 0;
        boolean salir = false;
        while (listaElem.size() > 0 && !salir) {
            int PesoElementoTope = listaElem.remove(0);
            int contElem = 1;
            List<Integer> listUnViaje = new LinkedList<>();
            listUnViaje.add(PesoElementoTope);
            while (PesoElementoTope * contElem < 50 && listaElem.size() > 0) {
                contElem++;
                listUnViaje.add(listaElem.remove(listaElem.size() - 1));
            }
            if (listaElem.size() > 0) {
                if (listaElem.get(0) * listaElem.size() < 50) {
                    for (Integer peso : listaElem) {
                        listUnViaje.add(peso);
                    }
                    contElem = contElem + listaElem.size();
                    salir = true;

                }
            }
            nroViajes++;
            System.out.println("Viaje " + nroViajes + listUnViaje);
        }
        System.out.println("Case :" + nroViajes);
    }
}
