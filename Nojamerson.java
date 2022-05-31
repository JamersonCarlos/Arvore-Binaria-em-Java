public interface Nojamerson {

    public int getChave();

    public <T extends Nojamerson> void setEsquerda(T no);

    public <T extends Nojamerson> T getDireita();

    public <T extends Nojamerson> T getEsquerda();

    public <T extends Nojamerson> void setDireita(T no);

    public void setChave(int chave);

    public String toString();
}
