public class NoArvore implements Nojamerson {
    private int chave;
    private Nojamerson esquerda;
    private Nojamerson direita;

    @Override
    public int getChave() {
        // TODO Auto-generated method stub
        return this.chave;
    }

    @Override
    public <T extends Nojamerson> void setEsquerda(T no) {
        this.esquerda = no;
    }

    @Override
    public <T extends Nojamerson> T getDireita() {
        // TODO Auto-generated method stub
        return (T) this.direita;
    }

    @Override
    public <T extends Nojamerson> T getEsquerda() {
        // TODO Auto-generated method stub
        return (T) this.esquerda;
    }

    @Override
    public <T extends Nojamerson> void setDireita(T no) {
        // TODO Auto-generated method stub
        this.direita = no;

    }

    @Override
    public void setChave(int key) {
        this.chave = key;
    }

}