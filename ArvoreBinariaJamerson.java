
public class ArvoreBinariaJamerson implements ArvoreBinariaPesquisa {
    private NoArvore raiz;
    private NoArvore atual = raiz;
    private NoArvore aux;

    @Override
    public Nojamerson novoNode(int key) {
        NoArvore novono = new NoArvore();
        novono.setChave(key);
        return novono;
    }

    @Override
    public Nojamerson inserir(int key) {

        if (raiz == null) {
            raiz = new NoArvore();
            raiz.setChave(key);
        } else if (key < atual.getChave()) {
            if (atual.getEsquerda() == null) {
                atual.setEsquerda(novoNode(key));
            } else {
                atual = atual.getEsquerda();
                inserir(key);
            }
        } else if (key >= atual.getChave()) {
            if (atual.getDireita() == null) {
                atual.setDireita(novoNode(key));
            } else {
                atual = atual.getDireita();
                inserir(key);
            }
        }
        atual = raiz;
        return atual;
    }

    @Override
    public Nojamerson procurar(int key) {
        atual = raiz;
        // Procurando a chave informada
        while (true) {
            if (atual != null) {
                if (atual.getChave() == key) {
                    return atual;
                    // Caminhando para esquerda
                } else if (key < atual.getChave() && atual.getEsquerda() != null) {
                    atual = atual.getEsquerda();
                    // Caminhando para direita
                } else if (key >= atual.getChave() && atual.getDireita() != null) {
                    atual = atual.getDireita();
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }
    }

    public Nojamerson menor(NoArvore noProcura) {
        try {
            while (noProcura.getEsquerda().getEsquerda() != null) {
                noProcura = noProcura.getEsquerda();
            }
            return noProcura;
        } catch (NullPointerException e) {
            return null;
        }
    }

    @Override
    public void deletar(int key) {
        // Só irá ser feita a procura se a chave que será apagada existir
        if (procurar(key) != null) {
            // Verifica se é a raiz
            if (raiz.getChave() == key) {
                // Caso do nó a ser apagado for um FOLHA
                if (raiz.getEsquerda() == null && raiz.getDireita() == null) {
                    raiz = null;
                    // || com 1 filho na esquerda
                } else if (raiz.getEsquerda() != null) {
                    raiz.setChave(raiz.getEsquerda().getChave());
                    raiz.setEsquerda(null);
                    // || com 1 filho na direita
                } else if (raiz.getDireita() != null) {
                    raiz.setChave(raiz.getDireita().getChave());
                    raiz.setDireita(null);
                }
            } else {
                atual = raiz;
                while (true) {
                    // Caminhando para esquerda
                    if (key < atual.getChave()) {
                        if (atual.getEsquerda().getChave() == key) {
                            // Caso do nó a ser apagado for um FOLHA
                            if (atual.getEsquerda().getEsquerda() == null && atual.getEsquerda().getDireita() == null) {
                                atual.setEsquerda(null);
                                break;
                                // || com 1 filho na esquerda
                            } else if (atual.getEsquerda().getEsquerda() != null
                                    && atual.getEsquerda().getDireita() == null) {

                                atual.getEsquerda().setChave(atual.getEsquerda().getEsquerda().getChave());
                                atual.setEsquerda(atual.getEsquerda().getEsquerda());
                                break;

                                // || com 1 filho na direita
                            } else if (atual.getEsquerda().getDireita() != null
                                    && atual.getEsquerda().getEsquerda() == null) {

                                atual.getEsquerda().setChave(atual.getEsquerda().getDireita().getChave());
                                atual.setEsquerda(atual.getEsquerda().getDireita().getDireita());
                                break;
                                // Com dois filhos
                            } else {
                                if (menor(atual.getEsquerda().getDireita()) != null) {
                                    aux = (NoArvore) menor(atual.getEsquerda().getDireita());
                                    atual.getEsquerda().setChave(aux.getEsquerda().getChave());
                                    aux.setEsquerda(null);
                                } else {
                                    atual.getEsquerda().setChave(atual.getEsquerda().getDireita().getChave());
                                    atual.getEsquerda().setDireita(atual.getEsquerda().getDireita().getDireita());
                                }
                                break;
                            }
                        } else {
                            atual = atual.getEsquerda();
                        }
                        // Caminhando para direita
                    } else if (key >= atual.getChave()) {
                        if (atual.getDireita().getChave() == key) {
                            // Caso do nó a ser apagado for um FOLHA
                            if (atual.getDireita().getEsquerda() == null && atual.getDireita().getDireita() == null) {
                                atual.setDireita(null);
                                break;
                                // || com 1 filho na esquerda
                            } else if (atual.getDireita().getEsquerda() != null
                                    && atual.getDireita().getDireita() == null) {

                                atual.getDireita().setChave(atual.getDireita().getEsquerda().getChave());
                                atual.setDireita(atual.getDireita().getEsquerda());
                                break;

                                // || com 1 filho na direita
                            } else if (atual.getDireita().getDireita() != null
                                    && atual.getDireita().getEsquerda() == null) {

                                atual.getDireita().setChave(atual.getDireita().getDireita().getChave());
                                atual.setDireita(atual.getDireita().getDireita());
                                break;

                            } else {
                                // Quando o filho do nó a ser removido, se encontra na direita, e possui filhos
                                // a esquerda
                                if (menor(atual.getDireita().getDireita()) != null) {
                                    aux = (NoArvore) menor(atual.getDireita().getDireita());
                                    atual.getDireita().setChave(aux.getEsquerda().getChave());
                                    aux.setEsquerda(null);
                                    // || Quando não possui
                                } else {
                                    atual.getDireita().setChave(atual.getDireita().getDireita().getChave());
                                    atual.getDireita().setDireita(atual.getDireita().getDireita().getDireita());
                                }
                                break;
                            }
                        } else {
                            atual = atual.getDireita();
                        }
                    }
                }
            }

        } else {
            System.out.println("Chave não encontrada! ");
        }
    }

    public Boolean ehRaiz(int i) {
        if (i == raiz.getChave()) {
            return true;
        } else {
            return false;
        }
    }

}
