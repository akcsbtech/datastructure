package improvement;
public interface Rule {
    boolean evaluate(Expression expression);
    Result getResult();
}