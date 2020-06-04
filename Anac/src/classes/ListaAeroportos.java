package classes;

public class ListaAeroportos implements Cloneable // Lista contendo objeto DadosAeroporto e objeto ListaVoos
{
    protected class No
    {
        protected DadosAeroporto dados;
        protected ListaVoos lisVoos;
        protected No prox;
        protected No ante;

        public No (DadosAeroporto dados, ListaVoos lisVoos, No prox, No ante)
        {
            this.dados = dados;
            this.lisVoos = lisVoos;
            this.prox = prox;
            this.ante = ante;
        }

        public No (DadosAeroporto dados)
        {
            this.dados = dados;
            this.prox = null;
        }

        public No (DadosAeroporto dados, ListaVoos lisVoos)
        {
            this.dados = dados;
            this.lisVoos = lisVoos;
        }

        public DadosAeroporto getDados ()
        {
            return this.dados;
        }

        public ListaVoos getVoos()
        {
            return this.lisVoos;
        }

        public No getProx ()
        {
            return this.prox;
        }

        public No getAnte()
        {
        	return this.ante;
        }
        
        public void setDados (DadosAeroporto dados)
        {
            this.dados = dados;
        }

        public void setVoos (ListaVoos listaVoos)
        {
            this.lisVoos = listaVoos;
        }

        public void setProx (No p)
        {
            this.prox = p;
        }
        
        public void setAnte (No ante)
        {
        	this.ante = ante;
        }
    }

    protected No primeiro, ultimo;

    public void insiraNoInicio (DadosAeroporto dados, ListaVoos lis) throws Exception
    {
        if (dados == null)
            throw new Exception ("Informacao ausente");

        this.primeiro = new No (dados, lis, this.primeiro, this.primeiro);

        if (this.ultimo == null)
            this.ultimo = this.primeiro;
    }

    public void insiraNoFim (DadosAeroporto dados, ListaVoos lis) throws Exception
    {
    	if (dados == null)
            throw new Exception ("Informacao ausente");

        if (this.ultimo == null)
        {
            No novo = new No (dados, lis);
            this.primeiro = novo;
            this.primeiro.setAnte(null);
            this.ultimo = this.primeiro;
            this.ultimo.setAnte(this.primeiro);
        }
        else
        {
            No valor = new No (dados, lis, null, this.ultimo);
            this.ultimo.setProx(valor);
            this.ultimo = valor;
        }
    }

    public DadosAeroporto getProxDados (DadosAeroporto dados) throws Exception
    {
    	No aux = this.primeiro;
    	while (aux != null)
    	{
    		if (aux.getDados().equals(dados))
    		{
    			if (aux.getProx() != null)
    			    return aux.getProx().getDados();
    			else
    				return null;
    		}
    		
    		aux = aux.getProx();
    	}
    	
    	return null;
    }
    
    public DadosAeroporto getAnteDados (DadosAeroporto dados) throws Exception
    {
    	No aux = this.primeiro;
    	while (aux != null)
    	{
    		if (aux.getDados().equals(dados))
    		{
    			return aux.getAnte().getDados();
    		}
    		
    		aux = aux.getProx();
    	}
    	
    	return null;
    }
    
    
    public DadosAeroporto exibirAeroporto (String codigo) throws Exception
    {
    	if (codigo == null || codigo == "")
            throw new Exception ("Codigo do aeroporto invalido");

 
        No aux = this.primeiro;
        while (aux != null)
        {
            if (aux.getDados().getCodigo().equals(codigo))
            {
                return aux.getDados();
            }

            aux = aux.getProx();
        }

        return null;
    }
    
    public ListaVoos exibirDestino (String codigo) throws Exception
    {
    	if (codigo == null || codigo == "")
            throw new Exception ("Codigo do aeroporto invalido");

 
        No aux = this.primeiro;
        while (aux != null)
        {
            if (aux.getDados().getCodigo().equals(codigo))
            {
                return aux.getVoos();
            }

            aux = aux.getProx();
        }

        return null;
    }
    
    public Destino getDestinoDoInicio (String codigo) throws Exception
    {
        if (codigo == null || codigo == "")
            throw new Exception ("Codigo do aeroporto invalido");

 
        No aux = this.primeiro;
        while (aux != null)
        {
            if (aux.getDados().getCodigo().equals(codigo))
            {
                return aux.getVoos().getDoInicio();
            }

            aux = aux.getProx();
        }

        return null;
    }
    
    public Destino getDestinoDoFim (String codigo) throws Exception
    {
        if (codigo == null || codigo == "")
            throw new Exception ("Codigo do aeroporto invalido");

 
        No aux = this.primeiro;
        while (aux != null)
        {
            if (aux.getDados().getCodigo().equals(codigo))
            {
                return aux.getVoos().getDoFim();
            }

            aux = aux.getProx();
        }

        return null;
    }
    

    public ListaVoos getLista (String codigo) throws Exception
    {
    	if (codigo == null || codigo == "")
            throw new Exception ("Codigo do aeroporto invalido");

 
        No aux = this.primeiro;
        while (aux != null)
        {
            if (aux.getDados().getCodigo().equals(codigo))
            {
                return aux.getVoos();
            }

            aux = aux.getProx();
        }

        return null;
    }
    
    
    public String toString ()
    {
        String ret = "";

        No aux = this.primeiro;

        while (aux != null)
        {
            if (aux.getProx() != null)
            {
            	if (aux == this.primeiro)
                    ret = ret + aux.getDados() + aux.getVoos() +  ", ";
            	else
            		ret = "\n" + ret + aux.getDados() + aux.getVoos() +  ", ";
            }
            else
                ret = ret + "(" + aux.getDados() + aux.getVoos() + ")";

            aux = aux.getProx();
        }

        return ret + "}";
    }

    public int hashCode ()
    {
        int ret = 17;
        No aux = this.primeiro;

        while (aux != null)
        {
            ret = ret * 17 + aux.getDados().hashCode();

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

        ListaAeroportos lis = (ListaAeroportos) obj;

        No aux1 = this.primeiro;
        No aux2 = lis.primeiro;

        while (aux1 != null && aux2 != null)
        {
            if (aux1.getDados().equals(aux2.getDados()) == false)
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

    public void remova (DadosAeroporto dados) throws Exception
    {
        if (dados == null)
            throw new Exception ("Parametro ausente");

        if (this.ultimo == null & this.primeiro == null)
            throw new Exception ("Lista esta vazia");

        if (this.primeiro.getDados().equals(dados))
        {
            No guardado = this.primeiro;
            this.primeiro = guardado.getProx();
            return;
        }

        No aux = this.primeiro;
        while (aux != null)
        {
            if (aux.getProx().getDados().equals(dados))
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

    public boolean tem (DadosAeroporto dados) throws Exception
    {
        if (dados == null)
            throw new Exception("Parametro ausente");

        No aux = this.primeiro;

        while (aux != null)
        {
            if (aux.getDados() == null)
                aux = aux.getProx();
            else
            {
                if (aux.getDados().equals(dados) == true)
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
        ListaAeroportos ret = null;
        try
        {
            ret = new ListaAeroportos(this);
        }
        catch (Exception erro)
        {}

        return ret;
    }

    public ListaAeroportos (ListaAeroportos modelo) throws Exception
    {
        if (modelo == null)
            throw new Exception ("Modelo ausente");

        this.primeiro = modelo.primeiro;
        this.ultimo = modelo.ultimo;
        No aux = this.primeiro;
        No aux2 = modelo.primeiro;
        while (aux != null)
        {
            aux.setDados(aux2.getDados());

            aux = aux.getProx();
            aux2 = aux2.getProx();
        }
    }

    public ListaAeroportos ()
    {}

    public DadosAeroporto getDadosDoInicio() throws Exception
    {
        if (this.ultimo == null && this.primeiro == null)
            throw new Exception ("Lista esta vazia");

        return this.primeiro.getDados();
    }
    
    
    public Destino getProxDestino (String codigo, Destino destino) throws Exception
    {
    	Destino destinoProx = null;
    	try
    	{
    		ListaVoos lisVoos = getLista(codigo);
        	destinoProx = lisVoos.getProxDestino(destino);
    	}
    	catch (Exception e)
    	{}
    	
    	return destinoProx;
    }
    
    public Destino getAnteDestino (String codigo, Destino destino) throws Exception
    {
    	Destino destinoProx = null;
    	try
    	{
    		ListaVoos lisVoos = getLista(codigo);
        	destinoProx = lisVoos.getAnteDestino(destino);
    	}
    	catch (Exception e)
    	{}
    	
    	return destinoProx;
    }
    
    public DadosAeroporto getDadosDoFim() throws Exception
    {
        if (this.ultimo == null && this.primeiro == null)
            throw new Exception ("Lista esta vazia");

        return this.ultimo.getDados();
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

    /*public ListaAeroportos getInversao ()
    {
        ListaAeroportos  ret = new ListaAeroportos ();
        for (No atual=this.primeiro; atual!=null; atual=atual.getProx())
            ret.primeiro = new No (atual.getDados(), atual.ge,ret.primeiro);
        return ret;
    }*/
}