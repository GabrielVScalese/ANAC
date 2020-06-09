package classes;

/**
 * A classe ListaAeroportos representa uma classe que armazena uma lista com todos os aeroportos presentes.
 * Instâncias desta classe permitem a manutenção desses aeroportos.
 * Nela encontramos, por exemplo, metodos para inserir e remover, um construtor, equals etc.
 * @author Gabriel Villar Scalese && Guilherme Augusto Felisberto Teixeira.
 * @since 2020.
 */

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

    /**No Contendo o primeiro e o ultimo Aeroporto da lista. */
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
    
    public void inserirVoo (String codigo, Destino destino) throws Exception
    {
    	try
    	{
    		ListaVoos lis;
        	lis = getLista(codigo);
        	lis.insiraNoFim(destino);
    	}
    	catch (Exception e)
    	{}
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
    

    public DadosAeroporto getDadosDoInicio() throws Exception
    {
        if (this.ultimo == null && this.primeiro == null)
            throw new Exception ("Lista esta vazia");

        return this.primeiro.getDados();
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
    
    /**
     * Gera uma representação textual de todo conteúdo da ListaAeroportos.
     * Produz e resulta um String representando a lista de aeroportos.
     * @return um String contendo representando a lista de aeroportos.
     */
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

    /**
     * Calcula o código de espalhamento (ou código de hash).
     * Calcula e resulta o código de espalhamento (ou código de hash, ou ainda o
     * hashcode) da classe ListaAeroportos representada pela instância à qual o método for aplicado.
     * @return o código de espalhamento do objeto chamante da classe ListaAeroportos.
     */
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

    /**
     * Verifica a igualdade entre dois ListaAeroportos.
     * Verifica se o Object fornecido como parâmetro representa um
     * ListaVoos igual àquele representado pela instância à qual este
     * método for aplicado, resultando true em caso afirmativo,
     * ou false, caso contrário.
     * @param  obj o objeto a ser comparado com a instância à qual esse método
     * for aplicado.
     * @return true, caso o Object fornecido ao método e a instância chamante do
     * método representarem ListaAeroportos iguais, ou false, caso contrário.
     */
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

    public void remova (String codigo, int numeroVoo) throws Exception
    {
    	try
    	{
    		ListaVoos lis;
        	lis = getLista(codigo);
        	
        	lis.remova(numeroVoo);
    	}
    	catch (Exception e)
    	{}
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
    
    public boolean temVoo (String codigo, int numeroVoo) throws Exception
    {
    	boolean ret = false;
    	try
    	{
    		ListaVoos lis = getLista(codigo);
    		if (lis.tem(numeroVoo))
    			ret = true;
    		else
    			ret = false;
    	}
    	catch (Exception error)
    	{}
    	
    	return ret;
    }
    
    public boolean tem (String codigo) throws Exception
    {
    	 if (codigo == null)
             throw new Exception("Parametro ausente");

         No aux = this.primeiro;

         while (aux != null)
         {
             if (aux.getDados() == null)
                 aux = aux.getProx();
             else
             {
                 if (aux.getDados().getCodigo().equals(codigo))
                 {
                     return true;
                 }
                 else
                     aux = aux.getProx();
             }
         }

         return false;
    }
    
    public boolean tem (String codigo, int numeroVoo) throws Exception
    {
    	boolean ret = false;
    	try
    	{
    		ListaVoos lis;
        	lis = getLista(codigo);
        	
        	if (lis.tem(numeroVoo))
        		ret = true;
        	else
        		ret = false;
    	}
    	catch (Exception e)
    	{}
    	
    	return ret;
    }

    /**
     * Constroi uma cópia deste ListaAeroportos.
     * Utiliza o construtor de cópia para gerar uma cópia de this e a retorna.
     * @return a cópia deste ListaAeroportos como Object.
     */
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

    
    /**
     * Constroi uma cópia da instância da classe ListaAeroportos dada.
     * Para tanto, deve ser fornecida uma instancia da classe ListaAeroportos para ser
     * utilizada como modelo para a construção da nova instância criada.
     * @param modelo a instância da classe ListaAeroportos a ser usada como modelo.
     * @throws Exception se o modelo for null.
     */
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

    

    public boolean isVazia()
    {
        if (this.ultimo == null && this.primeiro == null)
            return true;
        else
            return false;
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