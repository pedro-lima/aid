package aid.core.main.interfaces;

import java.io.Serializable;
import java.util.List;

public interface SearchPojo<T> extends Serializable {

	public abstract int getCount();

	public abstract void setCount(int count);

	public abstract List<T> getCollection();

	public abstract void setCollection(List<T> collection);

}