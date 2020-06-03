package classes;

public class DadosAeroporto implements Cloneable // Armazena o nome da cidade e codigo do aeroporto
{
    protected String nome;
    protected String codigo;

    public DadosAeroporto(String nome, String codigo) throws Exception
    {
        setNome(nome);
        setCodigo(codigo);
    }

    public void setNome (String nome) throws Exception
    {
        if (nome == null || nome == "")
            throw new Exception ("Nome invalido");

        this.nome = nome;
    }

    public void setCodigo (String codigo) throws Exception
    {
        if (codigo == null || codigo == "")
            throw new Exception ("Codigo invalido");

        this.codigo = codigo;
    }

    public String getNome ()
    {
        return this.nome;
    }

    public String getCodigo ()
    {
        return this.codigo;
    }

    public boolean equals (Object obj)
    {
        if (obj == null)
            return false;

        if (this == obj)
            return true;

        if (this.getClass() != obj.getClass())
            return false;

        DadosAeroporto da = (DadosAeroporto)obj;

        if (!this.nome.equals(da.nome))
            return false;

        if (this.codigo.equals(da.codigo))
            return false;

        return true;
    }

    public int hashCode ()
    {
        int ret = 17;

        ret = ret * 17 + this.nome.hashCode();
        ret = (ret * 17) + this.codigo.hashCode();

        if (ret < 0)
            ret = -ret;

        return ret;
    }

    public String toString()
    {
        return "Nome: " + this.nome + " | " + "Codigo: " + this.codigo + " | ";
    }

    public Object clone ()
    {
        DadosAeroporto ret = null;
        try
        {
            ret = new DadosAeroporto(this);
        }
        catch (Exception e)
        {}

        return ret;
    }

    public DadosAeroporto (DadosAeroporto modelo) throws Exception
    {
        if (modelo == null)
            throw new Exception ("Modelo invalido");

        this.nome = modelo.nome;
        this.codigo = modelo.codigo;
    }
}