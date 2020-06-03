package classes;

import java.util.concurrent.LinkedBlockingDeque;

public class Destino implements Cloneable // Armazena o indice da cidade e o numero do voo
{
    protected int indice;
    protected int numeroVoo;

    public Destino (int indice, int numeroVoo) throws Exception
    {
        setIndice(indice);
        setNumeroVoo(numeroVoo);
    }

    public void setIndice (int indice) throws Exception
    {
        if (indice < 0)
            throw new Exception ("Indice invalido");

        this.indice = indice;
    }

    public void setNumeroVoo (int numeroVoo) throws Exception
    {
        if (numeroVoo < 0)
            throw new Exception ("Numero de voo invalido");

        this.numeroVoo = numeroVoo;
    }

    public int getIndice ()
    {
        return this.indice;
    }

    public int getNumeroVoo ()
    {
        return this.numeroVoo;
    }

    public boolean equals (Object obj)
    {
        if (obj == null)
            return false;

        if (this == obj)
            return true;

        if (this.getClass() != obj.getClass())
            return false;

        Destino des = (Destino)obj;

        if (this.indice != des.indice)
            return false;

        if (this.numeroVoo != des.numeroVoo)
            return false;

        return true;
    }

    public String toString ()
    {
        return "Indice: " + this.indice + " e " + "Numero do voo: " + this.numeroVoo;
    }

    public int hashCode ()
    {
        int ret = 17;

        ret = ret * 17 + Integer.valueOf(this.indice).hashCode();
        ret = ret * 17 + Integer.valueOf(this.numeroVoo).hashCode();

        if (ret < 0)
            ret = -ret;

        return ret;
    }

    public int compareTo (Destino obj)
    {
        if (this.indice > obj.indice)
            return 1;

        if (this.indice < obj.indice)
            return -1;

        if (this.numeroVoo > obj.numeroVoo)
            return 1;

        if (this.numeroVoo < obj.numeroVoo)
            return -1;

        return 0;
    }

    public Object clone ()
    {
        Destino ret = null;
        try
        {
            ret = new Destino(this);
        }
        catch (Exception e)
        {}

        return ret;
    }

    public Destino (Destino modelo) throws Exception
    {
        if (modelo == null)
            throw new Exception ("Modelo invalido");

        this.indice = modelo.indice;
        this.numeroVoo = modelo.numeroVoo;
    }
}