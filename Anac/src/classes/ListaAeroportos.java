package classes;

/**
 * A classe ListaAeroportos representa uma classe que armazena uma lista com todos os aeroportos presentes.
 * Inst�ncias desta classe permitem a manuten��o desses aeroportos.
 * Nela encontramos, por exemplo, metodos para inserir e remover, um construtor, equals etc.
 * @author Gabriel Villar Scalese && Guilherme Augusto Felisberto Teixeira.
 * @since 2020.
 */

public class ListaAeroportos implements Cloneable
{
    public class No
    {
    	/**DadosAeroporto onde dados do aeroporto ser� armazenado. */
        protected DadosAeroporto dados;
        /**ListaVoos onde os v�os serao armazenados. */
        protected ListaVoos lisVoos;
        /**No onde os objetos posteriores do atual est�o armazenados. */
        protected No prox;
        /**No onde os objetos anteriores do atual est�o armazenados. */
        protected No ante;

        /**
         * Constroi uma nova inst�ncia da classe No.
         * @param dados DadosAeroporto contedo dados do aeroporto.
         * @param lisVoos ListaVoos contendo a lista de voos desse aeroporto.
         * @param prox No contendo os objetos posteriores ao atual.
         * @param ante No contendo os objetos anteriores ao atual.
         *  */
        protected No (DadosAeroporto dados, ListaVoos lisVoos, No prox, No ante)
        {
            this.dados = dados;
            this.lisVoos = lisVoos;
            this.prox = prox;
            this.ante = ante;
        }

        /**
         * Constroi uma nova inst�ncia da classe No.
         * @param dados DadosAeroporto contedo dados do aeroporto.
         *  */
        public No (DadosAeroporto dados)
        {
            this.dados = dados;
            this.prox = null;
        }

        /**
         * Constroi uma nova inst�ncia da classe No.
         * @param dados DadosAeroporto contedo dados do aeroporto.
         * @param lisVoos ListaVoos contendo a lista de voos desse aeroporto.
         *  */
        public No (DadosAeroporto dados, ListaVoos lisVoos)
        {
            this.dados = dados;
            this.lisVoos = lisVoos;
        }

        /**
         * Retorna o objeto DadosAeroporto.
         * @return Retorna os valores presentes no objeto DadosAeroporto. 
         *  */
        public DadosAeroporto getDados ()
        {
            return this.dados;
        }

        /**
         * Retorna o objeto ListaVoos.
         * @return Retorna os valores presentes no objeto ListaVoos.
         *  */
        public ListaVoos getVoos()
        {
            return this.lisVoos;
        }

        /**
         * Retorna os objetos posteriores ao atual.
         * @return Retorna os valores presentes nos objetos posteriores ao atual.
         *  */
        public No getProx ()
        {
            return this.prox;
        }

        /**
         * Retorna os objetos anteriores ao atual.
         * @return Retorna os valores presentes nos objetos anteriores ao atual.
         *  */
        public No getAnte()
        {
        	return this.ante;
        }
        
        /**
         * Adiciona valores ao DadosAeroporto dados.
         * @param dados DadosAeroporto contedo dados do aeroporto.
         *  */
        public void setDados (DadosAeroporto dados)
        {
            this.dados = dados;
        }

        /**
         * Adiciona valores ao ListaVoos lisVoos.
         * @param lisVoos ListaVoos contendo a lista de voos desse aeroporto.
         *  */
        public void setVoos (ListaVoos lisVoos)
        {
            this.lisVoos = lisVoos;
        }

        /**
         * Adiciona valores ao objeto posterior.
         * @param prox No contendo os objetos posteriores ao atual.
         *  */
        public void setProx (No prox)
        {
            this.prox = prox;
        }
        
        /**
         * Adiciona valores ao objeto anterior.
         * @param ante No contendo os objetos anteriores ao atual.
         *  */
        public void setAnte (No ante)
        {
        	this.ante = ante;
        }
    }

    /**No Contendo o primeiros e o ultimos aeroporto e lista de v�os da lista. */
    protected No primeiro, ultimo;

    /**
     * Insere novos dados de aeroporto.
     * @param dados DadosAeroporto contedo dados do aeroporto.
     * @throws Exception se o dados passado por par�metro for nulo.
     *  */
    public void insiraAeroportoNoFim (DadosAeroporto dados) throws Exception
    {
    	if (dados == null)
            throw new Exception ("Dados de aeroporto ausentes");
    	
        if (this.ultimo == null)
        {
            No novo = new No (dados, null);
            this.primeiro = novo;
            this.primeiro.setAnte(null);
            this.ultimo = this.primeiro;
            this.ultimo.setAnte(this.primeiro);
        }
        else
        {
            No valor = new No (dados, null, null, this.ultimo);
            this.ultimo.setProx(valor);
            this.ultimo = valor;
        }
    }
    
    /**
     * Insere nova lista de v�os a um aeroporto especificado por seu c�digo.
     * @param codigo String contedo o c�digo do aeroporto.
     * @param listaVoos ListaVoos contendo a lista de voos desse aeroporto.
     * @throws Exception se o codAeroporto passado por par�metro for nulo ou se o listaVoos passado por par�metro for nulo.
     *  */
    public void insiraListaVoos (String codAeroporto, ListaVoos listaVoos) throws Exception
    {
    	
    	if (codAeroporto == null || codAeroporto.equals(""))
            throw new Exception ("C�digo de aeroporto inv�lido");
    	
    	if (listaVoos == null)
    		throw new Exception ("Lista de v�os inv�lida");
    	
    	No aux = this.primeiro;
    	while (aux != null)
    	{
    		if (aux.getDados().getCodigo().equals(codAeroporto))
    		{
    			aux.setVoos(listaVoos);
    			return;
    		}
    		else
    			aux = aux.getProx();
    	}
    }
    
    /**
     * Insere novo v�o na lista de v�os a partir do c�digo do aeroporto.
     * @param codigo String contedo o c�digo do aeroporto.
     * @param destino Destino contendo destino do v�o.
     * @throws Exception se o c�digo passado por par�metro for nulo ou vazio, se o destino passado por par�metro for nulo ou se c�digo de aeroporto n�o existe na lista.
     *  */
    public void inserirVoo (String codigo, Destino destino) throws Exception
    {
    	if (codigo == null || codigo.equals(""))
    		throw new Exception ("C�digo de aeroporto ausente");
    	
    	if (destino == null)
    		throw new Exception ("Destino ausente");
    	
    	try
    	{
    		ListaVoos lis;
        	lis = getListaDeVoos(codigo);
        	lis.insiraNoFim(destino);
    	}
    	catch (Exception e)
    	{
    		System.out.println ("Lista de v�os inexistente");
    	}
    }

    /**
     * Retorna o No de um aeroporto especificado por seu c�digo.
     * @param codAeroporto String contedo o c�digo do aeroporto.
     * @return Retorna os valores presentes no No do aeroporto especificado por seu c�digo.
     * @throws Exception se o dados passado por par�metro for nulo.
     *  */
    public No getAeroportoDestino (String codAeroporto) throws Exception
    {
    	if (codAeroporto == null || codAeroporto.equals(""))
    		throw new Exception ("C�digo de aeroporto inv�lido");
    	
    	No aux = this.primeiro;
    	while (aux != null)
    	{
    		if (aux.getDados().getCodigo().equals(codAeroporto))
    	        return aux;
    		else
    			aux = aux.getProx();
    	}
    	
    	return null;
    }
    
    /**
     * Retorna o objeto DadosAeroporto posterior ao do par�metro.
     * @param dados DadosAeroporto contedo dados do aeroporto.
     * @return Retorna os valores presentes no objeto DadosAeroporto posterior ao atual.
     * @throws Exception se o dados passado por par�metro for nulo.
     *  */
    public DadosAeroporto getProxDados (DadosAeroporto dados) throws Exception
    {
    	if (dados == null)
    		throw new Exception ("Dados de aeroporto inexistentes");
    	
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
    
    /**
     * Retorna o objeto DadosAeroporto anterior ao do par�metro.
     * @param dados DadosAeroporto contedo dados do aeroporto.
     * @return Retorna os valores presentes no objeto DadosAeroporto anterior ao atual.
     * @throws Exception se o dados passado por par�metro for nulo.
     *  */
    public DadosAeroporto getAnteDados (DadosAeroporto dados)
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
    
    /**
     * Retorna o objeto Destino do in�cio da lista de v�os a partir do c�digo do aeroporto.
     * @param codigo String contedo o c�digo do aeroporto.
     * @return Retorna os valores presentes no objeto Destino.
     * @throws Exception se o codigo passado por par�metro for nulo.
     *  */
    public Destino getDestinoDoInicio (String codigo) throws Exception
    {
        if (codigo == null || codigo.equals(""))
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
    
    /**
     * Retorna o objeto Destino do fim da lista de v�os a partir do c�digo do aeroporto.
     * @param codigo String contedo o c�digo do aeroporto.
     * @return Retorna os valores presentes no objeto Destino.
     * @throws Exception se o codigo passado por par�metro for nulo.
     *  */
    public Destino getDestinoDoFim (String codigo) throws Exception
    {
        if (codigo == null || codigo.equals(""))
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
    
    /**
     * Retorna o objeto ListaVoos a partir do c�digo do aeroporto.
     * @param codigo String contedo o c�digo do aeroporto.
     * @return Retorna os valores presentes no objeto ListaVoos.
     * @throws Exception se o codigo passado por par�metro for nulo.
     *  */
    public ListaVoos getListaDeVoos (String codigo) throws Exception
    {
    	if (codigo == null || codigo.equals(""))
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
     * Retorna o objeto Destino posterior ao do par�metro a partir do c�digo do aeroporto.
     * @param codigo String contedo o c�digo do aeroporto.
     * @param destino Destino contendo destino do v�o.
     * @return Retorna os valores presentes no objeto Destino.
     * @throws Exception se o codigo passado por par�metro for nulo, se o destino passado por par�metro for nulo ou se a lista de v�os n�o existe.
     *  */
    public Destino getProxDestino (String codigo, Destino destino) throws Exception
    {
    	if (codigo == null || codigo.equals(""))
    		throw new Exception ("C�digo do aeroporto ausente");
    	
    	if (destino == null)
    		throw new Exception ("Destino ausente");
    	
    	Destino destinoProx = null;
    	try
    	{
    		ListaVoos lisVoos = getListaDeVoos(codigo);
        	destinoProx = lisVoos.getProxDestino(destino);
    	}
    	catch (Exception e)
    	{
    		System.out.println ("Lista de v�os inexistente");
    	}
    	
    	return destinoProx;
    }
    
    /**
     * Retorna o objeto Destino anterior ao do par�metro a partir do c�digo do aeroporto.
     * @param codigo String contedo o c�digo do aeroporto.
     * @param destino Destino contendo destino do v�o.
     * @return Retorna os valores presentes no objeto Destino.
     * @throws Exception se o codigo passado por par�metro for nulo, se o destino passado por par�metro for nulo ou se a lista de v�os n�o existe.
     *  */
    public Destino getAnteDestino (String codigo, Destino destino) throws Exception
    {
    	if (codigo == null || codigo.equals(""))
    		throw new Exception ("C�digo do aeroporto ausente");
    	
    	if (destino == null)
    		throw new Exception ("Destino ausente");
    	
    	Destino destinoProx = null;
    	try
    	{
    		ListaVoos lisVoos = getListaDeVoos(codigo);
        	destinoProx = lisVoos.getAnteDestino(destino);
    	}
    	catch (Exception e)
    	{
    		System.out.println ("Lista de v�os inexistente");
    	}
    	
    	return destinoProx;
    }
    
    /**
     * Retorna o objeto DadosAeroporto do fim da lista de aeroportos.
     * @return Retorna os valores presentes no objeto DadosAeroporto.
     * @throws Exception se a lista de aeroportos estiver vazia.
     *  */
    public DadosAeroporto getDadosDoFim() throws Exception
    {
        if (this.ultimo == null && this.primeiro == null)
            throw new Exception ("Lista esta vazia");

        return this.ultimo.getDados();
    }
    
    /**
     * Retorna o objeto DadosAeroporto do in�cio da lista de aeroportos.
     * @return Retorna os valores presentes no objeto DadosAeroporto.
     * @throws Exception se a lista de aeroportos estiver vazia.
     *  */
    public DadosAeroporto getDadosDoInicio() throws Exception
    {
        if (this.ultimo == null && this.primeiro == null)
            throw new Exception ("Lista esta vazia");

        return this.primeiro.getDados();
    }
    
    /**
     * Retorna a quantidade de itens da lista de aeroportos.
     * @return Retorna o n�mero de itens da lista de aeroportos.
     *  */
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

    /**
     * Retorna o objeto DadosAeroporto a partir do c�digo do aeroporto.
     * @param codigo String contedo o c�digo do aeroporto.
     * @return Retorna os valores presentes no objeto DadosAeroporto.
     * @throws Exception se o codigo passado por par�metro for nulo.
     *  */
    public DadosAeroporto getAeroporto (String codigo) throws Exception
    {
    	if (codigo == null || codigo.equals(""))
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
    
    /**
     * Gera uma representa��o textual de todo conte�do da ListaAeroportos.
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
     * Calcula o c�digo de espalhamento (ou c�digo de hash).
     * Calcula e resulta o c�digo de espalhamento (ou c�digo de hash, ou ainda o
     * hashcode) da classe ListaAeroportos representada pela inst�ncia � qual o m�todo for aplicado.
     * @return o c�digo de espalhamento do objeto chamante da classe ListaAeroportos.
     */
    public int hashCode ()
    {
        int ret = 17;
        No aux = this.primeiro;

        while (aux != null)
        {
            ret = ret * 17 + aux.getDados().hashCode();
            ret = ret * 17 + aux.getVoos().hashCode();

            aux = aux.getProx();
        }

        if (ret < 0)
            ret = -ret;

        return ret;
    }

    /**
     * Verifica a igualdade entre dois ListaAeroportos.
     * Verifica se o Object fornecido como par�metro representa um
     * ListaAeroportos igual �quele representado pela inst�ncia � qual este
     * m�todo for aplicado, resultando true em caso afirmativo,
     * ou false, caso contr�rio.
     * @param  obj o objeto a ser comparado com a inst�ncia � qual esse m�todo
     * for aplicado.
     * @return true, caso o Object fornecido ao m�todo e a inst�ncia chamante do
     * m�todo representarem ListaAeroportos iguais, ou false, caso contr�rio.
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
            
            if (aux1.getVoos().equals(aux2.getVoos()) == false)

            aux1 = aux1.getProx();
            aux2 = aux2.getProx();
        }

        return true;
    }

    /**
     * Remove o objeto Destino a partir do c�digo do aeroporto.
     * @param codigo String contedo o c�digo do aeroporto.
     * @throws Exception se o codigo passado por par�metro for nulo, se o numeroVoo passado por par�metro for menor que 0 ou se a lista de v�os n�o existe.
     *  */
    public void removaVoo (String codigo, int numeroVoo) throws Exception
    {
    	if (codigo == null || codigo.equals(""))
    		throw new Exception ("C�digo de aeroporto inv�lido");
    	
    	if (numeroVoo < 0)
    		throw new Exception ("N�mero de v�o inv�lido");
    	try
    	{
        	ListaVoos lis = getListaDeVoos(codigo);
        	
        	lis.removaVoo(numeroVoo);
    	}
    	catch (Exception e)
    	{
    		System.out.println("Lista de v�os inexistente");
    	}
    }
    
    /**
     * Verifica se o v�o existe a partir do c�digo do aeroporto.
     * @param codigo String contedo o c�digo do aeroporto.
     * @param numeroVoo int contendo o numero do voo.
     * @return Retorna true se v�o existe ou false caso o v�o n�o exista.
     * @throws Exception se o codigo passado por par�metro for nulo ou se o numeroVoo passado por par�metro for menor que 0.
     *  */
    public boolean temVoo (String codigo, int numeroVoo) throws Exception
    {
    	if (codigo == null || codigo.equals(""))
    		throw new Exception ("C�digo de aeroporto inv�lido");
    	
    	if (numeroVoo < 0)
    		throw new Exception ("N�mero de v�o inv�lido");
    	
    	boolean ret = false;
    	try
    	{
    		ListaVoos lis = getListaDeVoos(codigo);
    		if (lis.temVoo(numeroVoo))
    			ret = true;
    		else
    			ret = false;
    	}
    	catch (Exception error)
    	{
    		System.out.println("Lista de v�os inexistente");
    	}
    	
    	return ret;
    }
    
    /**
     * Verifica se o aeroporto existe a partir do c�digo do aeroporto.
     * @param codigo String contedo o c�digo do aeroporto.
     * @return Retorna true se aeroporto existe ou false caso o aeroporto n�o exista.
     * @throws Exception se o codigo passado por par�metro for nulo.
     *  */
    public boolean temAeroporto (String codigo) throws Exception
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
    
    /**
     * Constroi uma c�pia deste ListaAeroportos.
     * Utiliza o construtor de c�pia para gerar uma c�pia de this e a retorna.
     * @return a c�pia deste ListaAeroportos como Object.
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
     * Constroi uma c�pia da inst�ncia da classe ListaAeroportos dada.
     * Para tanto, deve ser fornecida uma instancia da classe ListaAeroportos para ser
     * utilizada como modelo para a constru��o da nova inst�ncia criada.
     * @param modelo a inst�ncia da classe ListaAeroportos a ser usada como modelo.
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
            aux.setVoos(aux2.getVoos());

            aux = aux.getProx();
            aux2 = aux2.getProx();
        }
    }

    /**
     * Constroi uma nova inst�ncia da classe ListaAeroportos.
     *  */
    public ListaAeroportos ()
    {}
}