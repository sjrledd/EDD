package ejercicio1;

class Nodo {

    Object dato;
    Nodo sig;
    Nodo ant;

    public Nodo(Object dato) {
        this.dato = dato;
    }

    public Object getDato() {
        return dato;
    }

    public Nodo getSig() {
        return sig;
    }

    public Nodo getAnt() {
        return ant;
    }

    public void EnlazarAnt(Nodo nodo) {
        this.ant = nodo;
    }

    public void EnlazarSig(Nodo nodo) {
        this.sig = nodo;
    }
}

public class Lista {

    private Nodo Prin;
    private Nodo Sec;
    private int tam;

    public Lista() {
        this.Prin = null;
        this.Sec = null;
        this.tam = 0;
    }

    public Object ObtenerPrin() {
        return this.Prin.getDato();
    }

    public void AgregarP(Object val) {
        Nodo nodo = new Nodo(val);
        if (Prin == null && Sec == null) {
            this.Prin = nodo;
            this.Sec = nodo;
        } else {
            nodo.EnlazarSig(this.Prin);
            this.Prin.EnlazarAnt(nodo);
            nodo.EnlazarAnt(this.Sec);
            this.Sec.EnlazarSig(nodo);
            this.Prin = nodo;
        }
        tam++;
    }

    public void AgregarF(Object val) {
        Nodo nodo = new Nodo(val);
        if (Sec == null && Prin == null) {
            this.Sec = nodo;
            this.Prin = nodo;

        } else {
            this.Sec.EnlazarSig(nodo);
            nodo.EnlazarAnt(this.Sec);
            nodo.EnlazarSig(this.Prin);
            this.Prin.EnlazarAnt(nodo);
            this.Sec = nodo;
        }
        tam++;
    }

    public boolean isEmpty() {
        return this.Prin == null;
    }

    public int getTam() {
        return tam;
    }

    public void Mostrar() {
        for (Nodo i = Prin; i != Prin.getAnt(); i = i.getSig()) {
            System.out.print(i.getDato().toString() + " ");
        }
        System.out.println(Sec.getDato().toString());
    }

    public static void main(String[] args) {

        Lista l = new Lista();
        l.AgregarP(1);
        l.AgregarP(2);
        l.AgregarP(3);
        l.AgregarP(4);
        l.AgregarP(5);
        l.AgregarP(6);
        System.out.println("tam: " + l.getTam());
        l.Mostrar();
    }
}