package buscaia;

public class Frontier {
    Vertex vertice;
    double custoTotal;

    public Frontier(Vertex vertice, double custoTotal) {
        this.vertice = vertice;
        this.custoTotal = custoTotal;
    }

    public Vertex getVertice() {
        return vertice;
    }

    public void setVertice(Vertex vertice) {
        this.vertice = vertice;
    }

    public double getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(double custoTotal) {
        this.custoTotal = custoTotal;
    }
    
}
