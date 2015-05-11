package ServicesInterface;

public interface ObeyServices<G> {
    public G selectAll();
    public G select(int id);
    public void insert(G object);
    public void update(G object);
    public void delete(G object);
}
