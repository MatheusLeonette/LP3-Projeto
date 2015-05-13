package ServicesInterface;

public interface ObeyServices<G> {
    public G listAll();
    public G select(int id);
    public void novo(G object);
    public void update(G object);
    public void delete(G object);
}
