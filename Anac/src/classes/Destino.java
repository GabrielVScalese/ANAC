package classes;

/**
 * A classe Destino representa uma classe que armazena os destinos dos voos.  Instâncias desta classe permitem o 
 * armazenamento do indice do aeroporto e o numero do voo.
 * Nela encontramos, por exemplo, getters, setters, um construtor, equals etc.
 * @author Gabriel Villar Scalese && Guilherme Augusto Felisberto Teixeira.
 * @since 2020.
 */


import java.util.concurrent.LinkedBlockingDeque;

import classes.ListaVoos.No;

public class Destino implements Cloneable
{
    /**Integer onde o numero do voo será armazenado. */
    protected int numeroVoo;
    /**No onde o No do aeroporto de destino é apontado. */
    protected classes.ListaAeroportos.No aeroportoDestino;

    /**
     * Constroi uma nova instância da classe Destino.
     * @param aeroportoDestino No apontando ao No do aeroporto de destino.
     * @param numeroVoo int contendo o numero do voo.
     * @throws Exception se ocorrer algum erro nos Setters.
     *  */
    public Destino (classes.ListaAeroportos.No aeroportoDestino, int numeroVoo) throws Exception
    {
        setNumeroVoo(numeroVoo);
        setAeroportoDestino(aeroportoDestino);
    }

    /**
     * Adiciona valores ao No aeroportoDestino.
     * @param aeroportoDestino No apontando ao No do aeroporto de destino.
     * @throws Exception se o aeroportoDestino passado por parâmetro for nulo.
     *  */
    public void setAeroportoDestino (classes.ListaAeroportos.No aeroportoDestino) throws Exception
    {
    	if (aeroportoDestino == null)
    		throw new Exception ("Aeroporto de destino inválido");
    	
    	this.aeroportoDestino = aeroportoDestino;
    }
    
    /**
     * Adiciona valores ao int numeroVoo.
     * @param numeroVoo int contedo o numero do voo.
     * @throws Exception se o numeroVoo passado por parametro for menor que zero.
     *  */
    public void setNumeroVoo (int numeroVoo) throws Exception
    {
        if (numeroVoo < 0)
            throw new Exception ("Numero de voo invalido");

        this.numeroVoo = numeroVoo;
    }
    
    /**
     * Retorna o indice do destino.
     * @return  Retorna o valor presente no int indice. 
     *  */
    public classes.ListaAeroportos.No getAeroportoDestino ()
    {
        return this.aeroportoDestino;
    }

    /**
     * Retorna o numero do voo.
     * @return  Retorna o valor presente no int numeroVoo. 
     *  */
    public int getNumeroVoo ()
    {
        return this.numeroVoo;
    }

    /**
     * Verifica a igualdade entre dois Destino.
     * Verifica se o Object fornecido como parâmetro representa um
     * Destino igual àquele representado pela instância à qual este
     * método for aplicado, resultando true em caso afirmativo,
     * ou false, caso contrário.
     * @param  obj o objeto a ser comparado com a instância à qual esse método
     * for aplicado.
     * @return true, caso o Object fornecido ao método e a instância chamante do
     * método representarem Destino iguais, ou false, caso contrário.
     */
    public boolean equals (Object obj)
    {
        if (obj == null)
            return false;

        if (this == obj)
            return true;

        if (this.getClass() != obj.getClass())
            return false;

        Destino des = (Destino)obj;

        if (!this.aeroportoDestino.equals(des.getAeroportoDestino()))
            return false;

        if (this.numeroVoo != des.numeroVoo)
            return false;

        return true;
    }

    /**
     * Gera uma representação textual de todo conteúdo do Destino.
     * Produz e resulta um String representando o Indice e o numero do voo.
     * @return um String contendo representando o Indice e o numero do voo.
     */
    public String toString ()
    {
        return "Código do aeroporto: " + getAeroportoDestino().getDados().getCodigo() + " e " + "Número do vôo: " + this.numeroVoo;
    }


    /**
     * Calcula o código de espalhamento (ou código de hash).
     * Calcula e resulta o código de espalhamento (ou código de hash, ou ainda o
     * hashcode) da classe Destino representada pela instância à qual o método for aplicado.
     * @return o código de espalhamento do objeto chamante da classe Destino.
     */
    public int hashCode ()
    {
        int ret = 17;

        ret = ret * 17 + this.aeroportoDestino.hashCode();
        ret = ret * 17 + Integer.valueOf(this.numeroVoo).hashCode();

        if (ret < 0)
            ret = -ret;

        return ret;
    }
    
    /**
     * Constroi uma cópia deste Destino.
     * Utiliza o construtor de cópia para gerar uma cópia de this e a retorna.
     * @return a cópia deste Destino como Object.
     */
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
    
    /**
     * Constroi uma cópia da instância da classe Destino dada.
     * Para tanto, deve ser fornecida uma instancia da classe Destino para ser
     * utilizada como modelo para a construção da nova instância criada.
     * @param modelo a instância da classe Destino a ser usada como modelo.
     * @throws Exception se o modelo for null.
     */
    public Destino (Destino modelo) throws Exception
    {
        if (modelo == null)
            throw new Exception ("Modelo invalido");

        this.aeroportoDestino = modelo.aeroportoDestino;
        this.numeroVoo = modelo.numeroVoo;
    }
}