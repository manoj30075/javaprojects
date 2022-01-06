public interface StorageInterface<E>
{
     boolean add(E x);
     boolean find(E x);
     boolean includesNull();
     boolean delete(E x);
}
