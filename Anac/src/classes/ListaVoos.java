package classes;

public class ListaVoos implements Cloneable // Lista contendo objeto Destino
{
    protected class No
    {
        protected Destino destino;
        protected No prox;

        public No (Destino destino, No p)
        {
            this.destino = destino;
            this.prox = p;
        }

        public No (Destino destino)
        {
            this.destino = destino;
            this.prox = null;
        }

        public Destino getDestino ()
        {
            return this.destino;
        }

        public No getProx ()
        {
            return this.prox;
        }

        public void setDestino (Destino destino)
        {
            this.destino = destino;
        }

        public void setProx (No p)
        {
            this.prox = p;
        }
    }

    protected No primeiro, ultimo;

    public void insiraNoInicio (Destino destino) throws Exception
    {
        if (destino == null)
            throw new Exception ("Informacao ausente");

        this.primeiro = new No (destino, this.primeiro);

        if (this.ultimo == null)
            this.ultimo = this.primeiro;
    }

    public void insiraNoFim (Destino destino) throws Exception
    {
        if (destino == null)
            throw new Exception ("Informacao ausente");

        if (this.ultimo == null)
        {
            No novo = new No (destino);
            this.primeiro = novo;
            this.ultimo = this.primeiro;
        }
        else
        {
            No valor = new No (destino);
            this.ultimo.setProx(valor);
            this.ultimo = valor;
            this.ultimo.setProx(null);
        }
    }

    public String toString ()
    {
        String ret = "Voos: ";

        No aux = this.primeiro;

        while (aux != null)
        {
            if (aux.getProx() != null)
                ret = ret + aux.getDestino() + "; ";
            else
                ret = ret + aux.getDestino();

            aux = aux.getProx();
        }

        return ret + "";
    }

    public int hashCode ()
    {
        int ret = 17;
        No aux = this.primeiro;

        while (aux != null)
        {
            ret = ret * 17 + aux.getDestino().hashCode();

            aux = aux.getProx();
        }

        if (ret < 0)
            ret = -ret;

        return ret;
    }

    public boolean equals (Object obj)
    {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (this.getClass() != obj.getClass())
            return false;

        ListaVoos lis = (ListaVoos)obj;

        No aux1 = this.primeiro;
        No aux2 = lis.primeiro;

        while (aux1 != null && aux2 != null)
        {
            if (aux1.getDestino().equals(aux2.getDestino()) == false)
                return false;

            aux1 = aux1.getProx();
            aux2 = aux2.getProx();
        }

        return true;
    }

    public void removaDoInicio () throws Exception
    {
        if (this.ultimo == null && this.primeiro == null)
            throw new Exception ("Lista esta vazia");

        No aux = this.primeiro.getProx();
        this.primeiro = null;
        this.primeiro = aux;
    }

    public void remova (int numeroDoVoo) throws Exception
    {
        if (this.ultimo == null & this.primeiro == null)
            throw new Exception ("Lista esta vazia");

        if (this.primeiro.getDestino().getNumeroVoo() == numeroDoVoo)
        {
            No guardado = this.primeiro;
            this.primeiro = guardado.getProx();
            return;
        }

        No aux = this.primeiro;
        while (aux != null)
        {
            if (aux.getProx().getDestino().getNumeroVoo() == numeroDoVoo)
            {
                No guardado = aux.getProx().getProx();
                aux.setProx(guardado);
                break;
            }
            aux = aux.getProx();
        }
    }

    public void removaDoFim () throws Exception
    {
        if (this.ultimo == null && this.primeiro == null)
            throw new Exception ("Lista esta vazia");

        No aux = this.primeiro;
        while (aux != null)
        {
            if (aux.getProx().equals(this.ultimo))
            {
                this.ultimo = aux;
                aux.setProx(null);
                break;
            }

            aux = aux.getProx();
        }
    }

    public boolean tem (Destino destino) throws Exception
    {
        if (destino == null)
            throw new Exception("Parametro ausente");

        No aux = this.primeiro;

        while (aux != null)
        {
            if (aux.getDestino() == null)
                aux = aux.getProx();
            else
            {
                if (aux.getDestino().equals(destino) == true)
                {
                    return true;
                }
                else
                    aux = aux.getProx();
            }
        }

        return false;
    }

    public Object clone ()
    {
        ListaVoos ret = null;
        try
        {
            ret = new ListaVoos(this);
        }
        catch (Exception erro)
        {}

        return ret;
    }

    public ListaVoos (ListaVoos modelo) throws Exception
    {
        if (modelo == null)
            throw new Exception ("Modelo ausente");

        this.primeiro = modelo.primeiro;
        this.ultimo = modelo.ultimo;
        No aux = this.primeiro;
        No aux2 = modelo.primeiro;
        while (aux != null)
        {
            aux.setDestino(aux2.getDestino());

            aux = aux.getProx();
            aux2 = aux2.getProx();
        }
    }

    public ListaVoos ()
    {}

    public Destino getDoInicio() throws Exception
    {
        if (this.ultimo == null && this.primeiro == null)
            throw new Exception ("Lista esta vazia");

        return this.primeiro.getDestino();
    }

    public Destino getDoFim() throws Exception
    {
        if (this.ultimo == null && this.primeiro == null)
            throw new Exception ("Lista esta vazia");

        return this.ultimo.getDestino();
    }

    public boolean isVazia()
    {
        if (this.ultimo == null && this.primeiro == null)
            return true;
        else
            return false;
    }

    public int getQtd ()
    {
        No aux = this.primeiro;
        int qtd = 0;
        while (aux != null)
        {
            qtd++;
            aux = aux.getProx();
        }

        return qtd;
    }

    public void invertaSe ()
    {
        if (this.primeiro==null)
            return;

        if (this.primeiro.getProx() == null)
            return;

        No anterior=null, atual=this.primeiro, seguinte=atual.getProx();
        while (seguinte!=null)
        {
            atual.setProx (anterior);
            anterior = atual;
            atual    = seguinte;
            seguinte = seguinte.getProx();
        }

        this.ultimo.setProx(anterior);

        No   backup   = this.primeiro;
        this.primeiro = this.ultimo;
        this.ultimo   = backup;
    }

    public ListaVoos getInversao ()
    {
        ListaVoos ret = new ListaVoos ();

        for (No atual=this.primeiro; atual!=null; atual=atual.getProx())
            ret.primeiro = new No (atual.getDestino(),ret.primeiro);

        return ret;
    }
}